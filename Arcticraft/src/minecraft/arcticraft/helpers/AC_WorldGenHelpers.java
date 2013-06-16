package arcticraft.helpers;

import java.util.Random;

import arcticraft.main.MainRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

public class AC_WorldGenHelpers
{

	static Random rand;
	static ItemStack [] availableItems = new ItemStack []
		{new ItemStack(MainRegistry.frostLog), new ItemStack(MainRegistry.frostPlanks), new ItemStack(MainRegistry.frostCobble)};
	static int [] availableItems_MaxSize = new int []
		{16, 32, 48};

	public static void addRandomDungeonLoot(TileEntityChest chest, String type)
	{
		// current (unused) types: ship, iceberg, portalHouse
		// can be used to generate different loot based on where the chest is found

		if (rand == null)
		{
			rand = new Random();
		}

		for (int i = 0; i < chest.getSizeInventory(); i++)
		{
			if (rand.nextInt(10) <= 1)
			{
				if (type.equals("ship"))
				{
					int var2 = rand.nextInt(11);
					chest.setInventorySlotContents(i, var2 == 0 ? new ItemStack(MainRegistry.itemLantern) : (var2 == 1 ? new ItemStack(MainRegistry.bomb, rand.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(MainRegistry.pirateHat): (var2 == 3 ? new ItemStack(MainRegistry.escariaGem) : (var2 == 5 ? new ItemStack(MainRegistry.eriumGem) : null)))));
					
				}
				else if(type.equals("iceberg"))
				{
					int var2 = rand.nextInt(11);
					chest.setInventorySlotContents(i, var2 == 0 ? new ItemStack(MainRegistry.floranSeed) : (var2 == 0 ? new ItemStack(MainRegistry.whiteberry) : (var2 == 1 ? new ItemStack(MainRegistry.ArcticStoneSword, rand.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(MainRegistry.arcaneStone): (var2 == 3 ? new ItemStack(MainRegistry.emptyCup) : (var2 == 5 ? new ItemStack(MainRegistry.floranBerry) : null))))));
				}
				else
				{
					chest.setInventorySlotContents(i, getRandomItem());
				}
			}
		}
	}

	public static void addRandomDungeonLoot(TileEntityChest [] chests, String type)
	{
		for (TileEntityChest chest : chests)
		{
			addRandomDungeonLoot(chest, type);
			addRandomDungeonLoot(chest, "ship");
			addRandomDungeonLoot(chest, "iceberg");
		}
	}

	private static ItemStack getRandomItem()
	{
		int selectedItem = rand.nextInt(availableItems.length);

		ItemStack item = availableItems [selectedItem];
		item.stackSize = rand.nextInt(availableItems_MaxSize [selectedItem]);

		return item;
	}
}
