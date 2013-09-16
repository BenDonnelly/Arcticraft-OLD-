package arcticraft.helpers;

import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import arcticraft.items.AC_ItemRecord;
import arcticraft.main.MainRegistry;
import arcticraft.renderers.AC_RenderHUD;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ClientForgeEvents extends AC_ForgeEvents {

	@SideOnly(Side.CLIENT)
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
		case HELMET:
			AC_RenderHUD.renderFreezeOverlay(event.resolution.getScaledWidth(), event.resolution.getScaledHeight());
			break;
		default:
			break;
		}
	}

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void renderGameOverlay(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.ALL) {
			return;
		}

		AC_RenderHUD.renderBossBars();
		AC_RenderHUD.renderPickaxeCooldown();
	}

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void playMusicDisks(PlayStreamingEvent event) {
		for (String name : AC_ItemRecord.recordNames) {
			if (name.equals(event.name)) {
				event.result = new SoundPoolEntry(name + ".wav", MainRegistry.class.getResource("/assets/ac/records/" + name + ".wav"));
			}
		}
	}

}
