package arcticraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AC_ItemInvisoStaff extends Item 
{

	public AC_ItemInvisoStaff(int par1)
	{
		super(par1);
		this.setMaxDamage(16);
		this.maxStackSize = 1;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Invisibility (1:30)");
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "mob.endermen.portal", 1.0F, 1.0F);
		par3EntityPlayer.addPotionEffect(new PotionEffect(14, 1800, 0));
		par1ItemStack.damageItem(1, par3EntityPlayer);
		return par1ItemStack;
	}

}
