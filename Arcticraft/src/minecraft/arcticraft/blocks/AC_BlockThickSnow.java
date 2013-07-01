package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AC_BlockThickSnow extends Block
{

	public static boolean shouldSlowPlayer = true;
	Minecraft mc;

	public AC_BlockThickSnow(int par1)
	{
		super(par1, Material.snow);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setTickRandomly(true);
		mc = mc.getMinecraft();
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate()
	{
		return 30;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Block.blockSnow.blockID;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return AxisAlignedBB.getAABBPool().getAABB(0, 0, 0, 0, 0, 0);
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		this.setBlockBoundsForBlockRender(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
	}

	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	public void setBlockBoundsForItemRender()
	{
		float var1 = 0.1875F;
		this.setBlockBounds(0.0F, 0.5F - var1 / 2.0F, 0.0F, 1.0F, 0.5F + var1 / 2.0F, 1.0F);
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockId(par2, par3 - 1, par4);
		Block block = Block.blocksList [l];
		if (block == null) return false;
		if (block == this && (par1World.getBlockMetadata(par2, par3 - 1, par4) & 7) == 7) return true;
		if (!block.isLeaves(par1World, par2, par3 - 1, par4) && !Block.blocksList [l].isOpaqueCube()) return false;
		return par1World.getBlockMaterial(par2, par3 - 1, par4).blocksMovement();
	}

	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		par1World.setBlockToAir(par3, par4, par5);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		this.canSnowStay(par1World, par2, par3, par4);
	}

	/**
	 * Checks if this snow block can stay at this location.
	 */
	private boolean canSnowStay(World par1World, int par2, int par3, int par4)
	{
		if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
		{
			par1World.setBlockToAir(par2, par3, par4);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.getSavedLightValue(EnumSkyBlock.Block, par2, par3, par4) > 11)
		{
			par1World.setBlockToAir(par2, par3, par4);
		}
	}

	public void setBlockBoundsForBlockRender(int par1)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.250F, 1.0F);
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		
		if (shouldSlowPlayer == true)
		{
			par5Entity.motionX *= 0.8D;
			par5Entity.motionZ *= 0.8D;

		}
	}
}
