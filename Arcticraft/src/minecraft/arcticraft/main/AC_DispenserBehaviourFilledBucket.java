package arcticraft.main;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import arcticraft.items.AC_ItemBucket;

final class AC_DispenserBehaviorFilledBucket extends BehaviorDefaultDispenseItem
{
    private final BehaviorDefaultDispenseItem defaultDispenserItemBehavior = new BehaviorDefaultDispenseItem();

    /**
     * Dispense the specified stack, play the dispense sound and spawn particles.
     */
    public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack)
    {
        AC_ItemBucket itembucket = (AC_ItemBucket)par2ItemStack.getItem();
        int i = par1IBlockSource.getXInt();
        int j = par1IBlockSource.getYInt();
        int k = par1IBlockSource.getZInt();
        EnumFacing enumfacing = BlockDispenser.getFacing(par1IBlockSource.getBlockMetadata());

        if (itembucket.tryPlaceContainedLiquid(par1IBlockSource.getWorld(), (double)i, (double)j, (double)k, i + enumfacing.getFrontOffsetX(), j + enumfacing.getFrontOffsetY(), k + enumfacing.getFrontOffsetZ()))
        {
            par2ItemStack.itemID = MainRegistry.bucketEmpty.itemID;
            par2ItemStack.stackSize = 1;
            return par2ItemStack;
        }
        else
        {
            return this.defaultDispenserItemBehavior.dispense(par1IBlockSource, par2ItemStack);
        }
    }
}
