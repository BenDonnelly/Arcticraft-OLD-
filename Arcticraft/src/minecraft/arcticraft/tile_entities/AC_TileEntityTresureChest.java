package arcticraft.tile_entities;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import arcticraft.blocks.AC_BlockTresureChest;

public class AC_TileEntityTresureChest extends TileEntity implements IInventory
{

	public float lidAngle;
	public float prevLidAngle;
	public int numUsingPlayers;
	private int ticksSinceSync;

	ItemStack[] chestSlots = new ItemStack[27];

	public AC_TileEntityTresureChest()
	{}

	@Override
	public int getSizeInventory()
	{
		return chestSlots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return chestSlots[slot];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2)
	{
		if(this.chestSlots[par1] != null)
		{
			ItemStack itemstack;

			if(this.chestSlots[par1].stackSize <= par2)
			{
				itemstack = this.chestSlots[par1];
				this.chestSlots[par1] = null;
				this.onInventoryChanged();
				return itemstack;
			}
			else
			{
				itemstack = this.chestSlots[par1].splitStack(par2);

				if(this.chestSlots[par1].stackSize == 0)
				{
					this.chestSlots[par1] = null;
				}

				this.onInventoryChanged();
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if(this.chestSlots[par1] != null)
		{
			ItemStack itemstack = this.chestSlots[par1];
			this.chestSlots[par1] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		this.chestSlots[i] = itemstack;

		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}

		this.onInventoryChanged();
	}

	@Override
	public String getInvName()
	{
		return "Tresure Chest";
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.chestSlots = new ItemStack[this.getSizeInventory()];

		for(int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if(j >= 0 && j < this.chestSlots.length)
			{
				this.chestSlots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();

		for(int i = 0; i < this.chestSlots.length; ++i)
		{
			if(this.chestSlots[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.chestSlots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		par1NBTTagCompound.setTag("Items", nbttaglist);
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return true;
	}

	@Override
	public void openChest()
	{
	}

	@Override
	public void closeChest()
	{
	}


	

}
