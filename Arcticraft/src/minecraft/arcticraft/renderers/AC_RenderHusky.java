package arcticraft.renderers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityHusky;
import arcticraft.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderHusky extends RenderLiving
{

	private static final ResourceLocation field_110917_a = new ResourceLocation(Strings.MOD_ID, "textures/mobs/husky.png");
	private static final ResourceLocation field_110915_f = new ResourceLocation(Strings.MOD_ID, "textures/mobs/husky_tamed.png");
	private static final ResourceLocation field_110916_g = new ResourceLocation(Strings.MOD_ID, "textures/mobs/husky_angry.png");
	private static final ResourceLocation field_110918_h = new ResourceLocation(Strings.MOD_ID, "textures/mobs/husky_collar.png");

	public AC_RenderHusky(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
	{
		super(par1ModelBase, par3);
		this.setRenderPassModel(par2ModelBase);
	}

	protected float getTailRotation(AC_EntityHusky par1AC_EntityHusky, float par2)
	{
		return par1AC_EntityHusky.getTailRotation();
	}

	protected int func_82447_a(AC_EntityHusky par1AC_EntityHusky, int par2, float par3)
	{
		float f1;

		if(par2 == 0 && par1AC_EntityHusky.getWolfShaking())
		{
			f1 = par1AC_EntityHusky.getBrightness(par3) * par1AC_EntityHusky.getShadingWhileShaking(par3);
			this.bindTexture(field_110917_a);
			GL11.glColor3f(f1, f1, f1);
			return 1;
		}
		else if(par2 == 1 && par1AC_EntityHusky.isTamed())
		{
			this.bindTexture(field_110918_h);
			f1 = 1.0F;
			int j = par1AC_EntityHusky.getCollarColor();
			GL11.glColor3f(f1 * EntitySheep.fleeceColorTable[j][0], f1 * EntitySheep.fleeceColorTable[j][1], f1 * EntitySheep.fleeceColorTable[j][2]);
			return 1;
		}
		else
		{
			return - 1;
		}
	}

	protected ResourceLocation getEntityTexture(AC_EntityHusky par1AC_EntityHusky)
	{
		return par1AC_EntityHusky.isTamed() ? field_110915_f : (par1AC_EntityHusky.isAngry() ? field_110916_g : field_110917_a);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.func_82447_a((AC_EntityHusky) par1EntityLivingBase, par2, par3);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2)
	{
		return this.getTailRotation((AC_EntityHusky) par1EntityLivingBase, par2);
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((AC_EntityHusky) par1Entity);
	}
}
