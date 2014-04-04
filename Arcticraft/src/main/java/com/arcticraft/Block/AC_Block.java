package com.arcticraft.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;

import com.arcticraft.creativetabs.AC_CreativeTabs;
import com.arcticraft.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class AC_Block {
	
	public static void mainRegistry(){
		initialiseBlocks();
		registerBlocks();
	}
	
	public static Block debugBlock;

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
	public static Block acWaterIce;

	/* Dungeon Blocks */
	public static Block mossyFrostCobble;
	public static Block unbreakableIce;

	public static Block amouryDoor;
	public static Block frostFlame;

	/* Crop Blocks */
	public static Block floranPlant;
	public static Block whiteberryBush;
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
	public static Block captainStatue;
	public static Block campfire;
	public static Block caveman;
	public static Block tresureChest;
	public static Block cannon;
	
	/* Miscellaneous Blocks */
	public static Block lantern;
	
	public static void initialiseBlocks(){
		frostGrass = new FrostGrass(Material.grass).setHardness(0.5F).setBlockName("FrostGrass").setBlockTextureName(Strings.MODID + ":frost_grass").setStepSound(Block.soundTypeGrass).setCreativeTab(AC_CreativeTabs.tabBlock);
		frostDirt = new FrostDirt().setBlockName("FrostDirt").setHardness(0.5F).setBlockTextureName(Strings.MODID + ":frost_dirt").setStepSound(Block.soundTypeGravel).setCreativeTab(AC_CreativeTabs.tabBlock);
		frostStone = new FrostStone().setBlockName("FrostStone").setHardness(2.0F).setBlockTextureName(Strings.MODID + ":frost_stone").setStepSound(Block.soundTypePiston).setCreativeTab(AC_CreativeTabs.tabBlock);
		frostCobble = new FrostCobble().setBlockName("FrostCobble").setHardness(2.0F).setBlockTextureName(Strings.MODID + ":frost_cobble").setStepSound(Block.soundTypePiston).setCreativeTab(AC_CreativeTabs.tabBlock);
		acWaterFlowing = new FrostWaterFlowing(Material.water).setBlockName("FrostWaterFlowing").setBlockTextureName(Strings.MODID + ":ice_water_flowing").setCreativeTab(AC_CreativeTabs.tabBlock);
		acWaterStill = new FrostWaterStill(Material.water).setBlockName("FrostWaterStill").setBlockTextureName(Strings.MODID + ":ice_water_stationary").setCreativeTab(AC_CreativeTabs.tabBlock);
		arcaneStone = new ArcaneStone(Material.redstoneLight).setHardness(1.5F).setBlockName("ArcaneStone").setBlockTextureName(Strings.MODID + ":arcane_stone").setCreativeTab(AC_CreativeTabs.tabBlock);
		
		frostPlanks = new FrostPlanks(Material.wood).setHardness(1.5F).setBlockName("FrostPlanks").setBlockTextureName(Strings.MODID + ":frost_planks").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostStairs = new FrostStairs(frostPlanks, 0).setHardness(1.5F).setBlockName("FrostStairs").setBlockTextureName(Strings.MODID + ":arcane_stone").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostWoodDoubleSlab = new FrostSlab(true).setHardness(1.5F).setBlockName("FrostDoubleSlab").setBlockTextureName(Strings.MODID + ":frostslab").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostWoodSingleSlab = new FrostSlab(false).setHardness(1.5F).setBlockName("FrostSlab").setBlockTextureName(Strings.MODID + ":frostslab").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostFence = new FrostFence(Strings.MODID + ":frost_planks", Material.wood).setHardness(1.5F).setBlockName("FrostFence").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostLadders = new FrostLadder().setHardness(1.5F).setBlockName("FrostLadder").setBlockTextureName(Strings.MODID + ":frost_ladder").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostChest = new FrostChest(0).setHardness(1.5F).setBlockName("FrostChest").setBlockTextureName(Strings.MODID + ":frost_chest").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostDoor = new AC_Door(Material.wood).setHardness(1.5F).setBlockName("FrostDoor").setBlockTextureName(Strings.MODID + ":frost_door");
	
		frostLog = new FrostLog(Material.wood).setHardness(1.5F).setBlockName("FrostLog").setCreativeTab(AC_CreativeTabs.tabBlock).setBlockTextureName(Strings.MODID + ":frost_log");
		frostLeaves = new FrostLeaves(Material.leaves).setHardness(0.5F).setBlockName("FrostLeaves").setCreativeTab(AC_CreativeTabs.tabBlock);
		frostSapling = new FrostSapling().setBlockName("FrostSapling").setBlockTextureName(Strings.MODID + ":frost_sapling").setCreativeTab(AC_CreativeTabs.tabBlock);
	
		mossyFrostCobble = new MossyFrostCobble(Material.rock).setHardness(2.0F).setBlockName("MossyFrost").setBlockTextureName(Strings.MODID + ":frost_mossy_cobble").setCreativeTab(AC_CreativeTabs.tabBlock);
		amouryDoor =  new AC_Door(Material.iron).setHardness(3.0F).setBlockName("ArmouryDoor").setBlockTextureName(Strings.MODID + ":amoury_door");
	
		frostFlame = new FrostFire().setBlockName("FrostFire").setCreativeTab(AC_CreativeTabs.tabBlock).setBlockTextureName(Strings.MODID + ":frost_flame");
	
		floranPlant = new AC_Crop().setBlockTextureName(Strings.MODID + ":floran").setBlockName("floran");
		tilledFrostField = new FrostTillField().setHardness(2.0F).setBlockName("FrostTilled").setBlockTextureName(Strings.MODID + ":frostfarmland").setCreativeTab(AC_CreativeTabs.tabBlock);
		
		mysticalSnow = new MysticalSnow(Material.snow).setBlockName("MysticalSnow").setCreativeTab(AC_CreativeTabs.tabBlock).setBlockTextureName(Strings.MODID + ":mystical_snow");
	
		tekkiteBlock = new AC_MaterialBlock(Material.iron).setBlockName("TekkiteBlock").setBlockTextureName(Strings.MODID + ":tekkite_block").setCreativeTab(AC_CreativeTabs.tabBlock);
		glacianBlock = new AC_MaterialBlock(Material.iron).setBlockName("GlacianBlock").setBlockTextureName(Strings.MODID + ":glacian_block").setCreativeTab(AC_CreativeTabs.tabBlock);
		rigentemBlock = new AC_MaterialBlock(Material.iron).setBlockName("RigentemBlock").setBlockTextureName(Strings.MODID + ":rigentem_block").setCreativeTab(AC_CreativeTabs.tabBlock);
		escariaBlock = new AC_MaterialBlock(Material.iron).setBlockName("EscariaBlock").setBlockTextureName(Strings.MODID + ":escaria_block").setCreativeTab(AC_CreativeTabs.tabBlock);
		
		snowPressurePlate = new AC_BlockPressurePlate("snow", Material.snow, BlockPressurePlate.Sensitivity.everything).setBlockName("SnowPressurePlate").setCreativeTab(AC_CreativeTabs.tabBlock);
		snowTrapdoor = new AC_BlockTrapDoor(Material.snow).setBlockName("SnowTrapDoor").setCreativeTab(AC_CreativeTabs.tabBlock).setBlockTextureName("snow");
	
		tekkiteOre = new AC_Ore(Material.iron).setBlockName("TekkiteOre").setBlockTextureName(Strings.MODID + ":tekkite_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
		escariaOre = new AC_Ore(Material.iron).setBlockName("EscariaOre").setBlockTextureName(Strings.MODID + ":escaria_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
		frigusOre = new AC_Ore(Material.rock).setBlockName("FrigusOre").setBlockTextureName(Strings.MODID + ":frigus_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
		rigentemOre = new AC_Ore(Material.iron).setBlockName("RigentemOre").setBlockTextureName(Strings.MODID + ":rigentem_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
		glacianOre = new AC_Ore(Material.iron).setBlockName("GlacianOre").setBlockTextureName(Strings.MODID + ":glacian_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
		eriumOre = new AC_Ore(Material.iron).setBlockName("EriumOre").setBlockTextureName(Strings.MODID + ":erium_ore").setCreativeTab(AC_CreativeTabs.tabBlock);
	
		arcticFurnaceIdle = new AC_Furnace(false).setBlockName("ArcticFurnaceIdle").setCreativeTab(AC_CreativeTabs.tabBlock);
		arcticFurnaceBurning = new AC_Furnace(true).setBlockName("ArcticFurnaceLit");
	
		freezerIdle  =new AC_Freezer(false).setBlockName("FreezerIdle").setCreativeTab(AC_CreativeTabs.tabBlock);
		freezerBurning = new AC_Freezer(true).setBlockName("FreezerBurning").setCreativeTab(AC_CreativeTabs.tabBlock);
	
		captainStatue = new CaptainStatue(Material.rock).setBlockName("CaptainStatue").setCreativeTab(AC_CreativeTabs.tabBlock);
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(frostGrass, "AC_FrostGrass");
		GameRegistry.registerBlock(frostDirt, "AC_FrostDirt");
		GameRegistry.registerBlock(frostStone, "AC_FrostStone");
		GameRegistry.registerBlock(frostCobble, "AC_FrostCobble");
		GameRegistry.registerBlock(acWaterFlowing, "AC_IceWaterFlowing");
		GameRegistry.registerBlock(acWaterStill, "AC_IceWaterStill");
		GameRegistry.registerBlock(frostPlanks, frostPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(frostStairs, frostStairs.getUnlocalizedName());
		GameRegistry.registerBlock(frostWoodDoubleSlab, frostWoodDoubleSlab.getUnlocalizedName());
		GameRegistry.registerBlock(frostWoodSingleSlab, frostWoodSingleSlab.getUnlocalizedName());
		GameRegistry.registerBlock(frostChest, frostChest.getUnlocalizedName());
		GameRegistry.registerBlock(arcaneStone, arcaneStone.getUnlocalizedName());
		GameRegistry.registerBlock(frostFence, frostFence.getUnlocalizedName());
		GameRegistry.registerBlock(frostLadders, frostLadders.getUnlocalizedName());
		GameRegistry.registerBlock(frostDoor, frostDoor.getUnlocalizedName());
		GameRegistry.registerBlock(frostLog, frostLog.getUnlocalizedName());
		GameRegistry.registerBlock(frostLeaves, frostLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(frostSapling, frostSapling.getUnlocalizedName());
		GameRegistry.registerBlock(mossyFrostCobble, mossyFrostCobble.getUnlocalizedName());
		GameRegistry.registerBlock(amouryDoor, amouryDoor.getUnlocalizedName());
		//GameRegistry.registerBlock(frostFlame, frostFlame.getUnlocalizedName());
		GameRegistry.registerBlock(floranPlant, floranPlant.getUnlocalizedName());
		GameRegistry.registerBlock(tilledFrostField, tilledFrostField.getUnlocalizedName());
		GameRegistry.registerBlock(mysticalSnow, mysticalSnow.getUnlocalizedName());
		GameRegistry.registerBlock(tekkiteBlock, tekkiteBlock.getUnlocalizedName());
		GameRegistry.registerBlock(glacianBlock, glacianBlock.getUnlocalizedName());
		GameRegistry.registerBlock(rigentemBlock, rigentemBlock.getUnlocalizedName());
		GameRegistry.registerBlock(escariaBlock, escariaBlock.getUnlocalizedName());
		GameRegistry.registerBlock(snowPressurePlate, snowPressurePlate.getUnlocalizedName());
		GameRegistry.registerBlock(snowTrapdoor, snowTrapdoor.getUnlocalizedName());
		GameRegistry.registerBlock(tekkiteOre, tekkiteOre.getUnlocalizedName());
		GameRegistry.registerBlock(escariaOre, escariaOre.getUnlocalizedName());
		GameRegistry.registerBlock(frigusOre, frigusOre.getUnlocalizedName());
		GameRegistry.registerBlock(rigentemOre, rigentemOre.getUnlocalizedName());
		GameRegistry.registerBlock(glacianOre, glacianOre.getUnlocalizedName());
		GameRegistry.registerBlock(eriumOre, eriumOre.getUnlocalizedName());
		GameRegistry.registerBlock(arcticFurnaceIdle, arcticFurnaceIdle.getUnlocalizedName());
		GameRegistry.registerBlock(arcticFurnaceBurning, arcticFurnaceBurning.getUnlocalizedName());
		GameRegistry.registerBlock(freezerIdle, freezerIdle.getUnlocalizedName());
		GameRegistry.registerBlock(freezerBurning, freezerBurning.getUnlocalizedName());
		GameRegistry.registerBlock(captainStatue, captainStatue.getUnlocalizedName());
	}
	
}
