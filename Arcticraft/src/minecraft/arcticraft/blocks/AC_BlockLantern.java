package arcticraft.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;
import arcticraft.tile_entities.AC_TileEntityLantern;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockLantern extends Block implements ITileEntityProvider
{

	private TileEntity tileEntity;

	public AC_BlockLantern(int par1)
	{
		super(par1, Material.circuits);
		this.setTickRandomly(true);
	}

	public void retrieveDurability(int durability, int x, int y, int z)
	{
		//TODO save to nbt
		System.out.println("retrieved durability: " + durability);

		//don't know why it doesn't get the correct durability, this may be completely wrong but, wont the idDropped method just cancel the harvest method out. 
		//the thing is that that there says that the durability is 0 when you break it. Again, this might be wrong but isnt it because the lanternblock drops the itemlantern with no damage.
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{

		return new AC_TileEntityLantern();
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if (!par5EntityPlayer.isSneaking()) return false;
    	if (par1World.isRemote) return false;
    	AC_TileEntityLantern tile = (AC_TileEntityLantern)par1World.getBlockTileEntity(par2, par3, par4);
    	System.out.println(tile.getDurability());
    	return true;
    }
	
	/*public int idDropped(int par1, Random par2Random, int par3)
	{

		return AC_Item.itemLantern.itemID; //couldnt you use this? 
	}*/

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		AC_TileEntityLantern lan = (AC_TileEntityLantern) world.getBlockTileEntity(x, y, z);
		list.add(new ItemStack(AC_Item.itemLantern, 1, lan.getDurability()));
		return list;
	}

	/*
	 * @Override
	 * public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer)
	 * {
	 * System.out.println("This is being called " + AC_TickHandler.getSideAsString() + " sided");
	 * AC_TileEntityLantern lan = (AC_TileEntityLantern)par1World.getBlockTileEntity(par2, par3, par4);
	 * ItemStack is = new ItemStack(MainRegistry.itemLantern);
	 * is.setItemDamage(lan.getDurability());
	 * System.out.println(lan.getDurability());
	 * par1World.spawnEntityInWorld(new EntityItem(par1World, par2, par3, par4, is));
	 * }
	 */

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
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

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return 2;
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World par1World)
	{
		return 1;
	}

	/**
	 * Gets if we can place a torch on a block.
	 */
	private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4)
	{
		if(par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
		{
			return true;
		}
		else
		{
			int l = par1World.getBlockId(par2, par3, par4);
			return(Block.blocksList[l] != null && Block.blocksList[l].canPlaceTorchOnTop(par1World, par2, par3, par4));
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)
				|| canPlaceTorchOn(par1World, par2, par3 - 1, par4);
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		int j1 = par9;

		if(par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4))
		{
			j1 = 5;
		}

		if(par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true))
		{
			j1 = 4;
		}

		if(par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true))
		{
			j1 = 3;
		}

		if(par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true))
		{
			j1 = 2;
		}

		if(par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true))
		{
			j1 = 1;
		}

		return j1;
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if(par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			this.onBlockAdded(par1World, par2, par3, par4);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if(par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			if(par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			}
			else if(par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			}
			else if(par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			}
			else if(par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			}
			else if(this.canPlaceTorchOn(par1World, par2, par3 - 1, par4))
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			}
		}

		this.dropTorchIfCantStay(par1World, par2, par3, par4);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		this.func_94397_d(par1World, par2, par3, par4, par5);
	}

	protected boolean func_94397_d(World par1World, int par2, int par3, int par4, int par5)
	{
		if(this.dropTorchIfCantStay(par1World, par2, par3, par4))
		{
			int i1 = par1World.getBlockMetadata(par2, par3, par4);
			boolean flag = false;

			if(! par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) && i1 == 1)
			{
				flag = true;
			}

			if(! par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) && i1 == 2)
			{
				flag = true;
			}

			if(! par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) && i1 == 3)
			{
				flag = true;
			}

			if(! par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) && i1 == 4)
			{
				flag = true;
			}

			if(! this.canPlaceTorchOn(par1World, par2, par3 - 1, par4) && i1 == 5)
			{
				flag = true;
			}

			if(flag)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockToAir(par2, par3, par4);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}

	/**
	 * Tests if the block can remain at its current location and will drop as an
	 * item if it is unable to stay. Returns True if it can stay and False if it
	 * drops. Args: world, x, y, z
	 */
	protected boolean dropTorchIfCantStay(World par1World, int par2, int par3, int par4)
	{
		if(! this.canPlaceBlockAt(par1World, par2, par3, par4))
		{
			if(par1World.getBlockId(par2, par3, par4) == this.blockID)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockToAir(par2, par3, par4);
			}

			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Ray traces through the blocks collision from start vector to end vector
	 * returning a ray trace hit. Args: world, x, y, z, startVec, endVec
	 */
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
		float f = 0.15F;

		if(l == 1)
		{
			this.setBlockBounds(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
		}
		else if(l == 2)
		{
			this.setBlockBounds(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
		}
		else if(l == 3)
		{
			this.setBlockBounds(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
		}
		else if(l == 4)
		{
			this.setBlockBounds(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
		}
		else
		{
			f = 0.1F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
		}

		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		double d0 = (double) ((float) par2 + 0.5F);
		double d1 = (double) ((float) par3 + 0.7F);
		double d2 = (double) ((float) par4 + 0.5F);
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if(l == 1)
		{
			par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
		else if(l == 2)
		{
			par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
		else if(l == 3)
		{
			par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		}
		else if(l == 4)
		{
			par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		}
		else
		{
			par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public void registerIcons(IconRegister iconRegister)
	{

		this.blockIcon = iconRegister.registerIcon("AC:lantern");

	}

}
