package com.arcticraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.arcticraft.item.AC_Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BerryBush extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public static int stage;

	@Override
	protected Item func_149866_i() {
		return AC_Item.whiteberrySeed;
	}

	@Override
	protected Item func_149865_P() {
		return AC_Item.whiteberrySeed;
	}

	private Random rand = new Random();
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		if (world.getBlockMetadata(x, y, z) > 4) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(AC_Item.whiteberry, rand.nextInt(5)));
			world.setBlockMetadataWithNotify(x, y, z, 4, 3);
		}
		return false;
	}

	/**
	 * is the block grass, dirt or farmland
	 */
	@Override
	protected boolean canPlaceBlockOn(Block p_149854_1_) {
		return p_149854_1_ == AC_Block.tilledFrostField;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	public IIcon getIcon(int par1, int par2) {
		if (par2 == 1) {
			return this.iconArray[1];
		} else if (par2 == 2) {
			return this.iconArray[2];
		} else if (par2 == 3) {
			return this.iconArray[3];
		} else if (par2 == 4) {
			return this.iconArray[4];
		} else if (par2 == 5) {
			return this.iconArray[5];
		} else if (par2 == 0) {
			return this.iconArray[0];
		} else {
			stage = 5;
			return this.iconArray[5];
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.iconArray = new IIcon[6];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = p_149651_1_.registerIcon(this.getTextureName() + "_stage_" + i);
		}
	}
}