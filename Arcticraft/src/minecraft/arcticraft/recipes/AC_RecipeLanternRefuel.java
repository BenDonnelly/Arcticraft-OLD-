package arcticraft.recipes;

import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import arcticraft.lib.Debug;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AC_RecipeLanternRefuel implements IRecipe
{

    @Override
    public boolean matches(InventoryCrafting crafting, World world)
    {
        return getCraftingResult(crafting) != null;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting)
    {
        int lanternSlot = -1;
        int fuelSlots = 0;
        
        boolean needsCancelation = false;
        
        for (int i = 0; i <= 8; i++)
        {
            if (crafting.getStackInSlot(i) != null && crafting.getStackInSlot(i).itemID == AC_Block.lantern.blockID && lanternSlot != -1) needsCancelation = true;
            if (crafting.getStackInSlot(i) != null && crafting.getStackInSlot(i).itemID == AC_Block.lantern.blockID && lanternSlot == -1) lanternSlot = i; 
            
            if (crafting.getStackInSlot(i) != null && crafting.getStackInSlot(i).itemID == AC_Item.frigus.itemID) fuelSlots++;
        }
        
        if (needsCancelation) return null;
        if (lanternSlot == -1) return null;

        int damageBuilder = crafting.getStackInSlot(lanternSlot).getItemDamage();
        damageBuilder = damageBuilder - (4 * fuelSlots);
        if (damageBuilder < 0) damageBuilder = 0;
        
        return new ItemStack(AC_Block.lantern.blockID, 1, damageBuilder);
    }

    @Override
    public int getRecipeSize()
    {
        return 2;
    }

    public ItemStack getRecipeOutput()
    {
        return new ItemStack(AC_Block.lantern);
    }
    
}
