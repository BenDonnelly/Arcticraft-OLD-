package arcticraft.tile_entities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import arcticraft.models.AC_ModelPlainStatue;

public class AC_TileEntityCaptainStatueRenderer extends TileEntitySpecialRenderer
{

	public AC_TileEntityCaptainStatueRenderer()
	{
		model = new AC_ModelPlainStatue();
	}

	public void renderAModelAt(AC_TileEntityCaptainStatue tile, double d, double d1, double d2, float f)
	{

		int rotation = 0;
		if (tile.worldObj != null)
		{
			rotation = tile.getBlockMetadata();
		}
		bindTextureByName("/mods/AC/textures/blocks/captain_statue.png"); //texture
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); //end
	}

	private AC_ModelPlainStatue model;

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderAModelAt((AC_TileEntityCaptainStatue) par1TileEntity, par2, par4, par6, par8);
	}
}
