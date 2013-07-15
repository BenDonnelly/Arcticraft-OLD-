package arcticraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;

public class AC_BlockACWaterFlowing extends BlockFlowing
{
	@SideOnly(Side.CLIENT)
    protected static Icon[] theIcon;
	
	public AC_BlockACWaterFlowing(int par1)
	{
		super(par1, Material.water);

		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();
	}


	
	public void registerIcons(IconRegister par1IconRegister)
    {      
            this.theIcon = new Icon[] {par1IconRegister.registerIcon("ac:ice_water_stationary"), par1IconRegister.registerIcon("ac:ice_water_flowing")};
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94424_b(String par0Str)
    {
        return par0Str == "ac:ice_water_stationary" ? AC_BlockACWaterFlowing.theIcon[0] : (par0Str == "ac:ice_water_flowing" ?  AC_BlockACWaterFlowing.theIcon[1]: null);
    }

    public Icon getIcon(int par1, int par2)
    {
        return par1 != 0 && par1 != 1 ? this.theIcon[1] : this.theIcon[0];
    }

}
