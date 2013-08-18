package arcticraft.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import arcticraft.gui.SlotCaveman;
import arcticraft.tile_entities.AC_TileEntityCavemanGUI;

public class AC_ContainerCaveman extends Container
{

	private AC_TileEntityCavemanGUI caveman;

	public AC_ContainerCaveman(InventoryPlayer invPlayer, AC_TileEntityCavemanGUI tile)
	{
		this.caveman = tile;
		this.addSlotToContainer(new SlotCaveman(tile, 0, 8, 8));

		int i;

		for(i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return caveman.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		if(slotObject != null && slotObject.getHasStack() )
		{
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			if(slot < 1)
			{
				if(! this.mergeItemStack(stackInSlot, 0, 35, true))
				{
					return null;
				}
			}
			else if(! this.mergeItemStack(stackInSlot, 0, 1, false))
			{
				return null;
			}

			if(stackInSlot.stackSize == 0)
			{
				slotObject.putStack(null);
			}
			else
			{
				slotObject.onSlotChanged();
			}

			if(stackInSlot.stackSize == stack.stackSize)
			{
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

}
