package com.arcticraft.render.entity;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.arcticraft.entity.mob.EntityCaptain;
import com.arcticraft.handler.AC_BossStatus;
import com.arcticraft.lib.Strings;
import com.arcticraft.model.AC_ModelCaptain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityCaptain extends RenderBiped
{

	private static final ResourceLocation captain = new ResourceLocation(Strings.MODID + ":textures/mobs/captain.png");

	public RenderEntityCaptain()
	{
		super(new AC_ModelCaptain(), 0.5F);
	}

	public void func_82418_a(EntityCaptain captain, double par2, double par4, double par6, float par8, float par9)
	{
		AC_BossStatus.func_82824_a(captain, true);

		super.doRender(captain, par2, par4, par6, par8, par9);
	}

	protected int func_82417_a(EntityCaptain par1EntityFrostZombieBoss, int par2, float par3)
	{
		return - 1;
	}

	protected int func_82416_b(EntityCaptain par1EntityFrostZombieBoss, int par2, float par3)
	{
		return - 1;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82417_a((EntityCaptain) par1EntityLiving, par2, par3);
	}

	protected int inheritRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82416_b((EntityCaptain) par1EntityLiving, par2, par3);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityCaptain) par1EntityLiving, par2, par4, par6, par8, par9);
		this.setLeftItem(par1EntityLiving, ((EntityCaptain) par1EntityLiving).getHookItem());
		this.field_82423_g.heldItemLeft = this.field_82425_h.heldItemLeft = this.modelBipedMain.heldItemLeft = 0;
	}
	
	protected void setLeftItem(EntityLiving par1EntityLiving, ItemStack par2ItemStack) {
		this.field_82423_g.heldItemLeft = this.field_82425_h.heldItemLeft = this.modelBipedMain.heldItemLeft = par2ItemStack != null ? 1 : 0;
	}
	
	@Override
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        super.renderEquippedItems(par1EntityLivingBase, par2);
        if (!((EntityCaptain) par1EntityLivingBase).isHookAirBorne()) {
        	this.renderHook((EntityCaptain)par1EntityLivingBase, par2);
        }
    }
	
	protected void renderHook(EntityCaptain captain, float par2)
    {
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        ItemStack itemstack = captain.getHookItem();
        float f2;

        if (itemstack != null)
        {
            GL11.glPushMatrix();

            if (this.mainModel.isChild)
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f2, f2, f2);
            }

            this.modelBipedMain.bipedLeftArm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            if (itemstack.getItem().isFull3D())
            {
                f2 = 0.625F;

                if (itemstack.getItem().shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f2 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.renderManager.itemRenderer.renderItem(captain, itemstack, 0);

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                for (int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
                {
                    this.renderManager.itemRenderer.renderItem(captain, itemstack, x);
                }
            }

            GL11.glPopMatrix();
        }
    }

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityCaptain) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return captain;
	}
}
