package arcticraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityCannonball;

public class AC_ItemBomb extends Item
{

	public AC_ItemBomb(int i)
	{
		super(i);
		this.maxStackSize = 8;
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if(! var3.capabilities.isCreativeMode)
		{
			--var1.stackSize;
		}
		var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if(! var2.isRemote)
		{
			var2.spawnEntityInWorld(new AC_EntityCannonball(var2, var3));
		}
		return var1;
	}

}
