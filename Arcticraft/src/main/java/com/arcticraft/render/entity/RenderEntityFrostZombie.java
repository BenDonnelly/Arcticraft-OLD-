package com.arcticraft.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.arcticraft.entity.mob.EntityFrostZombie;
import com.arcticraft.lib.Strings;
import com.arcticraft.model.AC_ModelFrostZombie;

public class RenderEntityFrostZombie extends RenderLiving
{

	private static final ResourceLocation zombie = new ResourceLocation(Strings.MODID + ":textures/mobs/frozen_zombie.png");

	public RenderEntityFrostZombie(AC_ModelFrostZombie par1ModelBiped, float par2, float par3)
	{
		super(par1ModelBiped, par3);
	}

	public void func_177_a(EntityFrostZombie zombie, double d, double d1, double d2, float f, float f1)
	{
		super.doRender(zombie, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((EntityFrostZombie) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((EntityFrostZombie) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return zombie;
	}
}
