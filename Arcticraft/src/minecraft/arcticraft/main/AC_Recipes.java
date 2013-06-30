package arcticraft.main;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class AC_Recipes
{
	public static void initializeRecipes()
	{
		tools();
		misc();
		smelting();
		frostWood();
//		freezing();
		food();
	}

	public static void frostWood()
	{
		GameRegistry.addRecipe(new ItemStack(Block.workbench), new Object[]{ "XX", "XX", 'X', MainRegistry.frostPlanks  });
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 4, 1), new Object[] {
			MainRegistry.glacierLog });

		GameRegistry.addShapelessRecipe(new ItemStack(MainRegistry.frostPlanks, 4), new Object[] {
			MainRegistry.frostLog });
		GameRegistry.addShapelessRecipe(new ItemStack(Block.wood, 4, 1), new Object[] {
			MainRegistry.glacierLog });
		
		GameRegistry.addRecipe(new ItemStack(Item.arrow, 4), new Object [] {
			" Z ", " Y ", " X ", Character.valueOf('X'), MainRegistry.penguinFeather, Character.valueOf('Y'), Item.stick, 
			Character.valueOf('Z'), Item.flint
		});
		GameRegistry.addRecipe(new ItemStack(MainRegistry.frostSticks, 4), new Object[]{
			"X", "X", Character.valueOf('X'), MainRegistry.frostPlanks });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.snowPressurePlate, 2), new Object[]{
			"XX",  Character.valueOf('X'), Block.snow });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.frostStairs, 4), new Object[]{
			"X  ", "XX " , "XXX", Character.valueOf('X'), MainRegistry.frostPlanks});

		GameRegistry.addRecipe(new ItemStack(MainRegistry.frostWoodSingleSlab, 6), new Object[] {
			"XXX", Character.valueOf('X'), MainRegistry.frostPlanks });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.frostFence, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), MainRegistry.frostSticks});
		GameRegistry.addRecipe(new ItemStack(MainRegistry.snowTrapdoor, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Block.snow});
	}
//
//	public static void freezing()
//	{
//		AC_FreezerRecipes.smelting().addSmelting(Item.bucketMilk.itemID, new ItemStack(MainRegistry.vanillaIceCream, 1), 0.2F);
//		AC_FreezerRecipes.smelting().addSmelting(Item.bucketWater.itemID, new ItemStack(Block.ice, 1), 0.2F);
//		AC_FreezerRecipes.smelting().addSmelting(Item.bucketLava.itemID, new ItemStack(Block.obsidian, 1), 0.2F);
//		AC_FreezerRecipes.smelting().addSmelting(Block.snow.blockID, new ItemStack(Block.ice, 1), 0.1F);
//	}

	public static void smelting()
	{
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.frostCobble.blockID, new ItemStack(MainRegistry.frostStone, 1), 0.1F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.frigusOre.blockID, new ItemStack(MainRegistry.frigus, 1), 0.2F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.tekkiteOre.blockID, new ItemStack(MainRegistry.tekkiteGem, 1), 1.0F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.escariaOre.blockID, new ItemStack(MainRegistry.escariaGem, 1), 0.8F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.rigentemOre.blockID, new ItemStack(MainRegistry.rigentemIngot, 1), 0.6F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.glacianOre.blockID, new ItemStack(MainRegistry.glacianIngot, 1), 0.7F);
		AC_FurnaceRecipes.smelting().addSmelting(MainRegistry.teaDrinks.itemID, 3 , new ItemStack(MainRegistry.teaDrinks, 1, 1), 0.7F);
	}

	public static void food()
	{
		MainRegistry.bucketIcyWater.setContainerItem(MainRegistry.bucketEmpty);
	
		GameRegistry.addRecipe(new ItemStack(MainRegistry.teaDrinks, 1, 0), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 1), Character.valueOf('Z'), MainRegistry.emptyCup, Character.valueOf('Y'), MainRegistry.bucketIcyWater }); 
		
		GameRegistry.addRecipe(new ItemStack(MainRegistry.teaDrinks, 1, 3), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('Z'), MainRegistry.emptyCup, Character.valueOf('Y'), MainRegistry.bucketIcyWater }); 
		
		GameRegistry.addRecipe(new ItemStack(MainRegistry.teaDrinks, 1, 2), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), MainRegistry.floranBerry, Character.valueOf('Z'), MainRegistry.emptyCup, Character.valueOf('Y'), MainRegistry.bucketIcyWater }); 
	}

	public static void tools()
	{
		//Escaria
		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, '%', MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), MainRegistry.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.EscariaBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), MainRegistry.escariaGem});
		
		//Glacian 
		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, '%', MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), MainRegistry.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.GlacianBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), MainRegistry.glacianIngot});



		//Tekite
		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkitePickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkitePlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), MainRegistry.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.TekkiteBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), MainRegistry.tekkiteGem});


		//Rigentem
		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), MainRegistry.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.RigentemBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), MainRegistry.rigentemIngot});


		//Frost Wood
		GameRegistry.addRecipe(new ItemStack(MainRegistry.FrostWoodPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.FrostWoodShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.FrostWoodHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.FrostWoodAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.FrostWoodSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostPlanks}); 

		//Arctic Stone
		GameRegistry.addRecipe(new ItemStack(MainRegistry.ArcticStonePickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.ArcticStoneShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.ArcticStoneHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.ArcticStoneAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(MainRegistry.ArcticStoneSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), MainRegistry.frostSticks, Character.valueOf('%'), MainRegistry.frostCobble}); 
	}

	public static void misc()
	{
		GameRegistry.addRecipe(new ItemStack(MainRegistry.arcticFurnaceIdle), new Object[] { 
			"XXX", "X X", "XXX", Character.valueOf('X'), MainRegistry.frostCobble });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.arcaneStone), new Object [] {
			"XX", "XX", Character.valueOf('X'), MainRegistry.arcaneDust });
	
		
		GameRegistry.addRecipe(new ItemStack(MainRegistry.mysticalSnow, 8), new Object[] {
			"GDG", "GSG", "GDG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('S'), Block.blockSnow, Character.valueOf('D'), Item.diamond });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.Lantern, 4), new Object[] {
			" S ", "SFS", " S ", Character.valueOf('S'), MainRegistry.frostSticks, Character.valueOf('F'), MainRegistry.frigus });

		GameRegistry.addRecipe(new ItemStack(MainRegistry.freezerIdle), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Item.ingotIron,
			Character.valueOf('Y'), MainRegistry.tekkiteGem});
		
		GameRegistry.addRecipe(new ItemStack(MainRegistry.campfire), new Object[]{
		 " Y ", "XXX", Character.valueOf('X'), Item.stick,
			Character.valueOf('Y'), MainRegistry.frigus});
	}
}
