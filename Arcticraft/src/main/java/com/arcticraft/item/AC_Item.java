package com.arcticraft.item;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.creativetabs.AC_CreativeTabs;
import com.arcticraft.lib.Strings;

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
	
	public static void initialiseItems() {
		arcaneDust = new Item().setUnlocalizedName("ArcaneDust").setTextureName(Strings.MODID + ":arcaneDust").setCreativeTab(AC_CreativeTabs.tabItem);
		frostDoor = new AC_ItemDoor(Material.wood).setCreativeTab(AC_CreativeTabs.tabBlock).setUnlocalizedName("FrostDoor").setTextureName(Strings.MODID + ":frost_door_icon");
		amouryDoor = new AC_ItemDoor(Material.wood).setCreativeTab(AC_CreativeTabs.tabBlock).setUnlocalizedName("AmouryDoor").setTextureName(Strings.MODID + ":amoury_door");
		
		floranSeed = new AC_ItemSeeds(AC_Block.floranPlant, AC_Block.tilledFrostField).setUnlocalizedName("FloranSeed").setTextureName(Strings.MODID + ":floran_seed").setCreativeTab(AC_CreativeTabs.tabItem);
		floranBerry = new ItemFood(6, false).setCreativeTab(AC_CreativeTabs.tabFood).setUnlocalizedName("FloranBerry").setTextureName(Strings.MODID + ":floran_berry");
	}

	public static void registerItems() {
		GameRegistry.registerItem(arcaneDust, arcaneDust.getUnlocalizedName());
		GameRegistry.registerItem(frostDoor, frostDoor.getUnlocalizedName());
		GameRegistry.registerItem(amouryDoor, amouryDoor.getUnlocalizedName());
		GameRegistry.registerItem(floranSeed, floranSeed.getUnlocalizedName());
		GameRegistry.registerItem(floranBerry, floranBerry.getUnlocalizedName());
	}
}
