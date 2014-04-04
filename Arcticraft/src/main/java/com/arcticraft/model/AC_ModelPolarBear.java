package com.arcticraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class AC_ModelPolarBear extends ModelBase
{
	//fields
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;
	ModelRenderer BackLeftLeg;
	ModelRenderer BackRightLeg;
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer Tail;
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public AC_ModelPolarBear()
	{
		textureWidth = 64;
		textureHeight = 64;
		LeftLeg = new ModelRenderer(this, 28, 0);
		LeftLeg.addBox(0F, 0F, 0F, 5, 8, 5);
		LeftLeg.setRotationPoint(2F, 16F, -8F);
		LeftLeg.setTextureSize(64, 64);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		RightLeg = new ModelRenderer(this, 28, 0);
		RightLeg.addBox(0F, 0F, 0F, 5, 8, 5);
		RightLeg.setRotationPoint(-5F, 16F, -8F);
		RightLeg.setTextureSize(64, 64);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		BackLeftLeg = new ModelRenderer(this, 28, 0);
		BackLeftLeg.addBox(0F, 0F, 0F, 5, 8, 5);
		BackLeftLeg.setRotationPoint(2F, 16F, 3F);
		BackLeftLeg.setTextureSize(64, 64);
		BackLeftLeg.mirror = true;
		setRotation(BackLeftLeg, 0F, 0F, 0F);
		BackRightLeg = new ModelRenderer(this, 28, 0);
		BackRightLeg.addBox(0F, 0F, 0F, 5, 8, 5);
		BackRightLeg.setRotationPoint(-5F, 16F, 3F);
		BackRightLeg.setTextureSize(64, 64);
		BackRightLeg.mirror = true;
		setRotation(BackRightLeg, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 15);
		Body.addBox(0F, 0F, 0F, 12, 11, 18);
		Body.setRotationPoint(-5F, 5F, -9F);
		Body.setTextureSize(64, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 6, 7, 8);
		Head.setRotationPoint(-2F, 4.5F, -15F);
		Head.setTextureSize(64, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 0, 18);
		Tail.addBox(0F, 0F, 0F, 4, 4, 3);
		Tail.setRotationPoint(-1F, 6F, 8F);
		Tail.setTextureSize(64, 64);
		Tail.mirror = true;
		setRotation(Tail, 0.2617994F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 25);
		Shape1.addBox(0F, 0F, 0F, 3, 3, 5);
		Shape1.setRotationPoint(-0.5F, 8F, -18F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 15);
		Shape2.addBox(0F, 0F, 4F, 8, 3, 0);
		Shape2.setRotationPoint(-3F, 2F, -15.53333F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		BackLeftLeg.render(f5);
		BackRightLeg.render(f5);
		Body.render(f5);
		Head.render(f5);
		Tail.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		this.BackRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.BackRightLeg.rotateAngleZ = 0.0F;
		this.BackLeftLeg.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.Tail.rotateAngleZ = MathHelper.cos(par1 * 0.0662F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.Tail.rotateAngleX = 0.0F;

	}

}