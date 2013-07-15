package arcticraft.blocks;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class AC_BlockACWaterStill extends BlockStationary
{
	public AC_BlockACWaterStill(int par1)
	{
		super(par1, Material.water);

		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();		

	}

	  public Icon getIcon(int par1, int par2)
	    {
	        return par1 != 0 && par1 != 1 ? this.theIcon[1] : this.theIcon[0];
	    }

}