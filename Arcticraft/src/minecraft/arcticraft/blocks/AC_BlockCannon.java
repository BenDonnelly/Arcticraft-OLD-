package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.entities.AC_EntityNPickThing;
import arcticraft.items.AC_Item;
import arcticraft.main.MainRegistry;
import arcticraft.tile_entities.AC_TileEntityCannon;

public class AC_BlockCannon extends BlockContainer
{

	public boolean isLoaded;
	public int fuse;

	public AC_BlockCannon(int id, Material material)
	{
		super(id, material);
		this.setTickRandomly(true);
		//minX, minY, minZ, maxX, maxY, maxZ  
		this.setBlockBounds(- 0.25F, 0.0F, - 0.25F, 1.25F, 2.0F, 1.25F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are)
	{

		ItemStack hand = player.getCurrentItemOrArmor(0);

		if(! world.isRemote)
		{
			if(! isLoaded)
			{
				if(hand != null && hand.getItem() == AC_Item.bomb)
				{
					world.scheduleBlockUpdate(x, y, z, this.blockID, 0);
					isLoaded = true;
					world.playSoundAtEntity(player, "ac:misc.fuse", 1.5F, 1.5F);
				}
				if(! player.capabilities.isCreativeMode)
				{
					hand.stackSize--;
				}
			}
		}
		return true;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random par5Random)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(isLoaded)
		{
			fuse++;
			world.scheduleBlockUpdate(x, y, z, this.blockID, 0);
			if(fuse == 100)
			{
				AC_EntityBomb bomb = new AC_EntityBomb(world, x, y, z);
				if(meta == 4)
				{
					bomb.setPosition(x, y + 2, z + 2);
					bomb.setVelocity(0, 2.0, 0.7);
				}
				if(meta == 3)
				{
					bomb.setPosition(x + 1.5, y + 2, z - 1);
					bomb.setVelocity(0.625, 2.0, 0.025);
				}
				if(meta == 2)
				{
					bomb.setPosition(x , y + 2, z - 1);
					bomb.setVelocity(0, 2.0, -0.7);
					
				}
				if(meta == 1)
				{
					bomb.setPosition(x - 1.5, y + 2, z + 1);
					bomb.setVelocity(-0.625, 2.0, -0.025);
				}
				world.spawnEntityInWorld(bomb);
				isLoaded = false;
				fuse = 0;
			}
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return AxisAlignedBB.getAABBPool().getAABB((double) par2 + this.minX, (double) par3 + this.minY, (double) par4 + this.minZ, (double) par2 + this.maxX, (double) par3 + this.maxY, (double) par4 + this.maxZ);
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return - 2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		int i1 = par1World.getBlockMetadata(par2, par3, par4) >> 2;
		++l;
		l %= 4;

		if(l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
		}

		if(l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
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

	@Override
	public TileEntity createNewTileEntity(World par1World)
	{
		return new AC_TileEntityCannon();
	}
}
