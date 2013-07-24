package arcticraft.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AC_EntityCastleMobDefault extends EntityMob
{

	public AC_EntityCastleMobDefault(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void func_110147_ax()
	{
		super.func_110147_ax();
		// Max Health 
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0D);
		// Follow Range 
		this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
		// Movement Speed 
		   this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30D);	
		// Attack Damage
		this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0D);
	}

	public boolean canDespawn()
	{
		return false;
	}

}
