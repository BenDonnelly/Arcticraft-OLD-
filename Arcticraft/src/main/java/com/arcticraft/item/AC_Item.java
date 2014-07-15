package com.arcticraft.item;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.creativetabs.AC_CreativeTabs;
import com.arcticraft.enums.AC_EnumArmourMaterial;
import com.arcticraft.enums.AC_EnumToolMaterial;
import com.arcticraft.lib.Strings;
import com.arcticraft.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class AC_Item {
	
	public static void mainRegistry(){
		initialiseItems();
		registerItems();
	}
	
	/* Food Items */
	public static Item MystFruit;
	public static Item GlacierFruit;
	public static Item penguinMeat;
	public static Item penguinMeatCooked;
	public static Item emptyCup;
	public static Item teaDrinks;
	public static Item boarMeat;
	public static Item uncookedBoarMeat;
	public static Item floranSeed;
	public static Item floranBerry;

	/* Tools & Armour */

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

	public static Item pirateHat;
	public static Item pirateSword;
	public static Item hikingBoots;
	public static Item woodenClub;

	/* Dungeon Loot */
	public static Item iceCream;
	public static Item bomb;
	public static Item amouryDoor;
	public static Item amouryKey;
	public static Item notchedPickaxe;
	public static Item ignisBlade;
	public static Item archerBow;

	/* Ore Drops */
	public static Item tekkiteGem;
	public static Item escariaGem;
	public static Item frigus;
	public static Item glacianIngot;
	public static Item rigentemIngot;
	public static Item eriumGem;

	/* Records */
	public static Item recordFrozenFeelings;
	public static Item recordWTTC;

	/* Miscellaneous Items */
	public static Item IceShard;
	public static Item penguinFeather;
	public static Item arcaneDust;
	public static Item heatPack;
	public static Item frostSticks;
	public static Item bucketEmpty;
	public static Item bucketIcyWater;
	public static Item frostDoor;
	public static Item invisoStaff;
	public static Item sled;
	public static Item captainLog;
	public static Item lantern;
	public static Item cannonball;
	public static Item pirateHook;
	public static Item jadeite;
	public static Item whiteberrySeed;
	public static Item whiteberry;
	
	public static void initialiseItems() {
		MystFruit = new AC_Fruit().setUnlocalizedName("MystFruit");
		GlacierFruit = new AC_Fruit().setUnlocalizedName("GlacierFruit");
		
		arcaneDust = new Item().setUnlocalizedName("ArcaneDust").setTextureName(Strings.MODID + ":arcaneDust").setCreativeTab(AC_CreativeTabs.tabItem);
		frostDoor = new AC_ItemDoor(Material.wood).setCreativeTab(AC_CreativeTabs.tabBlock).setUnlocalizedName("FrostDoor").setTextureName(Strings.MODID + ":frost_door_icon");
		amouryDoor = new AC_ItemDoor(Material.wood).setCreativeTab(AC_CreativeTabs.tabBlock).setUnlocalizedName("AmouryDoor").setTextureName(Strings.MODID + ":amoury_door");
		
		floranSeed = new AC_ItemSeeds(AC_Block.floranPlant, AC_Block.tilledFrostField).setUnlocalizedName("FloranSeed").setTextureName(Strings.MODID + ":floran_seed").setCreativeTab(AC_CreativeTabs.tabItem);
		floranBerry = new ItemFood(6, false).setCreativeTab(AC_CreativeTabs.tabFood).setUnlocalizedName("FloranBerry").setTextureName(Strings.MODID + ":floran_berry");
		whiteberrySeed = new AC_ItemSeeds(AC_Block.whiteberryBush, AC_Block.tilledFrostField).setUnlocalizedName("WhiteberrySeed").setTextureName(Strings.MODID + ":floran_seed").setCreativeTab(AC_CreativeTabs.tabItem);
		whiteberry = new ItemFood(6, false).setCreativeTab(AC_CreativeTabs.tabFood).setUnlocalizedName("Whiteberry").setTextureName(Strings.MODID + ":whiteberry");
		
		cannonball = new Item().setUnlocalizedName("Cannonball").setCreativeTab(AC_CreativeTabs.tabItem).setTextureName(Strings.MODID + ":cannonball_icon");
	
		penguinMeat = new ItemFood(4, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setUnlocalizedName("PenguinMeat").setTextureName(Strings.MODID + ":penguin_meat");
		penguinMeatCooked = new ItemFood(8, true).setUnlocalizedName("CookedPenguinMeat").setTextureName(Strings.MODID + ":penguin_meat_cooked");
		emptyCup = new Item().setMaxStackSize(8).setUnlocalizedName("EmptyCup").setTextureName(Strings.MODID + ":empty_cup");
		teaDrinks = new ItemTeaDrinks(4, 1.3F, true).setUnlocalizedName("TeaDrinks");
	
		TekkitePickaxe = new AC_ItemPickaxe(AC_EnumToolMaterial.TekkiteTool).setUnlocalizedName("TekkitePickaxe").setTextureName(Strings.MODID + ":tekkitePickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		EscariaPickaxe = new AC_ItemPickaxe(AC_EnumToolMaterial.EscariaTool).setUnlocalizedName("EscariaPickaxe").setTextureName(Strings.MODID + ":escaria_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		RigentemPickaxe = new AC_ItemPickaxe(AC_EnumToolMaterial.RigentemTool).setUnlocalizedName("RigentemPickaxe").setTextureName(Strings.MODID + ":rigentem_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		GlacianPickaxe = new AC_ItemPickaxe(AC_EnumToolMaterial.GlacianTool).setUnlocalizedName("GlacianPickaxe").setTextureName(Strings.MODID + ":glacian_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		ArcticStonePickaxe = new AC_ItemPickaxe(ToolMaterial.STONE).setUnlocalizedName("ArcticStonePickaxe").setTextureName(Strings.MODID + ":arctic_stone_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		FrostWoodPickaxe = new AC_ItemPickaxe(ToolMaterial.WOOD).setUnlocalizedName("FrostWoodPickaxe").setTextureName(Strings.MODID + ":frost_wood_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
	
		TekkiteAxe = new AC_ItemAxe(AC_EnumToolMaterial.TekkiteTool).setUnlocalizedName("TekkiteAxe").setTextureName(Strings.MODID + ":tekkite_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		EscariaAxe = new AC_ItemAxe(AC_EnumToolMaterial.EscariaTool).setUnlocalizedName("EscariaAxe").setTextureName(Strings.MODID + ":escaria_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		RigentemAxe = new AC_ItemAxe(AC_EnumToolMaterial.RigentemTool).setUnlocalizedName("RigentemAxe").setTextureName(Strings.MODID + ":rigentem_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		GlacianAxe = new AC_ItemAxe(AC_EnumToolMaterial.GlacianTool).setUnlocalizedName("GlacianAxe").setTextureName(Strings.MODID + ":glacian_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		ArcticStoneAxe = new AC_ItemAxe(ToolMaterial.STONE).setUnlocalizedName("ArcticStoneAxe").setTextureName(Strings.MODID + ":arctic_stone_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		FrostWoodAxe = new AC_ItemAxe(ToolMaterial.WOOD).setUnlocalizedName("FrostWoodAxe").setTextureName(Strings.MODID + ":frost_wood_axe").setCreativeTab(AC_CreativeTabs.tabTool);
		
		TekkiteShovel = new AC_ItemSpade(AC_EnumToolMaterial.TekkiteTool).setUnlocalizedName("TekkiteSpade").setTextureName(Strings.MODID + ":tekkite_spade").setCreativeTab(AC_CreativeTabs.tabTool);
		EscariaShovel = new AC_ItemSpade(AC_EnumToolMaterial.EscariaTool).setUnlocalizedName("EscariaSpade").setTextureName(Strings.MODID + ":escaria_pickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		RigentemShovel = new AC_ItemSpade(AC_EnumToolMaterial.RigentemTool).setUnlocalizedName("RigentemSpade").setTextureName(Strings.MODID + ":rigentem_spade").setCreativeTab(AC_CreativeTabs.tabTool);
		GlacianShovel = new AC_ItemSpade(AC_EnumToolMaterial.GlacianTool).setUnlocalizedName("GlacianSpade").setTextureName(Strings.MODID + ":glacian_spade").setCreativeTab(AC_CreativeTabs.tabTool);
		ArcticStoneShovel = new AC_ItemSpade(ToolMaterial.STONE).setUnlocalizedName("ArcticStoneSpade").setTextureName(Strings.MODID + ":arctic_stone_spade").setCreativeTab(AC_CreativeTabs.tabTool);
		FrostWoodShovel = new AC_ItemSpade(ToolMaterial.WOOD).setUnlocalizedName("FrostWoodSpade").setTextureName(Strings.MODID + ":frost_wood_spade").setCreativeTab(AC_CreativeTabs.tabTool);
		
		TekkiteHoe = new AC_ItemHoe(AC_EnumToolMaterial.TekkiteTool).setUnlocalizedName("TekkiteHoe").setTextureName(Strings.MODID + ":tekkite_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		EscariaHoe = new AC_ItemHoe(AC_EnumToolMaterial.EscariaTool).setUnlocalizedName("EscariaHoe").setTextureName(Strings.MODID + ":escaria_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		RigentemHoe = new AC_ItemHoe(AC_EnumToolMaterial.RigentemTool).setUnlocalizedName("RigentemHoe").setTextureName(Strings.MODID + ":rigentem_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		GlacianHoe = new AC_ItemHoe(AC_EnumToolMaterial.GlacianTool).setUnlocalizedName("GlacianHoe").setTextureName(Strings.MODID + ":glacian_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		ArcticStoneHoe = new AC_ItemHoe(ToolMaterial.STONE).setUnlocalizedName("ArcticStoneHoe").setTextureName(Strings.MODID + ":arctic_stone_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		FrostWoodHoe = new AC_ItemHoe(ToolMaterial.WOOD).setUnlocalizedName("FrostWoodHoe").setTextureName(Strings.MODID + ":frost_wood_hoe").setCreativeTab(AC_CreativeTabs.tabTool);
		
		TekkiteSword = new AC_ItemSword(AC_EnumToolMaterial.TekkiteTool).setUnlocalizedName("TekkiteSword").setTextureName(Strings.MODID + ":tekkite_sword").setCreativeTab(AC_CreativeTabs.tabTool);
		EscariaSword = new AC_ItemSword(AC_EnumToolMaterial.EscariaTool).setUnlocalizedName("EscariaSword").setTextureName(Strings.MODID + ":escaria_sword").setCreativeTab(AC_CreativeTabs.tabTool);
		RigentemSword = new AC_ItemSword(AC_EnumToolMaterial.RigentemTool).setUnlocalizedName("RigentemSword").setTextureName(Strings.MODID + ":rigentem_sword").setCreativeTab(AC_CreativeTabs.tabTool);
		GlacianSword = new AC_ItemSword(AC_EnumToolMaterial.GlacianTool).setUnlocalizedName("GlacianSword").setTextureName(Strings.MODID + ":glacian_sword").setCreativeTab(AC_CreativeTabs.tabTool);
		ArcticStoneSword = new AC_ItemSword(ToolMaterial.STONE).setUnlocalizedName("ArcticStoneSword").setTextureName(Strings.MODID + ":arctic_stone_sword").setCreativeTab(AC_CreativeTabs.tabTool);
		FrostWoodSword = new AC_ItemSword(ToolMaterial.WOOD).setUnlocalizedName("FrostWoodSword").setTextureName(Strings.MODID + ":frost_wood_sword").setCreativeTab(AC_CreativeTabs.tabTool);
	
		TekkiteHelmet = new AC_Armor(AC_EnumArmourMaterial.TekkiteArmour, MainRegistry.proxy.addArmor("Tekkite"), 0).setUnlocalizedName("TekkiteHelmet").setTextureName(Strings.MODID + ":tekkite_helm").setCreativeTab(AC_CreativeTabs.tabCombat);
		TekkitePlate = new AC_Armor(AC_EnumArmourMaterial.TekkiteArmour, MainRegistry.proxy.addArmor("Tekkite"), 1).setUnlocalizedName("TekkitePlate").setTextureName(Strings.MODID + ":tekkite_plate").setCreativeTab(AC_CreativeTabs.tabCombat);
		TekkiteLegs = new AC_Armor(AC_EnumArmourMaterial.TekkiteArmour, MainRegistry.proxy.addArmor("Tekkite"), 2).setUnlocalizedName("TekkiteLegs").setTextureName(Strings.MODID + ":tekkite_legs").setCreativeTab(AC_CreativeTabs.tabCombat);
		TekkiteBoots = new AC_Armor(AC_EnumArmourMaterial.TekkiteArmour, MainRegistry.proxy.addArmor("Tekkite"), 3).setUnlocalizedName("TekkiteBoots").setTextureName(Strings.MODID + ":tekkite_boots").setCreativeTab(AC_CreativeTabs.tabCombat);
		
		GlacianHelmet = new AC_Armor(AC_EnumArmourMaterial.GlacianArmour, MainRegistry.proxy.addArmor("Glacian"), 0).setUnlocalizedName("GlacianHelmet").setTextureName(Strings.MODID + ":glacian_helm").setCreativeTab(AC_CreativeTabs.tabCombat);
		GlacianPlate = new AC_Armor(AC_EnumArmourMaterial.GlacianArmour, MainRegistry.proxy.addArmor("Glacian"), 1).setUnlocalizedName("GlacianPlate").setTextureName(Strings.MODID + ":glacian_plate").setCreativeTab(AC_CreativeTabs.tabCombat);
		GlacianLegs = new AC_Armor(AC_EnumArmourMaterial.GlacianArmour, MainRegistry.proxy.addArmor("Glacian"), 2).setUnlocalizedName("GlacianLegs").setTextureName(Strings.MODID + ":glacian_legs").setCreativeTab(AC_CreativeTabs.tabCombat);
		GlacianBoots = new AC_Armor(AC_EnumArmourMaterial.GlacianArmour, MainRegistry.proxy.addArmor("Glacian"), 3).setUnlocalizedName("GlacianBoots").setTextureName(Strings.MODID + ":glacian_boots").setCreativeTab(AC_CreativeTabs.tabCombat);
		
		RigentemHelmet = new AC_Armor(AC_EnumArmourMaterial.RigentemArmour, MainRegistry.proxy.addArmor("Rigentem"), 0).setUnlocalizedName("RigentemHelmet").setTextureName(Strings.MODID + ":rigentem_helm").setCreativeTab(AC_CreativeTabs.tabCombat);
		RigentemPlate = new AC_Armor(AC_EnumArmourMaterial.RigentemArmour, MainRegistry.proxy.addArmor("Rigentem"), 1).setUnlocalizedName("RigentemPlate").setTextureName(Strings.MODID + ":rigentem_plate").setCreativeTab(AC_CreativeTabs.tabCombat);
		RigentemLegs = new AC_Armor(AC_EnumArmourMaterial.RigentemArmour, MainRegistry.proxy.addArmor("Rigentem"), 2).setUnlocalizedName("RigentemLegs").setTextureName(Strings.MODID + ":rigentem_legs").setCreativeTab(AC_CreativeTabs.tabCombat);
		RigentemBoots = new AC_Armor(AC_EnumArmourMaterial.RigentemArmour, MainRegistry.proxy.addArmor("Rigentem"), 3).setUnlocalizedName("RigentemBoots").setTextureName(Strings.MODID + ":rigentem_boots").setCreativeTab(AC_CreativeTabs.tabCombat);
		
		EscariaHelmet = new AC_Armor(AC_EnumArmourMaterial.EscariaArmour, MainRegistry.proxy.addArmor("Escaria"), 0).setUnlocalizedName("EscariaHelmet").setTextureName(Strings.MODID + ":escaria_helm").setCreativeTab(AC_CreativeTabs.tabCombat);
		EscariaPlate = new AC_Armor(AC_EnumArmourMaterial.EscariaArmour, MainRegistry.proxy.addArmor("Escaria"), 1).setUnlocalizedName("EscariaPlate").setTextureName(Strings.MODID + ":escaria_plate").setCreativeTab(AC_CreativeTabs.tabCombat);
		EscariaLegs = new AC_Armor(AC_EnumArmourMaterial.EscariaArmour, MainRegistry.proxy.addArmor("Escaria"), 2).setUnlocalizedName("EscariaLegs").setTextureName(Strings.MODID + ":escaria_legs").setCreativeTab(AC_CreativeTabs.tabCombat);
		EscariaBoots = new AC_Armor(AC_EnumArmourMaterial.EscariaArmour, MainRegistry.proxy.addArmor("Escaria"), 3).setUnlocalizedName("EscariaBoots").setTextureName(Strings.MODID + ":escaria_boots").setCreativeTab(AC_CreativeTabs.tabCombat);
	
		pirateHat = new AC_Armor(AC_EnumArmourMaterial.PirateArmour, MainRegistry.proxy.addArmor("Pirate"), 0).setUnlocalizedName("PirateHat").setTextureName(Strings.MODID + ":pirate_hat_icon").setCreativeTab(AC_CreativeTabs.tabCombat);
		pirateSword = new ItemCaptainSword(ToolMaterial.EMERALD).setUnlocalizedName("PirateSword").setCreativeTab(AC_CreativeTabs.tabCombat).setTextureName(Strings.MODID + ":pirateSword");
		woodenClub = new AC_ItemSword(ToolMaterial.WOOD).setUnlocalizedName("WoodenClub").setCreativeTab(AC_CreativeTabs.tabCombat).setTextureName(Strings.MODID + ":wooden_club");
	
		bomb = new ItemBomb().setUnlocalizedName("Bomb").setTextureName(Strings.MODID + ":bomb").setCreativeTab(AC_CreativeTabs.tabCombat);
		amouryKey = new Item().setUnlocalizedName("key").setTextureName(Strings.MODID + ":amoury_key").setCreativeTab(AC_CreativeTabs.tabMisc);
		notchedPickaxe = new NotchedPickaxe(AC_EnumToolMaterial.notchedPickaxeMaterial).setUnlocalizedName("NotchedPickaxe").setCreativeTab(AC_CreativeTabs.tabTool);
		ignisBlade = new IgnisBlade(AC_EnumToolMaterial.ignisBladeMaterial).setUnlocalizedName("IgnisBlade").setCreativeTab(AC_CreativeTabs.tabCombat).setTextureName(Strings.MODID + ":ignis_blade");
		archerBow = new AC_Bow().setTextureName(Strings.MODID + ":archer_bow").setUnlocalizedName("ArcherBow").setCreativeTab(AC_CreativeTabs.tabCombat);
		IceShard = new Item().setTextureName(Strings.MODID + ":ice_shard").setUnlocalizedName("IceShard").setCreativeTab(AC_CreativeTabs.tabCombat);
	}

	public static void registerItems() {
		GameRegistry.registerItem(TekkiteHelmet, TekkiteHelmet.getUnlocalizedName());
		GameRegistry.registerItem(TekkitePlate, TekkitePlate.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteLegs, TekkiteLegs.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteBoots, TekkiteBoots.getUnlocalizedName());
		GameRegistry.registerItem(GlacianHelmet, GlacianHelmet.getUnlocalizedName());
		GameRegistry.registerItem(GlacianPlate, GlacianPlate.getUnlocalizedName());
		GameRegistry.registerItem(GlacianLegs, GlacianLegs.getUnlocalizedName());
		GameRegistry.registerItem(GlacianBoots, GlacianBoots.getUnlocalizedName());
		GameRegistry.registerItem(RigentemHelmet, RigentemHelmet.getUnlocalizedName());
		GameRegistry.registerItem(RigentemPlate, RigentemPlate.getUnlocalizedName());
		GameRegistry.registerItem(RigentemLegs, RigentemLegs.getUnlocalizedName());
		GameRegistry.registerItem(RigentemBoots, RigentemBoots.getUnlocalizedName());
		GameRegistry.registerItem(EscariaHelmet, EscariaHelmet.getUnlocalizedName());
		GameRegistry.registerItem(EscariaPlate, EscariaPlate.getUnlocalizedName());
		GameRegistry.registerItem(EscariaLegs, EscariaLegs.getUnlocalizedName());
		GameRegistry.registerItem(EscariaBoots, EscariaBoots.getUnlocalizedName());
		GameRegistry.registerItem(arcaneDust, arcaneDust.getUnlocalizedName());
		GameRegistry.registerItem(frostDoor, frostDoor.getUnlocalizedName());
		GameRegistry.registerItem(amouryDoor, amouryDoor.getUnlocalizedName());
		GameRegistry.registerItem(floranSeed, floranSeed.getUnlocalizedName());
		GameRegistry.registerItem(floranBerry, floranBerry.getUnlocalizedName());
		GameRegistry.registerItem(cannonball, cannonball.getUnlocalizedName());
		GameRegistry.registerItem(whiteberrySeed, whiteberrySeed.getUnlocalizedName());
		GameRegistry.registerItem(whiteberry, whiteberry.getUnlocalizedName());
		GameRegistry.registerItem(penguinMeat, penguinMeat.getUnlocalizedName());
		GameRegistry.registerItem(penguinMeatCooked, penguinMeatCooked.getUnlocalizedName());
		GameRegistry.registerItem(emptyCup, emptyCup.getUnlocalizedName());
		GameRegistry.registerItem(teaDrinks, teaDrinks.getUnlocalizedName());
		GameRegistry.registerItem(TekkitePickaxe, TekkitePickaxe.getUnlocalizedName());
		GameRegistry.registerItem(EscariaPickaxe, EscariaPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(RigentemPickaxe, RigentemPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(GlacianPickaxe, GlacianPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(ArcticStonePickaxe, ArcticStonePickaxe.getUnlocalizedName());
		GameRegistry.registerItem(FrostWoodPickaxe, FrostWoodPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteAxe, TekkiteAxe.getUnlocalizedName());
		GameRegistry.registerItem(EscariaAxe, EscariaAxe.getUnlocalizedName());
		GameRegistry.registerItem(RigentemAxe, RigentemAxe.getUnlocalizedName());
		GameRegistry.registerItem(GlacianAxe, GlacianAxe.getUnlocalizedName());
		GameRegistry.registerItem(ArcticStoneAxe, ArcticStoneAxe.getUnlocalizedName());
		GameRegistry.registerItem(FrostWoodAxe, FrostWoodAxe.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteShovel, TekkiteShovel.getUnlocalizedName());
		GameRegistry.registerItem(EscariaShovel, EscariaShovel.getUnlocalizedName());
		GameRegistry.registerItem(RigentemShovel, RigentemShovel.getUnlocalizedName());
		GameRegistry.registerItem(GlacianShovel, GlacianShovel.getUnlocalizedName());
		GameRegistry.registerItem(ArcticStoneShovel, ArcticStoneShovel.getUnlocalizedName());
		GameRegistry.registerItem(FrostWoodShovel, FrostWoodShovel.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteHoe, TekkiteHoe.getUnlocalizedName());
		GameRegistry.registerItem(EscariaHoe, EscariaHoe.getUnlocalizedName());
		GameRegistry.registerItem(RigentemHoe, RigentemHoe.getUnlocalizedName());
		GameRegistry.registerItem(GlacianHoe, GlacianHoe.getUnlocalizedName());
		GameRegistry.registerItem(ArcticStoneHoe, ArcticStoneHoe.getUnlocalizedName());
		GameRegistry.registerItem(FrostWoodHoe, FrostWoodHoe.getUnlocalizedName());
		GameRegistry.registerItem(TekkiteSword, TekkiteSword.getUnlocalizedName());
		GameRegistry.registerItem(EscariaSword, EscariaSword.getUnlocalizedName());
		GameRegistry.registerItem(RigentemSword, RigentemSword.getUnlocalizedName());
		GameRegistry.registerItem(GlacianSword, GlacianSword.getUnlocalizedName());
		GameRegistry.registerItem(ArcticStoneSword, ArcticStoneSword.getUnlocalizedName());
		GameRegistry.registerItem(FrostWoodSword, FrostWoodSword.getUnlocalizedName());
		GameRegistry.registerItem(pirateHat, pirateHat.getUnlocalizedName());
		GameRegistry.registerItem(pirateSword, pirateSword.getUnlocalizedName());
		GameRegistry.registerItem(woodenClub, woodenClub.getUnlocalizedName());
		GameRegistry.registerItem(bomb, bomb.getUnlocalizedName());
		GameRegistry.registerItem(amouryKey, amouryKey.getUnlocalizedName());
		GameRegistry.registerItem(notchedPickaxe, notchedPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(ignisBlade, ignisBlade.getUnlocalizedName());
		GameRegistry.registerItem(archerBow, archerBow.getUnlocalizedName());
		GameRegistry.registerItem(IceShard, IceShard.getUnlocalizedName());
		//GameRegistry.registerItem(GlacierFruit, GlacierFruit.getUnlocalizedName());
		//GameRegistry.registerItem(MystFruit, MystFruit.getUnlocalizedName());
	}
}
