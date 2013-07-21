package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityPolarBear;

public class AC_RenderPolarBear extends RenderLiving
{

	private static final ResourceLocation polarBear = new ResourceLocation("ac", "textures/mobs/polar_bear.png");

	public AC_RenderPolarBear(ModelBase par1ModelBase, float par2, float par3)
	{
		super(par1ModelBase, par2);
	}

	protected void scalePolarBear(AC_EntityPolarBear par1AC_EntityPolarBear, float par2)
	{
		GL11.glScalef(1.7F, 1.7F, 1.7F);
	}

	protected ResourceLocation func_110892_a(AC_EntityPolarBear par1AC_EntityPolarBear)
	{
		return polarBear;
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
	 * entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.scalePolarBear((AC_EntityPolarBear) par1EntityLivingBase, par2);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110892_a((AC_EntityPolarBear) par1Entity);
	}
}
