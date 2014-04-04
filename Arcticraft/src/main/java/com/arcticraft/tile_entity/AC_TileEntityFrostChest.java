package com.arcticraft.tile_entity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;

import com.arcticraft.Block.FrostChest;

public class AC_TileEntityFrostChest extends TileEntityChest{
	
	private int cachedChestType;
	private String customName;
	private ItemStack[] chestContents = new ItemStack[36];
	
	/**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : "Frost Chest";
    }
    
    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];

        if (p_145839_1_.hasKey("Frost Chest", 8))
        {
            this.customName = p_145839_1_.getString("Frost Chest");
        }

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.chestContents.length)
            {
                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

	private boolean func_145977_a(int p_145977_1_, int p_145977_2_, int p_145977_3_)
    {
        Block block = this.worldObj.getBlock(p_145977_1_, p_145977_2_, p_145977_3_);
        return block instanceof FrostChest && ((FrostChest)block).field_149956_a == this.func_145980_j();
    }

	public void closeInventory()
    {
        if (this.getBlockType() instanceof FrostChest)
        {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
        }
    }
	
	public int func_145980_j()
    {
        if (this.cachedChestType == -1)
        {
            if (this.worldObj == null || !(this.getBlockType() instanceof FrostChest))
            {
                return 0;
            }

            this.cachedChestType = ((FrostChest)this.getBlockType()).field_149956_a;
        }

        return this.cachedChestType;
    }
	
}
