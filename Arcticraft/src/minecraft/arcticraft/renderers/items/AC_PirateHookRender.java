package arcticraft.renderers.items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import arcticraft.models.AC_ModelPirateHook;
import arcticraft.renderers.AC_RenderPirateHook;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_PirateHookRender implements IItemRenderer {

	private final AC_ModelPirateHook hook;
	
	public AC_PirateHookRender() {
		this.hook = new AC_ModelPirateHook();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		default:
			return false;
		}
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
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(AC_RenderPirateHook.texture);
		GL11.glScalef(-0.35F, -0.35F, -0.35F);
		GL11.glRotatef(300F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(270F, -0.1F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.4F, -3.0F, 0.6F);
		this.hook.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

}
