package arcticraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import arcticraft.items.*;
import arcticraft.main.*;
import arcticraft.tile_entities.*;

public class AC_Block
{

	/* Core Dimension Blocks */
	public static Block frostGrass;
	public static Block frostDirt;
	public static Block frostStone;
	public static Block frostCobble;
	public static Block acWaterStill;
	public static Block acWaterFlowing;
	public static Block thickSnow;
	public static Block arcaneStone;

	/* 'Frost' Type Blocks */
	public static Block frostPlanks;
	public static Block frostStairs;
	public static Block frostWoodDoubleSlab;
	public static Block frostWoodSingleSlab;
	public static Block frostFence;
	public static Block frostLadders;
	public static Block frostChest;
	public static Block frostDoor;

	/* Land Generation Blocks */
	public static Block frostLog;
	public static Block frostLeaves;
	public static Block frostSapling;
	public static Block glacierLog;
	public static Block glacierLeaves;

	/* Dungeon Blocks */
	public static Block mossyFrostCobble;
	public static Block unbreakableIce;
	public static Block amouryDoor;
	public static Block frostFlame;

	/* Crop Blocks + Crop Items */
	public static Block floranPlant;
	public static Item floranBerry;
	public static Block whiteberryBush;
	public static Item whiteberry;
	public static Block tilledFrostField;

	/* Decoration Blocks */
	public static Block mysticalSnow;
	public static Block crystalGlass;
	public static Block tekkiteBlock;
	public static Block glacianBlock;
	public static Block rigentemBlock;
	public static Block escariaBlock;

	/* 'Snow' Type Blocks */
	public static Block snowPressurePlate;
	public static Block snowTrapdoor;

	/* Ore Blocks */
	public static Block tekkiteOre;
	public static Block escariaOre;
	public static Block frigusOre;
	public static Block rigentemOre;
	public static Block glacianOre;
	public static Block eriumOre;

	/* 'Machine' Blocks */
	public static Block arcticFurnaceIdle;
	public static Block arcticFurnaceBurning;
	public static Block freezerIdle;
	public static Block freezerBurning;

	/* Blocks w/ Custom Model */
	public static Block statue;
	public static Block captainStatue;
	public static Block campfire;

	/* Miscellaneous Blocks */
	public static Block Lantern;

