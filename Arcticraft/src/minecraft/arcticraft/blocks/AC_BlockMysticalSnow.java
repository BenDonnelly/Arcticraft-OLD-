package arcticraft.blocks; 

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockMysticalSnow extends Block 
{
	public AC_BlockMysticalSnow(int i) 
	{
		super(i, Material.snow);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
	}

	public boolean renderAsNormalBlock() //Tells the game how to render the block
	{
	         return false;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	public void registerIcons(IconRegister iconRegister)
	{
	
	this.blockIcon = iconRegister.registerIcon("AC:mystical_snow");
	
	}
	
}