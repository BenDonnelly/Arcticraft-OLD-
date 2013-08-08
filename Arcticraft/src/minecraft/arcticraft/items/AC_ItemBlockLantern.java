package arcticraft.items;

import arcticraft.blocks.AC_Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_ItemBlockLantern extends ItemBlock
{
    public static AC_ItemBlockLantern me;
    
	public AC_ItemBlockLantern(int ID) 
	{
		super(ID - 256);
		setUnlocalizedName("ac:lantern");
		setMaxStackSize(1);
		setHasSubtypes(false);
		setMaxDamage(16);
		me = this;
	}
	
    public int getMetadata(int meta)
    {
        return meta;
    }

	public boolean canPlaceItemBlockOnSide(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack currentStack)
    {
		return AC_Block.Lantern.canPlaceBlockAt(world, x, y, z);
    }

    public boolean damageLanternInInventory(EntityPlayerMP player)
    {
        if (player == null) return false;
        if (player.getCurrentEquippedItem() == null) return false;
        if (player.getCurrentEquippedItem().itemID != AC_Block.Lantern.blockID) return false;
        if (player.getCurrentEquippedItem().getItemDamage() == 15) return false;
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(AC_Block.Lantern.blockID, 1, player.getCurrentEquippedItem().getItemDamage() + 1));
        return true;
    }

    public static AC_ItemBlockLantern getInstance()
    {
        return me;
    }
}
