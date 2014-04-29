package com.arcticraft.Block;

import java.util.Random;

import com.arcticraft.item.AC_Item;
import com.arcticraft.tile_entity.TileEntityCannon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Cannon extends BlockContainer {

	public Cannon(Material material) {
		super(material);
		this.setTickRandomly(true);
		// minX, minY, minZ, maxX, maxY, maxZ
		this.setBlockBounds(-0.25F, 0.0F, -0.25F, 1.25F, 2.0F, 1.25F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityCannon cannon = (TileEntityCannon) world.getTileEntity(x, y, z);
		ItemStack hand = player.getCurrentEquippedItem();

		if (!world.isRemote) {
			if (!cannon.isLoaded) {
				if (hand != null && hand.getItem() == AC_Item.cannonball) {
					cannon.isLoaded = true;
					System.out.println("Cannon Loaded!");
					world.playSoundAtEntity(player, "ac:misc.fuse", 1.5F, 1.5F);
				}
				if (!player.capabilities.isCreativeMode && hand != null && hand.getItem() == AC_Item.cannonball) {
					hand.stackSize--;
				}
			}
		}
		return true;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return AxisAlignedBB.getAABBPool().getAABB((double) par2 + this.minX, (double) par3 + this.minY, (double) par4 + this.minZ, (double) par2 + this.maxX, (double) par3 + this.maxY, (double) par4 + this.maxZ);
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return -2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int i1 = par1World.getBlockMetadata(par2, par3, par4) >> 2;
		++l;
		l %= 4;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCannon();
	}
}
