package arcticraft.main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import arcticraft.entities.AC_EntityIceShard;

public class AC_DamageSource extends DamageSource
{

	public static DamageSource freezing = (new AC_DamageSource("Freezing")).setDamageBypassesArmor();

	protected AC_DamageSource(String par1Str)
	{
		super(par1Str);
	}

	public static DamageSource causeFreezeDamage(EntityLiving par0EntityLiving)
	{
		return new EntityDamageSource("freeze", par0EntityLiving);
	}

	public static DamageSource causeIceShardDamage(AC_EntityIceShard par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("ice shard", par0EntityArrow, par1Entity)).setProjectile();
    }

}
