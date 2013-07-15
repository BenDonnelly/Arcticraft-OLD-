package arcticraft.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class AC_Recipes
{
	public static void initializeRecipes()
	{
		tools();
		misc();
		smelting();
		frostWood();
		food();
	}

	public static void frostWood()
	{
		GameRegistry.addRecipe(new ItemStack(Block.workbench), new Object[]{ "XX", "XX", 'X', AC_Block.frostPlanks  });
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 4, 1), new Object[] {
			AC_Block.glacierLog });

		GameRegistry.addShapelessRecipe(new ItemStack(AC_Block.frostPlanks, 4), new Object[] {
			AC_Block.frostLog });
		GameRegistry.addShapelessRecipe(new ItemStack(Block.wood, 4, 1), new Object[] {
			AC_Block.glacierLog });
		
		GameRegistry.addRecipe(new ItemStack(Item.arrow, 4), new Object [] {
			" Z ", " Y ", " X ", Character.valueOf('X'), AC_Item.penguinFeather, Character.valueOf('Y'), Item.stick, 
			Character.valueOf('Z'), Item.flint
		});
		GameRegistry.addRecipe(new ItemStack(AC_Item.frostSticks, 4), new Object[]{
			"X", "X", Character.valueOf('X'), AC_Block.frostPlanks });

		GameRegistry.addRecipe(new ItemStack(AC_Block.snowPressurePlate, 2), new Object[]{
			"XX",  Character.valueOf('X'), Block.snow });

		GameRegistry.addRecipe(new ItemStack(AC_Block.frostStairs, 4), new Object[]{
			"X  ", "XX " , "XXX", Character.valueOf('X'), AC_Block.frostPlanks});

		GameRegistry.addRecipe(new ItemStack(AC_Block.frostWoodSingleSlab, 6), new Object[] {
			"XXX", Character.valueOf('X'), AC_Block.frostPlanks });

		GameRegistry.addRecipe(new ItemStack(AC_Block.frostFence, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), AC_Item.frostSticks});
		GameRegistry.addRecipe(new ItemStack(AC_Block.snowTrapdoor, 2), new Object[] {
			"XXX", "XXX", Character.valueOf('X'), Block.snow});
	}


	public static void smelting()
	{
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.frostCobble.blockID, new ItemStack(AC_Block.frostStone, 1), 0.1F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.frigusOre.blockID, new ItemStack(AC_Item.frigus, 1), 0.2F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.tekkiteOre.blockID, new ItemStack(AC_Item.tekkiteGem, 1), 1.0F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.escariaOre.blockID, new ItemStack(AC_Item.escariaGem, 1), 0.8F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.rigentemOre.blockID, new ItemStack(AC_Item.rigentemIngot, 1), 0.6F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Block.glacianOre.blockID, new ItemStack(AC_Item.glacianIngot, 1), 0.7F);
		AC_FurnaceRecipes.smelting().addSmelting(AC_Item.teaDrinks.itemID, 3 , new ItemStack(AC_Item.teaDrinks, 1, 1), 0.7F);
	}

	public static void food()
	{
		AC_Item.bucketIcyWater.setContainerItem(AC_Item.bucketEmpty);
	
		GameRegistry.addRecipe(new ItemStack(AC_Item.teaDrinks, 1, 0), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 1), Character.valueOf('Z'), AC_Item.emptyCup, Character.valueOf('Y'), AC_Item.bucketIcyWater }); 
		
		GameRegistry.addRecipe(new ItemStack(AC_Item.teaDrinks, 1, 3), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('Z'), AC_Item.emptyCup, Character.valueOf('Y'), AC_Item.bucketIcyWater }); 
		
		GameRegistry.addRecipe(new ItemStack(AC_Item.teaDrinks, 1, 2), new Object [] {		
			 "X", "Y", "Z", Character.valueOf('X'), AC_Block.floranBerry, Character.valueOf('Z'), AC_Item.emptyCup, Character.valueOf('Y'), AC_Item.bucketIcyWater }); 
	}

	public static void tools()
	{
		//Escaria
		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, '%', AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), AC_Item.escariaGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.EscariaBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), AC_Item.escariaGem});
		
		//Glacian 
		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, '%', AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), AC_Item.glacianIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.GlacianBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), AC_Item.glacianIngot});



		//Tekite
		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkitePickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkitePlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), AC_Item.tekkiteGem}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.TekkiteBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), AC_Item.tekkiteGem});


		//Rigentem
		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemHelmet, 1), new Object [] { 
			"%%%", "% %", Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemPlate, 1), new Object [] { 
			"* *", "***", "***", Character.valueOf('*'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemLegs, 1), new Object [] { 
			"%%%", "% %", "% %", Character.valueOf('%'), AC_Item.rigentemIngot}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.RigentemBoots, 1), new Object [] {
			"X X", "X X", Character.valueOf('X'), AC_Item.rigentemIngot});


		//Frost Wood
		GameRegistry.addRecipe(new ItemStack(AC_Item.FrostWoodPickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.FrostWoodShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.FrostWoodHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.FrostWoodAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostPlanks}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.FrostWoodSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostPlanks}); 

		//Arctic Stone
		GameRegistry.addRecipe(new ItemStack(AC_Item.ArcticStonePickaxe, 1), new Object [] {		
			"%%%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.ArcticStoneShovel, 1), new Object [] { 
			" % ", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.ArcticStoneHoe, 1), new Object [] { 
			" %%", " ? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.ArcticStoneAxe, 1), new Object [] { 
			"%% ", "%? ", " ? ", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostCobble}); 

		GameRegistry.addRecipe(new ItemStack(AC_Item.ArcticStoneSword, 1), new Object [] { 
			"%", "%", "?", Character.valueOf('?'), AC_Item.frostSticks, Character.valueOf('%'), AC_Block.frostCobble}); 
	}

	public static void misc()
	{
		GameRegistry.addRecipe(new ItemStack(AC_Block.arcticFurnaceIdle), new Object[] { 
			"XXX", "X X", "XXX", Character.valueOf('X'), AC_Block.frostCobble });

		GameRegistry.addRecipe(new ItemStack(AC_Block.arcaneStone), new Object [] {
			"XX", "XX", Character.valueOf('X'), AC_Item.arcaneDust });
	
		
		GameRegistry.addRecipe(new ItemStack(AC_Block.mysticalSnow, 8), new Object[] {
			"GDG", "GSG", "GDG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('S'), Block.blockSnow, Character.valueOf('D'), Item.diamond });

		GameRegistry.addRecipe(new ItemStack(AC_Block.Lantern, 4), new Object[] {
			" S ", "SFS", " S ", Character.valueOf('S'), AC_Item.frostSticks, Character.valueOf('F'), AC_Item.frigus });

		GameRegistry.addRecipe(new ItemStack(AC_Block.freezerIdle), new Object[] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), AC_Item.glacianIngot,
			Character.valueOf('Y'), AC_Item.tekkiteGem});
		
		GameRegistry.addRecipe(new ItemStack(AC_Block.campfire), new Object[]{
		 " Y ", "XXX", Character.valueOf('X'), Item.stick,
			Character.valueOf('Y'), AC_Item.frigus});
		
		GameRegistry.addRecipe(new ItemStack(AC_Block.glacianBlock), new Object[]{
			 "XXX", "XXX", "XXX", Character.valueOf('X'), AC_Item.glacianIngot});
		
		GameRegistry.addRecipe(new ItemStack(AC_Block.tekkiteBlock), new Object[]{
			 "XXX", "XXX", "XXX", Character.valueOf('X'), AC_Item.tekkiteGem});
		
		GameRegistry.addRecipe(new ItemStack(AC_Block.escariaBlock), new Object[]{
			 "XXX", "XXX", "XXX", Character.valueOf('X'), AC_Item.escariaGem});

		GameRegistry.addRecipe(new ItemStack(AC_Block.rigentemBlock), new Object[]{
			 "XXX", "XXX", "XXX", Character.valueOf('X'), AC_Item.rigentemIngot});
	
		GameRegistry.addRecipe(new ItemStack(AC_Item.glacianIngot, 9), new Object[]{
			 "X",  Character.valueOf('X'), AC_Block.glacianBlock});
		
		GameRegistry.addRecipe(new ItemStack(AC_Item.tekkiteGem, 9), new Object[]{
			 "X",  Character.valueOf('X'), AC_Block.tekkiteBlock});
		
		GameRegistry.addRecipe(new ItemStack(AC_Item.rigentemIngot, 9), new Object[]{
			 "X",  Character.valueOf('X'), AC_Block.rigentemBlock});
		
		GameRegistry.addRecipe(new ItemStack(AC_Item.escariaGem, 9), new Object[]{
			 "X",  Character.valueOf('X'), AC_Block.escariaBlock});
	}
}
