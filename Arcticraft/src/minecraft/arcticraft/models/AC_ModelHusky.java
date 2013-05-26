package arcticraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityHusky;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_ModelHusky extends ModelBase
{
    /** main box for the husky head */
    public ModelRenderer huskyHeadMain;

    /** The husky's body */
    public ModelRenderer huskyBody;

    /** Wolf'se first leg */
    public ModelRenderer huskyLeg1;

    /** Wolf's second leg */
    public ModelRenderer huskyLeg2;

    /** Wolf's third leg */
    public ModelRenderer huskyLeg3;

    /** Wolf's fourth leg */
    public ModelRenderer huskyLeg4;

    /** The husky's tail */
    ModelRenderer huskyTail;

    /** The husky's mane */
    ModelRenderer huskyMane;

    public AC_ModelHusky()
    {
        float f = 0.0F;
        float f1 = 13.5F;
        this.huskyHeadMain = new ModelRenderer(this, 0, 0);
        this.huskyHeadMain.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, f);
        this.huskyHeadMain.setRotationPoint(-1.0F, f1, -7.0F);
        this.huskyBody = new ModelRenderer(this, 18, 14);
        this.huskyBody.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6, f);
        this.huskyBody.setRotationPoint(0.0F, 14.0F, 2.0F);
        this.huskyMane = new ModelRenderer(this, 21, 0);
        this.huskyMane.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 7, f);
        this.huskyMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
        this.huskyLeg1 = new ModelRenderer(this, 0, 18);
        this.huskyLeg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        this.huskyLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.huskyLeg2 = new ModelRenderer(this, 0, 18);
        this.huskyLeg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        this.huskyLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.huskyLeg3 = new ModelRenderer(this, 0, 18);
        this.huskyLeg3.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        this.huskyLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.huskyLeg4 = new ModelRenderer(this, 0, 18);
        this.huskyLeg4.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        this.huskyLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.huskyTail = new ModelRenderer(this, 9, 18);
        this.huskyTail.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
        this.huskyTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.huskyHeadMain.setTextureOffset(16, 14).addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1, f);
        this.huskyHeadMain.setTextureOffset(16, 14).addBox(1.0F, -5.0F, 0.0F, 2, 2, 1, f);
        this.huskyHeadMain.setTextureOffset(0, 10).addBox(-1.5F, 0.0F, -5.0F, 3, 3, 4, f);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        super.render(par1Entity, par2, par3, par4, par5, par6, par7);
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * par7, 2.0F * par7);
            this.huskyHeadMain.renderWithRotation(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.huskyBody.render(par7);
            this.huskyLeg1.render(par7);
            this.huskyLeg2.render(par7);
            this.huskyLeg3.render(par7);
            this.huskyLeg4.render(par7);
            this.huskyTail.renderWithRotation(par7);
            this.huskyMane.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.huskyHeadMain.renderWithRotation(par7);
            this.huskyBody.render(par7);
            this.huskyLeg1.render(par7);
            this.huskyLeg2.render(par7);
            this.huskyLeg3.render(par7);
            this.huskyLeg4.render(par7);
            this.huskyTail.renderWithRotation(par7);
            this.huskyMane.render(par7);
        }
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        AC_EntityHusky entityhusky = (AC_EntityHusky)par1EntityLiving;

        if (entityhusky.isAngry())
        {
            this.huskyTail.rotateAngleY = 0.0F;
        }
        else
        {
            this.huskyTail.rotateAngleY = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        }

        if (entityhusky.isSitting())
        {
            this.huskyMane.setRotationPoint(-1.0F, 16.0F, -3.0F);
            this.huskyMane.rotateAngleX = ((float)Math.PI * 2F / 5F);
            this.huskyMane.rotateAngleY = 0.0F;
            this.huskyBody.setRotationPoint(0.0F, 18.0F, 0.0F);
            this.huskyBody.rotateAngleX = ((float)Math.PI / 4F);
            this.huskyTail.setRotationPoint(-1.0F, 21.0F, 6.0F);
            this.huskyLeg1.setRotationPoint(-2.5F, 22.0F, 2.0F);
            this.huskyLeg1.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.huskyLeg2.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.huskyLeg2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.huskyLeg3.rotateAngleX = 5.811947F;
            this.huskyLeg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.huskyLeg4.rotateAngleX = 5.811947F;
            this.huskyLeg4.setRotationPoint(0.51F, 17.0F, -4.0F);
        }
        else
        {
            this.huskyBody.setRotationPoint(0.0F, 14.0F, 2.0F);
            this.huskyBody.rotateAngleX = ((float)Math.PI / 2F);
            this.huskyMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.huskyMane.rotateAngleX = this.huskyBody.rotateAngleX;
            this.huskyTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.huskyLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.huskyLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.huskyLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.huskyLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.huskyLeg1.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
            this.huskyLeg2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
            this.huskyLeg3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
            this.huskyLeg4.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        }

        this.huskyHeadMain.rotateAngleZ = entityhusky.getInterestedAngle(par4) + entityhusky.getShakeAngle(par4, 0.0F);
        this.huskyMane.rotateAngleZ = entityhusky.getShakeAngle(par4, -0.08F);
        this.huskyBody.rotateAngleZ = entityhusky.getShakeAngle(par4, -0.16F);
        this.huskyTail.rotateAngleZ = entityhusky.getShakeAngle(par4, -0.2F);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
        this.huskyHeadMain.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.huskyHeadMain.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.huskyTail.rotateAngleX = par3;
    }
}
