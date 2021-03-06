package com.arcticraft.item;

import java.util.List;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTeaDrinks extends ItemFood
{

	private static final String[] teaFlavours = {"ac:red_tea" , "ac:hot_chocolate" , "ac:floran_tea" , "ac:hot_chocolate_cold"};
	@SideOnly(Side.CLIENT)
	private IIcon[] teaField;

	public ItemTeaDrinks(int par2, float par3, boolean par4)
	{
		super(par2, par3, par4);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public IIcon getIconFromDamage(int par1)
	{
		int j = MathHelper.clamp_int(par1, 0, 15);
		return this.teaField[j];
	}

	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		String[] teaflavours = new String[] {"Red Tea" , "Hot Chocolate" , "Floran Tea" , "Chocolate Milk"};

		return teaflavours[par1ItemStack.getItemDamage()];
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(par1ItemStack.getItemDamage() == 0)
		{
			par3List.add("Regeneration II (1:00)");
			par3List.add("Decrease Temperature By 15\u00B0C");
		}
		else if(par1ItemStack.getItemDamage() == 1)
		{
			par3List.add("Increase Temperature By 30\u00B0C");
		}
		else if(par1ItemStack.getItemDamage() == 2)
		{
			par3List.add("Jump Boost III (1:00)");
			par3List.add("Decrease Temperature By 15\u00B0C");
		}
		else if(par1ItemStack.getItemDamage() == 3)
		{
			par3List.add("Decrease Temperature By 15\u00B0C");
		}

	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);

		if(! par2World.isRemote)
		{
			if(par1ItemStack.getItemDamage() == 0)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200, 2));
				/*if(AC_TickHandler.value <= 100 && AC_TickHandler.value >= 15)
				{
					AC_TickHandler.value -= 15;
				}
				else if(AC_TickHandler.value <= 14)
				{
					AC_TickHandler.value = 0;

				}*/
			}

		/*	else if(par1ItemStack.getItemDamage() == 1)
			{
				if(AC_TickHandler.value <= 70)
				{
					AC_TickHandler.value += 30;
				}
				else if(AC_TickHandler.value >= 71)
				{
					AC_TickHandler.value = 100;
				}
			}*/

			else if(par1ItemStack.getItemDamage() == 2)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 2));
				/*if(AC_TickHandler.value <= 100 && AC_TickHandler.value >= 15)
				{
					AC_TickHandler.value -= 15;
				}
				else if(AC_TickHandler.value <= 14)
				{
					AC_TickHandler.value = 0;

				}*/
			}
			/*else if(par1ItemStack.getItemDamage() == 3)
			{
				if(AC_TickHandler.value <= 100 && AC_TickHandler.value >= 15)
				{
					AC_TickHandler.value -= 15;
				}
				else if(AC_TickHandler.value <= 14)
				{
					AC_TickHandler.value = 0;
				}
			}*/

		}
		return new ItemStack(AC_Item.emptyCup);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < 4; i++)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.teaField = new IIcon[teaFlavours.length];

		for(int i = 0; i < teaFlavours.length; ++i)
		{
			this.teaField[i] = par1IconRegister.registerIcon(teaFlavours[i]);
		}
	}
}
