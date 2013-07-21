package arcticraft.helpers;

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

	}
	
	public static void iceBerg()
	{
		ChestGenHooks chestcontents = ChestGenHooks.getInfo("iceberg");
		
		chestcontents.addItem(new WeightedRandomChestContent(new ItemStack(Item.dyePowder, 1, 3), 4, 6, 10));
		
		chestcontents.setMin(1);
		chestcontents.setMax(2);
	}
}
