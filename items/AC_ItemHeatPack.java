package arcticraft.items;

import arcticraft.main.AC_TickHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_ItemHeatPack extends Item
{

	public static AC_TickHandler instance = new AC_TickHandler();

	public AC_ItemHeatPack(int par1)
	{
		super(par1);
		this.maxStackSize = 16;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par3EntityPlayer != null && instance.value != 100)
		{
			if (instance.value > 86)
			{
				instance.value = 100;
			}

			else if (instance.value <= 85)
			{
				instance.value += 7.5;
			}
			System.out.println(instance.value);
			--par1ItemStack.stackSize;
		}
		return par1ItemStack;
	}
}
