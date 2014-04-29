package com.arcticraft.render.tile_entity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.arcticraft.Block.TileEntityCampfire;
import com.arcticraft.lib.Strings;
import com.arcticraft.model.AC_ModelCampfire;

import cpw.mods.fml.client.FMLClientHandler;

public class AC_TileEntityCampfireRenderer extends TileEntitySpecialRenderer
{

	public AC_TileEntityCampfireRenderer()
	{
		model = new AC_ModelCampfire();
	}

	public void renderAModelAt(TileEntityCampfire tile, double d, double d1, double d2, float f)
	{

		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
			rotation = tile.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MODID + ":textures/blocks/campfire.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, - 1F, - 1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); //end
	}

	private AC_ModelCampfire model;

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderAModelAt((TileEntityCampfire) par1TileEntity, par2, par4, par6, par8);
	}
}
