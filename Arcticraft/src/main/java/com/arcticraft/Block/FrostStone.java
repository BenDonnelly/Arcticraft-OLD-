package com.arcticraft.Block;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FrostStone extends BlockStone
{
    private static final String __OBFID = "CL_00000317";

    public FrostStone()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(AC_Block.frostCobble);
    }
}