	public static void initializeBlocks()
	{
		frostGrass = new AC_BlockFrostGrass(230).setHardness(0.6F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frostgrass").func_111022_d("grass").setStepSound(Block.soundGrassFootstep);
		frostDirt = new Block(231, Material.ground).setHardness(0.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_dirt").func_111022_d("ac:frost_dirt").setStepSound(Block.soundGrassFootstep);
		frostStone = new AC_BlockFrostStone(232).setHardness(1.5F).setResistance(2.0F).setUnlocalizedName("frost_stone").setCreativeTab(MainRegistry.tabBlocks).func_111022_d("ac:frost_stone").setStepSound(Block.soundStoneFootstep);
		frostCobble = new Block(1503, Material.rock).setHardness(2.0F).setResistance(2.0F).setUnlocalizedName("frost_cobble").setCreativeTab(MainRegistry.tabBlocks).func_111022_d("ac:frost_cobble").setStepSound(Block.soundStoneFootstep);
		acWaterFlowing = new AC_BlockACWaterFlowing(233).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("acwaterflowing").func_111022_d("ac:ice_water_flowing");
		acWaterStill = new AC_BlockACWaterStill(234).setUnlocalizedName("acwaterstill").setCreativeTab(MainRegistry.tabBlocks).func_111022_d("ac:ice_water_stationary");
		mysticalSnow = new AC_BlockMysticalSnow(1506).setHardness(0.8F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("mystical_snow").func_111022_d("ac:mystical_snow").setStepSound(Block.soundClothFootstep);
		frostSapling = new AC_BlockFrostSapling(1507).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_sapling").func_111022_d("ac:frost_sapling").setStepSound(Block.soundGrassFootstep);
		frostLeaves = new AC_BlockFrostLeaves(1508).setHardness(0.2F).setCreativeTab(MainRegistry.tabBlocks).setLightOpacity(1).setUnlocalizedName("frost_leaves").setStepSound(Block.soundGrassFootstep);
		frostLog = new AC_BlockFrostLog(1509).setHardness(2.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_log").setStepSound(Block.soundWoodFootstep);
		glacierLeaves = new AC_BlockGlacierLeaves(1511).setHardness(0.2F).setCreativeTab(MainRegistry.tabBlocks).setLightOpacity(1).setUnlocalizedName("glacier_leaves").setStepSound(Block.soundGrassFootstep);
		glacierLog = new AC_BlockGlacierLog(1512).setHardness(2.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("glacier_log").setStepSound(Block.soundWoodFootstep);
		thickSnow = new AC_BlockThickSnow(1514).setHardness(0.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("thick_snow").func_111022_d("ac:thick_snow").setStepSound(Block.soundSnowFootstep);
		arcaneStone = new AC_BlockArcaneStone(240).setHardness(1.5F).setResistance(2.3F).setCreativeTab(MainRegistry.tabBlocks).setLightValue(1.0F).setUnlocalizedName("arcane_stone").func_111022_d("ac:arcane_stone").setStepSound(Block.soundGlassFootstep);
		Lantern = new AC_BlockLantern(1516).setLightValue(1.0F).setUnlocalizedName("lantern").func_111022_d("ac:lantern").setStepSound(Block.soundWoodFootstep);
		frostPlanks = new Block(1517, Material.wood).setHardness(2.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frostplanks").func_111022_d("ac:frost_planks").setStepSound(Block.soundWoodFootstep);
		frostStairs = new AC_BlockFrostStairs(1518, frostPlanks, 0).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("froststairs").setStepSound(Block.soundWoodFootstep);
		frostFence = new BlockFence(1520, "ac:frost_planks", Material.wood).setHardness(2.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frostfence").setStepSound(Block.soundWoodFootstep);
		frostLadders = new AC_BlockFrostLadder(1521).setHardness(1.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frostladders").func_111022_d("ac:frost_ladder").setStepSound(Block.soundGlassFootstep);
		mossyFrostCobble = new Block(1522, Material.rock).setHardness(2.0F).setResistance(10.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_mossy_cobble").func_111022_d("ac:frost_mossy_cobble").setStepSound(Block.soundStoneFootstep);
		unbreakableIce = new AC_BlockUnbreakableIce(1523, 0).setBlockUnbreakable().setResistance(6000000.0F).setCreativeTab(MainRegistry.tabBlocks).setLightOpacity(3).setUnlocalizedName("ice").func_111022_d("ac:ice").setStepSound(Block.soundGlassFootstep);
		snowPressurePlate = new AC_BlockSnowPressurePlate(1524, "AC:snow_pressure_plate", Material.rock, EnumMobType.players).setHardness(0.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("snow_pressure_plate").func_111022_d("ac:snow_pressure_plate").setStepSound(Block.soundSnowFootstep);
		snowTrapdoor = new AC_BlockSnowTrapdoor(1525, Material.snow).setHardness(0.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("snow_trapdoor").func_111022_d("ac:snow_trapdoor").setStepSound(Block.soundSnowFootstep);
		tekkiteOre = new AC_BlockOres(1526).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("tektite_ore").func_111022_d("ac:tekkite_ore").setStepSound(Block.soundStoneFootstep);
		escariaOre = new AC_BlockOres(1527).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("escaria_ore").func_111022_d("ac:escaria_ore").setStepSound(Block.soundStoneFootstep);
		frigusOre = new AC_BlockOres(1528).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frigus_ore").func_111022_d("ac:frigus_ore").setStepSound(Block.soundStoneFootstep);
		rigentemOre = new AC_BlockOres(1529).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("rigentem_ore").func_111022_d("ac:rigentem_ore").setStepSound(Block.soundStoneFootstep);
		glacianOre = new AC_BlockOres(1530).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("glacian_ore").func_111022_d("ac:glacian_ore").setStepSound(Block.soundStoneFootstep);
		eriumOre = new AC_BlockOres(1531).setHardness(3.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("erium_ore").func_111022_d("ac:erium_ore").setStepSound(Block.soundStoneFootstep);
		arcticFurnaceIdle = new AC_BlockACFurnace(1532, false).setHardness(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("ac_furnace").setStepSound(Block.soundStoneFootstep);
		arcticFurnaceBurning = new AC_BlockACFurnace(1533, true).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("ac_furnace").setStepSound(Block.soundStoneFootstep);
		freezerIdle = new AC_BlockFreezer(1534, false).setHardness(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("freezer").setStepSound(Block.soundMetalFootstep);
		freezerBurning = new AC_BlockFreezer(1535, true).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("freezer").setStepSound(Block.soundMetalFootstep);
		frostWoodDoubleSlab = (BlockHalfSlab) (new AC_BlockFrostSlab(1537, true)).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("frost_wood_double_slab").setStepSound(Block.soundWoodFootstep);
		frostWoodSingleSlab = (BlockHalfSlab) (new AC_BlockFrostSlab(1538, false)).setHardness(2.0F).setResistance(5.0F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_wood_single_slab").setStepSound(Block.soundWoodFootstep);
		frostChest = new AC_BlockFrostChest(1539, 0).setHardness(2.0F).setResistance(3.5F).setUnlocalizedName("frost_chest").setCreativeTab(MainRegistry.tabBlocks).func_111022_d("ac:frost_chest").setStepSound(Block.soundWoodFootstep);
		statue = new AC_BlockStatue(1540, Material.iron).setHardness(3.0F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("statue").func_111022_d("ac:plain_statue_icon").setStepSound(Block.soundStoneFootstep);
		frostDoor = new AC_BlockFrostDoor(1542, Material.wood).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("icedoor");
		tilledFrostField = new AC_BlockTilledFrostField(1543).setUnlocalizedName("frostfarmland").setStepSound(Block.soundGravelFootstep);
		/*
		 * The crops berry has to be initialized before the crop to avoid NPE so thats why they're in the Blocks class.
		 */

		floranBerry = new ItemFood(6501, 6, false).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("floran_berry").func_111206_d("ac:floran_berry");
		floranPlant = new AC_BlockFloranCrop(1544, Material.plants, tilledFrostField.blockID, floranBerry.itemID).setUnlocalizedName("floranPlant").setStepSound(Block.soundGravelFootstep);
		whiteberry = new AC_ItemWhiteberry(6502, 2, 0.6F, 1545, 1545).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("Whiteberry").func_111206_d("ac:whiteberry");
		whiteberryBush = new AC_BlockWhiteberry(1545, Material.plants, tilledFrostField.blockID, whiteberry.itemID).setUnlocalizedName("whiteberry_bush").setStepSound(Block.soundGravelFootstep);
		/*
		 * The crops berry has to be initialized before the crop to avoid NPE so thats why they're in the Blocks class.
		 */
		captainStatue = new AC_BlockCaptainStatue(1546, Material.iron).setHardness(3.0F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("captain_statue_icon").func_111022_d("ac:captain_statue_icon").setStepSound(Block.soundStoneFootstep);
		campfire = new AC_BlockCampfire(1547, Material.wood).setHardness(1.0F).setCreativeTab(MainRegistry.tabBlocks).setLightValue(1.0F).setUnlocalizedName("campfire_icon").func_111022_d("ac:campfire_icon").setStepSound(Block.soundStoneFootstep);
		amouryDoor = new AC_BlockAmouryDoor(1549, Material.wood).setBlockUnbreakable().setResistance(6000000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("amoury_door").func_111022_d("ac:amoury_door");
		crystalGlass = new AC_BlockCrystalGlass(1550).setStepSound(Block.soundGlassFootstep).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("crystal_glass").func_111022_d("ac:crystal_glass");
		frostFlame = new AC_BlockFrostFlame(1551).setStepSound(Block.soundPowderFootstep).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("frost_flame").func_111022_d("frost_flame");
		tekkiteBlock = new Block(1552, Material.rock).setHardness(3.5F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("tekkite_block").func_111022_d("ac:tekkite_block").setStepSound(Block.soundStoneFootstep);
		glacianBlock = new Block(1553, Material.rock).setHardness(3.5F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("glacian_block").func_111022_d("ac:glacian_block").setStepSound(Block.soundStoneFootstep);
		escariaBlock = new Block(1554, Material.rock).setHardness(3.5F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("escaria_block").func_111022_d("ac:escaria_block").setStepSound(Block.soundStoneFootstep);
		rigentemBlock = new Block(1555, Material.rock).setHardness(3.5F).setResistance(3.5F).setCreativeTab(MainRegistry.tabBlocks).setUnlocalizedName("rigentem_block").func_111022_d("ac:rigentem_block").setStepSound(Block.soundStoneFootstep);
	}

	public static void registerBlocks()
	{
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
		GameRegistry.registerBlock(frostWoodSingleSlab, "Frost_SingleSlab");
		GameRegistry.registerBlock(frostWoodDoubleSlab, "Frost_DoubleSlab");
		GameRegistry.registerBlock(statue, "Statue");
		GameRegistry.registerBlock(floranPlant, "Floran_Plant");
		GameRegistry.registerBlock(tilledFrostField, "Tilled_Frost_Field");
		GameRegistry.registerBlock(whiteberryBush, "Whiteberry_Bush");
		GameRegistry.registerBlock(captainStatue, "Captain_Statue");
		GameRegistry.registerBlock(campfire, "Campfire");
		GameRegistry.registerBlock(amouryDoor, "Amoury_door");
		GameRegistry.registerBlock(crystalGlass, "Ice_Crystal_Glass");
		GameRegistry.registerBlock(frostFlame, "Frost_Flame");
		GameRegistry.registerBlock(tekkiteBlock, "Tekkite_Block");
		GameRegistry.registerBlock(glacianBlock, "Glacia_Block");
		GameRegistry.registerBlock(rigentemBlock, "Rigentem_Block");
		GameRegistry.registerBlock(escariaBlock, "Escaria_Block");
		GameRegistry.registerBlock(arcticFurnaceIdle, "AC_Furnace_Idle");
		GameRegistry.registerBlock(arcticFurnaceBurning, "AC_Furnace_Buring");
		GameRegistry.registerBlock(freezerIdle, "Freeer_Idle");
		GameRegistry.registerBlock(freezerBurning, "Freezer_Buring");
		GameRegistry.registerBlock(frostChest, "AC_FrostChest");
		GameRegistry.registerTileEntity(AC_TileEntityArcticFurnace.class, "tileEntityArcticFurnace");
		GameRegistry.registerTileEntity(AC_TileEntityFreezer.class, "tileEntityFreezer");
		GameRegistry.registerTileEntity(AC_TileEntityFrostChest.class, "tileEntityFrostChest");
		GameRegistry.registerTileEntity(AC_TileEntityLantern.class, "tileEntityLantern");
		GameRegistry.registerTileEntity(AC_TileEntityStatue.class, "tileEntityStatue");
		GameRegistry.registerTileEntity(AC_TileEntityCaptainStatue.class, "tileEntityCaptainStatue");
		GameRegistry.registerTileEntity(AC_TileEntityCampfire.class, "tileEntityCampfire");
	}

	public static void nameBlocks()
	{
		LanguageRegistry.addName(frostDoor, "Frost Door");
		LanguageRegistry.addName(frostChest, "Frost Chest");
		LanguageRegistry.addName(frostGrass, "Frost Grass");
		LanguageRegistry.addName(frostDirt, "Frost Dirt");
		LanguageRegistry.addName(frostStone, "Frost Stone");
		LanguageRegistry.addName(frostCobble, "Frost Cobblestone");
		LanguageRegistry.addName(acWaterFlowing, "Water");
		LanguageRegistry.addName(acWaterStill, "Water");
		LanguageRegistry.addName(mysticalSnow, "Mystical Snow");
		LanguageRegistry.addName(frostLeaves, "Frost Leaves");
		LanguageRegistry.addName(frostLog, "Frost Log");
		LanguageRegistry.addName(frostSapling, "Frost Sapling");
		LanguageRegistry.addName(glacierLeaves, "Glacier Leaves");
		LanguageRegistry.addName(glacierLog, "Glacier Log");
		LanguageRegistry.addName(thickSnow, "Thick Snow");
		LanguageRegistry.addName(arcaneStone, "Arcane Stone");
		LanguageRegistry.addName(Lantern, "Do not use this lantern, use the other one");
		LanguageRegistry.addName(unbreakableIce, "Unbreakable Ice");
		LanguageRegistry.addName(mossyFrostCobble, "Mossy Frost Cobble");
		LanguageRegistry.addName(snowTrapdoor, "Snow Trapdoor");
		LanguageRegistry.addName(snowPressurePlate, "Snow Pressure Plate");
		LanguageRegistry.addName(glacianOre, "Glacian Ore");
		LanguageRegistry.addName(escariaOre, "Escaria Ore");
		LanguageRegistry.addName(frigusOre, "Frigus Ore");
		LanguageRegistry.addName(rigentemOre, "Rigentem Ore");
		LanguageRegistry.addName(tekkiteOre, "Tekkite Ore");
		LanguageRegistry.addName(eriumOre, "Erium Ore");
		LanguageRegistry.addName(arcticFurnaceIdle, "Arctic Frunace");
		LanguageRegistry.addName(freezerIdle, "Freezer");
		LanguageRegistry.addName(frostWoodDoubleSlab, "Frost Wood Double Slab");
		LanguageRegistry.addName(frostWoodSingleSlab, "Frost Wood Slab");
		LanguageRegistry.addName(statue, "Statue");
		LanguageRegistry.addName(floranBerry, "Floran Berry");
		LanguageRegistry.addName(whiteberry, "Whiteberry");
		LanguageRegistry.addName(captainStatue, "Captain Statue");
		LanguageRegistry.addName(campfire, "Campfire");
		LanguageRegistry.addName(amouryDoor, "Armoured");
		LanguageRegistry.addName(frostFlame, "Frost Flame");
		LanguageRegistry.addName(frostStairs, "Frost Stairs");
		LanguageRegistry.addName(frostLadders, "Frost Ladders");
		LanguageRegistry.addName(frostPlanks, "Frost Planks");
		LanguageRegistry.addName(frostFence, "Frost Fence");
		LanguageRegistry.addName(tekkiteBlock, "Tekkite Block");
		LanguageRegistry.addName(rigentemBlock, "Rigentem Block");
		LanguageRegistry.addName(glacianBlock, "Glacian Block");
		LanguageRegistry.addName(escariaBlock, "Escaria Block");
		LanguageRegistry.addName(crystalGlass, "Crystal Glass");
		LanguageRegistry.addName(floranPlant, "Floran Plant");
	}

	public static void harvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(tekkiteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(escariaOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(frigusOre, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(rigentemOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glacianOre, "pickaxe", 2);
	}

}
