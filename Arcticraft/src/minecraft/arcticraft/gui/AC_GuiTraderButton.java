package arcticraft.gui;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import arcticraft.entities.AC_EskimoTrade;

public class AC_GuiTraderButton extends GuiButton
{

	private AC_EskimoTrade trade;
	private AC_GuiTraderEskimo traderGui;
	private static RenderItem itemRenderer = new RenderItem();

	public AC_GuiTraderButton(int ID, int x, int y, AC_EskimoTrade trd, AC_GuiTraderEskimo gui)
	{
		super(ID, x, y, 18, 18, "");
		this.trade = trd;
		this.traderGui = gui;
	}

	@Override
	public void drawButton(Minecraft mc, int pointX, int pointY)
	{
		if(this.drawButton)
		{
			boolean notEnoughGems = AC_EskimoTrade.getGemsFromInventory(this.traderGui.inventory) < this.trade.gemAmount;

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			RenderHelper.enableGUIStandardItemLighting();
			itemRenderer.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.renderEngine, this.trade.itemstack, this.xPosition + 1, this.yPosition + 1);
			itemRenderer.renderItemOverlayIntoGUI(mc.fontRenderer, mc.renderEngine, this.trade.itemstack, this.xPosition + 1, this.yPosition + 1);
			RenderHelper.disableStandardItemLighting();

			if(notEnoughGems)
			{
				this.enabled = false;
				this.drawRedOverlay();
			}

			this.field_82253_i = pointX >= this.xPosition && pointY >= this.yPosition && pointX < this.xPosition + this.width && pointY < this.yPosition + this.height;

			if(this.field_82253_i)
			{
				this.drawName(this.trade.itemstack, notEnoughGems, pointX, pointY, mc);
			}
		}
	}

	protected void drawRedOverlay()
	{
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0x80FF0000);
	}

	protected void drawName(ItemStack itemstack, boolean gems, int par2, int par3, Minecraft mc)
	{
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		List list = itemstack.getTooltip(mc.thePlayer, mc.gameSettings.advancedItemTooltips);
		String color = gems ? "\u00a7c" : "\u00a7a";

		list.add(color + this.trade.gemAmount + " Gems");

		if(! list.isEmpty())
		{
			int var5 = 0;
			Iterator var6 = list.iterator();

			while(var6.hasNext())
			{
				String var7 = (String) var6.next();
				int var8 = mc.fontRenderer.getStringWidth(var7);

				if(var8 > var5)
				{
					var5 = var8;
				}
			}

			int var15 = par2 + 12;
			int var16 = par3 - 12;
			int var9 = 8;

			if(list.size() > 1)
			{
				var9 += 2 + (list.size() - 1) * 10;
			}

			this.zLevel = 300.0F;
			itemRenderer.zLevel = 200.0F;
			int var10 = - 267386864;
			this.drawGradientRect(var15 - 3, var16 - 4, var15 + var5 + 3, var16 - 3, var10, var10);
			this.drawGradientRect(var15 - 3, var16 + var9 + 3, var15 + var5 + 3, var16 + var9 + 4, var10, var10);
			this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 + var9 + 3, var10, var10);
			this.drawGradientRect(var15 - 4, var16 - 3, var15 - 3, var16 + var9 + 3, var10, var10);
			this.drawGradientRect(var15 + var5 + 3, var16 - 3, var15 + var5 + 4, var16 + var9 + 3, var10, var10);
			int var11 = 1347420415;
			int var12 = (var11 & 16711422) >> 1 | var11 & - 16777216;
			this.drawGradientRect(var15 - 3, var16 - 3 + 1, var15 - 3 + 1, var16 + var9 + 3 - 1, var11, var12);
			this.drawGradientRect(var15 + var5 + 2, var16 - 3 + 1, var15 + var5 + 3, var16 + var9 + 3 - 1, var11, var12);
			this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 - 3 + 1, var11, var11);
			this.drawGradientRect(var15 - 3, var16 + var9 + 2, var15 + var5 + 3, var16 + var9 + 3, var12, var12);

			for(int var13 = 0; var13 < list.size(); ++var13)
			{
				String var14 = (String) list.get(var13);

				if(var13 == 0)
				{
					var14 = "\u00a7" + Integer.toHexString(itemstack.getRarity().rarityColor) + var14;
				}

				mc.fontRenderer.drawStringWithShadow(var14, var15, var16, - 1);

				if(var13 == 0)
				{
					var16 += 2;
				}

				var16 += 10;
			}

			this.zLevel = 0.0F;
			itemRenderer.zLevel = 0.0F;
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			RenderHelper.enableStandardItemLighting();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}

	}
}
