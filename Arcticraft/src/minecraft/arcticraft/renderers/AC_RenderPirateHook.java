package arcticraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import arcticraft.entities.AC_EntityPirateHook;
import arcticraft.lib.Strings;
import arcticraft.models.AC_ModelPirateHook;

public class AC_RenderPirateHook extends Render {

	private static final ResourceLocation texture = new ResourceLocation(Strings.MOD_ID, "textures/mobs/captain.png");
	public AC_ModelPirateHook hook;
	
	public AC_RenderPirateHook() {
		this.hook = new AC_ModelPirateHook();
		this.shadowSize = 0.0F;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		this.renderHook((AC_EntityPirateHook) entity, x, y, z, yaw, partialTicks);
	}
	
	public void renderHook(AC_EntityPirateHook entity, double x, double y, double z, float yaw, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y + 1.5F, (float)z);
		
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.func_110777_b(entity);
		this.hook.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
}
