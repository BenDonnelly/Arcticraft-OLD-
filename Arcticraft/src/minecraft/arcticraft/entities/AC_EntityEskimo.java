package arcticraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityEskimo extends EntityMob
{

	public AC_EntityEskimo(World par1World)
	{
		super(par1World);
		this.moveSpeed = 0.3F;
		this.texture = "/mods/AC/textures/mobs/eskimo.png";
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));

		
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public int getMaxHealth()
	{
		return 40;
	}

	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

}
