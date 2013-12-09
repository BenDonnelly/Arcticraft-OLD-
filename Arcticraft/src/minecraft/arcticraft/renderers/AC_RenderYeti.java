package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_BossStatus;
import arcticraft.entities.AC_EntityYeti;
import arcticraft.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderYeti extends RenderLiving
{

	private static final ResourceLocation yeti = new ResourceLocation(Strings.MOD_ID, "textures/mobs/yeti.png");

	public AC_RenderYeti(ModelBase modelbase, float f)
	{
		super(modelbase, f);

	}

	public void func_82418_a(AC_EntityYeti yeti, double par2, double par4, double par6, float par8, float par9)
	{
		AC_BossStatus.func_82824_a(yeti, true);

		super.doRenderLiving(yeti, par2, par4, par6, par8, par9);
	}

	protected int func_82417_a(AC_EntityYeti yeti, int par2, float par3)
	{
		return - 1;
	}

	protected int func_82416_b(AC_EntityYeti yeti, int par2, float par3)
	{
		return - 1;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82417_a((AC_EntityYeti) par1EntityLiving, par2, par3);
	}

	protected int inheritRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82416_b((AC_EntityYeti) par1EntityLiving, par2, par3);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((AC_EntityYeti) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((AC_EntityYeti) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return yeti;
	}
}
