package arcticraft.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import arcticraft.items.AC_ItemSword;

public class SlotCaveman extends Slot
{


	public SlotCaveman(IInventory par1iInventory, int par2, int par3, int par4)
	{
		super(par1iInventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack stack)
	{
		if(stack.getItem() instanceof AC_ItemSword)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getSlotStackLimit()
    {
        return 1;
    }
	
}
