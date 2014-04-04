package com.arcticraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelSled extends ModelBase {

	public ModelRenderer leftBottom;
	public ModelRenderer rightBottom;
	public ModelRenderer rightBottomBack;
	public ModelRenderer leftBottomBack;
	public ModelRenderer rightBack;
	public ModelRenderer rightFront;
	public ModelRenderer leftBack;
	public ModelRenderer leftFront;
	public ModelRenderer bottomPlank;
	public ModelRenderer frontPlank;

	public AC_ModelSled() {
		this.leftBottom = new ModelRenderer(this, 0, 15);
		this.leftBottom.addBox(0F, 0F, 0F, 1, 1, 16);
		this.leftBottom.setRotationPoint(-7F, 23F, -8F);

		this.rightBottom = new ModelRenderer(this, 0, 15);
		this.rightBottom.addBox(0F, 0F, 0F, 1, 1, 16);
		this.rightBottom.setRotationPoint(6F, 23F, -8F);

		this.rightBottomBack = new ModelRenderer(this, 0, 15);
		this.rightBottomBack.addBox(0F, -1F, -3F, 1, 1, 3);
		this.rightBottomBack.setRotationPoint(6F, 24F, -7F);
		this.rightBottomBack.rotateAngleX = -0.1858931F;
		
		this.leftBottomBack = new ModelRenderer(this, 0, 15);
		this.leftBottomBack.addBox(0F, 0F, -3F, 1, 1, 3);
		this.leftBottomBack.setRotationPoint(-7F, 23F, -7F);
		this.leftBottomBack.rotateAngleX = -0.1858931F;
		
		this.rightBack = new ModelRenderer(this, 8, 15);
		this.rightBack.addBox(0F, 0F, 0F, 1, 2, 1);
		this.rightBack.setRotationPoint(6F, 21F, -5F);

		this.rightFront = new ModelRenderer(this, 8, 15);
		this.rightFront.addBox(0F, 0F, 0F, 1, 2, 1);
		this.rightFront.setRotationPoint(6F, 21F, 5F);

		this.leftBack = new ModelRenderer(this, 8, 15);
		this.leftBack.addBox(0F, 0F, 0F, 1, 2, 1);
		this.leftBack.setRotationPoint(-7F, 21F, -5F);

		this.leftFront = new ModelRenderer(this, 8, 15);
		this.leftFront.addBox(0F, 0F, 0F, 1, 2, 1);
		this.leftFront.setRotationPoint(-7F, 21F, 5F);

		this.bottomPlank = new ModelRenderer(this, 0, 0);
		this.bottomPlank.addBox(0F, 0F, 0F, 16, 1, 14);
		this.bottomPlank.setRotationPoint(-8F, 20F, -6F);

		this.frontPlank = new ModelRenderer(this, 18, 15);
		this.frontPlank.addBox(0F, 0F, 0F, 16, 2, 1);
		this.frontPlank.setRotationPoint(-8F, 18F, 7F);
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float f5) {
		this.leftBottom.render(f5);
		this.rightBottom.render(f5);
		this.rightBottomBack.render(f5);
		this.leftBottomBack.render(f5);
		this.rightBack.render(f5);
		this.rightFront.render(f5);
		this.leftBack.render(f5);
		this.leftFront.render(f5);
		this.bottomPlank.render(f5);
		this.frontPlank.render(f5);
	}
}

