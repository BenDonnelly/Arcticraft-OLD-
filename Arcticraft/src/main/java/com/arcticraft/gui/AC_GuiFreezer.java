package com.arcticraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.arcticraft.inventory.AC_ContainerFreezer;
import com.arcticraft.lib.Strings;
import com.arcticraft.tile_entity.TileEntityFreezer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_GuiFreezer extends GuiContainer
{

	private TileEntityFreezer freezerInventory;

	public AC_GuiFreezer(InventoryPlayer par1InventoryPlayer, TileEntityFreezer par2TileEntityFreezer)
	{
		super(new AC_ContainerFreezer(par1InventoryPlayer, par2TileEntityFreezer));
		this.freezerInventory = par2TileEntityFreezer;
	}	

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MODID + ":textures/gui/Freezer.png"));
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;

		if(this.freezerInventory.isBurning())
		{
			i1 = this.freezerInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.freezerInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}
