package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderBoar extends RenderLiving
{

	private static final ResourceLocation field_110888_a = new ResourceLocation("textures/entity/pig/pig_saddle.png");
	private static final ResourceLocation field_110887_f = new ResourceLocation(Strings.MOD_ID, "textures/mobs/boar.png");

	public AC_RenderBoar(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
	{
		super(par1ModelBase, par3);
		this.setRenderPassModel(par2ModelBase);
	}


	protected ResourceLocation func_110886_a(AC_EntityBoar par1AC_EntityBoar)
	{
		return field_110887_f;
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110886_a((AC_EntityBoar) par1Entity);
	}
}
