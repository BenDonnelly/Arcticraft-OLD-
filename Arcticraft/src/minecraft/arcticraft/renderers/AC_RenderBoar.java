package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import arcticraft.entities.AC_EntityBoar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderBoar extends RenderLiving
{
    public AC_RenderBoar(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected int renderSaddledPig(AC_EntityBoar par1EntityBoar, int par2, float par3)
    {
        if (par2 == 0 && par1EntityBoar.getSaddled())
        {
            this.loadTexture("/mob/saddle.png");
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public void renderLivingPig(AC_EntityBoar par1EntityBoar, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityBoar, par2, par4, par6, par8, par9);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.renderSaddledPig((AC_EntityBoar)par1EntityLiving, par2, par3);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingPig((AC_EntityBoar)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingPig((AC_EntityBoar)par1Entity, par2, par4, par6, par8, par9);
    }
}
