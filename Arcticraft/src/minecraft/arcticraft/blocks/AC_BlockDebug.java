package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.items.AC_Item;
import arcticraft.main.MainRegistry;
import arcticraft.tile_entities.AC_TileEntityCavemanGUI;

public class AC_BlockDebug extends BlockContainer
{

	public boolean isLoaded;
	public int fuse;

	protected AC_BlockDebug(int id)
	{
		super(id, Material.wood);
		this.setTickRandomly(true);
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
					world.playSoundAtEntity(player, "random.fuse", 1.5F, 1.5F);
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

		if(isLoaded)
		{
			fuse++;
			world.scheduleBlockUpdate(x, y, z, this.blockID, 0);
			if(fuse == 100)
			{
				AC_EntityBomb bomb = new AC_EntityBomb(world, x, y, z);
				bomb.setPosition(x + 2, y + 2, z + 2);
				bomb.setVelocity(0, 2.0, 0.7);
				world.spawnEntityInWorld(bomb);
				isLoaded = false;
				fuse = 0;
				System.out.println("Spawing Explosion");
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(! (tileEntity instanceof IInventory))
		{
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for(int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);

			if(item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

				if(item.hasTagCompound())
				{
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new AC_TileEntityCavemanGUI();
	}

}
