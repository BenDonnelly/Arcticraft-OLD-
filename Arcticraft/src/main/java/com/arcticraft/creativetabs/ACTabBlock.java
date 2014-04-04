package com.arcticraft.creativetabs;

import com.arcticraft.Block.AC_Block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ACTabBlock extends CreativeTabs {

	public ACTabBlock(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(AC_Block.frostGrass);
	}

}
