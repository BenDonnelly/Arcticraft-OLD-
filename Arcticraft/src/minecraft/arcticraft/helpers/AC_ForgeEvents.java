package arcticraft.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import arcticraft.items.AC_ItemRecord;
import arcticraft.main.MainRegistry;
import arcticraft.renderers.AC_RenderHUD;

public class AC_ForgeEvents
{

	Minecraft mc;

	@ForgeSubscribe
	public void playerDeath(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			System.out.println("Resetting the players Temperature...");
			AC_TickHandler.value = 50;
		}
	}

	
	@ForgeSubscribe
	public void playerInteract(PlayerInteractEvent event)
	{
		if(event.entityPlayer != null && event.entityPlayer.getCurrentItemOrArmor(0) != null)
		{
			ItemStack hand = event.entityPlayer.getCurrentItemOrArmor(0);

			if(hand.itemID == Block.torchWood.blockID && event.entityPlayer.dimension == MainRegistry.dimension)
			{

				if(event.action == event.action.RIGHT_CLICK_BLOCK)
				{
					System.out.println("Cancelling the placing of torches...");
					event.setCanceled(true);
				}
			}
		}
	}

	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void renderGameOverlay(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.type != ElementType.ALL)
		{
			return;
		}

		AC_RenderHUD.renderBossBars();
		AC_RenderHUD.renderPickaxeCooldown();
	}
	
	@ForgeSubscribe
	public void renderGameOverlay(RenderGameOverlayEvent.Post event) {
		switch (event.type) {
			case BOSSHEALTH:
				break;
			case CROSSHAIRS:
				break;
			case FOOD:
				AC_RenderHUD.renderTemperatureBar(event.resolution);
				break;
			default:
				break;
		}
	}

	@ForgeSubscribe
	public void playMusicDisks(PlayStreamingEvent event)
	{
		for(String name : AC_ItemRecord.recordNames)
		{
			if(name.equals(event.name))
			{
				event.result = new SoundPoolEntry(name + ".wav", MainRegistry.class.getResource("/assets/ac/records/" + name + ".wav"));
			}
		}
	}

}
