package com.arcticraft.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.arcticraft.entity.mob.EntityPirate;
import com.arcticraft.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityPirate extends RenderBiped
{

	private static final ResourceLocation pirate = new ResourceLocation(Strings.MODID + ":textures/mobs/pirate.png");

	public RenderEntityPirate()
	{
		super(new ModelBiped(), 0.5F);
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}

	protected ResourceLocation func_110860_a(EntityPirate par1AC_EntityPirate)
	{
		return pirate;
	}

	protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
	{
		return this.func_110860_a((EntityPirate) par1EntityLiving);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110860_a((EntityPirate) par1Entity);
	}
}
