package arcticraft.helpers;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.blocks.AC_BlockFrostLeaves;
import arcticraft.blocks.AC_BlockGlacierLeaves;
import arcticraft.blocks.AC_BlockThickSnow;
import arcticraft.items.AC_Item;
import arcticraft.items.AC_ItemLantern;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;

public class AC_TickHandler implements ITickHandler
{

	private AC_ItemLantern itemLantern;
	private Minecraft mc;
	int tickCounter;
	int tempIncrementCounter;
	public static boolean renderOverlay = true;
	public static AC_TickHandler tickHandler;
	Random rand = new Random();

	public AC_TickHandler()
	{
		this.mc = Minecraft.getMinecraft();
		this.maxValue = 100;

	}

	//Util Methods
	public static Minecraft getMinecraft()
	{
		return Minecraft.getMinecraft();
	}

	public static AC_TickHandler getTickHandler()
	{
		return tickHandler;
	}

	public static ScaledResolution getScaledResolution()
	{
		Minecraft mc = getMinecraft();
		return new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	}

	@Deprecated
	public static String getSideAsString()
	{
		return FMLCommonHandler.instance().getSide() == Side.CLIENT ? "client" : "server";
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{

		if(mc.thePlayer != null)
		{

			if(type.equals(EnumSet.of(TickType.PLAYER)))
			{
				AC_ItemLantern.fuelCounter(mc.thePlayer, mc.thePlayer.getCurrentItemOrArmor(0));
				AC_BlockFrostLeaves.setGraphicsLevel(! Minecraft.getMinecraft().gameSettings.fancyGraphics);
				AC_BlockGlacierLeaves.setGraphicsLevel(! Minecraft.getMinecraft().gameSettings.fancyGraphics);
				tickCounter();
				tempIncrementCounter();
				canDecrementTemp();
				canIncrementTemp();
				slowPlayer();

			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{

		mc.entityRenderer.setupOverlayRendering();
		ScaledResolution scaledresolution = getScaledResolution();
		if(type.equals(EnumSet.of(TickType.RENDER)))
		{
			renderFreezeEffect(scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight());
			onRenderTick();
		}
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER, TickType.PLAYER);

	}

	@Override
	public String getLabel()
	{
		return "Temperature Bar";
	}

	public static int value = 50;
	public static int maxValue = 100;
	//	public static boolean dragging = false;
	public static int x;
	public static int y;

	public void onRenderTick()
	{
		ScaledResolution scaledresolution = getScaledResolution();
		GuiIngame gui = this.mc.ingameGUI;

		if(mc.currentScreen == null && mc.thePlayer.dimension != - 1 && mc.thePlayer.dimension != 0 || mc.currentScreen instanceof GuiIngameMenu)
		{

			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("ac", "/textures/gui/temperature_bar.png"));
			gui.drawTexturedModalRect(x, y, 0, 6, 80, 6);
			gui.drawTexturedModalRect(x, y, 0, 0, value * 80 / maxValue, 6);
		}
	}

	public void tickCounter()
	{
		GuiIngame ingamegui = this.mc.ingameGUI;
		if(! mc.thePlayer.capabilities.isCreativeMode)
		{
			if(mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && ! (mc.currentScreen instanceof GuiIngameMenu) && ! (mc.currentScreen instanceof GuiMainMenu))
			{
				//System.out.println(tickCounter);
				//System.out.println(value);
				tickCounter++;
			}

			if(tickCounter == 1501 && mc.thePlayer.dimension == MainRegistry.dimension)
			{
				tickCounter = 0;
			}
		}
	}

	public void tempIncrementCounter()
	{
		GuiIngame ingamegui = this.mc.ingameGUI;
		if(! mc.thePlayer.capabilities.isCreativeMode)
		{
			if(mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && ! (mc.currentScreen instanceof GuiIngameMenu) && ! (mc.currentScreen instanceof GuiMainMenu))
			{
				//System.out.println(tempIncrementCounter);
				tempIncrementCounter++;
			}

			if(tempIncrementCounter == 75 && mc.thePlayer.dimension == MainRegistry.dimension)
			{
				tempIncrementCounter = 0;
			}
		}
	}

	public void canDecrementTemp()
	{
		if(! mc.thePlayer.capabilities.isCreativeMode)
		{

			if(mc.theWorld != null && mc.thePlayer.dimension == MainRegistry.dimension && mc.thePlayer.isInsideOfMaterial(Material.water) && this.tickCounter == 300)
			{
				this.value -= 2;
				this.tickCounter = 0;

			}
			else if(mc.theWorld != null && mc.thePlayer.dimension == MainRegistry.dimension && mc.theWorld.isRaining() == true && this.tickCounter == 300)
			{
				this.value -= 2;
				//				mc.thePlayer.getEntityData().setInteger("temp", mc.thePlayer.getEntityData().getInteger("temp") - 2);
				this.tickCounter = 0;
				//				System.out.println("nbt int: " + mc.thePlayer.getEntityData().getInteger("temp"));
				//				System.out.println("Value: " + value);
			}
			else if(this.tickCounter == 1500)
			{
				this.value -= 1;
			}
		}

	}

	public void canIncrementTemp()
	{
		if(! mc.thePlayer.capabilities.isCreativeMode)
		{

			if(mc.theWorld != null && mc.thePlayer != null)
			{
				int offsetX = (int) Math.round(mc.thePlayer.posX);
				int offsetY = (int) Math.round(mc.thePlayer.posY);
				int offsetZ = (int) Math.round(mc.thePlayer.posZ);

				for(int x = 0; x < 8; x++)
				{
					for(int y = 0; y < 8; y++)
					{
						for(int z = 0; z < 8; z++)
						{
							if(this.value < 100 && this.tempIncrementCounter == 74 && mc.theWorld.getBlockLightValue(offsetX + x - 4, offsetY + y - 4, offsetZ + z - 4) >= 10)
							{
								this.value += 1;
								this.tempIncrementCounter = 0;
							}
						}
					}
				}
			}
		}
	}

	public void slowPlayer()
	{

		ItemStack boots = mc.thePlayer.getCurrentItemOrArmor(1);

		if(mc.thePlayer.getCurrentItemOrArmor(1) != null && boots.getItem() == AC_Item.hikingBoots)
		{
			AC_BlockThickSnow.shouldSlowPlayer = false;
		}
		else
		{
			AC_BlockThickSnow.shouldSlowPlayer = true;
		}
	}

	public void renderFreezeEffect(int par1, int par2)
	{

		if(mc.thePlayer != null && mc.theWorld != null && mc.currentScreen == null && mc.thePlayer.dimension == MainRegistry.dimension && this.value <= 20 && this.renderOverlay == true)
		{

			GL11.glDisable(2929);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(770, 771);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(3008);
			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("ac", "/textures/misc/freezing.png"));
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(0.0D, par2, - 90.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV(par1, par2, - 90.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV(par1, 0.0D, - 90.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, - 90.0D, 0.0D, 0.0D);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(2929);
			GL11.glEnable(3008);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.currentScreen = null;
		}
	}
}
