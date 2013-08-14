package arcticraft.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcticraft.blocks.AC_Block;

public class AC_ItemBlockLantern extends ItemBlock
{
    
	private int ticksToDamage = getRandomTicksForDamage();
	
	public AC_ItemBlockLantern(int ID) 
	{
		super(ID - 256);
		this.setMaxStackSize(1);
		this.setHasSubtypes(false);
		this.setMaxDamage(16);
	}
	
    public int getMetadata(int meta)
    {
        return meta;
    }

	public boolean canPlaceItemBlockOnSide(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack currentStack)
    {
		return AC_Block.lantern.canPlaceBlockAt(world, x, y, z);
    }

    public boolean damageLanternInInventory(EntityPlayerMP player)
    {
        if (player == null) return false;
        if (player.getCurrentEquippedItem() == null) return false;
        if (player.getCurrentEquippedItem().itemID != AC_Block.lantern.blockID) return false;
        if (player.getCurrentEquippedItem().getItemDamage() == 15) return false;
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(AC_Block.lantern.blockID, 1, player.getCurrentEquippedItem().getItemDamage() + 1));
        return true;
    }
    
    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean held)
    {
    	if (!world.isRemote && entity instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) entity;
    		
    		if (--this.ticksToDamage == 0)
    		{
    			if (itemstack.getItemDamage() != this.getMaxDamage() - 1)
    			{
    				itemstack.damageItem(1, player);
    			}
    			
    			this.ticksToDamage = getRandomTicksForDamage();
    		}
    		
    		//set temp for player
    	}
    }
    
    public static int getRandomTicksForDamage()
    {
    	return 1200 + new Random().nextInt(150);
    }
}
