package arcticraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.entities.AC_EntityWhale;

public class AC_RenderWhale extends RenderLiving
{

	/** Scale of the model to use */
	private float scale;

	private static final ResourceLocation whale = new ResourceLocation("ac", "textures/mobs/whale.png");

	public AC_RenderWhale(ModelBase modelbase, float f/*, float f2*/)
	{
		super(modelbase, f);
		/*this.scale = f2;*/
	}

	/*protected void scaleWhale(AC_EntityWhale par1AC_EntityWhale, float par2)
	{
		GL11.glScalef(this.scale, this.scale, this.scale);
	}*/

	public void func_177_a(AC_EntityWhale entitywhale, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entitywhale, d, d1, d2, f, f1);
	}

	/*
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.scaleWhale((AC_EntityWhale) par1EntityLivingBase, par2);
	}
	 */
	@Override
	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityWhale) entityliving, d, d1, d2, f, f1);
	}
	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityWhale) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return whale;
	}
}
