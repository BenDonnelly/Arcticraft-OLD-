package arcticraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class AC_EntityPirateHook extends EntityThrowable {

	public AC_EntityPirateHook(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		
	}

}
