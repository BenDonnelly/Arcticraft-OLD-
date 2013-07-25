package arcticraft.renderers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntitySled;
import arcticraft.lib.Strings;
import arcticraft.models.AC_ModelSled;

public class AC_RenderSled extends Render {

	private static final ResourceLocation texture = new ResourceLocation(Strings.MOD_ID, "textures/mobs/sled.png");
	protected AC_ModelSled model;
	
	public AC_RenderSled() {
		this.model = new AC_ModelSled();
		this.shadowSize = 0.5F;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		this.renderSled((AC_EntitySled) entity, x, y, z, yaw, partialTicks);
	}
	
	public void renderSled(AC_EntitySled entity, double x, double y, double z, float yaw, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y + 1.5F, (float)z);
		GL11.glRotatef(270.0F - yaw, 0.0F, 1.0F, 0.0F);
		
		float f4 = 0.75F;
		this.func_110777_b(entity);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}

}
