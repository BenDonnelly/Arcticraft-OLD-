package arcticraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AC_EntityCaveman extends EntityAnimal
{

	public AC_EntityCaveman(World world)
	{
		super(world);
		this.setSize(0.9F, 1.9F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));

	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void func_110147_ax()
	{
		super.func_110147_ax();
		// Max Health 
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0D);
		// Movement Speed 
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{

		if(! worldObj.isRemote)
		{
			player.addChatMessage("Thankyou for getting me out of there, I don't have much but take this as a reward");
			//TODO add packet for sending erium 
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getLivingSound()
	{
		return "";
	}

	@Override
	public String getHurtSound()
	{
		return "";
	}

	@Override
	public String getDeathSound()
	{
		return "";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}
