package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import arcticraft.tile_entities.AC_TileEntityCampfire;

public class AC_BlockCampfire extends BlockContainer
{

	public AC_BlockCampfire(int id, Material material)
	{
		super(id, material);

		//minX, minY, minZ, maxX, maxY, maxZ
		this.setBlockBounds( 0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);

	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return AxisAlignedBB.getAABBPool().getAABB((double) par2 + this.minX, (double) par3 + this.minY, (double) par4 + this.minZ, (double) par2 + this.maxX, (double) par3 + this.maxY, (double) par4 + this.maxZ);
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return -2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.setFire(5);
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{

		int l = par1World.getBlockMetadata(par2, par3, par4);
		float f = (float) par2 + 0.5F;
		float f1 = (float) par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
		float f2 = (float) par4 + 0.5F;
		float f3 = 0.52F;
		float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

		par1World.spawnParticle("largesmoke", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);

		par1World.spawnParticle("largesmoke", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);

		par1World.spawnParticle("largesmoke", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);

		par1World.spawnParticle("largesmoke", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);

	}

	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup [l] && !Block.opaqueCubeLookup [i1])
			{
				b0 = 3;
			}

			if (Block.opaqueCubeLookup [i1] && !Block.opaqueCubeLookup [l])
			{
				b0 = 2;
			}

			if (Block.opaqueCubeLookup [j1] && !Block.opaqueCubeLookup [k1])
			{
				b0 = 5;
			}

			if (Block.opaqueCubeLookup [k1] && !Block.opaqueCubeLookup [j1])
			{
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	public TileEntity createNewTileEntity(World par1World)
	{
		return new AC_TileEntityCampfire();
	}
}
