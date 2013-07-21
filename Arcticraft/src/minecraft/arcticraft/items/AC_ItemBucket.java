package arcticraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class AC_ItemBucket extends ItemBucket
{

	private int isFull;

	public AC_ItemBucket(int par1, int par2)
	{
		super(par1, par2);
		this.maxStackSize = 1;
		this.isFull = par2;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		float f = 1.0F;
		double d0 = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double) f;
		double d1 = par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double) f + 1.62D - (double) par3EntityPlayer.yOffset;
		double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double) f;
		boolean flag = this.isFull == 0;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

		if(movingobjectposition == null)
		{
			return par1ItemStack;
		}
		else
		{
			FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
			if(MinecraftForge.EVENT_BUS.post(event))
			{
				return par1ItemStack;
			}

			if(event.getResult() == Event.Result.ALLOW)
			{
				if(par3EntityPlayer.capabilities.isCreativeMode)
				{
					return par1ItemStack;
				}

				if(--par1ItemStack.stackSize <= 0)
				{
					return event.result;
				}

				if(! par3EntityPlayer.inventory.addItemStackToInventory(event.result))
				{
					par3EntityPlayer.dropPlayerItem(event.result);
				}

				return par1ItemStack;
			}

			if(movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if(! par2World.canMineBlock(par3EntityPlayer, i, j, k))
				{
					return par1ItemStack;
				}

				if(this.isFull == 0)
				{
					if(! par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						return par1ItemStack;
					}

					if(par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
					{
						par2World.setBlockToAir(i, j, k);

						if(par3EntityPlayer.capabilities.isCreativeMode)
						{
							return par1ItemStack;
						}

						if(--par1ItemStack.stackSize <= 0)
						{
							return new ItemStack(AC_Item.bucketIcyWater);
						}

						if(! par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(AC_Item.bucketIcyWater)))
						{
							par3EntityPlayer.dropPlayerItem(new ItemStack(AC_Item.bucketIcyWater.itemID, 1, 0));
						}

						return par1ItemStack;
					}
				}
				else
				{
					if(this.isFull < 0)
					{
						return new ItemStack(AC_Item.bucketEmpty);
					}

					if(movingobjectposition.sideHit == 0)
					{
						--j;
					}

					if(movingobjectposition.sideHit == 1)
					{
						++j;
					}

					if(movingobjectposition.sideHit == 2)
					{
						--k;
					}

					if(movingobjectposition.sideHit == 3)
					{
						++k;
					}

					if(movingobjectposition.sideHit == 4)
					{
						--i;
					}

					if(movingobjectposition.sideHit == 5)
					{
						++i;
					}

					if(! par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						return par1ItemStack;
					}

					if(this.tryPlaceContainedLiquid(par2World, i, j, k) && ! par3EntityPlayer.capabilities.isCreativeMode)
					{
						return new ItemStack(AC_Item.bucketEmpty);
					}
				}
			}

		}
		return par1ItemStack;
	}
}
