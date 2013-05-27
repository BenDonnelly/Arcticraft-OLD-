package arcticraft.main;

import java.util.Iterator;

import net.aetherteam.mainmenu_api.MainMenuAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import arcticraft.blocks.AC_BlockACFurnace;
import arcticraft.blocks.AC_BlockACWaterFlowing;
import arcticraft.blocks.AC_BlockACWaterStill;
import arcticraft.blocks.AC_BlockArcaneStone;
import arcticraft.blocks.AC_BlockFlower;
import arcticraft.blocks.AC_BlockFreezer;
import arcticraft.blocks.AC_BlockFrostCobble;
import arcticraft.blocks.AC_BlockFrostDirt;
import arcticraft.blocks.AC_BlockFrostGrass;
import arcticraft.blocks.AC_BlockFrostLadder;
import arcticraft.blocks.AC_BlockFrostLeaves;
import arcticraft.blocks.AC_BlockFrostLog;
import arcticraft.blocks.AC_BlockFrostPlanks;
import arcticraft.blocks.AC_BlockFrostSapling;
import arcticraft.blocks.AC_BlockFrostSlab;
import arcticraft.blocks.AC_BlockFrostStairs;
import arcticraft.blocks.AC_BlockFrostStone;
import arcticraft.blocks.AC_BlockGlacierLeaves;
import arcticraft.blocks.AC_BlockGlacierLog;
import arcticraft.blocks.AC_BlockLantern;
import arcticraft.blocks.AC_BlockMossyFrostCobble;
import arcticraft.blocks.AC_BlockMysticalSnow;
import arcticraft.blocks.AC_BlockOres;
import arcticraft.blocks.AC_BlockSnowPressurePlate;
import arcticraft.blocks.AC_BlockSnowTrapdoor;
import arcticraft.blocks.AC_BlockStatue;
import arcticraft.blocks.AC_BlockThickSnow;
import arcticraft.blocks.AC_BlockUnbreakableIce;
import arcticraft.blocks.AC_FrostChest;
import arcticraft.blocks.AC_FrostDoor;
import arcticraft.creative_tabs.AC_TabBlocks;
import arcticraft.creative_tabs.AC_TabCombat;
import arcticraft.creative_tabs.AC_TabFood;
import arcticraft.creative_tabs.AC_TabMaterial;
import arcticraft.creative_tabs.AC_TabMisc;
import arcticraft.creative_tabs.AC_TabTools;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.entities.AC_EntityFrostZombieBoss;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.entities.AC_EntityIceCreeper;
import arcticraft.entities.AC_EntityIceShard;
import arcticraft.entities.AC_EntityMage;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.entities.AC_EntityPirate;
import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.gui.AC_GuiHandler;
import arcticraft.items.AC_FrostDoorPlace;
import arcticraft.items.AC_ItemArmour;
import arcticraft.items.AC_ItemAxe;
import arcticraft.items.AC_ItemBomb;
import arcticraft.items.AC_ItemBucket;
import arcticraft.items.AC_ItemFruits;
import arcticraft.items.AC_ItemHeatPack;
import arcticraft.items.AC_ItemHoe;
import arcticraft.items.AC_ItemIceCream;
import arcticraft.items.AC_ItemLantern;
import arcticraft.items.AC_ItemPickaxe;
import arcticraft.items.AC_ItemShovel;
import arcticraft.items.AC_ItemSword;
import arcticraft.tile_entities.AC_TileEntityArcticFurnace;
import arcticraft.tile_entities.AC_TileEntityFreezer;
import arcticraft.tile_entities.AC_TileEntityLantern;
import arcticraft.tile_entities.TileEntityFrostChest;
import arcticraft.world.AC_WorldGenerator;
import arcticraft.world.AC_WorldProvider;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "AC", name = "Arcticraft", version = "[1.5] V.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "AC_mod" }, packetHandler = AC_PacketHandler.class)


public class MainRegistry 
{
	@Instance("AC")
	public static MainRegistry instance = new MainRegistry();
	private AC_GuiHandler guiHandler = new AC_GuiHandler();

	@SidedProxy(clientSide = "arcticraft.main.AC_ClientProxy", serverSide = "arcticraft.main.AC_CommonProxy")
	public static AC_CommonProxy proxy;
	public static int dimension = DimensionManager.getNextFreeDimId();
	static int startEntityId = 327;
	
	//Creative Tabs
	public static CreativeTabs tabTools = new AC_TabTools(CreativeTabs.getNextID(),"Tabtools"); 
	public static CreativeTabs tabBlocks = new AC_TabBlocks(CreativeTabs.getNextID(),"TabBlocks"); 
	public static CreativeTabs tabCombat = new AC_TabCombat(CreativeTabs.getNextID(),"TabCombat");
	public static CreativeTabs tabFood = new AC_TabFood(CreativeTabs.getNextID(),"TabFood"); 
	public static CreativeTabs tabMaterial = new AC_TabMaterial(CreativeTabs.getNextID(),"TabMaterial"); 
	public static CreativeTabs tabMisc = new AC_TabMisc(CreativeTabs.getNextID(),"TabMisc"); 
	
	//Core dimension blocks & items
	public static Block frostGrass;
	public static Block frostDirt;
	public static Block frostStone;
	public static Block frostCobble;
	public static Block acWaterStill;
	public static Block acWaterFlowing;
	public static Item bucketEmpty;
	public static Item bucketIcyWater;
	public static Block thickSnow;
	public static Block arcaneStone;
	
