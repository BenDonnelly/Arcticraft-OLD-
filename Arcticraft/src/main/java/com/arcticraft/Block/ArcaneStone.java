package com.arcticraft.Block;

import java.util.Random;

import com.arcticraft.item.AC_Item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ArcaneStone extends Block{

	protected ArcaneStone(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}
	
	public int quantityDropped(Random par1Random) {
		return 2 + par1Random.nextInt(3);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return AC_Item.arcaneDust;
	}

}
