package arcticraft.helpers;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;

public class AC_WorldGenHelpers
{

	static Random rand;
	static ItemStack[] availableItems = new ItemStack[] {new ItemStack(AC_Block.frostLog) , new ItemStack(AC_Block.frostPlanks) , new ItemStack(AC_Block.frostCobble)};
	static int[] availableItems_MaxSize = new int[] {16 , 32 , 48};

	public static void addRandomDungeonLoot(TileEntityChest chest, String type)
	{
		// current (unused) types: ship, iceberg, portalHouse
		// can be used to generate different loot based on where the chest is
		// found

		if(rand == null)
		{
			rand = new Random();
		}

		for(int i = 0; i < chest.getSizeInventory(); i++)
		{
			if(rand.nextInt(10) <= 1)
			{
				if(type.equals("ship"))
				{
					int var2 = rand.nextInt(11);
					chest.setInventorySlotContents(i, var2 == 0 ? new ItemStack(AC_Item.itemLantern) : (var2 == 1 ? new ItemStack(AC_Item.bomb, rand.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(AC_Item.pirateHat) : (var2 == 3 ? new ItemStack(AC_Item.escariaGem) : (var2 == 5 ? new ItemStack(
							AC_Item.eriumGem) : null)))));

				}
				else if(type.equals("iceberg"))
				{
					int var2 = rand.nextInt(11);
					chest.setInventorySlotContents(i, var2 == 0 ? new ItemStack(AC_Item.floranSeed) : (var2 == 0 ? new ItemStack(AC_Block.whiteberry) : (var2 == 1 ? new ItemStack(AC_Item.ArcticStoneSword, rand.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(AC_Block.arcaneStone)
							: (var2 == 3 ? new ItemStack(AC_Item.emptyCup) : (var2 == 5 ? new ItemStack(AC_Block.floranBerry) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 0) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 1) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 2)
									: (var2 == 5 ? new ItemStack(AC_Item.iceCream, 3) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 4) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 5) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 6) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 7)
											: (var2 == 5 ? new ItemStack(AC_Item.iceCream, 8) : (var2 == 5 ? new ItemStack(AC_Item.iceCream, 9) : null))))))))))))))));
				}
				else
				{
					chest.setInventorySlotContents(i, getRandomItem());
				}
			}
		}
	}

	public static void addRandomDungeonLoot(TileEntityChest[] chests, String type)
	{
		for(TileEntityChest chest : chests)
		{
			addRandomDungeonLoot(chest, type);
			addRandomDungeonLoot(chest, "ship");
			addRandomDungeonLoot(chest, "iceberg");
		}
	}

	private static ItemStack getRandomItem()
	{
		int selectedItem = rand.nextInt(availableItems.length);

		ItemStack item = availableItems[selectedItem];
		item.stackSize = rand.nextInt(availableItems_MaxSize[selectedItem]);

		return item;
	}
}
