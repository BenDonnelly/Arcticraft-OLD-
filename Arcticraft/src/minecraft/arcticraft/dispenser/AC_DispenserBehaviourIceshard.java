package arcticraft.dispenser;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityIceShard;

final class AC_DispenserBehaviorIceshard extends BehaviorProjectileDispense
{

	/**
	 * Return the projectile entity spawned by this dispense behavior.
	 */
	protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition)
	{
		AC_EntityIceShard iceshard = new AC_EntityIceShard(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
		iceshard.canBePickedUp = 1;
		return iceshard;
	}
}
