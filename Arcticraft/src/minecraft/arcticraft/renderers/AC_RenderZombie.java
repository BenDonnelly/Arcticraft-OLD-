package arcticraft.renderers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.lib.Strings;
import arcticraft.models.AC_ModelFrostZombie;

public class AC_RenderZombie extends RenderLiving
{

	private static final ResourceLocation zombie = new ResourceLocation(Strings.MOD_ID, "textures/mobs/frozen_zombie.png");

	public AC_RenderZombie(AC_ModelFrostZombie par1ModelBiped, float par2, float par3)
	{
		super(par1ModelBiped, par3);
	}

	public void func_177_a(AC_EntityFrostZombie zombie, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(zombie, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityFrostZombie) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityFrostZombie) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return zombie;
	}
}
