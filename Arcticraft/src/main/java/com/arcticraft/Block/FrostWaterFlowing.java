package com.arcticraft.Block;

import javax.swing.Icon;

import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FrostWaterFlowing extends BlockDynamicLiquid{

	@SideOnly(Side.CLIENT)
	protected static IIcon[] theIcon;
	
	protected FrostWaterFlowing(Material p_i45403_1_) {
		super(p_i45403_1_);
		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();
	}
	
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.theIcon = new IIcon[] {par1IconRegister.registerIcon("ac:ice_water_stationary") , par1IconRegister.registerIcon("ac:ice_water_flowing")};
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getLiquidIcon(String par0Str)
	{
		return par0Str == "ac:ice_water_stationary" ? FrostWaterFlowing.theIcon[0] : (par0Str == "ac:ice_water_flowing" ? FrostWaterFlowing.theIcon[1] : null);
	}

	public IIcon getIcon(int par1, int par2)
	{
		return par1 != 0 && par1 != 1 ? this.theIcon[1] : this.theIcon[0];
	}

}
