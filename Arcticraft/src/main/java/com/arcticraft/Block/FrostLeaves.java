package com.arcticraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.arcticraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FrostLeaves extends Block {

	protected FrostLeaves(Material p_i45433_1_) {
		super(p_i45433_1_);
		// TODO Auto-generated constructor stub
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(AC_Block.frostSapling);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(Strings.MODID + ":frost_leaves_fancy");
	}

	public boolean isOpaqueCube() {
		return false;
	}
}
