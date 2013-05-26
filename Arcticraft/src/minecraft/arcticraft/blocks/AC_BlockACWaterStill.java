package arcticraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class AC_BlockACWaterStill extends BlockStationary
{
	public AC_BlockACWaterStill(int par1)
	{
		super(par1, Material.water);

		this.blockHardness = 100F;
		this.setLightOpacity(4);
		this.disableStats();		

	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("AC:icyWater");
	}
	
	 /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
  

	public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
	{
		if (side > 1) return AC_BlockACWaterFlowing.waterFlowingTexture;
		return blockIcon;
	}
}