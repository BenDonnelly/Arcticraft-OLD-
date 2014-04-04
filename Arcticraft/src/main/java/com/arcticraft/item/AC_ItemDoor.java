package com.arcticraft.item;

import com.arcticraft.Block.AC_Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AC_ItemDoor extends ItemDoor {

	public AC_ItemDoor(Material p_i45334_1_) {
		super(p_i45334_1_);
		doorMaterial = p_i45334_1_;
		// TODO Auto-generated constructor stub
	}

	private Material doorMaterial;

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		Block blockType;

		if (this == AC_Item.frostDoor) {
			blockType = AC_Block.frostDoor;
		} else {
			blockType = AC_Block.amouryDoor;
		}
		
		if (par7 != 1) {
			return false;
		} else {
			++par5;
			Block block = blockType;

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)) {
				if (!block.canPlaceBlockAt(par3World, par4, par5, par6)) {
					return false;
				} else {
					int i1 = MathHelper.floor_double((double) ((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					placeDoorBlock(par3World, par4, par5, par6, i1, block);
					--par1ItemStack.stackSize;
					return true;
				}
			} else {
				return false;
			}
		}
	}

}
