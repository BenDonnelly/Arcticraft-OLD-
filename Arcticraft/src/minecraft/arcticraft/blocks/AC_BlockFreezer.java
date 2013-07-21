package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;
import arcticraft.tile_entities.AC_TileEntityFreezer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockFreezer extends BlockContainer
{

	/**
	 * Is the random generator used by freezer to drop the inventory contents in
	 * random directions.
	 */
	private final Random freezerRand = new Random();

	/** True if this is an active freezer, false if idle */
	private final boolean isActive;

	/**
	 * This flag is used to prevent the freezer inventory to be dropped upon
	 * block removal, is used internally when the freezer block changes from
	 * idle to active and vice-versa.
	 */
	private static boolean keepFreezerInventory = false;
	@SideOnly(Side.CLIENT)
	private Icon freezerIconTop;
	@SideOnly(Side.CLIENT)
	private Icon freezerIconFront;

	private Icon[] activeFace;
	private Icon sideFace;

	public AC_BlockFreezer(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.isActive = par2;
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

		if(par6ItemStack.hasDisplayName())
		{
			((AC_TileEntityFreezer) par1World.getBlockTileEntity(par2, par3, par4)).getInvName();
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.freezerIconTop : (par1 == 0 ? this.freezerIconTop : (par1 != par2 ? this.blockIcon : this.freezerIconFront));
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("ac:freezer_side");
		this.freezerIconFront = par1IconRegister.registerIcon(this.isActive ? "ac:freezer_front_on" : "ac:freezer_front_off");
		this.freezerIconTop = par1IconRegister.registerIcon("ac:freezer_top");
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return AC_Block.freezerIdle.blockID;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
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

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity == null || player.isSneaking())
		{

			return false;
		}

		player.openGui(MainRegistry.instance, 0, world, x, y, z);

		return true;
	}

	/**
	 * Update which block ID the freezer is using depending on whether or not it
	 * is burning
	 */
	public static void updateFreezerBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepFreezerInventory = true;

		if(par0)
		{
			par1World.setBlock(par2, par3, par4, AC_Block.freezerBurning.blockID);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, AC_Block.freezerIdle.blockID);
		}

		keepFreezerInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if(tileentity != null)
		{
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(this.isActive)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			float f = (float) par2 + 0.5F;
			float f1 = (float) par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = (float) par4 + 0.5F;
			float f3 = 0.52F;
			float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

			if(l == 4)
			{
				par1World.spawnParticle("smoke", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 5)
			{
				par1World.spawnParticle("smoke", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 2)
			{
				par1World.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if(l == 3)
			{
				par1World.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World par1World)
	{
		return new AC_TileEntityFreezer();
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if(! keepFreezerInventory)
		{
			AC_TileEntityFreezer TileEntityFreezer = (AC_TileEntityFreezer) par1World.getBlockTileEntity(par2, par3, par4);

			if(TileEntityFreezer != null)
			{
				for(int j1 = 0; j1 < TileEntityFreezer.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = TileEntityFreezer.getStackInSlot(j1);

					if(itemstack != null)
					{
						float f = this.freezerRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.freezerRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.freezerRand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0)
						{
							int k1 = this.freezerRand.nextInt(21) + 10;

							if(k1 > itemstack.stackSize)
							{
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if(itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double) ((float) this.freezerRand.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.freezerRand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) this.freezerRand.nextGaussian() * f3);
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}

				par1World.func_96440_m(par2, par3, par4, par5);
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * If this returns true, then comparators facing away from this block will
	 * use the value from getComparatorInputOverride instead of the actual
	 * redstone signal strength.
	 */
	public boolean hasComparatorInputOverride()
	{
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is
	 * used instead of the redstone signal strength when this block inputs to a
	 * comparator.
	 */
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
	{
		return Container.calcRedstoneFromInventory((IInventory) par1World.getBlockTileEntity(par2, par3, par4));
	}
}
