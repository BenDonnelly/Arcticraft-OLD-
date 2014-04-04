package com.arcticraft.Block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FrostDirt extends Block {
	public static final String[] field_150009_a = new String[] { "default", "default", "podzol" };
	@SideOnly(Side.CLIENT)
	private IIcon field_150008_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_150010_M;
	private static final String __OBFID = "CL_00000228";

	protected FrostDirt() {
		super(Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		if (p_149691_2_ == 2) {
			if (p_149691_1_ == 1) {
				return this.field_150008_b;
			}

			if (p_149691_1_ != 0) {
				return this.field_150010_M;
			}
		}

		return this.blockIcon;
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int p_149692_1_) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
		int i1 = p_149673_1_.getBlockMetadata(p_149673_2_, p_149673_3_, p_149673_4_);

		if (i1 == 2) {
			if (p_149673_5_ == 1) {
				return this.field_150008_b;
			}

			if (p_149673_5_ != 0) {
				Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();

				if (material == Material.snow || material == Material.craftedSnow) {
					return AC_Block.frostGrass.getIcon(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_, p_149673_5_);
				}

				Block block = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_);

				if (block != AC_Block.frostDirt && block != AC_Block.frostGrass) {
					return this.field_150010_M;
				}
			}
		}

		return this.blockIcon;
	}

	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	protected ItemStack createStackedBlock(int p_149644_1_) {
		if (p_149644_1_ == 1) {
			p_149644_1_ = 0;
		}

		return super.createStackedBlock(p_149644_1_);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		super.registerBlockIcons(p_149651_1_);
		this.field_150008_b = p_149651_1_.registerIcon(this.getTextureName() + "_" + "podzol_top");
		this.field_150010_M = p_149651_1_.registerIcon(this.getTextureName() + "_" + "podzol_side");

	}
}