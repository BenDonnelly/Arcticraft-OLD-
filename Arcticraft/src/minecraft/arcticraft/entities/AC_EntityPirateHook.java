package arcticraft.entities;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import arcticraft.lib.Strings;

public class AC_EntityPirateHook extends EntityThrowable {
	
	public AC_EntityCaptain captain;
	
	public AC_EntityPirateHook(World par1World) {
		super(par1World);
	}
	
	public AC_EntityPirateHook(World par1World, AC_EntityCaptain captain) {
		super(par1World, captain);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if (mov.entityHit != null && mov.entityHit instanceof EntityLivingBase) {
			EntityLivingBase entityHit = (EntityLivingBase) mov.entityHit;
			double d0 = this.getThrower().posX - this.posX;
            double d1 = this.getThrower().posY - this.posY;
            double d2 = this.getThrower().posZ - this.posZ;
            double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
            double d4 = 0.5D;
            entityHit.motionX += d0 * d4;
            entityHit.motionY += d1 * d4 + (double)MathHelper.sqrt_double(d3) * 0.2D;
            entityHit.motionZ += d2 * d4;
            
            entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 1.0F);
            entityHit.addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 10));
            entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 10));
        }
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
	
	@Override
	protected float getGravityVelocity() {
        return 0.2F;
    }
	
	@Override
	protected float func_70182_d() {
        return 2.0F;
    }
	
	@Override
	public AC_EntityCaptain getThrower() {
        return (AC_EntityCaptain) super.getThrower();
    }

}
