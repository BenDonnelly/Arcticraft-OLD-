package arcticraft.gui;

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
		int k = width / 2 - 100;
		int l = height / 2 - 40;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/ac_default.png"));
		drawTexturedModalRect(k, l, 0, 0, 176, 166);
		textfield.drawTextBox();
		textfield2.drawTextBox();
		super.drawScreen(i, j, f);
	}
}
