package com.arcticraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCannonball extends EntityThrowable
{

	public EntityCannonball(World world)
	{
		super(world);
	}

	public EntityCannonball(World world, EntityLivingBase living)
	{
		super(world, living);
	}

	public EntityCannonball(World world, double d1, double d2, double d3)
	{
		super(world, d1, d2, d3);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition movingObject)
	{
		if(movingObject.entityHit != null)
		{
			byte damage = 0;
			if(movingObject.entityHit instanceof EntityBlaze)
			{
				damage = 3;
			}
			if(! movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage))
			{
				;
			}
		}
		for(int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("none", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		if(! this.worldObj.isRemote)
		{
			this.setDead();
			if(! this.worldObj.isRemote)
			{
			this.worldObj.createExplosion((Entity) null, this.posX, this.posY, this.posZ, 10.0F, true);
			}
		}
	}
}
