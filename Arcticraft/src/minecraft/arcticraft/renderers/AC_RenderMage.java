package arcticraft.renderers; 

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityMage;


public class AC_RenderMage extends RenderLiving
{
	private static final ResourceLocation mage = new ResourceLocation("ac", "textures/mobs/ice_mage.png");

    public AC_RenderMage(ModelBase modelbase, float f)
    {
        super(modelbase, f); 
    }

    public void func_177_a(AC_EntityMage entityIceMage, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entityIceMage, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
    	func_177_a((AC_EntityMage)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
    	func_177_a((AC_EntityMage)entity, d, d1, d2, f, f1);
    }

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return mage;
	}
}