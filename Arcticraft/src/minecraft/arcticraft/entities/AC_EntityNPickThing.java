package arcticraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class AC_EntityNPickThing extends EntityThrowable
{
    public AC_EntityNPickThing(World par1World)
    {
        super(par1World);
    }

    public AC_EntityNPickThing(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public AC_EntityNPickThing(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	float f = 4F;
		this.worldObj.createExplosion(null, this.posX , this.posY , this.posZ, f, true);
		
		EntityLightningBolt entitylightningbolt = new EntityLightningBolt(worldObj, this.posX , this.posY , this.posZ);
		
		this.worldObj.spawnEntityInWorld(entitylightningbolt);
    	
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
    
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return 0.0F;
    }
}
