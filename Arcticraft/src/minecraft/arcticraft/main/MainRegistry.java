package arcticraft.main;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.common.Property.Type;
import arcticraft.blocks.AC_Block;
import arcticraft.creative_tabs.AC_TabBlocks;
import arcticraft.creative_tabs.AC_TabCombat;
import arcticraft.creative_tabs.AC_TabFood;
import arcticraft.creative_tabs.AC_TabMaterial;
import arcticraft.creative_tabs.AC_TabMisc;
import arcticraft.creative_tabs.AC_TabTools;
import arcticraft.data_store.GeneratedShipsStore;
import arcticraft.data_store.TemperatureDataStorage;
import arcticraft.entities.AC_EntityRegistry;
import arcticraft.gui.AC_GuiHandler;
import arcticraft.helpers.AC_ChestLootHelper;
import arcticraft.helpers.AC_ForgeEvents;
import arcticraft.helpers.AC_PacketHandler;
import arcticraft.helpers.AC_TickHandler;
import arcticraft.items.AC_Item;
import arcticraft.items.AC_Potions;
import arcticraft.lib.Strings;
import arcticraft.recipes.AC_Recipes;
import arcticraft.renderers.items.AC_FurnaceRender;
import arcticraft.world.AC_WorldGenerator;
import arcticraft.world.AC_WorldProvider;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Strings.MOD_ID, name = Strings.MOD_NAME, version = Strings.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {Strings.CHANNEL_ESKIMO_TRADE , Strings.CHANNEL_ESKIMO_TALK, Strings.CHANNEL_ROPE_POSITION}, packetHandler = AC_PacketHandler.class)
public class MainRegistry
{

	@Instance(Strings.MOD_ID)
	public static MainRegistry instance = new MainRegistry();
	private AC_GuiHandler guiHandler = new AC_GuiHandler();

	@SidedProxy(clientSide = Strings.MOD_CLIENT_PROXY, serverSide = Strings.MOD_COMMON_PROXY)
	public static AC_CommonProxy proxy;
	public static int dimension = DimensionManager.getNextFreeDimId();

	
	/* Creative Tabs */
	public static CreativeTabs tabTools = new AC_TabTools(CreativeTabs.getNextID(), "Tabtools");
	public static CreativeTabs tabCombat = new AC_TabCombat(CreativeTabs.getNextID(), "TabCombat");
	public static CreativeTabs tabBlocks = new AC_TabBlocks(CreativeTabs.getNextID(), "TabBlocks");
	public static CreativeTabs tabFood = new AC_TabFood(CreativeTabs.getNextID(), "TabFood");
	public static CreativeTabs tabMaterial = new AC_TabMaterial(CreativeTabs.getNextID(), "TabMaterial");
	public static CreativeTabs tabMisc = new AC_TabMisc(CreativeTabs.getNextID(), "TabMisc");

	/* Potions */
	public static Potion freezePotion;

	/* Configuration Files */
	public Configuration temperatureFile;
	private TemperatureDataStorage storage = new TemperatureDataStorage();
	private GeneratedShipsStore generatedShips = new GeneratedShipsStore();
	public Configuration globalConfigFile;
	public Configuration ships;

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		storage.clear();
		System.out.println("Setting " + Strings.MOD_NAME + " server options");

