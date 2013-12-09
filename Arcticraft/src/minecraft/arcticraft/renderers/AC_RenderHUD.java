package arcticraft.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_BossStatus;
import arcticraft.helpers.AC_TemperatureHelper;
import arcticraft.helpers.AC_TickHandler;
import arcticraft.items.AC_Item;
import arcticraft.lib.Strings;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_RenderHUD
{

	public static void renderBossBars()
	{
		Minecraft mc = Minecraft.getMinecraft();
		GuiIngame gui = mc.ingameGUI;

		if(AC_BossStatus.bossName != null && AC_BossStatus.statusBarLength > 0)
		{
			--AC_BossStatus.statusBarLength;
			FontRenderer fontrenderer = mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			short short1 = 182;
			short short2 = 50;
			int j = i / 2 - short1 / 2;
			int l = i / 2 - short2 / 2;
			int k = (int) (AC_BossStatus.healthScale * (float) (short1 + 1));
			byte b0 = 12;
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MOD_ID, "textures/gui/boss_bars.png"));
			gui.drawTexturedModalRect(j, b0, 0, 0, short1, 14);
			if(k > 0)
			{
				gui.drawTexturedModalRect(j, b0, 0, 14, k, 14);
			}

			String s = AC_BossStatus.bossName;
			fontrenderer.drawStringWithShadow(s, i / 2 - fontrenderer.getStringWidth(s) / 2, b0 - 10, 16777215);

			if(AC_BossStatus.isMiniBoss == true)
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Mini Boss", l, 12 + 15, 0xffffffff);
			}
			else
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Final Boss", l, 12 + 15, 0xffffffff);
			}
		}

	}

	public static void renderPickaxeCooldown()
	{
		Minecraft mc = Minecraft.getMinecraft();
		ItemStack hand = mc.thePlayer.getCurrentItemOrArmor(0);

		if(hand != null && hand.getItem() == AC_Item.notchedPickaxe)
		{
			GuiIngame gui = mc.ingameGUI;
			FontRenderer fontrenderer = mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			short short1 = 90;
			int j = i / 2 - short1 / 2;

			if(mc.currentScreen == null || mc.currentScreen instanceof GuiIngameMenu)
			{
				renderPickaxeStrings();
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MOD_ID, "textures/gui/cooldown_bar.png"));
				gui.drawTexturedModalRect(j, 40, 0, 12, 82, 12);
				gui.drawTexturedModalRect(j, 40, 0, 0, (int) Math.round(AC_TickHandler.cooldown / 82 * 5.7), 12);
			}
		}

	}

	public static void renderPickaxeStrings()
	{
		Minecraft mc = Minecraft.getMinecraft();

		FontRenderer fontrenderer = mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		int i = scaledresolution.getScaledWidth();
		short short1 = 90;
		int j = i / 2 - short1 / 2;
		if(AC_TickHandler.cooldown == 0 && AC_TickHandler.pickaxeStringTick >= 20 && AC_TickHandler.pickaxeStringTick <= 40)
		{
			fontrenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "Ready To Fire", j, 10 + 45, 0xffffffff);
		}
		else if(AC_TickHandler.cooldown >= 1)
		{
			fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Cooling Down", j, 10 + 45, 0xffffffff);
		}

	}

	public static void renderTemperatureBar(ScaledResolution scaledres)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if(mc.thePlayer.dimension == MainRegistry.dimension)
		{
			mc.getTextureManager().bindTexture(new ResourceLocation(Strings.MOD_ID, "textures/gui/temperature_bar.png"));
			GuiIngame gui = mc.ingameGUI;
			gui.drawTexturedModalRect(AC_TickHandler.x, AC_TickHandler.y, 0, 6, 80, 6);
			gui.drawTexturedModalRect(AC_TickHandler.x, AC_TickHandler.y, 0, 0, mc.thePlayer.getDataWatcher().getWatchableObjectInt(AC_TemperatureHelper.tempID) * 80 / AC_TemperatureHelper.maxTemp, 6);
			//TODO check gui.icons
			mc.getTextureManager().bindTexture(Gui.icons);
		}

	}

	public static void renderFreezeOverlay(int par1, int par2)
	{

		Minecraft mc = Minecraft.getMinecraft();

		if(AC_TickHandler.value <= 20)
		{
		//	float alpha = 20 - AC_TickHandler.value /20;

			if(mc.thePlayer.dimension == MainRegistry.dimension && AC_TickHandler.renderOverlay)
			{
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				// System.out.println("Alpha: " + alpha);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				mc.renderEngine.bindTexture(new ResourceLocation(Strings.MOD_ID, "textures/misc/freezing.png"));
				Tessellator tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(0.0D, par2, - 90.0D, 0.0D, 1.0D);
				tessellator.addVertexWithUV(par1, par2, - 90.0D, 1.0D, 1.0D);
				tessellator.addVertexWithUV(par1, 0.0D, - 90.0D, 1.0D, 0.0D);
				tessellator.addVertexWithUV(0.0D, 0.0D, - 90.0D, 0.0D, 0.0D);
				tessellator.draw();
				GL11.glDepthMask(true);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}
