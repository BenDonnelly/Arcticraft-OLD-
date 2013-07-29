package arcticraft.renderers;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityCaptain;
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
		GL11.glTranslatef((float)x, (float)y, (float)z);
		
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.func_110777_b(entity);
		this.hook.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		x = this.func_110828_a(entity.captain.lastTickPosX, entity.captain.posX, partialTicks);
		y = this.func_110828_a(entity.captain.lastTickPosY, entity.captain.posY, partialTicks);
		z = this.func_110828_a(entity.captain.lastTickPosZ, entity.captain.posZ, partialTicks);
		yaw = (float) this.func_110828_a(entity.captain.prevRotationYaw, entity.captain.rotationYaw, partialTicks);
		this.renderRope(entity.captain, entity, x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, yaw, partialTicks);
	}
	
	private double func_110828_a(double par1, double par3, double par5)
    {
        return par1 + (par3 - par1) * par5;
    }
	
	
	public void renderRope(AC_EntityCaptain captain, AC_EntityPirateHook entity, double par2, double par4, double par6, float par8, float par9) {
		par4 -= (1.6D - (double)captain.height) * 0.5D;
        Tessellator tessellator = Tessellator.instance;
        double d3 = this.func_110828_a((double)entity.prevRotationYaw, (double)entity.rotationYaw, (double)(par9 * 0.5F)) * 0.01745329238474369D;
        double d4 = this.func_110828_a((double)entity.prevRotationPitch, (double)entity.rotationPitch, (double)(par9 * 0.5F)) * 0.01745329238474369D;
        double d5 = Math.cos(d3);
        double d6 = Math.sin(d3);
        double d7 = Math.sin(d4);
        double d8 = Math.cos(d4);
        double d9 = this.func_110828_a(entity.prevPosX, entity.posX, (double)par9) - d5 * 0.7D - d6 * 0.5D * d8;
        double d10 = this.func_110828_a(entity.prevPosY + (double)entity.getEyeHeight() * 0.7D, entity.posY + (double)entity.getEyeHeight() * 0.7D, (double)par9) - d7 * 0.5D - 0.25D;
        double d11 = this.func_110828_a(entity.prevPosZ, entity.posZ, (double)par9) - d6 * 0.7D + d5 * 0.5D * d8;
        double d12 = this.func_110828_a((double)captain.prevRenderYawOffset, (double)captain.renderYawOffset, (double)par9) * 0.01745329238474369D + (Math.PI / 2D);
        d5 = Math.cos(d12) * (double)captain.width * 0.4D;
        d6 = Math.sin(d12) * (double)captain.width * 0.4D;
        double d13 = this.func_110828_a(captain.prevPosX, captain.posX, (double)par9) + d5;
        double d14 = this.func_110828_a(captain.prevPosY, captain.posY, (double)par9);
        double d15 = this.func_110828_a(captain.prevPosZ, captain.posZ, (double)par9) + d6;
        par2 += d5;
        par6 += d6;
        double d16 = (double)((float)(d9 - d13));
        double d17 = (double)((float)(d10 - d14));
        double d18 = (double)((float)(d11 - d15));
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        boolean flag = true;
        double d19 = 0.025D;
        tessellator.startDrawing(5);
        int i;
        float f2;

        for (i = 0; i <= 24; ++i)
        {
            if (i % 2 == 0)
            {
                tessellator.setColorRGBA_F(0.5F, 0.4F, 0.3F, 1.0F);
            }
            else
            {
                tessellator.setColorRGBA_F(0.35F, 0.28F, 0.21000001F, 1.0F);
            }

            f2 = (float)i / 24.0F;
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.0D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F), par6 + d18 * (double)f2);
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.025D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F) + 0.025D, par6 + d18 * (double)f2);
        }

        tessellator.draw();
        tessellator.startDrawing(5);

        for (i = 0; i <= 24; ++i)
        {
            if (i % 2 == 0)
            {
                tessellator.setColorRGBA_F(0.5F, 0.4F, 0.3F, 1.0F);
            }
            else
            {
                tessellator.setColorRGBA_F(0.35F, 0.28F, 0.21000001F, 1.0F);
            }

            f2 = (float)i / 24.0F;
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.0D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F) + 0.025D, par6 + d18 * (double)f2);
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.025D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F), par6 + d18 * (double)f2 + 0.025D);
        }

        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_CULL_FACE);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
}
