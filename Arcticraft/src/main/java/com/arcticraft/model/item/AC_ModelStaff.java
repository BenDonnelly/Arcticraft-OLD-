// Date: 25-Jun-13 18:43:59
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package com.arcticraft.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelStaff extends ModelBase
{

	//fields
	ModelRenderer Staff1;
	ModelRenderer Staff;

	public AC_ModelStaff()
	{
		textureWidth = 64;
		textureHeight = 32;

		Staff1 = new ModelRenderer(this, 56, 0);
		Staff1.addBox(0F, 0F, 0F, 1, 27, 1);
		Staff1.setRotationPoint(-0.5F, -6F, -0.5F);
		Staff1.setTextureSize(64, 32);
		Staff1.mirror = true;
		setRotation(Staff1, 0F, 0F, 0F);
		Staff = new ModelRenderer(this, 32, 0);
		Staff.addBox(0F, 0F, 0F, 3, 3, 3);
		Staff.setRotationPoint(-1.5F, 21F, -1.5F);
		Staff.setTextureSize(64, 32);
		Staff.mirror = true;
		setRotation(Staff, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Staff1.render(f5);
		Staff.render(f5);
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
	}

	public void renderAll()
	{
		Staff.render(0.0625F);
		Staff1.render(0.0625F);

	}

}
