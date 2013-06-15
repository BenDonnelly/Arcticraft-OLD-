package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import arcticraft.main.MainRegistry;

public class AC_BlockArcaneStone extends Block
{
    public AC_BlockArcaneStone(int par1)
    {
        super(par1, Material.glass);
        
    }

    public int quantityDropped(Random par1Random)
    {
        return 2 + par1Random.nextInt(3);
    }

    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MainRegistry.arcaneDust.itemID ;
    }
}
