package arcticraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import arcticraft.entities.AC_EntityBlueSparkle;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockGlacierLeaves extends AC_BlockLeavesBase implements IShearable
{

	public static final String[] LEAF_TYPES = new String[] {"glacier"};
	public static final String[][] LEAF_TEXTURES = new String[][] { {"glacier_leaves_fast"} , {"glacier_leaves_fancy"}};
	@SideOnly(Side.CLIENT)
	private static int field_94394_cP;
	private Icon[][] iconArray = new Icon[2][];
	int[] adjacentTreeBlocks;

	public AC_BlockGlacierLeaves(int par1)
	{
		super(par1, Material.leaves, false);
		this.setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerFoliage.getFoliageColor(d0, d1);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	public int getRenderColor(int par1)
	{
		return (par1 & 3) == 1 ? ColorizerFoliage.getFoliageColorPine() : ((par1 & 3) == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic());
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 * when first determining what to render.
	 */
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

		if((l & 3) == 1)
		{
			return ColorizerFoliage.getFoliageColorPine();
		}
		else if((l & 3) == 2)
		{
			return ColorizerFoliage.getFoliageColorBirch();
		}
		else
		{
			int i1 = 0;
			int j1 = 0;
			int k1 = 0;

			for(int l1 = - 1; l1 <= 1; ++l1)
			{
				for(int i2 = - 1; i2 <= 1; ++i2)
				{
					int j2 = par1IBlockAccess.getBiomeGenForCoords(par2 + i2, par4 + l1).getBiomeFoliageColor();
					i1 += (j2 & 16711680) >> 16;
					j1 += (j2 & 65280) >> 8;
					k1 += j2 & 255;
				}
			}

			return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return AC_Block.frostSapling.blockID;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte b0 = 1;
		int j1 = b0 + 1;

		if(par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
		{
			for(int k1 = - b0; k1 <= b0; ++k1)
			{
				for(int l1 = - b0; l1 <= b0; ++l1)
				{
					for(int i2 = - b0; i2 <= b0; ++i2)
					{
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

						if(Block.blocksList[j2] != null)
						{
							Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
	{
		super.randomDisplayTick(world, i, j, k, random);

		for(int l = 0; l < 4; l++)
		{
			double d = (double) (float) i + ((double) random.nextFloat() - 0.5D) * 10D;
			double d1 = (double) (float) j + ((double) random.nextFloat() - 0.5D) * 10D;
			double d2 = (double) (float) k + ((double) random.nextFloat() - 0.5D) * 10D;
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			AC_EntityBlueSparkle entitybluesparkle = new AC_EntityBlueSparkle(world, d, d1, d2, d3, d4, d5);
			Minecraft.getMinecraft().effectRenderer.addEffect(entitybluesparkle);
		}

	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(! par1World.isRemote)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);

			if((l & 8) != 0 && (l & 4) == 0)
			{
				byte b0 = 4;
				int i1 = b0 + 1;
				byte b1 = 32;
				int j1 = b1 * b1;
				int k1 = b1 / 2;

				if(this.adjacentTreeBlocks == null)
				{
					this.adjacentTreeBlocks = new int[b1 * b1 * b1];
				}

				int l1;

				if(par1World.checkChunksExist(par2 - i1, par3 - i1, par4 - i1, par2 + i1, par3 + i1, par4 + i1))
				{
					int i2;
					int j2;
					int k2;

					for(l1 = - b0; l1 <= b0; ++l1)
					{
						for(i2 = - b0; i2 <= b0; ++i2)
						{
							for(j2 = - b0; j2 <= b0; ++j2)
							{
								k2 = par1World.getBlockId(par2 + l1, par3 + i2, par4 + j2);

								Block block = Block.blocksList[k2];

								if(block != null && block.canSustainLeaves(par1World, par2 + l1, par3 + i2, par4 + j2))
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
								}
								else if(block != null && block.isLeaves(par1World, par2 + l1, par3 + i2, par4 + j2))
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = - 2;
								}
								else
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = - 1;
								}
							}
						}
					}

					for(l1 = 1; l1 <= 4; ++l1)
					{
						for(i2 = - b0; i2 <= b0; ++i2)
						{
							for(j2 = - b0; j2 <= b0; ++j2)
							{
								for(k2 = - b0; k2 <= b0; ++k2)
								{
									if(this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
									{
										if(this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}

										if(this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}

										if(this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
										}

										if(this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
										}

										if(this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
										}

										if(this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == - 2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
										}
									}
								}
							}
						}
					}
				}

				l1 = this.adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];

				if(l1 >= 0)
				{
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l & - 9, 4);
				}
				else
				{
					this.removeLeaves(par1World, par2, par3, par4);
				}
			}
		}
	}

	private void removeLeaves(World par1World, int par2, int par3, int par4)
	{
		this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return par1Random.nextInt(20) == 0 ? 1 : 0;
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if(! par1World.isRemote)
		{
			int j1 = 20;

			if((par5 & 3) == 3)
			{
				j1 = 40;
			}

			if(par7 > 0)
			{
				j1 -= 2 << par7;

				if(j1 < 10)
				{
					j1 = 10;
				}
			}

			if(par1World.rand.nextInt(j1) == 0)
			{
				int k1 = this.idDropped(par5, par1World.rand, par7);
				this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
			}

			j1 = 200;

			if(par7 > 0)
			{
				j1 -= 10 << par7;

				if(j1 < 40)
				{
					j1 = 40;
				}
			}

			if((par5 & 3) == 0 && par1World.rand.nextInt(j1) == 0)
			{
				this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(AC_Item.GlacierFruit, 1, 0));
			}
		}
	}

	/**
	 * Called when the player destroys a block with an item that can harvest it.
	 * (i, j, k) are the coordinates of the block and l is the block's
	 * subtype/damage.
	 */
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int par1)
	{
		return par1 & 3;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		return (par2 & 3) == 1 ? this.iconArray[this.field_94394_cP][1] : ((par2 & 3) == 3 ? this.iconArray[this.field_94394_cP][3] : this.iconArray[this.field_94394_cP][0]);
	}

	@SideOnly(Side.CLIENT)
	public static void setGraphicsLevel(boolean par1)
	{
		graphicsLevel = par1;
		field_94394_cP = par1 ? 0 : 1;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}

	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(this.blockID, 1, par1 & 3);
	}

	public Icon getIcon(int par1, int par2)
	{
		return (par2 & 3) == 1 ? this.iconArray[this.field_94394_cP][1] : ((par2 & 3) == 3 ? this.iconArray[this.field_94394_cP][3] : ((par2 & 3) == 2 ? this.iconArray[this.field_94394_cP][2] : this.iconArray[this.field_94394_cP][0]));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{

		for(int i = 0; i < LEAF_TEXTURES.length; ++i)
		{

			this.iconArray[i] = new Icon[LEAF_TEXTURES[i].length];

			for(int j = 0; j < LEAF_TEXTURES[i].length; ++j)
			{

				this.iconArray[i][j] = par1IconRegister.registerIcon("ac:" + LEAF_TEXTURES[i][j]);
			}
		}
	}

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
}
