package arcticraft.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityPirate;
import arcticraft.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_RenderPirate extends RenderBiped
{

	private static final ResourceLocation pirate = new ResourceLocation(Strings.MOD_ID, "textures/mobs/pirate.png");

	public AC_RenderPirate()
	{
		super(new ModelBiped(), 0.5F);
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
	}

	protected ResourceLocation func_110860_a(AC_EntityPirate par1AC_EntityPirate)
	{
		return pirate;
	}

	protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
	{
		return this.func_110860_a((AC_EntityPirate) par1EntityLiving);
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110860_a((AC_EntityPirate) par1Entity);
	}
}
