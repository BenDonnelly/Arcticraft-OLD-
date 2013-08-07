package arcticraft.tile_entities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.lib.Strings;
import arcticraft.models.AC_ModelBlockCaveman;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_TileEntityCavemanRenderer extends TileEntitySpecialRenderer
{

	public AC_TileEntityCavemanRenderer()
	{
		model = new AC_ModelBlockCaveman();
	}

	public void renderAModelAt(AC_TileEntityCaveman par1TileEntity, double d, double d1, double d2, float f)
	{

		int rotation = 0;
		if(par1TileEntity.worldObj != null)
		{
			rotation = par1TileEntity.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/blocks/caveman.png"));
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, - 1F, - 1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); //end
	}

	private AC_ModelBlockCaveman model;

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderAModelAt((AC_TileEntityCaveman) par1TileEntity, par2, par4, par6, par8);
	}
}
