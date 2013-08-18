package arcticraft.tile_entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import arcticraft.items.AC_Item;

public class AC_TileEntityCavemanGUI extends TileEntity implements IInventory
{

	private ItemStack[] invSlots = new ItemStack[1];;

	@Override
	public int getSizeInventory()
	{
		return invSlots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return invSlots[0];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count)
	{
		ItemStack itemstack = getStackInSlot(slot);

		if(itemstack != null)
		{
			if(itemstack.stackSize <= count)
			{
				setInventorySlotContents(slot, null);
			}
			else
			{
				itemstack = itemstack.splitStack(count);
				onInventoryChanged();
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if(this.invSlots[slot] != null)
		{
			ItemStack var2 = this.invSlots[slot];
			this.invSlots[slot] = null;
			return var2;
		}
		else
			return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		invSlots[slot] = itemstack;

		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		NBTTagList tagList = new NBTTagList();
		for(int i = 0; i < this.invSlots.length; ++i)
		{
			if(this.invSlots[i] != null)
			{
				NBTTagCompound ntc3 = new NBTTagCompound();
				ntc3.setByte("slot", (byte) i);
				this.invSlots[i].writeToNBT(ntc3);
				tagList.appendTag(ntc3);
			}
		}
		tagCompound.setTag("items", tagList);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		NBTTagList var2 = tagCompound.getTagList("items");
		for(int i = 0; i < var2.tagCount(); ++i)
		{
			NBTTagCompound ntc3 = (NBTTagCompound) var2.tagAt(i);
			byte slot = ntc3.getByte("slot");
			if(slot >= 0 && slot < this.invSlots.length)
			{
				this.invSlots[slot] = ItemStack.loadItemStackFromNBT(ntc3);
			}
		}
	}

	@Override
	public String getInvName()
	{
		return "Caveman";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return true;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return entityplayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;

	}

	@Override
	public void openChest()
	{}

	@Override
	public void closeChest()
	{}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}
}
