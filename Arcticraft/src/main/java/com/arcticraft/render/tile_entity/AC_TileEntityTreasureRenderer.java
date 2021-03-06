package com.arcticraft.render.tile_entity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.arcticraft.lib.Strings;
import com.arcticraft.model.AC_ModelTresureChest;
import com.arcticraft.tile_entity.TileEntityTreasureChest;

import cpw.mods.fml.client.FMLClientHandler;

public class AC_TileEntityTreasureRenderer extends TileEntitySpecialRenderer
{

	public AC_TileEntityTreasureRenderer()
	{
		model = new AC_ModelTresureChest();
	}

	public void renderAModelAt(TileEntityTreasureChest tile, double d, double d1, double d2, float f)
	{

		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
			rotation = tile.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MODID + ":textures/blocks/tresure_chest.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, - 1F, - 1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		float f1 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * f;
		float f2;

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		/*model.C14.rotateAngleX = - (f1 * (float) Math.PI / 2.0F);
		model.C15.rotateAngleX = - (f1 * (float) Math.PI / 2.0F);
		model.C16.rotateAngleX = - (f1 * (float) Math.PI / 2.0F);
		model.C17.rotateAngleX = - (f1 * (float) Math.PI / 2.0F);*/
		model.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	private AC_ModelTresureChest model;

	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderAModelAt((TileEntityTreasureChest) par1TileEntity, par2, par4, par6, par8);
	}
}
