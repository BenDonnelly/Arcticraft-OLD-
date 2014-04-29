package com.arcticraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class AC_Ice extends BlockIce
{

	public AC_Ice()
	{
		super();
	}

	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		par2EntityPlayer.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
		par2EntityPlayer.addExhaustion(0.025F);

		if(this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(par2EntityPlayer))
		{
			ItemStack itemstack = this.createStackedBlock(par6);

			if(itemstack != null)
			{
				this.dropBlockAsItem(par1World, par3, par4, par5, itemstack);
			}
		}
		else
		{
			if(par1World.provider.isHellWorld)
			{
				par1World.setBlockToAir(par3, par4, par5);
				return;
			}

			int i1 = EnchantmentHelper.getFortuneModifier(par2EntityPlayer);
			this.dropBlockAsItem(par1World, par3, par4, par5, par6, i1);
			Material material = par1World.getBlock(par3, par4 - 1, par5).getMaterial();

			if(material.blocksMovement() || material.isLiquid())
			{
				par1World.setBlock(par3, par4, par5, AC_Block.acWaterFlowing);
			}
		}
	}

	 /**
     * Ticks the block if it's been scheduled
     */
	@Override
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (p_149674_1_.getSavedLightValue(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11 - this.getLightOpacity())
        {
            if (p_149674_1_.provider.isHellWorld)
            {
                p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
                return;
            }

            this.dropBlockAsItem(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_), 0);
            p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, AC_Block.acWaterStill);
        }
    }

}
