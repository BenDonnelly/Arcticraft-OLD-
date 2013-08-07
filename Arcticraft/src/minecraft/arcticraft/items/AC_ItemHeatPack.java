package arcticraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcticraft.helpers.AC_TickHandler;

public class AC_ItemHeatPack extends Item
{

	public AC_ItemHeatPack(int par1)
	{
		super(par1);
		this.maxStackSize = 16;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(! par2World.isRemote && AC_TickHandler.value != 100)
		{

			if(AC_TickHandler.value <= 85)
			{
				AC_TickHandler.value += 15;
			}
			else
			{
				AC_TickHandler.value = 100;
			}
			if(! par3EntityPlayer.capabilities.isCreativeMode)
			{
				par1ItemStack.stackSize--;
			}
		}

		return par1ItemStack;
	}
}
