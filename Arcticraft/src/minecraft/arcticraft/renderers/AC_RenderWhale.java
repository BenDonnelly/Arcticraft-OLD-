package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityWhale;
import arcticraft.lib.Strings;

public class AC_RenderWhale extends RenderLiving
{

	private static final ResourceLocation whale = new ResourceLocation(Strings.MOD_ID, "textures/mobs/whale.png");

	public AC_RenderWhale(ModelBase modelbase, float f)
	{
		super(modelbase, f);
	}

	public void func_177_a(AC_EntityWhale entitywhale, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entitywhale, d, d1, d2, f, f1);
	}

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
