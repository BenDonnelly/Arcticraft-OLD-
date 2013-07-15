package arcticraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;

public class AC_BlockFrostStairs extends BlockStairs{

	public AC_BlockFrostStairs(int par1, Block par2Block, int par3)
	{
		super(par1, par2Block, par3);
		this.useNeighborBrightness[par1] = true;
	}
	
}