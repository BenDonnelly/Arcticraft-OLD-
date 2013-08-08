package arcticraft.helpers;

import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class AC_ChestLootHelper 
{
	public static void initializeChestLoot()
	{
		ship();
		iceBerg();
	}
	
	/*example*/
	public void example()
	{
		ChestGenHooks chestcontents = ChestGenHooks.getInfo("Category"); // create registered ChestGenHooks
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Item.dyePowder, 1, 3), 4, 6, 10)); // 4-6 cocoa beans
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Block.cloth, 1, 15), 2, 3, 20)); // 2-3 black wool

		/*The last param is itemWeight: The probability of an entry being selected is the itemWeight for a particular item divided by the combined itemWeight
		 *  for all the entries.
		 */
		
		ItemStack itemStack = new ItemStack(Item.shovelIron);
		itemStack.addEnchantment(Enchantment.efficiency, 1);
		chestcontents.addItem(new WeightedRandomChestContent(itemStack, 1, 2, 5)); // 1-2 Efficiency I enchanted iron shovels

		/*number of items in chest*/
		chestcontents.setMin(7); // inclusive
		chestcontents.setMax(9); // exclusive
	}
	
	public static void ship()
	{
		ChestGenHooks chestcontents = ChestGenHooks.getInfo("acpirateship");
		
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Block.Lantern, 1, 0), 1, 1, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.bomb, 1, 0), 1, 3, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.pirateHat, 1, 0), 1, 1, 9));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.eriumGem, 1, 0), 1, 8, 10));
		
		chestcontents.setMin(5);
		chestcontents.setMax(7);
	}
	
	public static void iceBerg()
	{
		ChestGenHooks chestcontents = ChestGenHooks.getInfo("aciceberg");
		
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Block.Lantern, 1, 0), 1, 1, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 0), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 1), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 2), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 3), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 4), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 5), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 6), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 7), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 8), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.iceCream, 1, 8), 1, 1, 4));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.teaDrinks, 1, 0), 1, 1, 6));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.teaDrinks, 1, 1), 1, 1, 6));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.teaDrinks, 1, 2), 1, 1, 6));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.teaDrinks, 1, 3), 1, 1, 6));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Item.floranSeed, 1, 3), 1, 1, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Block.whiteberry, 1, 3), 1, 1, 10));
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(AC_Block.floranBerry, 1, 3), 1, 1, 9));
		
		chestcontents.setMin(2);
		chestcontents.setMax(4);
	}
}
