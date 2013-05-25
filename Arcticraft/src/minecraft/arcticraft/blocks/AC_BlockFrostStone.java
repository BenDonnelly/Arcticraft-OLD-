package arcticraft.blocks;

import java.util.Random;

import arcticraft.main.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class AC_BlockFrostStone extends Block
{
    public AC_BlockFrostStone(int par1)
    {
        super(par1, Material.rock);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MainRegistry.frostCobble.blockID;
    }
}