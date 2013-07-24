package arcticraft.renderers;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityArcher;
import arcticraft.models.AC_ModelArcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderArcher extends RenderBiped
{

	private static final ResourceLocation archer = new ResourceLocation("ac", "textures/mobs/archer.png");

	public AC_RenderArcher()
	{
		super(new AC_ModelArcher(), 0.5F);
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}

	protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
	{
		return this.func_110860_a((AC_EntityArcher) par1EntityLiving);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110860_a((AC_EntityArcher) par1Entity);
	}

	protected ResourceLocation func_110860_a(AC_EntityArcher par1AC_EntityArcher)
	{
		return archer;
	}

}
