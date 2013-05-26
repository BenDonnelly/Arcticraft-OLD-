package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.tile_entities.AC_TileEntityStatue;

public class AC_BlockStatue extends BlockContainer
{

	public AC_BlockStatue(int id, Material material)
	{
		super(id, material);
        this.setBlockBounds(0.1F, 0.1F, 0.1F, 1.0F, 3.0F, 1.0F);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
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

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{
		int rotation = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
		world.setBlock(i, j, k, rotation, -1, this.blockID);
	}

	public TileEntity createNewTileEntity(World par1World)
	{
		return new AC_TileEntityStatue();
	}
}
