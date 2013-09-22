package arcticraft.entities;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
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
	
	@SideOnly(Side.CLIENT)
	private AC_EntityCaptain captain;
	
	public AC_EntityPirateHook(World par1World) {
		super(par1World);
	}
	
	public AC_EntityPirateHook(World par1World, AC_EntityCaptain captain) {
		super(par1World, captain);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (this.ticksExisted > 100) {
			this.setDead();
		}
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if (mov.entityHit != null && mov.entityHit instanceof EntityLivingBase && this.getThrower() != null) {
			EntityLivingBase entityHit = (EntityLivingBase) mov.entityHit;
			double d0 = this.getThrower().posX - this.posX;
            double d1 = this.getThrower().posY - this.posY;
            double d2 = this.getThrower().posZ - this.posZ;
            double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
            double d4 = 0.5D;
            entityHit.motionX += d0 * d4;
            entityHit.motionY += d1 * d4 + (double)MathHelper.sqrt_double(d3) * 0.3D;
            entityHit.motionZ += d2 * d4;
            
            entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
            entityHit.addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 10));
            entityHit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 10));
        }
		
		Minecraft.getMinecraft().sndManager.stopEntitySound(this.getThrower());
		this.playSound("ac:mobs.captain_ting", 0.5F, 1.0F / (this.worldObj.rand.nextFloat() * 0.4F + 0.8F));
		this.setDead();
	}
	
	@Override
	protected float getGravityVelocity() {
        return 0.03F;
    }
	
	@Override
	protected float func_70182_d() {
        return 0.8F;
    }
	
	@Override
	public void setDead() {
		if (this.getThrower() != null) {
			this.getThrower().setHookAirBorne(false);
		}
		
		super.setDead();
	}
	
	@Override
	public AC_EntityCaptain getThrower() {
        return this.worldObj.isRemote ? this.captain : (AC_EntityCaptain) super.getThrower();
    }
	
	@SideOnly(Side.CLIENT)
	public void setThrower(AC_EntityCaptain captain) {
		this.captain = captain;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		this.setDead();
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		
	}

}
