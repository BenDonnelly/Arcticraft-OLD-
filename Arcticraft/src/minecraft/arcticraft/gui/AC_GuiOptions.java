package arcticraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.opengl.GL11;

public class AC_GuiOptions extends GuiScreen
{

	Minecraft mc;

	public AC_GuiOptions()
	{
		mc = mc.getMinecraft();
	}

	public void initGui()
	{
		this.buttonList.clear();
		this.buttonList.add(new AC_GuiOptionsButton(0, 0, this.height / 4 + 24 + -16,  "Back To Game"));
		this.buttonList.add(new AC_GuiOptionsButton(1, 0, this.height / 4 + 144 + -16, "Example1"));
		this.buttonList.add(new AC_GuiOptionsButton(2, 0, this.height / 4 + 96 + -16, "Example2"));
		this.buttonList.add(new AC_GuiOptionsButton(3, 0, this.height / 4 + 120 + -16, "Example3"));
		this.buttonList.add(new AC_GuiOptionsButton(4, 0, this.height / 4 + 48 + -16, "Example4"));
		this.buttonList.add(new AC_GuiOptionsButton(5, 0, this.height / 4 + 72 + -16, "Example5"));
	}

	public void actionPerformed(GuiButton button)
	{
		if (button.id == 0)
		{
			mc.thePlayer.closeScreen();
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return true;
	}

	@Override
	protected void keyTyped(char par1, int par2)
	{
		if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	public void drawScreen(int x, int y, float f)
	{
		this.drawDefaultBackground();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glPushMatrix();
		GL11.glScalef(5F, 5F, 5F);
		Boolean defaultunicode = fontRenderer.getUnicodeFlag();
		fontRenderer.setUnicodeFlag(true);
		this.drawString(this.fontRenderer, "Game", (int) ((float) (width - 200) / 5F), (int) ((float) (height - 120) / 5F), 0x32e0e0e0);
		this.drawString(this.fontRenderer, "Paused", (int) ((float) (width - 200) / 5F), (int) ((float) (height - 80) / 5F), 0x32e0e0e0);
		fontRenderer.setUnicodeFlag(defaultunicode);
		GL11.glPopMatrix();
		super.drawScreen(x, y, f);
	}
}
