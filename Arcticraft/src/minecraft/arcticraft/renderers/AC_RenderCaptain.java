package arcticraft.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_BossStatus;
import arcticraft.entities.AC_EntityCaptain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderCaptain extends RenderBiped
{

	private static final ResourceLocation captain = new ResourceLocation("ac", "textures/mobs/captain.png");

	public AC_RenderCaptain()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void func_82418_a(AC_EntityCaptain par1EntityFrostZombieBoss, double par2, double par4, double par6, float par8, float par9)
	{
		AC_BossStatus.func_82824_a(par1EntityFrostZombieBoss, true);

		super.doRenderLiving(par1EntityFrostZombieBoss, par2, par4, par6, par8, par9);
	}

	protected int func_82417_a(AC_EntityCaptain par1EntityFrostZombieBoss, int par2, float par3)
	{
		return - 1;
	}

	protected int func_82416_b(AC_EntityCaptain par1EntityFrostZombieBoss, int par2, float par3)
	{
		return - 1;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82417_a((AC_EntityCaptain) par1EntityLiving, par2, par3);
	}

	protected int inheritRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82416_b((AC_EntityCaptain) par1EntityLiving, par2, par3);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((AC_EntityCaptain) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((AC_EntityCaptain) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity)
	{
		return captain;
	}
}
