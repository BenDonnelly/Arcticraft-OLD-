package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AC_BlockFrostGrass extends Block
{

	public Icon grassSide;
	public Icon grassTop;
	public Icon grassBottom;
	public Icon grasSnowOverlay;

	public AC_BlockFrostGrass(int par1)
	{
		super(par1, Material.grass);
		this.setTickRandomly(true);

	}

	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.grassTop : (par1 == 0 ? AC_Block.frostDirt.getBlockTextureFromSide(par1) : this.grassSide);
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return par1 == 1 ? grassTop : (par1 == 0 ? grassBottom : grassSide);
	}

	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		if(world.getBlockId(x, y + 1, z) == Block.snow.blockID && side > 1)
			return grasSnowOverlay;
		{
			if(world.getBlockId(x, y + 1, z) == AC_Block.thickSnow.blockID && side > 1)
				return grasSnowOverlay;
		}
		return this.getBlockTextureFromSideAndMetadata(side, world.getBlockMetadata(x, y, z));
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		grassSide = par1IconRegister.registerIcon("ac:frost_grass_side");
		grassTop = par1IconRegister.registerIcon("ac:frost_grass_top");
		grassBottom = par1IconRegister.registerIcon("ac:frost_grass_bottom");
		grasSnowOverlay = par1IconRegister.registerIcon("ac:frost_snow_overlay");
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(! par1World.isRemote)
		{
			if(par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
			{
				par1World.setBlock(par2, par3, par4, AC_Block.frostDirt.blockID);
			}
			else if(par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
			{
				for(int l = 0; l < 4; ++l)
				{
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					int l1 = par1World.getBlockId(i1, j1 + 1, k1);

					if(par1World.getBlockId(i1, j1, k1) == AC_Block.frostDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
					{
						par1World.setBlock(i1, j1, k1, AC_Block.frostGrass.blockID);
					}
				}
			}
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return AC_Block.frostDirt.idDropped(0, par2Random, par3);
	}

}
