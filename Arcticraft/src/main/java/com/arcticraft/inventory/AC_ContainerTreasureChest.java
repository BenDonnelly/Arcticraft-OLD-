package com.arcticraft.inventory;

import com.arcticraft.tile_entity.TileEntityTreasureChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AC_ContainerTreasureChest extends Container
{

	private TileEntityTreasureChest chest;

	public AC_ContainerTreasureChest(InventoryPlayer inventoryPlayer, TileEntityTreasureChest tileEntity)
	{
		chest = tileEntity;

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(chest, j + i * 9, 8 + j * 18, 17 + i * 18));
			}
		}

		bindPlayerInventory(inventoryPlayer);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return chest.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int theSlot)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(theSlot);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if(theSlot < 9)
			{
				if(! this.mergeItemStack(itemstack1, 9, 45, true))
				{
					return null;
				}
			}
			else if(! this.mergeItemStack(itemstack1, 0, 9, false))
			{
				return null;
			}

			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if(itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;

	}

}
