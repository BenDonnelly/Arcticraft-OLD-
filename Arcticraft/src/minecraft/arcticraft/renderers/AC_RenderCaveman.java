package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityCaveman;
import arcticraft.lib.Strings;

public class AC_RenderCaveman extends RenderLiving
{

	public static final ResourceLocation caveman = new ResourceLocation(Strings.MOD_ID, "textures/mobs/caveman.png");

	public AC_RenderCaveman(ModelBase modelbase, float par2)
	{
		super(modelbase, par2);
	}

	public void func_177_a(AC_EntityCaveman caveman, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(caveman, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityCaveman) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityCaveman) entity, d, d1, d2, f, f1);
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return caveman;
	}
}
