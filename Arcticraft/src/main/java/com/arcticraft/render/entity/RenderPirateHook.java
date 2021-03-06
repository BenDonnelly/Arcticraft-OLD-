package com.arcticraft.render.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.arcticraft.entity.item.EntityPirateHook;
import com.arcticraft.entity.mob.EntityCaptain;
import com.arcticraft.lib.Strings;
import com.arcticraft.model.AC_ModelPirateHook;


public class RenderPirateHook extends Render {

	public static final ResourceLocation texture = new ResourceLocation(Strings.MODID + ":textures/projectiles/hook.png");
	public AC_ModelPirateHook hook;
	
	public RenderPirateHook() {
		this.hook = new AC_ModelPirateHook();
		this.shadowSize = 0.0F;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		this.renderHook((EntityPirateHook) entity, x, y, z, yaw, partialTicks);
	}
	
	public void renderHook(EntityPirateHook entity, double x, double y, double z, float yaw, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		
		GL11.glScalef(-0.35F, -0.35F, 0.35F);
		
		double dx = this.func_110828_a(entity.getThrower().lastTickPosX, entity.getThrower().posX, partialTicks) - this.func_110828_a(entity.lastTickPosX, entity.posX, partialTicks);
		double dy = this.func_110828_a(entity.getThrower().lastTickPosY, entity.getThrower().posY, partialTicks) - this.func_110828_a(entity.lastTickPosY, entity.posY, partialTicks) + entity.getThrower().ySize;
		double dz = this.func_110828_a(entity.getThrower().lastTickPosZ, entity.getThrower().posZ, partialTicks) - this.func_110828_a(entity.lastTickPosZ, entity.posZ, partialTicks);

		double d3 = (double)MathHelper.sqrt_double(dx * dx + dz * dz);
		float f2 = (float)(Math.atan2(dz, dx) * 180.0D / Math.PI);
		float f3 = (float)(Math.atan2(dy, d3) * 180.0D / Math.PI) + 90.0F;
		
		GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(f3, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, -1.5F, 0.0F);
		
		this.bindEntityTexture(entity);
		this.hook.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		x = this.func_110828_a(entity.getThrower().lastTickPosX, entity.getThrower().posX, partialTicks);
		y = this.func_110828_a(entity.getThrower().lastTickPosY, entity.getThrower().posY, partialTicks);
		z = this.func_110828_a(entity.getThrower().lastTickPosZ, entity.getThrower().posZ, partialTicks);
		yaw = (float) this.func_110828_a(entity.getThrower().prevRotationYaw, entity.getThrower().rotationYaw, partialTicks);
		this.renderRope(entity.getThrower(), entity, x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, yaw, partialTicks);
	}
	
	private double func_110828_a(double par1, double par3, double par5)
    {
        return par1 + (par3 - par1) * par5;
    }
	
	
	public void renderRope(EntityCaptain captain, EntityPirateHook entity, double par2, double par4, double par6, float par8, float par9) {
        Tessellator tessellator = Tessellator.instance;
        
        double d9 = this.func_110828_a(entity.prevPosX, entity.posX, (double)par9);
        double d10 = this.func_110828_a(entity.prevPosY, entity.posY, (double)par9);
        double d11 = this.func_110828_a(entity.prevPosZ, entity.posZ, (double)par9);
        
        double d13 = this.func_110828_a(captain.prevPosX, captain.posX, (double)par9);
        double d14 = this.func_110828_a(captain.prevPosY, captain.posY, (double)par9);
        double d15 = this.func_110828_a(captain.prevPosZ, captain.posZ, (double)par9);
        
        double d16 = (double)((float)(d9 - d13));
        double d17 = (double)((float)(d10 - d14));
        double d18 = (double)((float)(d11 - d15));
        
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
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
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.0D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.0F), par6 + d18 * (double)f2);
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.025D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.0F) + 0.025D, par6 + d18 * (double)f2);
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
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.0D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.0F) + 0.025D, par6 + d18 * (double)f2);
            tessellator.addVertex(par2 + d16 * (double)f2 + 0.025D, par4 + d17 * (double)(f2 * f2 + f2) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.0F), par6 + d18 * (double)f2 + 0.025D);
        }

        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_CULL_FACE);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
