package arcticraft.main;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import arcticraft.entities.AC_EntityCheifEskimo;
import arcticraft.entities.AC_EntityFrostZombie;

public class AC_ForgeEvents
{

	@ForgeSubscribe
	public void playerDeath(LivingDeathEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			System.out.println("Resetting the players Temperature...");
			AC_TickHandler.value = 50;
		}
	}

	@ForgeSubscribe
	public void playerInteract(PlayerInteractEvent event)
	{
		if (event.entityPlayer != null && event.entityPlayer.getCurrentItemOrArmor(0) != null)
		{
			ItemStack hand = event.entityPlayer.getCurrentItemOrArmor(0);

			if (hand.itemID == Block.torchWood.blockID && event.entityPlayer.dimension == MainRegistry.dimension)
			{

				if (event.action == event.action.RIGHT_CLICK_BLOCK)
				{
					System.out.println("Cancelling the placing of torches...");
					event.setCanceled(true);
				}
			}
		}
	}

}
