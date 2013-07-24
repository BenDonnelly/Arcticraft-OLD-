package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import arcticraft.entities.AC_EntityIceShard;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemArchersBow extends ItemBow
{

	public static final String[] bowPullIconNameArray = new String[] {"pulling_0" , "pulling_1" , "pulling_2"};
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public AC_ItemArchersBow(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(400);
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
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
			float f = (float) j / 20.0F;
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

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(this.func_111208_A() + "_standby");
		this.iconArray = new Icon[bowPullIconNameArray.length];

		for(int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(this.func_111208_A() + "_" + bowPullIconNameArray[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * used to cycle through icons based on their used duration, i.e. for the bow
	 */
	public Icon getItemIconForUseDuration(int par1)
	{
		return this.iconArray[par1];
	}
}
