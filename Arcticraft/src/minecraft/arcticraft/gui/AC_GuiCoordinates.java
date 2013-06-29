package arcticraft.gui;

import java.awt.image.BufferedImage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.opengl.GL11;

import arcticraft.main.AC_TickHandler;
import arcticraft.main.MainRegistry;

import cpw.mods.fml.client.TextureFXManager;

public class AC_GuiCoordinates extends GuiScreen
{

	private GuiTextField textfield;
	private GuiTextField textfield2;
	private Minecraft mc;

	public static AC_TickHandler tickHandlerInstance = new AC_TickHandler();

	public AC_GuiCoordinates()
	{
		mc = mc.getMinecraft();
	}

	public static Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}

	public static ScaledResolution getScaledResolution()
	{
		Minecraft mc = getMinecraft();
		return new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	}
	public void initGui()
	{

		buttonList.clear();
		buttonList.add(new GuiButton(2, width / 2 - 49, height / 2 - 50, 70, 20, "Back"));
		buttonList.add(new GuiButton(1, width / 2 - 49, height / 2 + 20, 70, 20, "Enter"));
		textfield = new GuiTextField(fontRenderer, width / 2 - 87, height / 2 - 10, 60, 20);
		textfield2 = new GuiTextField(fontRenderer, width / 2 - 2, height / 2 - 10, 60, 20);
		textfield.setMaxStringLength(3);
		textfield2.setMaxStringLength(3);
	}

	public void actionPerformed(GuiButton button)
	{
		if (button.id == 1)
		{
			AC_TickHandler.x = Integer.parseInt(textfield.getText());
			AC_TickHandler.y = Integer.parseInt(textfield2.getText());
//			mc.currentScreen.updateScreen();
			mc.thePlayer.sendChatToPlayer("You've succesfully changed the coordinates to - X: " + AC_TickHandler.x + " and Y: " + AC_TickHandler.y);
			mc.thePlayer.sendChatToPlayer("Your temperature is: "+AC_TickHandler.value);

		}
		else if (button.id == 2)
		{
			mc.displayGuiScreen(new AC_GuiOptions());

		}
	}

	public boolean doesGuiPauseGame()
	{
		return true;
	}

	protected void keyTyped(char c, int i)
	{
		super.keyTyped(c, i);
		textfield.textboxKeyTyped(c, i);
		textfield2.textboxKeyTyped(c, i);
	}

	protected void mouseClicked(int i, int j, int k)
	{
		super.mouseClicked(i, j, k);
		textfield.mouseClicked(i, j, k);
		textfield2.mouseClicked(i, j, k);
	}

	

	
	
	public void drawScreen(int i, int j, float f)
	{
		ScaledResolution scaledresolution = getScaledResolution();

		drawDefaultBackground();
		this.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0xffffff);
		this.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0xffffff);
//		this.drawCenteredString(mc.fontRenderer, "X: " + width + ", Y: " + height, scaledresolution.getScaledWidth() / 2, 10, 0x00ffff);
		int k = width / 2 - 100;
		int l = height / 2 - 40;

		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/mods/AC/textures/gui/ac_default.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture("/mods/AC/textures/gui/ac_default.png");
		drawTexturedModalRect(k, l, 0, 0, 176, 166);
		textfield.drawTextBox();
		textfield2.drawTextBox();
		super.drawScreen(i, j, f);
	}
}
