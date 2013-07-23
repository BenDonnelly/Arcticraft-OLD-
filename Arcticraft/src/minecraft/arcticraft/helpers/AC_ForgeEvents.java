package arcticraft.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import arcticraft.entities.AC_BossStatus;
import arcticraft.items.AC_Item;
import arcticraft.items.AC_ItemRecord;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;

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

		renderBossBars();
		renderPickaxeCooldown();

	}

	public void renderBossBars()
	{
		mc = mc.getMinecraft();
		GuiIngame gui = this.mc.ingameGUI;

		if(AC_BossStatus.bossName != null && AC_BossStatus.statusBarLength > 0)
		{
			--AC_BossStatus.statusBarLength;
			FontRenderer fontrenderer = this.mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			short short1 = 182;
			int j = i / 2 - short1 / 2;
			int k = (int) (AC_BossStatus.healthScale * (float) (short1 + 1));
			byte b0 = 12;
			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("ac", "/textures/gui/boss_bars.png"));
			gui.drawTexturedModalRect(j, b0, 0, 0, short1, 14);
			if(k > 0)
			{
				gui.drawTexturedModalRect(j, b0, 0, 14, k, 14);
			}

			String s = AC_BossStatus.bossName;
			fontrenderer.drawStringWithShadow(s, i / 2 - fontrenderer.getStringWidth(s) / 2, b0 - 10, 16777215);

			if(AC_BossStatus.isMiniBoss == true)
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Mini Boss", i / 2 - fontrenderer.getStringWidth(s) / 2, b0 + 15, 0xffffffff);
			}
			else
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Final Boss", i / 2 - fontrenderer.getStringWidth(s) / 2, b0 + 15, 0xffffffff);
			}
		}

	}

	public void renderPickaxeCooldown()
	{
		mc = mc.getMinecraft();
		ItemStack hand = mc.thePlayer.getCurrentItemOrArmor(0);
		GuiIngame gui = this.mc.ingameGUI;
		FontRenderer fontrenderer = this.mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		int i = scaledresolution.getScaledWidth();
		short short1 = 90;
		int j = i / 2 - short1 / 2;

		if(hand != null && hand.getItem() == AC_Item.notchedPickaxe)
		{
			if(mc.currentScreen == null || mc.currentScreen instanceof GuiIngameMenu)
			{
				renderPickaxeStrings();
				FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("ac", "/textures/gui/cooldown_bar.png"));
				gui.drawTexturedModalRect(j, 40, 0, 12, 82, 12);
				gui.drawTexturedModalRect(j, 40, 0, 0, (int) Math.round(AC_TickHandler.cooldown / 82 * 5.7), 6);
			}
		}

	}

	public void renderPickaxeStrings()
	{
		FontRenderer fontrenderer = this.mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		int i = scaledresolution.getScaledWidth();
		short short1 = 90;
		int j = i / 2 - short1 / 2;
		if(AC_TickHandler.cooldown == 0 && AC_TickHandler.pickaxeStringTick >= 20 && AC_TickHandler.pickaxeStringTick <= 40)
		{
			fontrenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "Ready To Fire", j, 10 + 15, 0xffffffff);
		}
		else if(AC_TickHandler.cooldown >= 1)
		{
			fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Cooling Down", j, 10 + 15, 0xffffffff);
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
