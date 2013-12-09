package arcticraft.gui;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.storage.ISaveFormat;

import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

// import net.minecraft.client.gui.ThreadTitleScreen;

@SideOnly(Side.CLIENT)
public class AC_GuiMainMenu extends GuiScreen
{

	//** The RNG used by the Main Menu Screen. *//*
	private static final Random rand = new Random();

	//** Counts the number of screen updates. *//*
	private float updateCounter = 0.0F;

	//** The splash message. *//*
	private String splashText = "missingno";
	private GuiButton buttonResetDemo;

	//** Timer used to rotate the panorama, increases every tick. *//*
	private int panoramaTimer = 0;

	//Decides whether to show the links or not
	private boolean showLinks;

	// Texture allocated for the current viewport of the main menu's panorama
	// background.
	private static final ResourceLocation field_110353_x = new ResourceLocation("texts/splashes.txt");

	private DynamicTexture viewportTexture;
	private boolean field_96141_q = true;
	private static boolean field_96140_r = false;
	private static boolean field_96139_s = false;
	private String field_92025_p;
	private String field_104024_v;

	//** An array of all the paths to the panorama pictures. *//*
	private static final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama0.png") , new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama1.png") ,
			new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama2.png") , new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama3.png") , new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama4.png") ,
			new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/panorama5.png")};
	private static final ResourceLocation logo = new ResourceLocation(arcticraft.lib.Strings.MOD_ID + ":textures/title/LogoMainMenu.png");
	public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
	private int field_92024_r;
	private int field_92023_s;
	private int field_92022_t;
	private int field_92021_u;
	private int field_92020_v;
	private int field_92019_w;
	private ResourceLocation field_110351_G;

	private AC_GuiMMButtons fmlModButton = null;

	public AC_GuiMainMenu()
	{
		BufferedReader bufferedreader = null;

		try
		{
			ArrayList arraylist = new ArrayList();
			bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(field_110353_x).getInputStream(), Charsets.UTF_8));
			String s;

			while((s = bufferedreader.readLine()) != null)
			{
				s = s.trim();

				if(s.length() > 0)
				{
					arraylist.add(s);
				}
			}

			do
			{
				this.splashText = (String) arraylist.get(rand.nextInt(arraylist.size()));
			}
			while(this.splashText.hashCode() == 125780783);
		}
		catch(IOException ioexception)
		{
			;
		}
		finally
		{
			if(bufferedreader != null)
			{
				try
				{
					bufferedreader.close();
				}
				catch(IOException ioexception1)
				{
					;
				}
			}
		}

		this.updateCounter = rand.nextFloat();
	}

	//  Called from the main game loop to update the screen.
	@Override
	public void updateScreen()
	{
		super.updateScreen();
		++this.panoramaTimer;
		++this.updateCounter;
	}

	/**
	  Returns true if this GUI should pause the game when it is displayed in
	  single-player
	*/
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	//**
	//Adds the buttons (and other controls) to the screen in question.
	@Override
	public void initGui()
	{
		super.initGui();
		this.viewportTexture = new DynamicTexture(256, 256);
		this.field_110351_G = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		if(calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
		{
			this.splashText = "Happy birthday, ez!";
		}
		else if(calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
		{
			this.splashText = "Happy birthday, Notch!";
		}
		else if(calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
		{
			this.splashText = "Merry X-mas!";
		}
		else if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
		{
			this.splashText = "Happy new year!";
		}
		else if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
		{
			this.splashText = "OOoooOOOoooo! Spooky!";
		}

		buttonList = new ArrayList();
		int i = this.height / 4 + 68;
		if(! this.showLinks)
		{
			this.addSingleplayerMultiplayerButtons(i, 24);
			fmlModButton = new AC_GuiMMButtons(2, 30, i + 48 - 65, "Mods");
			this.buttonList.add(fmlModButton);
			this.buttonList.add(new AC_GuiMMButtons(3, 30, i + 7, ("Arcticraft Links")));
			this.buttonList.add(new AC_GuiMMButtons(4, 30, i + 45, 200, 20, "Options"));
			this.buttonList.add(new AC_GuiMMButtons(5, 30, i + 70, 200, 20, "Quit"));
		}
		else
		{
			this.buttonList.add(new AC_GuiMMButtons(6, 30, i - 45 + 20 * 1, "AC's YouTube"));
			this.buttonList.add(new AC_GuiMMButtons(7, 30, i - 45 + 45 * 1, "AC's Topic"));
			this.buttonList.add(new AC_GuiMMButtons(8, 30, i - 45 + 70 * 1, "AC's Website"));
			this.buttonList.add(new AC_GuiMMButtons(9, 30, i - 45 + 95 * 1, "Main Menu"));
		}
		this.buttonList.add(new GuiButtonLanguage(15, width - 28, 4));
		this.field_92025_p = "";
		String s = System.getProperty("os_architecture");
		String s1 = System.getProperty("java_version");

		if("ppc".equalsIgnoreCase(s))
		{
			this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " PowerPC compatibility will be dropped in Minecraft 1.6";
		}
		else if(s1 != null && s1.startsWith("1.5"))
		{
			this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
		}

		this.field_92023_s = this.fontRenderer.getStringWidth(this.field_92025_p);
		this.field_92024_r = this.fontRenderer.getStringWidth(field_96138_a);
		int j = Math.max(this.field_92023_s, this.field_92024_r);
		this.field_92022_t = (this.width - j) / 2;
		this.field_92021_u = ((GuiButton) this.buttonList.get(0)).yPosition - 24;
		this.field_92020_v = this.field_92022_t + j;
		this.field_92019_w = this.field_92021_u + 24;
	}

	private void func_96137_a(StringTranslate par1StringTranslate, int par2, int par3)
	{
		if(this.field_96141_q)
		{
			if(! field_96140_r)
			{
				field_96140_r = true;
				//(new ThreadTitleScreen(this, par1StringTranslate, par2, par3)).start();
			}
			else if(field_96139_s)
			{
				this.func_98060_b(par1StringTranslate, par2, par3);
			}
		}
	}

	private void func_98060_b(StringTranslate par1StringTranslate, int par2, int par3)
	{

		//If Minecraft Realms is enabled, halve the size of both buttons and set them next to eachother.
		//fmlModButton.width = 98;
		fmlModButton.xPosition = this.width / 2 + 2;

		AC_GuiMMButtons realmButton = new AC_GuiMMButtons(3, 30, par2 - 45 + par3 * 2, par1StringTranslate.translateKey("menu.online"));
		//realmButton.width = 98;
		realmButton.xPosition = this.width / 2 - 100;
		this.buttonList.add(realmButton);
	}

	//  Adds Singleplayer and Multiplayer buttons on Main Menu for players who
	//	  have bought the game.
	private void addSingleplayerMultiplayerButtons(int par1, int par2)
	{
		this.buttonList.add(new AC_GuiMMButtons(0, 30, par1 - 65, "Singleplayer"));
		this.buttonList.add(new AC_GuiMMButtons(1, 30, par1 - 65 + par2 * 1, "Multiplayer"));
	}

	//**
	// Fired when a control is clicked. This is the equivalent of
	//ActionListener.actionPerformed(ActionEvent e).
	@Override
	protected void actionPerformed(GuiButton par1GuiButton)
	{
		if(par1GuiButton.id == 0)
		{
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}

		if(par1GuiButton.id == 1)
		{
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
		}

		if(par1GuiButton.id == 2)
		{
			this.mc.displayGuiScreen(new GuiModList(this));
		}

		if(par1GuiButton.id == 3)
		{
			this.showLinks = true;
			initGui();
		}

		if(par1GuiButton.id == 4)
		{
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}

		if(par1GuiButton.id == 5)
		{
			this.mc.shutdown();
		}

		if(par1GuiButton.id == 6)
		{
			try
			{
				Desktop.getDesktop().browse(URI.create("http://youtube.com/user/ArcticraftDEV"));
			}
			catch(Exception e)
			{
				System.err.println("Failed to load arcticraftdev youtubes");
			}
		}
		if(par1GuiButton.id == 7)
		{
			try
			{
				Desktop.getDesktop().browse(URI.create("http://minecraftforum.net/topic/1292251-arcticraft-an-icy-new-dimension-reboot/"));
			}
			catch(Exception e)
			{
				System.err.println("Failed to load arcticraft topic");
			}

		}
		if(par1GuiButton.id == 9)
		{
			this.mc.displayGuiScreen(new AC_GuiMainMenu());
		}
		if(par1GuiButton.id == 8)
		{
			try
			{
				Desktop.getDesktop().browse(URI.create("http://arcticraft.net"));
			}
			catch(Exception e)
			{
				System.err.println("Failed to load arcticraft topic");
			}

		}

		if(par1GuiButton.id == 15)
		{
			this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
		}

	}

	@Override
	public void confirmClicked(boolean par1, int par2)
	{
		if(par1 && par2 == 12)
		{
			ISaveFormat isaveformat = this.mc.getSaveLoader();
			isaveformat.flushCache();
			isaveformat.deleteWorldDirectory("Demo_World");
			this.mc.displayGuiScreen(this);
		}
		else if(par2 == 13)
		{
			if(par1)
			{
				try
				{
					Class oclass = Class.forName("java.awt.Desktop");
					Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object) null, new Object[0]);
					oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI("http://tinyurl.com/javappc")});
				}
				catch(Throwable throwable)
				{
					throwable.printStackTrace();
				}
			}

			this.mc.displayGuiScreen(this);
		}
	}

	private void drawPanorama(int par1, int par2, float par3)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		byte b0 = 8;

		for(int k = 0; k < b0 * b0; ++k)
		{
			GL11.glPushMatrix();
			float f1 = ((float) (k % b0) / (float) b0 - 0.5F) / 64.0F;
			float f2 = ((float) (k / b0) / (float) b0 - 0.5F) / 64.0F;
			float f3 = 0.0F;
			GL11.glTranslatef(f1, f2, f3);
			GL11.glRotatef(MathHelper.sin(((float) this.panoramaTimer + par3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(- ((float) this.panoramaTimer + par3) * 0.1F, 0.0F, 1.0F, 0.0F);

			for(int l = 0; l < 6; ++l)
			{
				GL11.glPushMatrix();

				if(l == 1)
				{
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
				}

				if(l == 2)
				{
					GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				}

				if(l == 3)
				{
					GL11.glRotatef(- 90.0F, 0.0F, 1.0F, 0.0F);
				}

				if(l == 4)
				{
					GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				}

				if(l == 5)
				{
					GL11.glRotatef(- 90.0F, 1.0F, 0.0F, 0.0F);
				}

				this.mc.getTextureManager().bindTexture(titlePanoramaPaths[l]);
				tessellator.startDrawingQuads();
				tessellator.setColorRGBA_I(16777215, 255 / (k + 1));
				float f4 = 0.0F;
				tessellator.addVertexWithUV(- 1.0D, - 1.0D, 1.0D, (double) (0.0F + f4), (double) (0.0F + f4));
				tessellator.addVertexWithUV(1.0D, - 1.0D, 1.0D, (double) (1.0F - f4), (double) (0.0F + f4));
				tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, (double) (1.0F - f4), (double) (1.0F - f4));
				tessellator.addVertexWithUV(- 1.0D, 1.0D, 1.0D, (double) (0.0F + f4), (double) (1.0F - f4));
				tessellator.draw();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
			GL11.glColorMask(true, true, true, false);
		}

		tessellator.setTranslation(0.0D, 0.0D, 0.0D);
		GL11.glColorMask(true, true, true, true);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	// Rotate and blurs the skybox view in the main menu
	private void rotateAndBlurSkybox(float par1)
	{
		this.mc.getTextureManager().bindTexture(this.field_110351_G);
		GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColorMask(true, true, true, false);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		byte b0 = 3;

		for(int i = 0; i < b0; ++i)
		{
			tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float) (i + 1));
			int j = this.width;
			int k = this.height;
			float f1 = (float) (i - b0 / 2) / 256.0F;
			tessellator.addVertexWithUV((double) j, (double) k, (double) this.zLevel, (double) (0.0F + f1), 0.0D);
			tessellator.addVertexWithUV((double) j, 0.0D, (double) this.zLevel, (double) (1.0F + f1), 0.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, (double) this.zLevel, (double) (1.0F + f1), 1.0D);
			tessellator.addVertexWithUV(0.0D, (double) k, (double) this.zLevel, (double) (0.0F + f1), 1.0D);
		}

		tessellator.draw();
		GL11.glColorMask(true, true, true, true);
	}

	//Renders the skybox in the main menu
	private void renderSkybox(int par1, int par2, float par3)
	{
		GL11.glViewport(0, 0, 256, 256);
		this.drawPanorama(par1, par2, par3);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		float f1 = this.width > this.height ? 120.0F / (float) this.width : 120.0F / (float) this.height;
		float f2 = (float) this.height * f1 / 256.0F;
		float f3 = (float) this.width * f1 / 256.0F;
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		int k = this.width;
		int l = this.height;
		tessellator.addVertexWithUV(0.0D, (double) l, (double) this.zLevel, (double) (0.5F - f2), (double) (0.5F + f3));
		tessellator.addVertexWithUV((double) k, (double) l, (double) this.zLevel, (double) (0.5F - f2), (double) (0.5F - f3));
		tessellator.addVertexWithUV((double) k, 0.0D, (double) this.zLevel, (double) (0.5F + f2), (double) (0.5F - f3));
		tessellator.addVertexWithUV(0.0D, 0.0D, (double) this.zLevel, (double) (0.5F + f2), (double) (0.5F + f3));
		tessellator.draw();
	}

	public void drawLogo(int k, int b0)
	{
		GL11.glPushMatrix();

		this.drawTexturedModalRect(25, b0 - 10, 0, 0, 155, 44);
		this.drawTexturedModalRect(180, b0 - 10, 0, 45, 155, 44);

		GL11.glPopMatrix();
	}

	// Draws the screen and all the components in it.
	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		this.renderSkybox(par1, par2, par3);
		Tessellator tessellator = Tessellator.instance;
		short short1 = 274;
		int k = this.width / 2 - short1 / 2;
		byte b0 = 30;
		this.drawGradientRect(0, 0, this.width, this.height, - 2130706433, 16777215);
		this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
		this.mc.getTextureManager().bindTexture(logo);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		if((double) this.updateCounter < 1.0E-4D)
		{
			this.drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 99, 44);
			this.drawTexturedModalRect(k + 99, b0 + 0, 129, 0, 27, 44);
			this.drawTexturedModalRect(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
			this.drawTexturedModalRect(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
			this.drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
		}
		else
		{
			drawLogo(k, b0);
		}

		tessellator.setColorOpaque_I(16777215);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) 200, 35F, 0.0F);
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
		float f1 = 1.4F - MathHelper.abs(MathHelper.sin((float) (Minecraft.getSystemTime() % 1000L) / 1000.0F * (float) Math.PI * 2.0F) * 0.1F); //makes it bounce
		f1 = f1 * 100.0F / (float) (this.fontRenderer.getStringWidth(this.splashText) + 40);
		GL11.glScalef(f1, f1, f1);
		this.drawCenteredString(this.fontRenderer, this.splashText, 10, 25, 0x3BA2BC);
		GL11.glPopMatrix();
		String s = "Minecraft 1.6.2";

		List<String> brandings = Lists.reverse(FMLCommonHandler.instance().getBrandings());
		for(int i = 0; i < brandings.size(); i++)
		{
			String brd = brandings.get(i);
			if(! Strings.isNullOrEmpty(brd))
			{
				this.drawString(this.fontRenderer, brd, width - 2 - fontRenderer.getStringWidth(brd), this.height - (10 + i * (this.fontRenderer.FONT_HEIGHT + 1)), 16777215);
			}
		}

		String s1 = "Copyright Mojang AB. Do not distribute!";
		String s2 = "Arcticraft Pre-Alpha";
		this.drawString(this.fontRenderer, s1, 2, this.height - 10, 16777215);
		this.drawString(this.fontRenderer, s2, width - 2 - fontRenderer.getStringWidth(s2), this.height - (6 * (this.fontRenderer.FONT_HEIGHT + 1)), 0x3BA2BC);

		if(this.field_92025_p != null && this.field_92025_p.length() > 0)
		{
			drawRect(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
			this.drawString(this.fontRenderer, this.field_92025_p, this.field_92022_t, this.field_92021_u, 16777215);
			this.drawString(this.fontRenderer, field_96138_a, (this.width - this.field_92024_r) / 2, ((GuiButton) this.buttonList.get(0)).yPosition - 12, 16777215);
		}

		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);

		if(this.field_92025_p.length() > 0 && par1 >= this.field_92022_t && par1 <= this.field_92020_v && par2 >= this.field_92021_u && par2 <= this.field_92019_w)
		{
			GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
			guiconfirmopenlink.func_92026_h();
			this.mc.displayGuiScreen(guiconfirmopenlink);
		}
	}

}
