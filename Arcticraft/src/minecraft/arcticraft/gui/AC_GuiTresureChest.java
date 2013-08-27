package arcticraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.containers.AC_ContainerTresureChest;
import arcticraft.lib.Strings;
import arcticraft.tile_entities.AC_TileEntityTresureChest;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_GuiTresureChest extends GuiContainer
{

	public AC_TileEntityTresureChest chest;

	public AC_GuiTresureChest(InventoryPlayer par1InventoryPlayer, AC_TileEntityTresureChest tileEntity)
	{
		super(new AC_ContainerTresureChest(par1InventoryPlayer, tileEntity));
		this.chest = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		this.fontRenderer.drawString("Tresure Chest", 8, 6, 4210752);
		this.fontRenderer.drawString(I18n.func_135053_a("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/tresure_chest.png"));
		int k = this.guiLeft;
		int l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, 256, 256);
	}
}
