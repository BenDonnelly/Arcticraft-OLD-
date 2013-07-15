package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import arcticraft.main.MainRegistry;

public class AC_BlockFrostStone extends Block
{
    public AC_BlockFrostStone(int par1)
    {
        super(par1, Material.rock);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return AC_Block.frostCobble.blockID;
    }


	
}
