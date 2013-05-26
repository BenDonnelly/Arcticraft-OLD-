package arcticraft.renderers; 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import arcticraft.entities.AC_EntityPenguin;


public class AC_RenderPenguin extends RenderLiving
{

    public AC_RenderPenguin(ModelBase modelbase, float f)
    {
        super(modelbase, f); 
    }

    public void func_177_a(AC_EntityPenguin entitypenguin, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entitypenguin, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((AC_EntityPenguin)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
    	func_177_a((AC_EntityPenguin)entity, d, d1, d2, f, f1);
    }
}