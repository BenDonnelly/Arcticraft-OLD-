package com.arcticraft.Block;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.arcticraft.item.AC_Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_Crop extends BlockCrops {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@Override
	 protected Item func_149866_i()
	    {
	        return AC_Item.floranSeed;
	    }

	 	@Override
	    protected Item func_149865_P()
	    {
	        return AC_Item.floranBerry;
	    }
	
	 /**
     * is the block grass, dirt or farmland
     */
	@Override
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == AC_Block.tilledFrostField;
    }
	
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		if(par2 == 1)
		{
			return this.iconArray[1];
		}
		else if(par2 == 2)
		{
			return this.iconArray[2];
		}
		else if(par2 == 0)
		{
			return this.iconArray[0];
		}
		else
		{
			return this.iconArray[3];
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.iconArray = new IIcon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = p_149651_1_.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }
}