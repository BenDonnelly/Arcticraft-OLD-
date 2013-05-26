package arcticraft.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;
import arcticraft.world.AC_Teleporter;

public class AC_ItemFruits extends ItemFood {

	public AC_ItemFruits(int par1, int par2, boolean par3)
	{
		super(par1, par2, par1, par3);
		this.setAlwaysEdible();
	}

	public Random rand = new Random();
	
    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
    	attemptToTeleport(itemStack, world, player);
    	    	
    	itemStack.stackSize--;
    	return itemStack;
    }
    
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (par2EntityPlayer.capabilities.isCreativeMode)
    		attemptToTeleport(par1ItemStack, par3World, par2EntityPlayer);
    	
    	return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
    }
    
    private void attemptToTeleport(ItemStack itemStack, World world, EntityPlayer player)
    {
    	if(itemStack.itemID == MainRegistry.MystFruit.itemID)
		{
			if(player.dimension == 0)
			{
				AC_Teleporter.teleportEntity(player, MainRegistry.dimension);
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
			}
		}
		else if(itemStack.itemID == MainRegistry.GlacierFruit.itemID)
		{
			int dimension = player.dimension == 0 ? MainRegistry.dimension : 0;
			
			AC_Teleporter.teleportEntity(player, dimension);			
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 250, 50));
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
		}
    }
    
	public boolean hasEffect(ItemStack par1ItemStack) {
		if (par1ItemStack.itemID == MainRegistry.MystFruit.itemID) {
			return true;
		}

		if (par1ItemStack.itemID == MainRegistry.GlacierFruit.itemID) {
			return true;
		}

		return false;
	}

	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		if (par1ItemStack.itemID == MainRegistry.MystFruit.itemID) {
			return EnumRarity.epic;
		}

		if (par1ItemStack.itemID == MainRegistry.GlacierFruit.itemID) {
			return EnumRarity.epic;
		}

		return null;
	}
}
