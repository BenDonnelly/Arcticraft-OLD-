package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockFloranCrop extends Block
{

	@SideOnly(Side.CLIENT)
	private Icon [] iconArray;

	public int berryID;
	public int berryMeta;

	public int soilID;
	public int soilMeta;

	public AC_BlockFloranCrop(int id, Material material, int soilID, int soilMeta, int berryID, int berryMeta)
	{
		super(id, material);

		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
		this.setStepSound(Block.soundGrassFootstep);

		//Ticking
		this.setTickRandomly(true);

		this.berryID = berryID;
		this.berryMeta = berryMeta;

		this.soilID = soilID;
		this.soilMeta = soilMeta;
	}

	public AC_BlockFloranCrop(int id, Material material, int soilID, int berryID)
	{
		super(id, material);

		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
		this.setStepSound(Block.soundGrassFootstep);

		//Ticking
		this.setTickRandomly(true);

		this.berryID = berryID;
		this.berryMeta = 0;

		this.soilID = soilID;
		this.soilMeta = 0;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return berryID;
	}

	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (meta > 4)
		{
			return 2;
		}
		else if (meta < 2)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return par1 == MainRegistry.tilledFrostField.blockID;
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par1World.getBlockId(par2, par3 - 1, par4) == soilID && par1World.getBlockMetadata(par2, par3 - 1, par4) == soilMeta;
	}

	public void fertilize(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

		if (l > 7)
		{
			l = 7;
		}

		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	 public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 == 1)
        {
            return this.iconArray[1];
        }
        else if(par2 == 2)
        {
        	return this.iconArray[2];
        }
        else if(par2 == 0)
        {
        	return this.iconArray[0];
        }
        else
        {
            return this.iconArray[3];
        }
    }

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
	{
		if (player.getCurrentEquippedItem().itemID == Item.shears.itemID)
		{
			harvestBerries(world, x, y, z, player);
			world.playSoundEffect(x, y, z, "random.wood click", 1F, 1F);
		}
		else if (player.getCurrentEquippedItem().isItemEqual(new ItemStack(Item.dyePowder, -1, 15)))
		{

			if (world.getBlockMetadata(x, x, z) < 3)
			{
				world.setBlockMetadataWithNotify(x, y, z, 3, 3);
			}

			if (!player.capabilities.isCreativeMode)
			{
				player.getCurrentEquippedItem().stackSize--;
			}
		}
		return true;
	}

	public void harvestBerries(World world, int x, int y, int z, EntityPlayer player)
	{
		if (world.getBlockMetadata(x, y, z) == 3)
		{
			if (!world.isRemote && world != null)
			{
				int dropAmount = ((int) Math.round(Math.random() * 4)) + 1;
				for (int i = 0; i < dropAmount; i++)
				{
					EntityItem entity = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(berryID, 1, berryMeta));
					entity.delayBeforeCanPickup = 10;
					world.spawnEntityInWorld(entity);
				}
				world.setBlockMetadataWithNotify(x, y, z,0, 3);
				if (!player.capabilities.isCreativeMode)
				{
					player.getCurrentEquippedItem().damageItem(1, player);
				}
			}
		}
	}
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		int l = 0;
		if (l == 0)
		{
			if (world.getBlockMetadata(x, y, z) < 3)
			{
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
				System.out.println("Metadata: " + world.getBlockMetadata(x, y, z));
			}
//			else if (world.getBlockMetadata(x, y, z) == 3)
//			{
//				world.setBlockMetadataWithNotify(x, y, z, 0, 3);
//			}
		}
	}

	public int getRenderType()
	{
		return 1;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MainRegistry.floranBerry.itemID;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconArray = new Icon [4];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray [i] = par1IconRegister.registerIcon("AC:floran_" + i);
		}
	}

	
}
