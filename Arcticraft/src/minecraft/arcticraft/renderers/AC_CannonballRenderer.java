package arcticraft.renderers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

public class AC_CannonballRenderer implements IItemRenderer
{

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		float f = 0.0625F;
		//GL11.glTranslatef(- 0.454F, - 0.800F, - 0.3F);
		GL11.glColor4f(0, 0, 0, 100);
		Sphere s = new Sphere();
		s.draw(0.4f, 30, 30);
		GL11.glPopMatrix();
	}
}
