package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import arcticraft.entities.AC_EntityIceShard;

public class AC_ItemArchersBow extends ItemBow
{

	public AC_ItemArchersBow(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(400);
	}

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if(flag || par3EntityPlayer.inventory.hasItem(AC_Item.IceShard.itemID))
		{
			float f = (float) j / 10.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if((double) f < 0.1D)
			{
				return;
			}

			if(f > 1.0F)
			{
				f = 1.0F;
			}

			AC_EntityIceShard iceshard = new AC_EntityIceShard(par2World, par3EntityPlayer, f * 2.0F);

			if(f == 1.0F)
			{
				iceshard.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

			if(k > 0)
			{
				iceshard.setDamage(iceshard.getDamage() + (double) k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

			if(l > 0)
			{
				iceshard.setKnockbackStrength(l);
			}

			if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
			{
				iceshard.setFire(100);
			}

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if(flag)
			{
				iceshard.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(AC_Item.IceShard.itemID);
			}

			if(! par2World.isRemote)
			{
				par2World.spawnEntityInWorld(iceshard);
			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}

	/**
	* How long it takes to use or consume an item
	*/
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 160000;
	}

	/**
	* returns the action that specifies what animation to play when the items is being used
	*/
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}

	/**
	* Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	*/
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return event.result;
		}

		if(par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(AC_Item.IceShard.itemID))
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;

	}

	private Icon[] Texture = new Icon[4];

	public void registerIcons(IconRegister iconRegister)

	{

		itemIcon = iconRegister.registerIcon("ac:" + this.getUnlocalizedName().substring(5) + "_0");
		for(int N = 0; N < 4; N++)
		{
			this.Texture[N] = iconRegister.registerIcon("ac:" + this.getUnlocalizedName().substring(5) + "_" + N);

		}
	}

	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(player.getItemInUse() == null)
			return this.itemIcon;
		int Pulling = stack.getMaxItemUseDuration() - useRemaining;
		if(Pulling >= 7)
		{
			return Texture[3];
		}
		else if(Pulling > 3)
		{
			return Texture[2];
		}
		else if(Pulling > 0)
		{
			return Texture[1];
		}
		return Texture[0];
	}
}
