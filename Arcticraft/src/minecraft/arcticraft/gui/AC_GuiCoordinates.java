package arcticraft.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import arcticraft.helpers.AC_TickHandler;
import arcticraft.lib.Strings;

public class AC_GuiCoordinates extends GuiScreen
{

	private GuiTextField textfield;
	private GuiTextField textfield2;
	private int switchGui;
	private int texture = 0;
	static ScaledResolution scaledresolution = getScaledResolution();
	static int i = scaledresolution.getScaledWidth();

	public AC_GuiCoordinates()
	{}

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

		buttonList = new ArrayList();
		switch(switchGui)
		{
		case 0:
			buttonList.add(new GuiButton(2, width / 2 - 49, height / 2 - 50, 70, 20, "Back"));
			buttonList.add(new GuiButton(1, width / 2 - 49, height / 2 + 40, 70, 20, "Enter"));
			buttonList.add(new GuiButton(3, width / 2 - 160, height / 2 - 10, 70, 20, "Default"));
			buttonList.add(new GuiButton(4, width / 2 + 66, height / 2 - 10, 70, 20, "Presets"));
			textfield = new GuiTextField(fontRenderer, width / 2 - 87, height / 2 - 10, 60, 20);
			textfield2 = new GuiTextField(fontRenderer, width / 2 + 3, height / 2 - 10, 60, 20);
			textfield.setMaxStringLength(3);
			textfield2.setMaxStringLength(3);
			break;

		case 1:
			textfield.setVisible(false);
			textfield2.setVisible(false);
			buttonList.add(new GuiButton(5, width / 2 - 100, height / 2 - 90, "Above Hunger Bar"));
			buttonList.add(new GuiButton(6, width / 2 - 100, height / 2 - 65, "Above Health/Armour Bar"));
			buttonList.add(new GuiButton(7, width / 2 - 100, height / 2 - 40, "Bottom Right Corner"));
			buttonList.add(new GuiButton(8, width / 2 - 100, height / 2 - 15, "Bottom Left Corner"));
			buttonList.add(new GuiButton(9, width / 2 - 100, height / 2 + 10, "Top Right Corner"));
			buttonList.add(new GuiButton(10, width / 2 - 100, height / 2 + 35, "Top Left Corner"));
			buttonList.add(new GuiButton(11, width / 2 - 125, height / 2 - 121, 25, 20, "<"));
			buttonList.add(new GuiButton(12, width / 2 - 100, height / 2 - 121, 25, 20, "<<"));
			
			break;

		}
	}

	public void actionPerformed(GuiButton button)
	{
		
		if(button.id == 1)
		{
			AC_TickHandler.x = Integer.parseInt(textfield.getText());
			AC_TickHandler.y = Integer.parseInt(textfield2.getText());
			mc.thePlayer.addChatMessage("You've succesfully changed the coordinates to - X: " + AC_TickHandler.x + " and Y: " + AC_TickHandler.y);
			mc.thePlayer.addChatMessage("Your temperature is: " + AC_TickHandler.value);

		}
		else if(button.id == 2)
		{
			mc.displayGuiScreen(new AC_GuiOptions());

		}
		else if(button.id == 3)
		{
			AC_TickHandler.x = 5;
			AC_TickHandler.y = 5;
			mc.thePlayer.addChatMessage("You've succesfully changed the coordinates to - X: " + AC_TickHandler.x + " and Y: " + AC_TickHandler.y);
			mc.thePlayer.addChatMessage("Your temperature is: " + AC_TickHandler.value);
		}
		else if(button.id == 4)
		{
			switchGui = 1;
			texture = 1;
			initGui();
		}
		else if(button.id == 5)
		{
			
		}
		else if(button.id == 6)
		{
			
		}
		else if(button.id == 7)
		{
			AC_TickHandler.x = width / 2 + 120;
			AC_TickHandler.y = height / 2 + 100;
		}
		else if(button.id == 8)
		{
			AC_TickHandler.x = i / 2 - 100;
			AC_TickHandler.y = height / 2 - 10;
		}
		else if(button.id == 9)
		{
			AC_TickHandler.x = i / 2 + 130;
			AC_TickHandler.y = 5;
		}
		else if(button.id == 10)
		{	
			AC_TickHandler.x = 5;
			AC_TickHandler.y = 5;
			
		}
		else if(button.id == 11)
		{
			switchGui = 0;
			texture = 0;
			initGui();
		}
		else if(button.id == 12)
		{
			mc.thePlayer.closeScreen();
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
		if(texture == 0)
		{
			this.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0xffffff);
			this.drawCenteredString(mc.fontRenderer, "X: " + i + ", Y: " + j, scaledresolution.getScaledWidth() / 2, 0, 0xffffff);
		}
		int k = width / 2 - 100;
		int l = height / 2 - 40;
		int x = width / 2 - 125;
		int y = height / 2 - 100;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if(texture == 0)
		{
			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/ac_default.png"));
			drawTexturedModalRect(k, l, 0, 0, 176, 166);
		}
		else if(texture == 1)
		{
			
			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/bgtemp.png"));
			drawTexturedModalRect(x, y, 0, 0, 256, 256);

		}
		
		textfield.drawTextBox();
		textfield2.drawTextBox();
		super.drawScreen(i, j, f);
	}
}
