package arcticraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import arcticraft.blocks.AC_BlockLantern;
import arcticraft.main.AC_TickHandler;
import arcticraft.main.MainRegistry;
import arcticraft.tile_entities.AC_TileEntityLantern;

public class AC_ItemLantern extends Item
{
	/** The ID of the block the reed will spawn when used from inventory bar. */
	private int spawnID;
	static int fuelCounter;

	public static AC_TickHandler instance = new AC_TickHandler();

	public AC_ItemLantern(int par1, Block par2Block)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(2);
		this.spawnID = par2Block.blockID;
	}

	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	public static ItemStack fuelCounter(EntityPlayer entityPlayer, ItemStack itemStack)
	{
		if (entityPlayer != null && entityPlayer.getCurrentItemOrArmor(0) != null)
		{
			ItemStack hand = entityPlayer.getCurrentItemOrArmor(0);

			if (hand.getItem() == MainRegistry.itemLantern)
			{
			//	System.out.println("Fuel Counter " + fuelCounter);
				fuelCounter++;

				if (hand.getItem() == MainRegistry.itemLantern && fuelCounter == 300)
				{
					fuelCounter = 0;
				}

				if (hand.getItem() == MainRegistry.itemLantern && fuelCounter == 299 && instance.value < 100)
				{
					instance.value += 1;
					hand.damageItem(1, entityPlayer);
				//	System.out.println("Value " + instance.value);
				//	System.out.println("Item damage " + Minecraft.getMinecraft().thePlayer.getCurrentItemOrArmor(0).getItemDamage());
				}
			}
		}
		return itemStack;
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{

		int i1 = par3World.getBlockId(par4, par5, par6);
		if (i1 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
		{
			par7 = 1;
		}
		else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID)
		{
			if (par7 == 0)
			{
				--par5;
			}

			if (par7 == 1)
			{
				++par5;
			}

			if (par7 == 2)
			{
				--par6;
			}

			if (par7 == 3)
			{
				++par6;
			}

			if (par7 == 4)
			{
				--par4;
			}

			if (par7 == 5)
			{
				++par4;
			}
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else if (par1ItemStack.stackSize == 0)
		{
			return false;
		}
		else
		{
			if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity) null, par1ItemStack))
			{
				Block block = Block.blocksList [this.spawnID];				
				int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);

				if (par3World.setBlock(par4, par5, par6, this.spawnID, j1, 3))
				{
					if (par3World.getBlockId(par4, par5, par6) == this.spawnID)
					{
						//dunno if this will work, hopefully it does, ye, worth a shot
						Block.blocksList [this.spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
						Block.blocksList [this.spawnID].onPostBlockPlaced(par3World, par4, par5, par6, j1);
						AC_TileEntityLantern lantern = (AC_TileEntityLantern)par3World.getBlockTileEntity(par4, par5, par6);
						lantern.setDurability(par1ItemStack.getItemDamage());
					}

					par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
					--par1ItemStack.stackSize;

				}
			}

			return true;
		}
	}
}
