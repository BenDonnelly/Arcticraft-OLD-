package arcticraft.main;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

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

}
