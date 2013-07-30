package arcticraft.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;

public class AC_EntityAICaptainAttack extends EntityAIAttackOnCollide {

	private AC_EntityCaptain captain;
	
	public AC_EntityAICaptainAttack(AC_EntityCaptain captain, Class par2Class, double par3, boolean par5) {
		super(captain, par2Class, par3, par5);
		this.captain = captain;
	}
	
	@Override
	public boolean shouldExecute() {
		return !this.captain.isHookAirBorne() && super.shouldExecute();
	}

}
