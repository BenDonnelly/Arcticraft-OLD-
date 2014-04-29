package com.arcticraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.arcticraft.inventory.AC_ContainerTreasureChest;
import com.arcticraft.lib.Strings;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

import cpw.mods.fml.client.FMLClientHandler;

public class AC_TreasureChest extends GuiContainer {

	public TileEntityTreasureChest chest;

	public AC_TreasureChest(InventoryPlayer par1InventoryPlayer, TileEntityTreasureChest tileEntity) {
		super(new AC_ContainerTreasureChest(par1InventoryPlayer, tileEntity));
		this.chest = tileEntity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MODID + ":textures/gui/tresure_chest.png"));
		int k = this.guiLeft;
		int l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, 256, 256);
	}
}
