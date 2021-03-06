package com.arcticraft.handler;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.arcticraft.item.AC_Item;

public class AC_EskimoTrade
{

	public ItemStack itemstack;
	public int gemAmount;

	public AC_EskimoTrade(ItemStack stack, int gems)
	{
		this.itemstack = stack;
		this.gemAmount = gems;
	}

	public static boolean removeGemsFromInventory(InventoryPlayer inv, int amount)
	{
		Item gemID = AC_Item.eriumGem;

		if(getGemsFromInventory(inv) < amount)
		{
			return false;
		}

		for(int j = 0; j < inv.mainInventory.length; ++j)
		{
			ItemStack stack = inv.mainInventory[j];
			if(stack != null && stack.getItem() == gemID)
			{
				while(amount > 0 && stack.stackSize > 0)
				{
					inv.decrStackSize(j, 1);
					amount--;
				}
			}
		}

		return true;
	}

	public static int getGemsFromInventory(InventoryPlayer inv)
	{
		Item gemID = AC_Item.eriumGem;
		int stackSize = 0;

		for(int j = 0; j < inv.mainInventory.length; ++j)
		{
			ItemStack stack = inv.mainInventory[j];
			if(stack != null && stack.getItem() == gemID)
			{
				stackSize += stack.stackSize;
			}
		}

		return stackSize;
	}
}
