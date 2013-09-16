package arcticraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import arcticraft.blocks.AC_Block;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AC_Item
{

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
	public static Item amouryDoorPlace;
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
	public static Item frostDoorPlace;
	public static Item invisoStaff;
	public static Item sled;
	public static Item captainLog;
	public static Item lantern;
	public static Item cannonball;
	
	
	public static void initializeItems()
	{
		/**Params go as follows : name, durability, reductionAmounts, enchantability**/

		EnumToolMaterial TekkiteTool = EnumHelper.addToolMaterial("Tekkite Tool", 3, 1634, 8.3F, 4.0F, 22);
		EnumArmorMaterial TekkiteArmor = EnumHelper.addArmorMaterial("Tekkite Armor", 36, new int[]{3, 7, 6, 3}, 12);

		EnumToolMaterial EscariaTool = EnumHelper.addToolMaterial("Escaria Tool", 0, 120, 12.0F, 0.5F, 23);
		EnumArmorMaterial EscariaArmor = EnumHelper.addArmorMaterial("Escaria Armor", 9, new int[]{2, 5, 3, 1}, 25);

		EnumToolMaterial RigentemTool = EnumHelper.addToolMaterial("Rigentem Tool", 2, 500, 7.0F, 3.0F, 15);
		EnumArmorMaterial RigentemArmor = EnumHelper.addArmorMaterial("Rigentem Armor", 17, new int[]{2, 6, 5, 2}, 11);

		EnumToolMaterial GlacianTool = EnumHelper.addToolMaterial("Glacian Tool", 3, 1400, 9.0F, 5.0F, 13);
		EnumArmorMaterial GlacianArmor = EnumHelper.addArmorMaterial("Glacian Armor", 40, new int[]{3, 8, 6, 3}, 15);

		EnumArmorMaterial PirateArmour = EnumHelper.addArmorMaterial("Pirate Armor", 33, new int[] {1 , 3 , 2 , 1}, 15);

		EnumArmorMaterial hikingAmrour = EnumHelper.addArmorMaterial("Hiking Armoru", 33, new int[] {1 , 3 , 2 , 1}, 20);

		EnumToolMaterial notchedPickaxeMaterial = EnumHelper.addToolMaterial("Notched Pickaxe", 3, 1000, 5.0F, 2.0F, 25);
		
		EnumToolMaterial ignisBladeMaterial = EnumHelper.addToolMaterial("Ignis Blade", 3, 750, 4.0F, 5.0F, 25);

		
		TekkitePickaxe = new AC_ItemPickaxe(6205, TekkiteTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Tekkite Pickaxe").func_111206_d("ac:tekkite_pickaxe");
		TekkiteAxe = new AC_ItemAxe(6206, TekkiteTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Tekkite Axe").func_111206_d("ac:tekkite_axe");
		TekkiteHoe = new AC_ItemHoe(6207, TekkiteTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Tekkite Hoe").func_111206_d("ac:tekkite_hoe");
		TekkiteSword = new AC_ItemSword(6208, TekkiteTool).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Tekkite Sword").func_111206_d("ac:tekkite_sword");
		TekkiteShovel = new AC_ItemShovel(6209, TekkiteTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Tekkite Spade").func_111206_d("ac:tekkite_spade");

		TekkiteHelmet = new AC_ItemArmour(6210, TekkiteArmor, MainRegistry.instance.proxy.addArmor("Tekkite"), 0).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Tekkite Helmet");
		TekkitePlate = new AC_ItemArmour(6211, TekkiteArmor, MainRegistry.instance.proxy.addArmor("Tekkite"), 1).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Tekkite Plate");
		TekkiteLegs = new AC_ItemArmour(6212, TekkiteArmor, MainRegistry.instance.proxy.addArmor("Tekkite"), 2).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Tekkite Legs");
		TekkiteBoots = new AC_ItemArmour(6213, TekkiteArmor, MainRegistry.instance.proxy.addArmor("Tekkite"), 3).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Tekkite Boots");

		EscariaPickaxe = new AC_ItemPickaxe(6214, EscariaTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Escaria Pickaxe").func_111206_d("ac:escaria_pickaxe");
		EscariaAxe = new AC_ItemAxe(6215, EscariaTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("escariaAxe").func_111206_d("ac:escaria_axe");
		EscariaHoe = new AC_ItemHoe(6216, EscariaTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Escaria Hoe").func_111206_d("ac:escaria_hoe");
		EscariaSword = new AC_ItemSword(6217, EscariaTool).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Escaria Sword").func_111206_d("ac:escaria_sword");
		EscariaShovel = new AC_ItemShovel(6218, EscariaTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Escaria Spade").func_111206_d("ac:escaria_spade");

		EscariaHelmet = new AC_ItemArmour(6219, EscariaArmor, MainRegistry.instance.proxy.addArmor("Escaria"), 0).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Escaria Helmet");
		EscariaPlate = new AC_ItemArmour(6220, EscariaArmor, MainRegistry.instance.proxy.addArmor("Escaria"), 1).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Escaria Plate");
		EscariaLegs = new AC_ItemArmour(6221, EscariaArmor, MainRegistry.instance.proxy.addArmor("Escaria"), 2).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Escaria Legs");
		EscariaBoots = new AC_ItemArmour(6222, EscariaArmor, MainRegistry.instance.proxy.addArmor("Escaria"), 3).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Escaria Boots");

		RigentemPickaxe = new AC_ItemPickaxe(6223, RigentemTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Rigentem Pickaxe").func_111206_d("ac:rigentem_pickaxe");
		RigentemAxe = new AC_ItemAxe(6224, RigentemTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("rigentemAxe").func_111206_d("ac:rigentem_axe");
		RigentemHoe = new AC_ItemHoe(6225, RigentemTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Rigentem Hoe").func_111206_d("ac:rigentem_hoe");
		RigentemSword = new AC_ItemSword(6226, RigentemTool).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Rigentem Sword").func_111206_d("ac:rigentem_sword");
		RigentemShovel = new AC_ItemShovel(6227, RigentemTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Rigentem Spade").func_111206_d("ac:rigentem_spade");

		RigentemHelmet = new AC_ItemArmour(6228, RigentemArmor, MainRegistry.instance.proxy.addArmor("Rigentem"), 0).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Rigentem Helmet");
		RigentemPlate = new AC_ItemArmour(6229, RigentemArmor, MainRegistry.instance.proxy.addArmor("Rigentem"), 1).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Rigentem Plate");
		RigentemLegs = new AC_ItemArmour(6230, RigentemArmor, MainRegistry.instance.proxy.addArmor("Rigentem"), 2).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Rigentem Legs");
		RigentemBoots = new AC_ItemArmour(6231, RigentemArmor, MainRegistry.instance.proxy.addArmor("Rigentem"), 3).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Rigentem Boots");

		GlacianPickaxe = new AC_ItemPickaxe(6232, GlacianTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Glacian Pickaxe").func_111206_d("ac:glacian_pickaxe");
		GlacianAxe = new AC_ItemAxe(6233, GlacianTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Glacian Axe").func_111206_d("ac:glacian_axe");
		GlacianHoe = new AC_ItemHoe(6234, GlacianTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Glacian Hoe").func_111206_d("ac:glacian_hoe");
		GlacianSword = new AC_ItemSword(6235, GlacianTool).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Glacian Sword").func_111206_d("ac:glacian_sword");
		GlacianShovel = new AC_ItemShovel(6236, GlacianTool).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Glacian Spade").func_111206_d("ac:glacian_spade");

		GlacianHelmet = new AC_ItemArmour(6237, GlacianArmor, MainRegistry.instance.proxy.addArmor("Glacian"), 0).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Glacian Helmet");
		GlacianPlate = new AC_ItemArmour(6238, GlacianArmor, MainRegistry.instance.proxy.addArmor("Glacian"), 1).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Glacian Plate");
		GlacianLegs = new AC_ItemArmour(6239, GlacianArmor, MainRegistry.instance.proxy.addArmor("Glacian"), 2).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Glacian Legs");
		GlacianBoots = new AC_ItemArmour(6240, GlacianArmor, MainRegistry.instance.proxy.addArmor("Glacian"), 3).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Glacian Boots");

		ArcticStonePickaxe = new AC_ItemPickaxe(6241, EnumToolMaterial.STONE).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Arctic Stone Pickaxe").func_111206_d("ac:arctic_stone_pickaxe");
		ArcticStoneAxe = new AC_ItemAxe(6242, EnumToolMaterial.STONE).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Arctic Stone Axe").func_111206_d("ac:arctic_stone_axe");
		ArcticStoneHoe = new AC_ItemHoe(6243, EnumToolMaterial.STONE).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Arctic Stone Hoe").func_111206_d("ac:arctic_stone_hoe");
		ArcticStoneSword = new AC_ItemSword(6244, EnumToolMaterial.STONE).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Arctic Stone Sword").func_111206_d("ac:arctic_stone_sword");
		ArcticStoneShovel = new AC_ItemShovel(6245, EnumToolMaterial.STONE).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Arctic Stone Spade").func_111206_d("ac:arctic_stone_spade");

		FrostWoodPickaxe = new AC_ItemPickaxe(6246, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Frost Wood Pickaxe").func_111206_d("ac:frost_wood_pickaxe");
		FrostWoodAxe = new AC_ItemAxe(6247, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("frostWoodAxe").func_111206_d("ac:frost_wood_axe");
		FrostWoodHoe = new AC_ItemHoe(6248, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Frost Wood Hoe").func_111206_d("ac:frost_wood_hoe");
		FrostWoodSword = new AC_ItemSword(6249, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("Frost Wood Sword").func_111206_d("ac:frost_wood_sword");
		FrostWoodShovel = new AC_ItemShovel(6250, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Frost Wood Spade").func_111206_d("ac:frost_wood_spade");

		frostSticks = new Item(6251).setCreativeTab(MainRegistry.tabMaterial).func_111206_d("ac:frost_stick");
		penguinMeat = new ItemFood(6252, 4, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("penguin_meat").func_111206_d("ac:penguin_meat");
		penguinMeatCooked = new ItemFood(6253, 8, true).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("penguin_meat_cooked").func_111206_d("ac:penguin_meat_cooked");
		penguinFeather = new Item(6254).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("penguin_feather").func_111206_d("ac:penguin_feather");
		tekkiteGem = new Item(6255).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("tekkite_gem").func_111206_d("ac:tekkite_gem");
		escariaGem = new Item(6256).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("escaria_gem").func_111206_d("ac:escaria_gem");
		frigus = new Item(6257).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("frigus").func_111206_d("ac:frigus");
		glacianIngot = new Item(6258).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("glacian").func_111206_d("ac:glacian_ingot");
		rigentemIngot = new Item(6259).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("rigentem").func_111206_d("ac:rigentem_ingot");
		eriumGem = new Item(6260).setCreativeTab(MainRegistry.tabMaterial).setUnlocalizedName("erium_gem").func_111206_d("ac:erium_gem");
		iceCream = new AC_ItemIceCream(6261, 10, 1.3F, true).setAlwaysEdible().setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("icecream");
		arcaneDust = new Item(6263).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("arcaneDust").func_111206_d("ac:arcane_dust");
		heatPack = new AC_ItemHeatPack(6264).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("heatpack").func_111206_d("ac:heatpack");
		bomb = new AC_ItemBomb(6265).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("bomb").func_111206_d("ac:bomb");
		emptyCup = new Item(6266).setMaxStackSize(8).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("empty_cup").func_111206_d("ac:empty_cup");
		teaDrinks = new AC_ItemTeaDrinks(6267, 4, 1.3F, true).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("hot_chocolate").func_111206_d("ac:hot_chocolate");
		pirateHat = new AC_ItemArmour(6268, PirateArmour, MainRegistry.instance.proxy.addArmor("Pirate"), 0).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("piratehaticon").func_111206_d("ac:pirate_hat_icon");
		pirateSword = new AC_ItemCaptainSword(6269, EnumToolMaterial.EMERALD).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("pirateSword").func_111206_d("ac:captain_sword");
		boarMeat = new ItemFood(6270, 10, true).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("boar_meat").func_111206_d("ac:cooked_boar_meat");
		uncookedBoarMeat = new ItemFood(6271, 4, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("raw_boar_meat").func_111206_d("ac:raw_boar_meat");
		hikingBoots = new AC_ItemArmour(6272, hikingAmrour, MainRegistry.instance.proxy.addArmor("Hiking"), 3).setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("Hiking Boots");
		invisoStaff = new AC_ItemInvisoStaff(6273).setFull3D().setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("staff_icon").func_111206_d("ac:staff_icon");
		recordFrozenFeelings = new AC_ItemRecord(6274, "Frozen Feelings").setUnlocalizedName("record_FF");
		recordWTTC = new AC_ItemRecord(6275, "Welcome To The Cold").setUnlocalizedName("record_WTTC");
		amouryKey = new Item(6276).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("amoury_key").func_111206_d("ac:amoury_key");
		bucketIcyWater = new AC_ItemBucket(6277, AC_Block.acWaterFlowing.blockID).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("bucket_ice_water").func_111206_d("ac:bucket_ice_water");
		bucketEmpty = new AC_ItemBucket(6278, 0).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("bucket_empty").func_111206_d("ac:bucket_empty");
		MystFruit = new AC_ItemFruits(6279, 0, false).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("mystical_fruit").func_111206_d("ac:mystical_fruit");
		GlacierFruit = (new AC_ItemFruits(6280, 0, false).setCreativeTab(MainRegistry.tabFood).setUnlocalizedName("glacier_fruit")).func_111206_d("ac:glacier_fruit");
		IceShard = new Item(6281).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("ice_shard").func_111206_d("ac:ice_shard");
		frostDoorPlace = new AC_ItemFrostDoor(6282, Material.wood).setUnlocalizedName("icedoor").setCreativeTab(MainRegistry.tabBlocks).func_111206_d("ac:frost_door_icon");
		amouryDoorPlace = new AC_ItemAmouryDoor(6283, Material.wood).setUnlocalizedName("amoury_door").setCreativeTab(MainRegistry.tabBlocks).func_111206_d("ac:amoury_door");
		floranSeed = new AC_ItemSeed(6284, AC_Block.floranPlant).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("floran_seed").func_111206_d("ac:floran_seed");
		sled = new AC_ItemSled(6285).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("sled").func_111206_d("ac:sled_icon");
		notchedPickaxe = new AC_ItemNPickaxe(6286, notchedPickaxeMaterial).setFull3D().setCreativeTab(MainRegistry.tabTools).setUnlocalizedName("notched_pickaxe").func_111206_d("ac:notched_pickaxe_icon");
		ignisBlade = new AC_ItemIgnisBlade(6287, ignisBladeMaterial).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("ignis_blade").func_111206_d("ac:ignis_blade");
		archerBow = new AC_ItemArchersBow(6288).setFull3D().setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("archer_bow").func_111206_d("ac:archer_bow");
		captainLog = new AC_ItemCaptainLog(6289).setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("captain_log").func_111206_d("ac:captain_log");
		woodenClub = new AC_ItemSword(6290, EnumToolMaterial.WOOD).setCreativeTab(MainRegistry.tabCombat).setUnlocalizedName("wooden_club").func_111206_d("ac:wooden_club");
		lantern = new AC_ItemBlockLantern(1516).setUnlocalizedName("lantern").func_111206_d("ac:lantern");
		cannonball = new Item(1517).setFull3D().setCreativeTab(MainRegistry.tabMisc).setUnlocalizedName("cannonball").func_111206_d("ac:cannonball_icon");
	}

	public static void nameItems()
	{
		LanguageRegistry.addName(cannonball, "Cannonball");
		LanguageRegistry.addName(woodenClub, "Wooden Club");
		LanguageRegistry.addName(archerBow, "Archer's Bow");
		LanguageRegistry.addName(ignisBlade, "Ignis Blade");
		LanguageRegistry.addName(pirateSword, "Pirate Sword");
		LanguageRegistry.addName(pirateHat, "Pirate Hat");
		LanguageRegistry.addName(frostDoorPlace, "Frost Door");
		LanguageRegistry.addName(bucketIcyWater, "Icy Water Bucket");
		LanguageRegistry.addName(bucketEmpty, "Empty Water Bucket");
		LanguageRegistry.addName(MystFruit, "Mysterious Fruit");
		LanguageRegistry.addName(GlacierFruit, "Glacier Fruit");
		LanguageRegistry.addName(IceShard, "Ice Shards");
		LanguageRegistry.addName(penguinMeat, "Penguin Meat");
		LanguageRegistry.addName(penguinMeatCooked, "Cooked Penguin Meat");
		LanguageRegistry.addName(penguinFeather, "Penguin Feather");
		LanguageRegistry.addName(tekkiteGem, "Tekkite Gem");
		LanguageRegistry.addName(escariaGem, "Escaria Gem");
		LanguageRegistry.addName(rigentemIngot, "Rigentem Ingot");
		LanguageRegistry.addName(glacianIngot, "Glacian Ingot");
		LanguageRegistry.addName(frigus, "Frigus");
		LanguageRegistry.addName(eriumGem, "Erium Gem");
		LanguageRegistry.addName(arcaneDust, "Arcane Dust");
		LanguageRegistry.addName(heatPack, "Heatpack");
		LanguageRegistry.addName(bomb, "Bomb");
		LanguageRegistry.addName(emptyCup, "Empty Cup");
		LanguageRegistry.addName(uncookedBoarMeat, "Raw Boar Meat");
		LanguageRegistry.addName(boarMeat, "Boar Meat");
		LanguageRegistry.addName(hikingBoots, "Hiking Boots");
		LanguageRegistry.addName(recordFrozenFeelings, "Music Disk");
		LanguageRegistry.addName(recordWTTC, "Music Disk");
		LanguageRegistry.addName(amouryDoorPlace, "Armoured Door");
		LanguageRegistry.addName(amouryKey, "Armoury Key");
		LanguageRegistry.addName(frostSticks, "Frost Sticks");
		LanguageRegistry.addName(invisoStaff, "Invisibility Staff");
		LanguageRegistry.addName(floranSeed, "Floran Seed");
		LanguageRegistry.addName(sled, "Sled");
		LanguageRegistry.addName(notchedPickaxe, "Notched Pickaxe");
		LanguageRegistry.addName(captainLog, "Captain's Log");
		LanguageRegistry.addName(lantern, "Lantern");
		
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
	}

}
