package arcticraft.helpers;

import java.util.Random;

import arcticraft.main.MainRegistry;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

public class AC_WorldGenHelpers
{
	static Random rand;
	static ItemStack[] availableItems = new ItemStack[] { new ItemStack(MainRegistry.frostLog), new ItemStack(MainRegistry.frostPlanks), new ItemStack(MainRegistry.frostCobble) };
	static int[] availableItems_MaxSize = new int[] { 16, 32, 48 };
	
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
				chest.setInventorySlotContents(i, getRandomItem());
			}
		}
	}
	
	public static void addRandomDungeonLoot(TileEntityChest[] chests, String type)
	{
		for (TileEntityChest chest : chests)
		{
			addRandomDungeonLoot(chest, type);
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