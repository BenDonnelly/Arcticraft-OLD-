package com.arcticraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class AC_ModelPenguin extends ModelBase
{
	//fields
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer RightWing;
	ModelRenderer LeftWing;
	ModelRenderer Beak;
	ModelRenderer RightFoot;
	ModelRenderer LeftFoot;

	public AC_ModelPenguin()
	{
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 8, 10, 6);
		Body.setRotationPoint(-4F, 14F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 28, 0);
		Head.addBox(0F, 0F, 0F, 6, 6, 4);
		Head.setRotationPoint(-3F, 8F, -1F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		RightWing = new ModelRenderer(this, 48, 0);
		RightWing.addBox(0F, 0F, 0F, 1, 7, 4);
		RightWing.setRotationPoint(-5F, 15F, -1F);
		RightWing.setTextureSize(64, 32);
		RightWing.mirror = true;
		setRotation(RightWing, 0F, 0F, 0F);
		LeftWing = new ModelRenderer(this, 48, 0);
		LeftWing.addBox(0F, 0F, 0F, 1, 7, 4);
		LeftWing.setRotationPoint(4F, 15F, -1F);
		LeftWing.setTextureSize(64, 32);
		LeftWing.mirror = true;
		setRotation(LeftWing, 0F, 0F, 0F);
		LeftWing.mirror = false;
		Beak = new ModelRenderer(this, 28, 10);
		Beak.addBox(0F, 0F, 0F, 2, 2, 2);
		Beak.setRotationPoint(-1F, 11F, -3F);
		Beak.setTextureSize(64, 32);
		Beak.mirror = true;
		setRotation(Beak, 0F, 0F, 0F);
		RightFoot = new ModelRenderer(this, 36, 10);
		RightFoot.addBox(0F, 0F, 0F, 3, 1, 3);
		RightFoot.setRotationPoint(-5F, 23F, -3F);
		RightFoot.setTextureSize(64, 32);
		RightFoot.mirror = true;
		setRotation(RightFoot, 0F, 0.3490659F, 0F);
		LeftFoot = new ModelRenderer(this, 36, 10);
		LeftFoot.addBox(0F, 0F, 0F, 3, 1, 3);
		LeftFoot.setRotationPoint(2F, 23F, -4F);
		LeftFoot.setTextureSize(64, 32);
		LeftFoot.mirror = true;
		setRotation(LeftFoot, 0F, -0.3490659F, 0F);
		LeftFoot.mirror = false;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		Head.render(f5);
		RightWing.render(f5);
		LeftWing.render(f5);
		Beak.render(f5);
		RightFoot.render(f5);
		LeftFoot.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
		RightFoot.rotateAngleX =  MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		LeftFoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		RightFoot.rotateAngleY = 0.0F;
		LeftFoot.rotateAngleY = 0.0F;
		RightWing.rotateAngleZ =  (MathHelper.cos(-f * -0.6662F) * -f1);
		LeftWing.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	}

}