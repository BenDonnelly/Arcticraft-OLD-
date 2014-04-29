package com.arcticraft.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.arcticraft.entity.mob.EntityFrostGhost;
import com.arcticraft.entity.mob.EntityMage;
import com.arcticraft.lib.Strings;

public class RenderIceMage extends RenderLiving
{

	private static final ResourceLocation mage = new ResourceLocation(Strings.MODID + ":textures/mobs/ice_mage.png");

	public RenderIceMage(ModelBase modelbase, float f)
	{
		super(modelbase, f);
	}

	public void doRender(EntityFrostGhost par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		 doRender((EntityMage) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		 doRender((EntityMage) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return mage;
	}
}
