package arcticraft.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityKnight;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderKnight extends RenderBiped
{

	private static final ResourceLocation knight = new ResourceLocation("ac", "textures/mobs/knight.png");

	public AC_RenderKnight()
	{
		super(new ModelBiped(), 0.5F);
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}

	protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
	{
		return this.func_110860_a((AC_EntityKnight) par1EntityLiving);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110860_a((AC_EntityKnight) par1Entity);
	}

	protected ResourceLocation func_110860_a(AC_EntityKnight par1AC_EntityKnight)
	{
		return knight;
	}

}
