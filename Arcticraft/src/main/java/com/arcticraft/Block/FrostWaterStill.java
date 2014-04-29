package com.arcticraft.Block;

import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class FrostWaterStill extends BlockStaticLiquid{

	protected FrostWaterStill(Material p_i45429_1_) {
		super(p_i45429_1_);
		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();
	}
	
	public IIcon getIcon(int par1, int par2)
	{
		return par1 != 0 && par1 != 1 ? FrostWaterFlowing.theIcon[1] : FrostWaterFlowing.theIcon[0];
	}

}
