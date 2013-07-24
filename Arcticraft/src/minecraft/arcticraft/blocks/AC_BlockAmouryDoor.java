package arcticraft.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockAmouryDoor extends BlockDoor
{

	private static final String[] field_94467_a = new String[] {"ac:amoury_door_bottom" , "ac:amoury_door_top"};
	private final int field_94465_b;
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public AC_BlockAmouryDoor(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.field_94465_b = 0;

		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		return this.iconArray[this.field_94465_b];
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
	 */
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if(par5 != 1 && par5 != 0)
		{
			int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if(flag)
			{
				if(j1 == 0 && par5 == 2)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 1 && par5 == 5)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 2 && par5 == 3)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 3 && par5 == 4)
				{
					flag1 = ! flag1;
				}
			}
			else
			{
				if(j1 == 0 && par5 == 5)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 1 && par5 == 3)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 2 && par5 == 4)
				{
					flag1 = ! flag1;
				}
				else if(j1 == 3 && par5 == 2)
				{
					flag1 = ! flag1;
				}

				if((i1 & 16) != 0)
				{
					flag1 = ! flag1;
				}
			}

			return this.iconArray[this.field_94465_b + (flag1 ? field_94467_a.length : 0) + (flag2 ? 1 : 0)];
		}
		else
		{
			return this.iconArray[this.field_94465_b];
		}
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack hand = par5EntityPlayer.getCurrentItemOrArmor(0);

		if(par5EntityPlayer.getCurrentItemOrArmor(0) != null && hand.getItem() == AC_Item.amouryKey)
		{
			int i1 = this.getFullMetadata(par1World, par2, par3, par4);
			int j1 = i1 & 7;
			j1 ^= 4;

			if((i1 & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
			}
			else
			{
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			}

			par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
			hand.stackSize--;
			
			if(par5EntityPlayer instanceof EntityPlayerMP)
			{
				par5EntityPlayer.addChatMessage("The key seems to disintegrate...");
			}
		}

		return true;
	}

	public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
	{}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconArray = new Icon[field_94467_a.length * 2];

		for(int i = 0; i < field_94467_a.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(field_94467_a[i]);
			this.iconArray[i + field_94467_a.length] = new IconFlipped(this.iconArray[i], true, false);
		}
	}

}
