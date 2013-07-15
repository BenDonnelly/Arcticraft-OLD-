package arcticraft.main;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.common.Property.Type;
import net.minecraftforge.fluids.Fluid;
import arcticraft.blocks.AC_Block;
import arcticraft.creative_tabs.AC_TabBlocks;
import arcticraft.creative_tabs.AC_TabCombat;
import arcticraft.creative_tabs.AC_TabFood;
import arcticraft.creative_tabs.AC_TabMaterial;
import arcticraft.creative_tabs.AC_TabMisc;
import arcticraft.creative_tabs.AC_TabTools;
import arcticraft.data_store.TemperatureDataStorage;
import arcticraft.entities.AC_EntityEgg;
import arcticraft.gui.AC_GuiHandler;
import arcticraft.items.AC_Item;
import arcticraft.recipes.AC_Recipes;
import arcticraft.world.AC_WorldGenerator;
import arcticraft.world.AC_WorldProvider;
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

@Mod(modid = "ac", name = "Arcticraft", version = "[1.5] V.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "AC_EskimoTrade", "AC_EskimoTalk" }, packetHandler = AC_PacketHandler.class)
public class MainRegistry {

	@Instance("ac")
	public static MainRegistry instance = new MainRegistry();
	private AC_GuiHandler guiHandler = new AC_GuiHandler();

	@SidedProxy(clientSide = "arcticraft.main.AC_ClientProxy", serverSide = "arcticraft.main.AC_CommonProxy")
	public static AC_CommonProxy proxy;
	public static int dimension = DimensionManager.getNextFreeDimId();

	/*Creative Tabs*/
	public static CreativeTabs tabTools = new AC_TabTools(CreativeTabs.getNextID(), "Tabtools");
	public static CreativeTabs tabBlocks = new AC_TabBlocks(CreativeTabs.getNextID(), "TabBlocks");
	public static CreativeTabs tabCombat = new AC_TabCombat(CreativeTabs.getNextID(), "TabCombat");
	public static CreativeTabs tabFood = new AC_TabFood(CreativeTabs.getNextID(), "TabFood");
	public static CreativeTabs tabMaterial = new AC_TabMaterial(CreativeTabs.getNextID(), "TabMaterial");
	public static CreativeTabs tabMisc = new AC_TabMisc(CreativeTabs.getNextID(), "TabMisc");

	/*Potions*/
	public static Potion freezePotion;
	
	
	/*Configuration Files*/
	private Configuration temperatureFile;
	private TemperatureDataStorage storage = new TemperatureDataStorage();
	private Configuration globalConfigFile;

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) 
	{
		storage.clear();
		System.out.println("I am getting called!!!! :D");

		File worldConfigFile = new File(new File(Minecraft.getMinecraft().mcDataDir, "ac_data"), "playertemps_" + MinecraftServer.getServer().getWorldName() + ".cfg");
		if (!worldConfigFile.exists()) {
			try {
				worldConfigFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		temperatureFile = new Configuration(worldConfigFile);
		temperatureFile.load();
		temperatureFile.save();

		ConfigCategory general = temperatureFile.getCategory("general");
		Map<String, Property> entries = general.getValues();
		storage.load(entries);
		AC_TickHandler.value = storage.getTemperature("Player");
	}

	@EventHandler
	public void serverStopping(FMLServerStoppingEvent event) 
	{
		storage.setTemperature("Player", AC_TickHandler.value);
		ConfigCategory general = temperatureFile.getCategory("general"); 
		general.putAll(storage.save());
		temperatureFile.save();
		ConfigCategory gui = globalConfigFile.getCategory("gui");
		gui.put("temp-bar-x", new Property("temp-bar-x", "" + AC_TickHandler.x, Type.INTEGER));
		gui.put("temp-bar-y", new Property("temp-bar-y", "" + AC_TickHandler.y, Type.INTEGER));
		globalConfigFile.save();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{

		File cfgFile = event.getSuggestedConfigurationFile();
		if (!cfgFile.exists()) {
			try {
				cfgFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		globalConfigFile = new Configuration(cfgFile);
		globalConfigFile.load();
		globalConfigFile.save();
		ConfigCategory gui = globalConfigFile.getCategory("gui");
		if (gui.get("temp-bar-x") != null) {
			AC_TickHandler.x = gui.get("temp-bar-x").getInt();
			AC_TickHandler.y = gui.get("temp-bar-y").getInt();
		}
	
		DimensionManager.registerProviderType(dimension, AC_WorldProvider.class, false);
		DimensionManager.registerDimension(dimension, dimension);		
		
	
		freezePotion = new AC_Potions(27, true, 0xffff).setIconIndex(2, 2).setPotionName("Freezing");
		
		

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
		AC_EntityEgg.registerEntityEggs();
		proxy.reigsterRenderThings();
		proxy.registerTickHandler();
		proxy.registerKeyHandler();
		GameRegistry.registerWorldGenerator(new AC_WorldGenerator());

		
		
		LanguageRegistry.instance().addStringLocalization("death.attack.Freezing", "%1$s froze");
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		MinecraftForge.EVENT_BUS.register(new AC_ForgeEvents());

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}

	
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
