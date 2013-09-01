package arcticraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.containers.AC_ContainerCaveman;
import arcticraft.entities.AC_EntityCaveman;
import arcticraft.lib.Strings;
import arcticraft.tile_entities.AC_TileEntityCavemanGUI;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_GuiCaveman extends GuiContainer
{

	/**
	 * x size of the inventory window in pixels. Defined as float, passed as int
	 */
	private float xSize_lo;

	/**
	 * y size of the inventory window in pixels. Defined as float, passed as int.
	 */
	private float ySize_lo;

	private AC_EntityCaveman cavemaninstance;

	public AC_GuiCaveman(InventoryPlayer inventoryPlayer, AC_TileEntityCavemanGUI tileEntity, AC_EntityCaveman caveman) //i wanna see where this constructor is called
	{
		super(new AC_ContainerCaveman(inventoryPlayer, tileEntity));
		cavemaninstance = caveman;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		fontRenderer.drawString("Caveman stats", 90, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/caveman.png"));
		int k = this.guiLeft;
		int l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, 256, 256);
		GuiInventory.func_110423_a(k + 51, l + 75, 30, (float) (k + 51) - this.xSize_lo, (float) (l + 75 - 50) - this.ySize_lo, cavemaninstance);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = (float) par1;
		this.ySize_lo = (float) par2;
	}

}
