package com.arcticraft.entity.mob;

import java.util.Random;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFrostGhost extends EntityFlying implements IMob
{
	public int courseChangeCooldown = 0;
	public double waypointX;
	public double waypointY;
	public double waypointZ;

	public EntityFrostGhost(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 2.0F);
	}
	@Override
	protected void updateEntityActionState()
	{

		this.despawnEntity();
		double d0 = this.waypointX - this.posX;
		double d1 = this.waypointY - this.posY;
		double d2 = this.waypointZ - this.posZ;
		double d3 = d0 * d0 + d1 * d1 + d2 * d2;

		if(d3 < 1.0D || d3 > 3600.0D)
		{
			this.waypointX = this.posX + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointY = this.posY + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointZ = this.posZ + (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
		}

		if(this.courseChangeCooldown-- <= 0)
		{
			this.courseChangeCooldown += this.rand.nextInt(5) + 2;
			d3 = (double) MathHelper.sqrt_double(d3);

			if(this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
			{
				this.motionX += d0 / d3 * 0.1D;
				this.motionY += d1 / d3 * 0.1D;
				this.motionZ += d2 / d3 * 0.1D;
			}
			else
			{
				this.waypointX = this.posX;
				this.waypointY = this.posY;
				this.waypointZ = this.posZ;
			}
		}

	}

	/**
	 * True if the ghast has an unobstructed line of travel to the waypoint.
	 */
	private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
	{
		double d4 = (this.waypointX - this.posX) / par7;
		double d5 = (this.waypointY - this.posY) / par7;
		double d6 = (this.waypointZ - this.posZ) / par7;
		AxisAlignedBB axisalignedbb = this.boundingBox.copy();

		for(int i = 1; (double) i < par7; ++i)
		{
			axisalignedbb.offset(d4, d5, d6);

			if(! this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
			{
				return false;
			}
		}

		return true;
	}


	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);;
	}
	
	@Override
	public boolean getCanSpawnHere()
	{
		if(this.rand.nextInt(1000) < 20)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
