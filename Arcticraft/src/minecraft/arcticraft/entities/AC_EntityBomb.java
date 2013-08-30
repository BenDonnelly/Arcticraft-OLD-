package arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class AC_EntityBomb extends EntityThrowable
{

	public AC_EntityBomb(World var1)
	{
		super(var1);
	}

	public AC_EntityBomb(World var1, EntityLivingBase var2)
	{
		super(var1, var2);
	}

	public AC_EntityBomb(World var1, double var2, double var4, double var6)
	{
		super(var1, var2, var4, var6);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition var1)
	{
		if(var1.entityHit != null)
		{
			byte var2 = 0;
			if(var1.entityHit instanceof EntityBlaze)
			{
				var2 = 3;
			}
			if(! var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2))
			{
				;
			}
		}
		for(int var3 = 0; var3 < 8; ++var3)
		{
			//this.worldObj.spawnParticle("none", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		if(! this.worldObj.isRemote)
		{
			this.setDead();
			if(! this.worldObj.isRemote)
			{
			///	this.worldObj.createExplosion((Entity) null, this.posX, this.posY, this.posZ, 2.5F, true);
			}
		}
	}

}
