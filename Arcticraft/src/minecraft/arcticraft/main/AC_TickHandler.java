package arcticraft.main;

import java.util.EnumSet;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import arcticraft.blocks.AC_BlockFrostLeaves;
import arcticraft.blocks.AC_BlockGlacierLeaves;
import arcticraft.items.AC_ItemLantern;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class AC_TickHandler implements ITickHandler
{

	private AC_ItemLantern itemLantern;
	private Minecraft mc;
	int tickCounter;
	int tempIncrementCounter;

	public AC_TickHandler()
	{
		this.mc = Minecraft.getMinecraft();
		this.value = 60;
		this.maxValue = 100;

	}

	//Util Methods
	public static Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}

	public static ScaledResolution getScaledResolution()
	{
		Minecraft mc = getMinecraft();
		return new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	}

	@Override
	public void tickStart(EnumSet <TickType> type, Object... tickData)
	{

		if (mc.thePlayer != null)
		{

			if (type.equals(EnumSet.of(TickType.RENDER)))
			{
				AC_ItemLantern.fuelCounter(mc.thePlayer, mc.thePlayer.getCurrentItemOrArmor(0));
				AC_BlockFrostLeaves.setGraphicsLevel(!Minecraft.getMinecraft().gameSettings.fancyGraphics);
				AC_BlockGlacierLeaves.setGraphicsLevel(!Minecraft.getMinecraft().gameSettings.fancyGraphics);
				tickCounter();
				tempIncrementCounter();
				canDecrementTemp();
				canIncrementTemp();
			}
		}
	}
	@Override
	public void tickEnd(EnumSet <TickType> type, Object... tickData)
	{
		mc.entityRenderer.setupOverlayRendering();
		ScaledResolution scaledresolution = getScaledResolution();
		if (type.equals(EnumSet.of(TickType.RENDER)))
		{
			renderFreezeEffect(scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight());
			onRenderTick();
		}
	}

	@Override
	public EnumSet <TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER);

	}

	@Override
	public String getLabel()
	{
		return "Temperature Bar";
	}
	public static int value;
	public static int maxValue = 100;
	public static boolean dragging = false;
	public static int x = 5, y = 5;

	public void onRenderTick()
	{
		ScaledResolution scaledresolution = getScaledResolution();
		GuiIngame gui = this.mc.ingameGUI;

		if (mc.currentScreen == null && mc.thePlayer.dimension != -1 && mc.thePlayer.dimension != 0 || mc.currentScreen instanceof GuiIngameMenu)
		{
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/mods/AC/textures/gui/tempbar.png"));

			gui.drawTexturedModalRect(x, y, 0, 6, 80, 6);
			gui.drawTexturedModalRect(x, y, 0, 0, value * 80 / maxValue, 6);
		}

		if (mc.currentScreen instanceof GuiIngameMenu)
		{
			int i = Mouse.getEventX() * mc.currentScreen.width / this.mc.displayWidth;
			int j = mc.currentScreen.height - Mouse.getEventY() * mc.currentScreen.height / this.mc.displayHeight - 1;

			boolean flag = i >= x && j >= y && i <= x + 80 && j <= x + 6;
			if (flag && Mouse.isButtonDown(0))
			{
				//gui.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0x00ff00);
				dragging = true;
			}
			else
			{
				//gui.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0xff0000);
			}

			//gui.drawCenteredString(mc.fontRenderer, "X: " + x + ", Y: " + y, scaledresolution.getScaledWidth() / 2, 10, 0x00ffff);

			if (dragging && !Mouse.isButtonDown(0)) dragging = false;

			if (dragging)
			{
				if (i - 40 >= 5 && j - 3 >= 5 && i + 40 <= scaledresolution.getScaledWidth() - 5 && j + 3 <= scaledresolution.getScaledHeight() - 5)
				{
					x = i - 40;
					y = j - 3;
				}
				else
				{
					if (i - 40 < 5) x = 5;
					else if (i + 40 > scaledresolution.getScaledWidth() - 5) x = scaledresolution.getScaledWidth() - 5 - 80;
					else x = i - 40;

					if (j - 3 < 5) y = 5;
					else if (j + 3 > scaledresolution.getScaledHeight() - 5) y = scaledresolution.getScaledHeight() - 5 - 6;
					else y = j - 3;

				}
			}
		}
	}

	public void tickCounter()
	{
		GuiIngame ingamegui = this.mc.ingameGUI;

		if (mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && !(mc.currentScreen instanceof GuiIngameMenu) && !(mc.currentScreen instanceof GuiMainMenu))
		{
			//System.out.println(tickCounter);
			//System.out.println(value);
			tickCounter++;
		}

		if (tickCounter == 3001 && mc.thePlayer.dimension == MainRegistry.dimension)
		{
			tickCounter = 0;
		}
	}

	public void tempIncrementCounter()
	{
		GuiIngame ingamegui = this.mc.ingameGUI;

		if (mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && !(mc.currentScreen instanceof GuiIngameMenu) && !(mc.currentScreen instanceof GuiMainMenu))
		{
			//System.out.println(tempIncrementCounter);
			tempIncrementCounter++;
		}

		if (tempIncrementCounter == 75 && mc.thePlayer.dimension == MainRegistry.dimension)
		{
			tempIncrementCounter = 0;
		}
	}

	public void canDecrementTemp()
	{
		if (mc.theWorld != null && mc.thePlayer.dimension == MainRegistry.dimension && this.value == 0)
		{
		}
		else if (mc.theWorld != null && mc.thePlayer.dimension == MainRegistry.dimension && mc.thePlayer.isInsideOfMaterial(Material.water) && this.tickCounter == 1500)
		{
			this.value -= 1;
			this.tickCounter = 0;

		}
		else if (this.tickCounter == 3000)
		{
			this.value -= 1;
		}
	}

	public void canIncrementTemp()
	{
		if (mc.theWorld != null && mc.thePlayer != null)
		{
			int offsetX = (int) Math.round(mc.thePlayer.posX);
			int offsetY = (int) Math.round(mc.thePlayer.posY);
			int offsetZ = (int) Math.round(mc.thePlayer.posZ);

			for (int x = 0; x < 8; x++)
			{
				for (int y = 0; y < 8; y++)
				{
					for (int z = 0; z < 8; z++)
					{
						if (this.value < 100 && this.tempIncrementCounter == 74 && mc.theWorld.getBlockLightValue(offsetX + x - 4, offsetY + y - 4, offsetZ + z - 4) >= 10)
						{
							this.value += 1;
							this.tempIncrementCounter = 0;
						}
					}
				}
			}
		}
	}

	public void renderFreezeEffect(int par1, int par2)
	{

		if (mc.thePlayer != null && mc.theWorld != null && mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && this.value <= 35)
		{

			GL11.glDisable(2929);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(770, 771);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(3008);
			GL11.glBindTexture(3553, mc.renderEngine.getTexture("/mods/AC/textures/misc/freezing.png"));
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(0.0D, par2, -90.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV(par1, par2, -90.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV(par1, 0.0D, -90.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(2929);
			GL11.glEnable(3008);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.currentScreen = null;
		}
	}
}