	//Frost type things. 
	public static Block frostPlanks;
	public static Block frostStairs;
	public static Block frostWoodDoubleSlab;
	public static Block frostWoodSingleSlab;
	public static Block frostFence;
	public static Item frostSticks;
	public static Block frostLadders; 
	
	public static Block frostChest;
	
	//Items
	public static Item MystFruit;
	public static Item GlacierFruit;
	public static Block Lantern;
	public static Item IceShard;
	public static Item penguinMeat;
	public static Item penguinMeatCooked;
	public static Item penguinFeather;
	public static Item itemLantern;
	public static Item arcaneDust;
	public static Item heatPack;
	
	//Tools and Armour
	private static ItemAxe axe;
	private static ItemPickaxe pickaxe;
	private static ItemSpade spade;
	private static ItemHoe hoe;
	private static ItemSword sword;

	public static Item TekkitePickaxe;
	public static Item TekkiteAxe;
	public static Item TekkiteHoe;
	public static Item TekkiteShovel;
	public static Item TekkiteSword;

	public static Item TekkiteHelmet;
	public static Item TekkitePlate;
	public static Item TekkiteLegs;
	public static Item TekkiteBoots;

	public static Item EscariaPickaxe;
	public static Item EscariaAxe;
	public static Item EscariaHoe;
	public static Item EscariaShovel;
	public static Item EscariaSword;

	public static Item EscariaHelmet;
	public static Item EscariaPlate;
	public static Item EscariaLegs;
	public static Item EscariaBoots;
	
	public static Item RigentemPickaxe;
	public static Item RigentemAxe;
	public static Item RigentemHoe;
	public static Item RigentemShovel;
	public static Item RigentemSword;
	
	public static Item RigentemHelmet;
	public static Item RigentemPlate;
	public static Item RigentemLegs;
	public static Item RigentemBoots;
	
	public static Item GlacianPickaxe;
	public static Item GlacianAxe;
	public static Item GlacianHoe;
	public static Item GlacianShovel;
	public static Item GlacianSword;
	
	public static Item GlacianHelmet;
	public static Item GlacianPlate;
	public static Item GlacianLegs;
	public static Item GlacianBoots;
	
	public static Item ArcticStonePickaxe;
	public static Item ArcticStoneAxe;
	public static Item ArcticStoneHoe;
	public static Item ArcticStoneShovel;
	public static Item ArcticStoneSword;
	
	public static Item FrostWoodPickaxe;
	public static Item FrostWoodAxe;
	public static Item FrostWoodHoe;
	public static Item FrostWoodShovel;
	public static Item FrostWoodSword;
	//Tools and armour
	
	//Land Generation
	public static Block frostLog;
	public static Block frostLeaves;
	public static Block frostSapling;
	public static Block glacierLog;
	public static Block glacierLeaves;
	public static Block frostFlower;
	
	//Dungeon loot and blocks
	public static Block mossyFrostCobble;
	public static Block unbreakableIce;
	public static Item iceCream;
	public static Item bomb;

	//Decoration blocks
	public static Block mysticalSnow;
	
	//snow blocks
	public static Block snowPressurePlate;
	public static Block snowTrapdoor;
	
	//Ores
	public static Block tekkiteOre;
	public static Block escariaOre;
	public static Block frigusOre;
	public static Block rigentemOre;
	public static Block glacianOre;
	public static Block eriumOre;

	//Ore Drops
	public static Item tekkiteGem;
	public static Item escariaGem;
	public static Item frigus;
	public static Item glacianIngot;
	public static Item rigentemIngot;
	public static Item eriumGem;

	//GUIs
	public static Block arcticFurnaceIdle;
	public static Block arcticFurnaceBurning;
	
	public static Block freezerIdle;
	public static Block freezerBurning;
	
	public static Block frostDoor;
	public static Item frostDoorPlace;
	
	//Blocks with a Techne Model
	public static Block statue; 
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
	    KeyBindingRegistry.registerKeyBinding(new AC_KeyBindHandler());
	    MainMenuAPI.registerMenu("Arcticraft", AC_MenuBase.class);
		
		DimensionManager.registerProviderType(dimension, AC_WorldProvider.class, false);
		DimensionManager.registerDimension(dimension, dimension);
		
		EnumToolMaterial TekkiteTool = EnumHelper.addToolMaterial("Tekkite Tool", 2, 250, 5.1F, 2, 22);
		EnumArmorMaterial TekkiteArmor = EnumHelper.addArmorMaterial("Tekkite Armor", 15, new int[] { 2, 6, 5, 2 }, 22);

		EnumToolMaterial EscariaTool = EnumHelper.addToolMaterial("Escaria Tool", 2, 310, 5.1F, 2, 22);
		EnumArmorMaterial EscariaArmor = EnumHelper.addArmorMaterial("Escaria Armor", 17, new int[] {2, 6, 5, 2}, 22);
		
		EnumToolMaterial RigentemTool = EnumHelper.addToolMaterial("Rigentem Tool", 2, 350, 6.0F, 2, 15);
		EnumArmorMaterial RigentemArmor = EnumHelper.addArmorMaterial("Rigentem Armor", 19, new int[] {3, 7, 6, 3}, 15);
		
		EnumToolMaterial GlacianTool = EnumHelper.addToolMaterial("Glacian Tool", 4, 900, 10.0F, 5, 18);
		EnumArmorMaterial GlacianArmor = EnumHelper.addArmorMaterial("Glacian Armor", 35, new int[] {5, 10, 8, 5}, 18);
			
