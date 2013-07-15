package arcticraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class AC_BlockMossyFrostCobble extends Block
{
    public AC_BlockMossyFrostCobble(int par1)
    {
        super(par1, Material.rock);

    }
    public void registerIcons(IconRegister iconRegister)
   	{
   	
   	this.blockIcon = iconRegister.registerIcon("AC:frost_mossy_cobble");
   	
   	}
}