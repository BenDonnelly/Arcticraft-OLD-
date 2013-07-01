package arcticraft.blocks;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import arcticraft.main.MainRegistry;

public class AC_BlockACWaterFlowing extends BlockFlowing
{
	public static Icon waterFlowingTexture;

	public AC_BlockACWaterFlowing(int par1)
	{
		super(par1, Material.water);

		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();
		this.setCreativeTab(MainRegistry.tabBlocks);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		waterFlowingTexture = par1IconRegister.registerIcon("AC:icyWaterFlowing");
	}

	 /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
   
	
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
	{
		return waterFlowingTexture;
	}
}
