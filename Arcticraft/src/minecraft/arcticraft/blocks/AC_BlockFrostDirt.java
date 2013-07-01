package arcticraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import arcticraft.main.MainRegistry;

public class AC_BlockFrostDirt extends Block
{
    public AC_BlockFrostDirt(int par1)
    {
        super(par1, Material.grass);
        this.setCreativeTab(MainRegistry.tabBlocks);
    }
}