		File shipFile = new File(DimensionManager.getCurrentSaveRootDirectory(), "ships.cfg");
		try
		{
			if(! shipFile.exists())
			{
				shipFile.createNewFile();
			}
			ships = new Configuration(shipFile);
			ships.load();
			Map<String, Property> entries = ships.getCategory("ships");
			generatedShips.load(entries);
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Strings.MOD_NAME + " can't load ships data");
		}
		File worldConfigFile = new File(DimensionManager.getCurrentSaveRootDirectory(), "playertemps_.cfg");
		if(! worldConfigFile.exists())
		{
			try
			{
				worldConfigFile.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}

		temperatureFile = new Configuration(worldConfigFile);

		try
		{
			temperatureFile.load();

			ConfigCategory general = temperatureFile.getCategory(Strings.CONFIG_CATEGORY_GENERAL);
			Map<String, Property> entries = general.getValues();
			storage.load(entries);
			AC_TickHandler.value = storage.getTemperature("Player");
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Strings.MOD_NAME + " can't load its temperature configuration");
		}
		finally
		{
			temperatureFile.save();
		}
	}

	@EventHandler
	public void serverStopping(FMLServerStoppingEvent event)
	{
		storage.setTemperature("Player", AC_TickHandler.value);

		try
		{
			ConfigCategory gui = globalConfigFile.getCategory(Strings.CONFIG_CATEGORY_GUI);
			ConfigCategory gen = globalConfigFile.getCategory(Strings.CONFIG_CATEGORY_GEN);
			ConfigCategory general = temperatureFile.getCategory(Strings.CONFIG_CATEGORY_GENERAL);

			gui.put(Strings.CONFIG_TEMP_BAR_X, new Property(Strings.CONFIG_TEMP_BAR_X, Integer.toString(AC_TickHandler.x), Type.INTEGER));
			gui.put(Strings.CONFIG_TEMP_BAR_Y, new Property(Strings.CONFIG_TEMP_BAR_Y, Integer.toString(AC_TickHandler.y), Type.INTEGER));
			gen.put(Strings.CONFIG_SNOW_LAYERS_ENABLED, new Property(Strings.CONFIG_SNOW_LAYERS_ENABLED, Boolean.toString(AC_TickHandler.snowLayersEnabled), Type.BOOLEAN));
			general.putAll(storage.save());

			ConfigCategory shipsCategory = ships.getCategory("ships");
			shipsCategory.putAll(generatedShips.save());
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Strings.MOD_NAME + " can't save all of its configuration options");
		}
		finally
		{
			globalConfigFile.save();
			temperatureFile.save();
			ships.save();
		}
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		File cfgFile = event.getSuggestedConfigurationFile();
		if(! cfgFile.exists())
		{
			try
			{
				cfgFile.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		globalConfigFile = new Configuration(cfgFile);

		try
		{
			globalConfigFile.load();

			AC_TickHandler.x = globalConfigFile.get(Strings.CONFIG_CATEGORY_GUI, Strings.CONFIG_TEMP_BAR_X, 0).getInt(0);
			AC_TickHandler.y = globalConfigFile.get(Strings.CONFIG_CATEGORY_GUI, Strings.CONFIG_TEMP_BAR_Y, 0).getInt(0);
			AC_TickHandler.snowLayersEnabled = globalConfigFile.get(Strings.CONFIG_CATEGORY_GEN, Strings.CONFIG_SNOW_LAYERS_ENABLED, true).getBoolean(true);
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Strings.MOD_NAME + " can't load its configuration");
		}
		finally
		{
			globalConfigFile.save();
		}

		DimensionManager.registerProviderType(dimension, AC_WorldProvider.class, false);
		DimensionManager.registerDimension(dimension, dimension);

		freezePotion = new AC_Potions(27, true, 0xffff).setIconIndex(2, 2).setPotionName(Strings.POTION_FREEZING_NAME);

	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		//		MainMenuAPI.registerMenu("Arcticraft", AC_MenuBase.class);
		AC_Block.initializeBlocks();
		AC_Item.initializeItems();
		AC_Recipes.initializeRecipes();
		AC_Block.registerBlocks();
		AC_Block.nameBlocks();
		AC_Item.nameItems();
		AC_EntityRegistry.registerEntityEggs();
		AC_ChestLootHelper.initializeChestLoot();
		AC_Achievements.initAchievements();
		proxy.reigsterRenderThings();
		proxy.registerTickHandler();
		proxy.registerKeyHandler();

		LanguageRegistry.instance().addStringLocalization("death.attack.Freezing", "%1$s froze");
		LanguageRegistry.instance().addStringLocalization("death.attack.ice shard", "%1$s was pierced iceshard");

		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		MinecraftForge.EVENT_BUS.register(new AC_ForgeEvents());
		GameRegistry.registerWorldGenerator(new AC_WorldGenerator());	
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{}

	public static void talkStuff(String s, World par1World)
	{
		Iterator<EntityPlayer> players = par1World.playerEntities.iterator();

		while(players.hasNext())
		{
			EntityPlayer player = players.next();

			if(player instanceof EntityPlayerMP)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage(s);
			}
		}

	}
}
