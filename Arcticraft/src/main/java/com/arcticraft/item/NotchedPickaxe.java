package com.arcticraft.item;

import java.util.List;

import com.arcticraft.entity.EntityNPickaxe;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NotchedPickaxe extends ItemPickaxe
{

	public NotchedPickaxe(ToolMaterial par2EnumToolMaterial)
	{
		super(par2EnumToolMaterial);
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(! par2World.isRemote && this.canFireExplosion == true)
		{
			par2World.spawnEntityInWorld(new EntityNPickaxe(par2World, par3EntityPlayer));

			par1ItemStack.damageItem(50, par3EntityPlayer);
			this.canFireExplosion = false;
			this.cooldown = 1200;
		}
		return par1ItemStack;
	}
	
	 /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
    	startPickaxeCooldown((EntityPlayer)par3Entity);
		stringTick();
    }

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Summons explosions on right click");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("ac:notched_pickaxe_icon");
	}
	
	public static boolean canFireExplosion;
	public static int cooldown = 1200;
	public static int pickaxeStringTick = 0;
	
	public void stringTick()
	{
		if(pickaxeStringTick < 40)
		{
			pickaxeStringTick++;
		}
		else if(pickaxeStringTick >= 40)
		{
			pickaxeStringTick = 0;
		}
	}
	
	public void startPickaxeCooldown(EntityPlayer player)
	{
		ItemStack hand =  player.getHeldItem();
		if(hand != null && hand.getItem() == AC_Item.notchedPickaxe)
		{

			if(cooldown != 0)
			{
				cooldown--;
			}
			else if(cooldown == 0)
			{
				canFireExplosion = true;
			}

		}
	}

}
