package com.arcticraft.item;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.arcticraft.main.MainRegistry;
import com.arcticraft.world.AC_Teleporter;

public class AC_Fruit extends ItemFood
{

	public AC_Fruit()
	{
		super(0, true);
		this.setAlwaysEdible();
	}

	public Random rand = new Random();

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		attemptToTeleport(itemStack, world, player);
		//TODO fix sound
//		Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.portal", 4.0F, 4.0F);
		//player.addStat(AC_Achievements.AC_ENTER, 1);
		itemStack.stackSize--;
		return itemStack;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(player.capabilities.isCreativeMode)
		{
			if(player.dimension != MainRegistry.dimensionId)
			{
				//player.addStat(AC_Achievements.AC_ENTER, 1);
			}
		//	Minecraft.getMinecraft()..playSoundFX("ac:misc.portal", 4.0F, 4.0F);
			attemptToTeleport(par1ItemStack, world, player);
		}
		return super.onItemUse(par1ItemStack, player, world, par4, par5, par6, par7, par8, par9, par10);
	}

	private void attemptToTeleport(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.itemID == AC_Item.MystFruit.itemID)
		{
			if(player.dimension == 0)
			{
				AC_Teleporter.teleportEntity(player, MainRegistry.dimension);
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));

			}
		}
		else if(itemStack.itemID == AC_Item.GlacierFruit.itemID)
		{
			int dimension = player.dimension == 0 ? MainRegistry.dimension : 0;

			AC_Teleporter.teleportEntity(player, dimension);
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));

		}
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(par1ItemStack.itemID == AC_Item.MystFruit.itemID)
		{
			return true;
		}

		if(par1ItemStack.itemID == AC_Item.GlacierFruit.itemID)
		{
			return true;
		}

		return false;
	}

	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		if(par1ItemStack.itemID == AC_Item.MystFruit.itemID)
		{
			return EnumRarity.epic;
		}

		if(par1ItemStack.itemID == AC_Item.GlacierFruit.itemID)
		{
			return EnumRarity.epic;
		}

		return null;
	}
}
