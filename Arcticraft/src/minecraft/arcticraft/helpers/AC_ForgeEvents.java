package arcticraft.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityFrostGhost;
import arcticraft.entities.AC_EntityPropertyTemperature;
import arcticraft.items.AC_Item;
import arcticraft.items.AC_ItemRecord;
import arcticraft.main.AC_Achievements;
import arcticraft.main.MainRegistry;
import arcticraft.renderers.AC_RenderHUD;

public class AC_ForgeEvents {

	Minecraft mc;

	@ForgeSubscribe
	public void itemPickUpNotifier(EntityItemPickupEvent event) {
		ItemStack itemstack = event.item.getEntityItem();

		if (itemstack.itemID == AC_Block.frostLog.blockID) {
			event.entityPlayer.addStat(AC_Achievements.BACK_TO_BASICS, 1);
		}
	}

	@ForgeSubscribe
	public void ghostDrop(LivingDropsEvent event) {
		if (event.entity instanceof AC_EntityFrostGhost && event.source.isProjectile()) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(AC_Item.invisoStaff)));
		}
	}

	@ForgeSubscribe
	public void playerDeath(LivingDeathEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			AC_TickHandler.value = 50;

		}
	}

	@ForgeSubscribe
	public void playerInteract(PlayerInteractEvent event) {
		if (event.entityPlayer != null && event.entityPlayer.getCurrentItemOrArmor(0) != null) {
			ItemStack hand = event.entityPlayer.getCurrentItemOrArmor(0);

			if (hand.itemID == Block.torchWood.blockID && event.entityPlayer.dimension == MainRegistry.dimension) {

				if (event.action == event.action.RIGHT_CLICK_BLOCK) {
					System.out.println("Cancelling the placing of torches...");
					event.setCanceled(true);
				}
			}
		}
	}

	@ForgeSubscribe
	public void onPlayerConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("Temperature") == null) {
			event.entity.registerExtendedProperties("Temperature", new AC_EntityPropertyTemperature());
		}
	}

}
