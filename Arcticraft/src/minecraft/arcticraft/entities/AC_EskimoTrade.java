package arcticraft.entities;

import arcticraft.main.MainRegistry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class AC_EskimoTrade {
	
	public ItemStack itemstack;
	public int gemAmount;
	
	public AC_EskimoTrade(ItemStack stack, int gems) {
		this.itemstack = stack;
		this.gemAmount = gems;
	}
	
	public static boolean removeGemsFromInventory(InventoryPlayer inv, int amount) {
		int gemID = MainRegistry.eriumGem.itemID;
		
		if (getGemsFromInventory(inv) < amount) {
			return false;
		}
		
		for (int j = 0; j < inv.mainInventory.length; ++j) {
			ItemStack stack = inv.mainInventory[j];
            if (stack != null && stack.itemID == gemID) {
            	while (amount > 0 && stack.stackSize > 0) {
            		inv.decrStackSize(j, 1);
            		amount--;
            	}
            }
        }
		
		return true;
	}
	
	public static int getGemsFromInventory(InventoryPlayer inv) {
		int gemID = MainRegistry.eriumGem.itemID;
		int stackSize = 0;
		
		for (int j = 0; j < inv.mainInventory.length; ++j) {
			ItemStack stack = inv.mainInventory[j];
            if (stack != null && stack.itemID == gemID) {
                stackSize += stack.stackSize;
            }
        }
		
		return stackSize;
	}
}
