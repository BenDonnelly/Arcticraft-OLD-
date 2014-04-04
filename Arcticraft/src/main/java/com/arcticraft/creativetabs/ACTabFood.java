package com.arcticraft.creativetabs;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.item.AC_Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ACTabFood extends CreativeTabs {

	public ACTabFood(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	public Item getTabIconItem() {
		return AC_Item.floranBerry;
	}

}