		frostDoorPlace = new AC_FrostDoorPlace(2000, Material.wood).setUnlocalizedName("AC:icedoor").setCreativeTab(tabMisc); 
		frostDoor = new AC_FrostDoor(1541, Material.wood).setHardness(3.0F).setUnlocalizedName("AC:???").setCreativeTab(tabBlocks);
		frostGrass = new AC_BlockFrostGrass(230).setHardness(0.6F).setCreativeTab(tabBlocks).setUnlocalizedName("frostgrass").setStepSound(Block.soundGrassFootstep);
		frostDirt = new AC_BlockFrostDirt(231).setHardness(0.5F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frost_dirt").setStepSound(Block.soundGrassFootstep);
		frostStone = new AC_BlockFrostStone(232).setHardness(1.5F).setResistance(2.0F).setUnlocalizedName("AC:frost_stone").setCreativeTab(tabBlocks);
		frostCobble = new AC_BlockFrostCobble(1503).setHardness(2.0F).setResistance(2.0F).setUnlocalizedName("AC:frost_cobble").setCreativeTab(tabBlocks);
		acWaterFlowing = new AC_BlockACWaterFlowing(233).setCreativeTab(tabBlocks).setUnlocalizedName("acwaterflowing");
		acWaterStill = new AC_BlockACWaterStill(234).setUnlocalizedName("acwaterstill").setCreativeTab(tabBlocks);
		mysticalSnow = new AC_BlockMysticalSnow(1506).setHardness(0.8F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:mystical_snow").setStepSound(Block.soundClothFootstep);
		frostSapling = new AC_BlockFrostSapling(1507).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frost_sapling").setStepSound(Block.soundGrassFootstep);
		frostLeaves = new AC_BlockFrostLeaves(1508).setHardness(0.2F).setCreativeTab(tabBlocks).setLightOpacity(1).setUnlocalizedName("AC:frost_leaves").setStepSound(Block.soundGrassFootstep);
		frostLog = new AC_BlockFrostLog(1509).setHardness(2.0F).setCreativeTab(tabBlocks).setUnlocalizedName("frost_log").setStepSound(Block.soundWoodFootstep);
		glacierLeaves = new AC_BlockGlacierLeaves(1511).setHardness(0.2F).setCreativeTab(tabBlocks).setLightOpacity(1).setUnlocalizedName("AC:glacier_leaves").setStepSound(Block.soundGrassFootstep); 
		glacierLog = new AC_BlockGlacierLog(1512).setHardness(2.0F).setCreativeTab(tabBlocks).setUnlocalizedName("glacier_log").setStepSound(Block.soundWoodFootstep);
		thickSnow = new AC_BlockThickSnow(1514).setHardness(0.1F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:thick_snow").setStepSound(Block.soundSnowFootstep);
		arcaneStone = new AC_BlockArcaneStone(240).setHardness(1.5F).setResistance(2.3F).setCreativeTab(tabBlocks).setLightValue(1.0F).setUnlocalizedName("AC:arcane_stone").setStepSound(Block.soundGlassFootstep);
		Lantern = new AC_BlockLantern(1516).setLightValue(1.0F).setUnlocalizedName("AC:lantern").setStepSound(Block.soundWoodFootstep);
		frostPlanks = new AC_BlockFrostPlanks(1517).setHardness(2.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frostplanks").setStepSound(Block.soundWoodFootstep);
		frostStairs = new AC_BlockFrostStairs(1518, frostPlanks, 0).setCreativeTab(tabBlocks).setUnlocalizedName("froststairs").setStepSound(Block.soundWoodFootstep);
		frostFence = new BlockFence(1520, "AC:frostplanks", Material.wood).setHardness(2.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("frostfence").setStepSound(Block.soundWoodFootstep);
		frostLadders = new AC_BlockFrostLadder(1521).setHardness(1.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frostladders").setStepSound(Block.soundWoodFootstep);
		mossyFrostCobble = new AC_BlockMossyFrostCobble(1522).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frost_mossy_cobble").setStepSound(Block.soundStoneFootstep);
		unbreakableIce =  new AC_BlockUnbreakableIce(1523, 0).setBlockUnbreakable().setResistance(6000000.0F).setCreativeTab(tabBlocks).setLightOpacity(3).setUnlocalizedName("AC:ice").setStepSound(Block.soundGlassFootstep);
		snowPressurePlate = new AC_BlockSnowPressurePlate(1524,  "AC:snow_pressure_plate", Material.rock, EnumMobType.players).setHardness(0.5F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:snow_pressure_plate").setStepSound(Block.soundSnowFootstep);
		snowTrapdoor = new AC_BlockSnowTrapdoor(1525, Material.snow).setHardness(0.5F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:snow_trapdoor").setStepSound(Block.soundSnowFootstep);	
		tekkiteOre = new AC_BlockOres(1526).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:tektite_ore");
		escariaOre = new AC_BlockOres(1527).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:escaria_ore");
		frigusOre = new AC_BlockOres(1528).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frigus_ore");
		rigentemOre = new AC_BlockOres(1529).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:rigentem_ore");
		glacianOre = new AC_BlockOres(1530).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:glacian_ore");
		eriumOre = new AC_BlockOres(1531).setHardness(3.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:erium_ore");
		arcticFurnaceIdle = new AC_BlockACFurnace(1532, false).setHardness(3.5F).setCreativeTab(tabBlocks).setUnlocalizedName("ac_furnace");
		arcticFurnaceBurning = new AC_BlockACFurnace(1533, true).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("ac_furnace");
		freezerIdle = new AC_BlockFreezer(1534, false).setHardness(3.5F).setCreativeTab(tabBlocks).setUnlocalizedName("freezer");
		freezerBurning = new AC_BlockFreezer(1535, true).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("freezer");
		frostFlower = new AC_BlockFlower(1536, Material.plants).setCreativeTab(tabBlocks).setUnlocalizedName("AC:frost_flower");
		frostWoodDoubleSlab = (BlockHalfSlab) (new AC_BlockFrostSlab(1537, true)).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("frost_wood_double_slab");
		frostWoodSingleSlab = (BlockHalfSlab) (new AC_BlockFrostSlab(1538, false)).setHardness(2.0F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("frost_wood_single_slab");
		frostChest = new AC_FrostChest(1539, 0).setHardness(2.0F).setResistance(3.5F).setUnlocalizedName("AC:frost_chest").setCreativeTab(tabBlocks);
		statue = new AC_BlockStatue(1540, Material.iron).setHardness(3.0F).setResistance(3.5F).setCreativeTab(tabBlocks).setUnlocalizedName("AC:plain_statue");
		
		
		
		//Items
		bucketIcyWater = new AC_ItemBucket(6200, acWaterFlowing.blockID).setCreativeTab(tabMisc).setUnlocalizedName("AC:BucketIcyWater");
		bucketEmpty = new AC_ItemBucket(6201, 0).setCreativeTab(tabMisc).setUnlocalizedName("AC:BucketIcyEmpty");
		MystFruit = new AC_ItemFruits(6202, 0, false).setCreativeTab(tabFood).setUnlocalizedName("AC:mystical_fruit");
		GlacierFruit = (new AC_ItemFruits(6203, 0, false).setCreativeTab(tabFood).setUnlocalizedName("AC:glacier_fruit"));
		IceShard = new Item(6204).setCreativeTab(tabCombat).setUnlocalizedName("AC:ice_shard");
	
		
		TekkitePickaxe = new AC_ItemPickaxe(6205, TekkiteTool).setCreativeTab(tabTools).setUnlocalizedName("Tekkite Pickaxe");
		TekkiteAxe = new AC_ItemAxe(6206, TekkiteTool).setCreativeTab(tabTools).setUnlocalizedName("articcraft:tekkiteAxe");
		TekkiteHoe = new AC_ItemHoe(6207, TekkiteTool).setCreativeTab(tabTools).setUnlocalizedName("Tekkite Hoe");
		TekkiteSword = new AC_ItemSword(6208, TekkiteTool).setCreativeTab(tabTools).setUnlocalizedName("Tekkite Sword");
		TekkiteShovel = new AC_ItemShovel(6209, TekkiteTool).setCreativeTab(tabTools).setUnlocalizedName("Tekkite Spade");

		TekkiteHelmet = new AC_ItemArmour(6210, TekkiteArmor, proxy.addArmor("Tekkite"), 0).setCreativeTab(tabCombat).setUnlocalizedName("Tekkite Helmet");
		TekkitePlate = new AC_ItemArmour(6211, TekkiteArmor, proxy.addArmor("Tekkite"), 1).setCreativeTab(tabCombat).setUnlocalizedName("Tekkite Plate");
		TekkiteLegs = new AC_ItemArmour(6212, TekkiteArmor, proxy.addArmor("Tekkite"), 2).setCreativeTab(tabCombat).setUnlocalizedName("Tekkite Legs");
		TekkiteBoots = new AC_ItemArmour(6213, TekkiteArmor, proxy.addArmor("Tekkite"), 3).setCreativeTab(tabCombat).setUnlocalizedName("Tekkite Boots");

		EscariaPickaxe = new AC_ItemPickaxe(6214, EscariaTool).setCreativeTab(tabTools).setUnlocalizedName("Escaria Pickaxe");
		EscariaAxe = new AC_ItemAxe(6215, EscariaTool).setCreativeTab(tabTools).setUnlocalizedName("escariaAxe");
		EscariaHoe = new AC_ItemHoe(6216, EscariaTool).setCreativeTab(tabTools).setUnlocalizedName("Escaria Hoe");
		EscariaSword = new AC_ItemSword(6217, EscariaTool).setCreativeTab(tabTools).setUnlocalizedName("Escaria Sword");
		EscariaShovel = new AC_ItemShovel(6218, EscariaTool).setCreativeTab(tabTools).setUnlocalizedName("Escaria Spade");
		
		EscariaHelmet = new AC_ItemArmour(6219, EscariaArmor, proxy.addArmor("Escaria"), 0).setCreativeTab(tabCombat).setUnlocalizedName("Escaria Helmet");
		EscariaPlate = new AC_ItemArmour(6220, EscariaArmor, proxy.addArmor("Escaria"), 1).setCreativeTab(tabCombat).setUnlocalizedName("Escaria Plate");
		EscariaLegs = new AC_ItemArmour(6221, EscariaArmor, proxy.addArmor("Escaria"), 2).setCreativeTab(tabCombat).setUnlocalizedName("Escaria Legs");
		EscariaBoots = new AC_ItemArmour(6222, EscariaArmor, proxy.addArmor("Escaria"), 3).setCreativeTab(tabCombat).setUnlocalizedName("Escaria Boots");
		
		RigentemPickaxe = new AC_ItemPickaxe(6223, RigentemTool).setCreativeTab(tabTools).setUnlocalizedName("Rigentem Pickaxe");
		RigentemAxe = new AC_ItemAxe(6224, RigentemTool).setCreativeTab(tabTools).setUnlocalizedName("rigentemAxe");
		RigentemHoe = new AC_ItemHoe(6225, RigentemTool).setCreativeTab(tabTools).setUnlocalizedName("Rigentem Hoe");
		RigentemSword = new AC_ItemSword(6226, RigentemTool).setCreativeTab(tabTools).setUnlocalizedName("Rigentem Sword");
		RigentemShovel = new AC_ItemShovel(6227, RigentemTool).setCreativeTab(tabTools).setUnlocalizedName("Rigentem Spade");
		
		RigentemHelmet = new AC_ItemArmour(6228, RigentemArmor, proxy.addArmor("Rigentem"), 0).setCreativeTab(tabCombat).setUnlocalizedName("Rigentem Helmet");
		RigentemPlate = new AC_ItemArmour(6229, RigentemArmor, proxy.addArmor("Rigentem"), 1).setCreativeTab(tabCombat).setUnlocalizedName("Rigentem Plate");
		RigentemLegs = new AC_ItemArmour(6230, RigentemArmor, proxy.addArmor("Rigentem"), 2).setCreativeTab(tabCombat).setUnlocalizedName("Rigentem Legs");
		RigentemBoots = new AC_ItemArmour(6231, RigentemArmor, proxy.addArmor("Rigentem"), 3).setCreativeTab(tabCombat).setUnlocalizedName("Rigentem Boots");
		
		GlacianPickaxe = new AC_ItemPickaxe(6232, GlacianTool).setCreativeTab(tabTools).setUnlocalizedName("Glacian Pickaxe");
		GlacianAxe = new AC_ItemAxe(6233, GlacianTool).setCreativeTab(tabTools).setUnlocalizedName("articcraft:glaciansAxe");
		GlacianHoe = new AC_ItemHoe(6234, GlacianTool).setCreativeTab(tabTools).setUnlocalizedName("Glacian Hoe");
		GlacianSword = new AC_ItemSword(6235, GlacianTool).setCreativeTab(tabTools).setUnlocalizedName("Glacian Sword");
		GlacianShovel = new AC_ItemShovel(6236, GlacianTool).setCreativeTab(tabTools).setUnlocalizedName("Glacian Spade");
		
		GlacianHelmet = new AC_ItemArmour(6237, GlacianArmor, proxy.addArmor("Glacian"), 0).setCreativeTab(tabCombat).setUnlocalizedName("Glacian Helmet");
		GlacianPlate = new AC_ItemArmour(6238, GlacianArmor, proxy.addArmor("Glacian"), 1).setCreativeTab(tabCombat).setUnlocalizedName("Glacian Plate");
		GlacianLegs = new AC_ItemArmour(6239, GlacianArmor, proxy.addArmor("Glacian"), 2).setCreativeTab(tabCombat).setUnlocalizedName("Glacian Legs");
		GlacianBoots = new AC_ItemArmour(6240, GlacianArmor, proxy.addArmor("Glacian"), 3).setCreativeTab(tabCombat).setUnlocalizedName("Glacian Boots");
		
		ArcticStonePickaxe = new AC_ItemPickaxe(6241, EnumToolMaterial.STONE).setCreativeTab(tabTools).setUnlocalizedName("Arctic Stone Pickaxe");
		ArcticStoneAxe = new AC_ItemAxe(6242, EnumToolMaterial.STONE).setCreativeTab(tabTools).setUnlocalizedName("iceAxe");
		ArcticStoneHoe = new AC_ItemHoe(6243, EnumToolMaterial.STONE).setCreativeTab(tabTools).setUnlocalizedName("Arctic Stone Hoe");
		ArcticStoneSword = new AC_ItemSword(6244, EnumToolMaterial.STONE).setCreativeTab(tabTools).setUnlocalizedName("Arctic Stone Sword");
		ArcticStoneShovel = new AC_ItemShovel(6245, EnumToolMaterial.STONE).setCreativeTab(tabTools).setUnlocalizedName("Arctic Stone Spade");
		
		FrostWoodPickaxe = new AC_ItemPickaxe(6246, EnumToolMaterial.WOOD).setCreativeTab(tabTools).setUnlocalizedName("Frost Wood Pickaxe");
		FrostWoodAxe = new AC_ItemAxe(6247, EnumToolMaterial.WOOD).setCreativeTab(tabTools).setUnlocalizedName("frostWoodAxe");
		FrostWoodHoe = new AC_ItemHoe(6248, EnumToolMaterial.WOOD).setCreativeTab(tabTools).setUnlocalizedName("Frost Wood Hoe");
		FrostWoodSword = new AC_ItemSword(6249, EnumToolMaterial.WOOD).setCreativeTab(tabTools).setUnlocalizedName("Frost Wood Sword");
		FrostWoodShovel = new AC_ItemShovel(6250, EnumToolMaterial.WOOD).setCreativeTab(tabTools).setUnlocalizedName("Frost Wood Spade");
		
		frostSticks = new Item(6251).setCreativeTab(tabMaterial).setUnlocalizedName("AC:froststicks");
		penguinMeat = new ItemFood(6252, 4, true).setCreativeTab(tabFood).setUnlocalizedName("AC:penguin_meat");
		penguinMeatCooked = new ItemFood(6253, 8, true).setCreativeTab(tabFood).setUnlocalizedName("AC:penguin_meat_cooked");
		penguinFeather = new Item(6254).setCreativeTab(tabMaterial).setUnlocalizedName("AC:penguin_feather");
		tekkiteGem = new Item(6255).setCreativeTab(tabMaterial).setUnlocalizedName("AC:tektike_gem");
		escariaGem = new Item(6256).setCreativeTab(tabMaterial).setUnlocalizedName("AC:escaria_gem");
		frigus = new Item(6257).setCreativeTab(tabMaterial).setUnlocalizedName("AC:frigus");
		glacianIngot = new Item(6258).setCreativeTab(tabMaterial).setUnlocalizedName("AC:glacian");
		rigentemIngot = new Item(6259).setCreativeTab(tabMaterial).setUnlocalizedName("AC:rigentem");
		eriumGem = new Item(6260).setCreativeTab(tabMaterial).setUnlocalizedName("AC:erium_gem");
		iceCream = new AC_ItemIceCream(6261, 4, 1.3F, true).setAlwaysEdible().setCreativeTab(tabFood).setUnlocalizedName("icecream");	
		itemLantern = new AC_ItemLantern(6262, this.Lantern).setCreativeTab(tabBlocks).setUnlocalizedName("AC:lantern");
		arcaneDust = new Item(6263).setCreativeTab(tabMisc).setUnlocalizedName("AC:arcaneDust");
		heatPack = new AC_ItemHeatPack(6264).setCreativeTab(tabMisc).setUnlocalizedName("AC:heatpack");
		
		bomb = new AC_ItemBomb(6265).setCreativeTab(tabCombat).setUnlocalizedName("AC:bomb");
		
		
		AC_Recipes.initializeRecipes();
		proxy.reigsterRenderThings();
		proxy.registerTickHandler();

	}
	
	@Init
	public void init(FMLInitializationEvent event)
	{
		
		GameRegistry.registerWorldGenerator(new AC_WorldGenerator());
		
		GameRegistry.registerBlock(frostDoor, "Frost_Door");
		GameRegistry.registerBlock(frostGrass, "Frost_Grass");
		GameRegistry.registerBlock(frostDirt, "Frost_Dirt");
		GameRegistry.registerBlock(frostStone, "Frost_Stone");
		GameRegistry.registerBlock(frostCobble, "Frost_Cobble");
		GameRegistry.registerBlock(acWaterFlowing, "AcWater_Flowing");
		GameRegistry.registerBlock(acWaterStill, "AcWater_Still");
		GameRegistry.registerBlock(mysticalSnow, "Mystical_Snow");
		GameRegistry.registerBlock(frostLeaves, "Frost_leaves");
		GameRegistry.registerBlock(frostLog, "Frost_Log");
		GameRegistry.registerBlock(frostSapling, "Frost_Sapling");
		GameRegistry.registerBlock(glacierLeaves, "Glacier_leaves");
		GameRegistry.registerBlock(glacierLog, "Glacier_Log");
		GameRegistry.registerBlock(thickSnow, "Thick_Snow");
		GameRegistry.registerBlock(arcaneStone, "Arcane Stone");
		GameRegistry.registerBlock(Lantern, "lantern");
		GameRegistry.registerBlock(frostPlanks, "Frost_Planks");
		GameRegistry.registerBlock(frostFence, "Frost_fence");
		GameRegistry.registerBlock(frostLadders, "Frost_Ladder");
		GameRegistry.registerBlock(frostStairs, "Frost_stairs");
		//GameRegistry.registerBlock(frostSlab, "Frost_slab");
		GameRegistry.registerBlock(mossyFrostCobble, "Mossy_frost_cobble");
		GameRegistry.registerBlock(unbreakableIce, "Unbreakable_Ice");
		GameRegistry.registerBlock(snowTrapdoor, "Snow_trapdoor");
		GameRegistry.registerBlock(snowPressurePlate, "Snow_pressure_plate");
		GameRegistry.registerBlock(escariaOre, "Escaria_Ore");
		GameRegistry.registerBlock(tekkiteOre, "Tekkite_Ore");
		GameRegistry.registerBlock(frigusOre, "Frigus_Ore");
		GameRegistry.registerBlock(glacianOre, "Glacian_Ore");
		GameRegistry.registerBlock(rigentemOre, "Rigentem_Ore");
		GameRegistry.registerBlock(eriumOre, "Erium_ore");
		GameRegistry.registerBlock(frostFlower, "Frost_Flower");
		GameRegistry.registerBlock(frostWoodSingleSlab, "Frost_SingleSlab");
		GameRegistry.registerBlock(frostWoodDoubleSlab, "Frost_DoubleSlab");
		GameRegistry.registerBlock(statue, "Statue");
	
		//furnace
		GameRegistry.registerBlock(arcticFurnaceIdle, "AC_Furnace_Idle");
		GameRegistry.registerBlock(arcticFurnaceBurning, "AC_Furnace_Buring");
		GameRegistry.registerTileEntity(AC_TileEntityArcticFurnace.class, "tileEntityArcticFurnace");
		
		
		//Freezer
		GameRegistry.registerBlock(freezerIdle, "Freeer_Idle");
		GameRegistry.registerBlock(freezerBurning, "Freezer_Buring");
		GameRegistry.registerTileEntity(AC_TileEntityFreezer.class, "tileEntityFreezer");

		//Frost Chest
		GameRegistry.registerBlock(frostChest, "AC_FrostChest");
		GameRegistry.registerTileEntity(TileEntityFrostChest.class, "tileEntityFrostChest");
		
		//lantern, feel free to move if needed
		GameRegistry.registerTileEntity(AC_TileEntityLantern.class, "tileEntityLantern");
		
		LanguageRegistry.addName(frostDoorPlace, "Frost Door");
		LanguageRegistry.addName(frostDoor, "Frost Door");
		LanguageRegistry.addName(frostChest, "Frost Chest");
		LanguageRegistry.addName(frostGrass, "Frost Grass");
		LanguageRegistry.addName(frostDirt, "Frost Dirt");
		LanguageRegistry.addName(frostStone, "Frost Stone");
		LanguageRegistry.addName(frostCobble, "Frost Cobblestone");
		LanguageRegistry.addName(acWaterFlowing, "Water");
		LanguageRegistry.addName(acWaterStill, "Water");
		LanguageRegistry.addName(bucketIcyWater, "Icy Water Bucket");
		LanguageRegistry.addName(bucketEmpty, "Empty Water Bucket");
		LanguageRegistry.addName(mysticalSnow, "Mystical Snow");
		LanguageRegistry.addName(frostLeaves, "Frost Leaves");
		LanguageRegistry.addName(frostLog, "Frost Log");
		LanguageRegistry.addName(frostSapling, "Frost Sapling");
		LanguageRegistry.addName(glacierLeaves, "Glacier Leaves");
		LanguageRegistry.addName(glacierLog, "Glacier Log");
		LanguageRegistry.addName(MystFruit, "Mysterious Fruit");
		LanguageRegistry.addName(GlacierFruit, "Glacier Fruit");
		LanguageRegistry.addName(thickSnow, "Thick Snow");
		LanguageRegistry.addName(arcaneStone, "Arcane Stone");
		LanguageRegistry.addName(Lantern, "Do not use this lantern, use the other one");		
		LanguageRegistry.addName(IceShard, "Ice Shards");
		//LanguageRegistry.addName(frostSlab, "Frost Slab");
		LanguageRegistry.addName(penguinMeat, "Penguin Meat");
		LanguageRegistry.addName(penguinMeatCooked, "Cooked Penguin Meat");
		LanguageRegistry.addName(unbreakableIce, "Unbreakable Ice");
		LanguageRegistry.addName(mossyFrostCobble, "Mossy Frost Cobble");
		LanguageRegistry.addName(penguinFeather, "Penguin Feather");
		LanguageRegistry.addName(snowTrapdoor, "Snow Trapdoor");
		LanguageRegistry.addName(snowPressurePlate, "Snow Pressure Plate");
		LanguageRegistry.addName(glacianOre, "Glacian Ore");
		LanguageRegistry.addName(escariaOre, "Escaria Ore");
		LanguageRegistry.addName(frigusOre, "Frigus Ore");
		LanguageRegistry.addName(rigentemOre, "Rigentem Ore");
		LanguageRegistry.addName(tekkiteOre, "Tekkite Ore");
		LanguageRegistry.addName(eriumOre, "Erium Ore");
		LanguageRegistry.addName(tekkiteGem, "Tekkite Gem");
		LanguageRegistry.addName(escariaGem, "Escaria Gem");
		LanguageRegistry.addName(rigentemIngot, "Rigentem Ingot");
		LanguageRegistry.addName(glacianIngot, "Glacian Ingot");
		LanguageRegistry.addName(frigus, "frigus");
		LanguageRegistry.addName(eriumGem, "Erium Gem");
		LanguageRegistry.addName(arcticFurnaceIdle, "Arctic Frunace");
		LanguageRegistry.addName(freezerIdle, "Freezer");
		LanguageRegistry.addName(frostFlower, "Slightly Frozen Flower");
		LanguageRegistry.addName(itemLantern, "Lantern");
		LanguageRegistry.addName(arcaneDust, "Arcane Dust");
		LanguageRegistry.addName(heatPack, "Heatpack");
		LanguageRegistry.addName(frostWoodDoubleSlab,"Frost Wood Double Slab");
		LanguageRegistry.addName(frostWoodSingleSlab, "Frost Wood Slab");
		LanguageRegistry.addName(statue, "Statue");
		LanguageRegistry.addName(bomb, "Bomb");
		
		LanguageRegistry.addName(frostSticks, "Frost Sticks");
		LanguageRegistry.addName(frostStairs, "Frost Stairs");
		LanguageRegistry.addName(frostLadders, "Frost Ladders");
		LanguageRegistry.addName(frostPlanks, "Frost Planks");
		LanguageRegistry.addName(frostFence, "Frost Fence");
		
		
		LanguageRegistry.addName(TekkitePickaxe, "Tekkite Pickaxe");
		LanguageRegistry.addName(TekkiteAxe, "Tekkite Axe");
		LanguageRegistry.addName(TekkiteHoe, "Tekkite Hoe");
		LanguageRegistry.addName(TekkiteSword, "Tekkite Sword");
		LanguageRegistry.addName(TekkiteShovel, "Tekkite Spade");
		LanguageRegistry.addName(TekkiteHelmet, "Tekkite Helmet");
		LanguageRegistry.addName(TekkitePlate, "Tekkite Chestplate");
		LanguageRegistry.addName(TekkiteLegs, "Tekkite Pants");
		LanguageRegistry.addName(TekkiteBoots, "Tekkite Boots");
		
		
		LanguageRegistry.addName(EscariaPickaxe, "Escaria Pickaxe");
		LanguageRegistry.addName(EscariaAxe, "Escaria Axe");
		LanguageRegistry.addName(EscariaHoe, "Escaria Hoe");
		LanguageRegistry.addName(EscariaSword, "Escaria Sword");
		LanguageRegistry.addName(EscariaShovel, "Escaria Spade");
		LanguageRegistry.addName(EscariaHelmet, "Escaria Helmet");
		LanguageRegistry.addName(EscariaPlate, "Escaria Chestplate");
		LanguageRegistry.addName(EscariaLegs, "Escaria Pants");
		LanguageRegistry.addName(EscariaBoots, "Escaria Boots");

		
		LanguageRegistry.addName(RigentemPickaxe, "Rigentem Pickaxe");
		LanguageRegistry.addName(RigentemAxe, "Rigentem Axe");
		LanguageRegistry.addName(RigentemHoe, "Rigentem Hoe");
		LanguageRegistry.addName(RigentemSword, "Rigentem Sword");
		LanguageRegistry.addName(RigentemShovel, "Rigentem Spade");
		LanguageRegistry.addName(RigentemHelmet, "Rigentem Helmet");
		LanguageRegistry.addName(RigentemPlate, "Rigentem Chestplate");
		LanguageRegistry.addName(RigentemLegs, "Rigentem Pants");
		LanguageRegistry.addName(RigentemBoots, "Rigentem Boots");
		
		LanguageRegistry.addName(GlacianPickaxe, "Glacian Pickaxe");
		LanguageRegistry.addName(GlacianAxe, "Glacian Axe");
		LanguageRegistry.addName(GlacianHoe, "Glacian Hoe");
		LanguageRegistry.addName(GlacianSword, "Glacian Sword");
		LanguageRegistry.addName(GlacianShovel, "Glacian Spade");
		LanguageRegistry.addName(GlacianHelmet, "Glacian Helmet");
		LanguageRegistry.addName(GlacianPlate, "Glacian Chestplate");
		LanguageRegistry.addName(GlacianLegs, "Glacian Pants");
		LanguageRegistry.addName(GlacianBoots, "Glacian Boots");
		
		LanguageRegistry.addName(FrostWoodPickaxe, "Frost Wood Pickaxe");
		LanguageRegistry.addName(FrostWoodAxe, "Frost Wood Axe");
		LanguageRegistry.addName(FrostWoodHoe, "Frost Wood Hoe");
		LanguageRegistry.addName(FrostWoodSword, "Frost Wood Sword");
		LanguageRegistry.addName(FrostWoodShovel, "Frost Wood Spade");
		
		LanguageRegistry.addName(ArcticStonePickaxe, "Arctic Stone Pickaxe");
		LanguageRegistry.addName(ArcticStoneAxe, "Arctic Stone Axe");
		LanguageRegistry.addName(ArcticStoneHoe, "Arctic Stone Hoe");
		LanguageRegistry.addName(ArcticStoneSword, "Arctic Stone Sword");
		LanguageRegistry.addName(ArcticStoneShovel, "Arctic Stone Spade");
	
		int zombieBackGround = 0x00AFAF;
		int zombieSpots = 0x5FA88E;
		int whiteColor = 0xffffff;
		int blackColor = 0x000000;
		int grayColor = 0x424242;
		int lightGrayColor = 0xEEEEEE;
		int lightBlueColor = 0xAFF5FF;
		int blueishIcyColor = 0x3EA6CF;
		int kindaBlueColor = 0x337BC7;
		int purpleBlueishColor = 0x6419F0;
		
		EntityRegistry.registerGlobalEntityID(AC_EntityMage.class, "Mage", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Mage.name", "The Ancient Ice Mage");
		registerEntityEgg(AC_EntityMage.class, kindaBlueColor, purpleBlueishColor);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityFrostZombie.class, "FrostZombie", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.FrostZombie.name", "Frost Zombie");
		registerEntityEgg(AC_EntityFrostZombie.class, 0x3CDECE, 0x95EAF5);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityIceCreeper.class, "IceCreeper", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.IceCreeper.name", "Ice Creeper");
		registerEntityEgg(AC_EntityIceCreeper.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityPirate.class, "Pirate", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Pirate.name", "Pirate");
		registerEntityEgg(AC_EntityPirate.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityPenguin.class, "Penguin", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Penguin.name", "Penguin");
		registerEntityEgg(AC_EntityPenguin.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityPolarBear.class, "PolarBear", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.PolarBear.name", "Polar Bear");
		registerEntityEgg(AC_EntityPolarBear.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityIceShard.class, "IceShard", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(AC_EntityIceShard.class, "IceShard", 0, this, 128, 1, true);
		 LanguageRegistry.instance().addStringLocalization("entity.articcraft.IceShard.name", "Ice Shard");

		EntityRegistry.registerGlobalEntityID(AC_EntityFrostZombieBoss.class, "FrostZombieBoss", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.FrostZombieBoss.name", "Frost Zombie Boss");
		registerEntityEgg(AC_EntityFrostZombieBoss.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Boar.name", "Boar");
		registerEntityEgg(AC_EntityBoar.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerGlobalEntityID(AC_EntityHusky.class, "Husky", EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity.Husky.name", "Husky");
		registerEntityEgg(AC_EntityHusky.class, 0x3CDECE, 0x1BE056);
		
		EntityRegistry.registerModEntity(AC_EntityBomb.class, "Bomb", 342, this, 64, 10, true);
		
		
	
		
		MinecraftForge.setBlockHarvestLevel(tekkiteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(escariaOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(frigusOre, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rigentemOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glacianOre, "pickaxe", 2);
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}

	public static void talkStuff(String s, World par1World)
	{
		Iterator <EntityPlayer> players = par1World.playerEntities.iterator();

		while (players.hasNext())
		{
			EntityPlayer player = players.next();

			if (player instanceof EntityPlayerMP)
			{
				player.sendChatToPlayer(s);
			}
		}

	}
}
