package arcticraft.renderers; 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityPirate;


public class AC_RenderPirate extends RenderBiped
{
	private static final ResourceLocation pirate = new ResourceLocation("ac", "textures/mobs/pirate.png");

    public AC_RenderPirate(ModelBiped par1ModelBiped, float par2, float par3)
    {
    	 super(par1ModelBiped, par2);
    }

    public void func_177_a(AC_EntityPirate entitypenguin, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entitypenguin, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((AC_EntityPirate)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((AC_EntityPirate)entity, d, d1, d2, f, f1);
    }

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return pirate;
	}
}