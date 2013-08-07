package arcticraft.helpers;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.blocks.AC_Block;
import arcticraft.blocks.AC_BlockFrostLeaves;
import arcticraft.blocks.AC_BlockGlacierLeaves;
import arcticraft.entities.AC_EntityBlueSparkle;
import arcticraft.entities.AC_EntityYellowSparkle;
import arcticraft.items.AC_Item;
import arcticraft.items.AC_ItemLantern;
import arcticraft.lib.Strings;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;

public class AC_TickHandler implements ITickHandler
{

	private Minecraft mc;

	int tickCounter;
	int tempIncrementCounter;
	public static int value = 50;
	public static int maxValue = 100;
	public static int x;
	public static int y;
	public static int cooldown = 1200;
	public static int pickaxeStringTick = 0;
	public static boolean renderOverlay = true;
	public static boolean canFireExplosion;
	public static boolean snowLayersEnabled = true;

	Random rand = new Random();
	public static AC_TickHandler tickHandler;

	public AC_TickHandler()
	{
		this.mc = Minecraft.getMinecraft();

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
				tickDecrementCounter();
				tempIncrementCounter();
				canDecrementTemp();
				canIncrementTemp();
				slowPlayer((EntityPlayer) tickData[0]);
				renderBlueYellowParticles((EntityPlayer) tickData[0]);
				startPickaxeCooldown((EntityPlayer) tickData[0]);
				stringTick();
			}
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER, TickType.PLAYER);

	}

	public void stringTick()
	{
		if(pickaxeStringTick < 40)
		{
			pickaxeStringTick++;
		}
		else if(pickaxeStringTick >= 40)
		{
			pickaxeStringTick = 0;
		}
	}

	public void tickDecrementCounter()
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
		if(! mc.thePlayer.capabilities.isCreativeMode && mc.theWorld != null)
		{

			if(mc.thePlayer.dimension == MainRegistry.dimension && mc.thePlayer.isInsideOfMaterial(Material.water) && this.tickCounter == 300)
			{
				this.value -= 2;
				this.tickCounter = 0;

			}
			else if(mc.thePlayer.dimension == MainRegistry.dimension && mc.theWorld.isRaining() == true && this.tickCounter == 300)
			{
				this.value -= 2;
				this.tickCounter = 0;
			}
			else if(this.tickCounter == 1500)
			{
				this.value -= 1;
			}
		}

	}

	public void canIncrementTemp()
	{
		if(! mc.thePlayer.capabilities.isCreativeMode && mc.theWorld != null && mc.thePlayer != null)
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

	public void slowPlayer(EntityPlayer player)
	{

		ItemStack boots = player.getCurrentItemOrArmor(1);
		int x = (int) Math.floor(player.posX);
		int y = (int) Math.floor(player.boundingBox.minY);
		int z = (int) Math.floor(player.posZ);
		int meta = player.worldObj.getBlockMetadata(x, y, z);
		int blockID = player.worldObj.getBlockId(x, y, z);

		if((boots != null && boots.getItem() == AC_Item.hikingBoots) || ! player.onGround)
		{
			return;
		}
		else if(blockID == Block.snow.blockID && meta > 0)
		{
			player.motionX *= 0.9D - meta * 0.1D;
			player.motionZ *= 0.9D - meta * 0.1D;
		}
		else if(blockID == AC_Block.thickSnow.blockID)
		{
			player.motionX *= 0.8D;
			player.motionZ *= 0.8D;
		}
	}

	public void startPickaxeCooldown(EntityPlayer player)
	{
		ItemStack hand = player.getCurrentItemOrArmor(0);
		if(hand != null && hand.getItem() == AC_Item.notchedPickaxe)
		{

			if(cooldown != 0)
			{
				cooldown--;
			}
			else if(cooldown == 0)
			{
				canFireExplosion = true;
			}

		}
	}

	public void renderBlueYellowParticles(EntityPlayer player)
	{
		ItemStack hand = player.getCurrentItemOrArmor(0);
		Random random = new Random();

		int i = (int) Math.floor(player.posX);
		int j = (int) Math.floor(player.boundingBox.minY);
		int k = (int) Math.floor(player.posZ);

		if(hand != null && hand.getItem() == AC_Item.notchedPickaxe)
		{
			for(int l = 0; l < 3; l++)
			{
				double d = (double) (float) i + ((double) random.nextFloat() - 0.5D) * 10D;
				double d1 = (double) (float) j + ((double) random.nextFloat() - 0.5D) * 10D;
				double d2 = (double) (float) k + ((double) random.nextFloat() - 0.5D) * 10D;
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
				AC_EntityYellowSparkle entityyellowsparkle = new AC_EntityYellowSparkle(player.worldObj, d, d1, d2, d3, d4, d5);
				Minecraft.getMinecraft().effectRenderer.addEffect(entityyellowsparkle);
				AC_EntityBlueSparkle entityBluesparkle = new AC_EntityBlueSparkle(player.worldObj, d, d1, d2, d3, d4, d5);
				Minecraft.getMinecraft().effectRenderer.addEffect(entityBluesparkle);
			}
		}
	}

	@Override
	public String getLabel()
	{
		return "Client Tick Handler";
	}
}
