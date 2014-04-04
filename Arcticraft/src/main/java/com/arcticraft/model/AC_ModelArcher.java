package com.arcticraft.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AC_ModelArcher extends ModelZombie
{

	public AC_ModelArcher()
	{
		this(0.0F, false);
	}

	protected AC_ModelArcher(float par1, float par2, int par3, int par4)
	{
		super(par1, par2, par3, par4);
	}

	public AC_ModelArcher(float par1, boolean par2)
	{
		super(par1, 0.0F, 64, par2 ? 32 : 64);
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		//this.aimedBow = ((AC_EntityArcher) par1EntityLivingBase) != null;
		super.setLivingAnimations(par1EntityLivingBase, par2, par3, par4);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
	 * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
	 * "far" arms and legs can swing at most.
	 */
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}
}
