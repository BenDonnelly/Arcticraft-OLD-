package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityCaveman;
import arcticraft.tile_entities.AC_TileEntityCaveman;

public class AC_BlockCaveman extends BlockContainer
{

	public AC_BlockCaveman(int id, Material material)
	{
		super(id, material);
		//                  minX  minY     minZ  maxX  maxY  maxZ
		this.setBlockBounds(- 0.25F, 0.0F, - 0.25F, 1.25F, 2.0F, 1.25F);

		//normal block      0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F
		//stacked block     ""                   ", 2.0F, 1.0F

	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return 0;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		if(! par1World.isRemote)
		{
			AC_EntityCaveman caveman = new AC_EntityCaveman(par1World);
			caveman.setLocationAndAngles((double) par2 + 0.5D, (double) par3, (double) par4 + 0.5D, 0.0F, 0.0F);
			par1World.spawnEntityInWorld(caveman);
		}

		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if(l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if(l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if(l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if(l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
	}

	/*
	 * public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	 * {
	 * this.setBlockBounds(0.1F, 0.0625F, 0.1F, 1.5F, 2.0F, 1.5F);
	 * super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	 * }
	 */

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{

		if(par1World.getBlockId(par2, par3 - 1, par4) == AC_Block.frostGrass.blockID || par1World.getBlockMetadata(par2, par3 - 1, par4) == AC_Block.acWaterStill.blockID)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return - 2;
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if(! par1World.isRemote)
		{
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if(Block.opaqueCubeLookup[l] && ! Block.opaqueCubeLookup[i1])
			{
				b0 = 3;
			}

			if(Block.opaqueCubeLookup[i1] && ! Block.opaqueCubeLookup[l])
			{
				b0 = 2;
			}

			if(Block.opaqueCubeLookup[j1] && ! Block.opaqueCubeLookup[k1])
			{
				b0 = 5;
			}

			if(Block.opaqueCubeLookup[k1] && ! Block.opaqueCubeLookup[j1])
			{
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	public TileEntity createNewTileEntity(World par1World)
	{
		return new AC_TileEntityCaveman();
	}
}
