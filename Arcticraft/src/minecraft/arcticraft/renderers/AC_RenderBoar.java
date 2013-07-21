package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityBoar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderBoar extends RenderLiving
{

	private static final ResourceLocation field_110888_a = new ResourceLocation("textures/entity/pig/pig_saddle.png");
	private static final ResourceLocation field_110887_f = new ResourceLocation("ac", "textures/mobs/boar.png");

	public AC_RenderBoar(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
	{
		super(par1ModelBase, par3);
		this.setRenderPassModel(par2ModelBase);
	}

	protected int renderSaddledPig(AC_EntityBoar par1AC_EntityBoar, int par2, float par3)
	{
		if(par2 == 0 && par1AC_EntityBoar.getSaddled())
		{
			this.func_110776_a(field_110888_a);
			return 1;
		}
		else
		{
			return - 1;
		}
	}

	protected ResourceLocation func_110886_a(AC_EntityBoar par1AC_EntityBoar)
	{
		return field_110887_f;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.renderSaddledPig((AC_EntityBoar) par1EntityLivingBase, par2, par3);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110886_a((AC_EntityBoar) par1Entity);
	}
}
