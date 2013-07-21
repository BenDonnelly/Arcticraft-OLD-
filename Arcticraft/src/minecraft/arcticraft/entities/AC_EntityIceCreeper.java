package arcticraft.entities;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_EntityIceCreeper extends EntityCreeper implements IRangedAttackMob
{

	/**
	 * Time when this creeper was last in an active state (Messed up code here,
	 * probably causes creeper animation to go weird)
	 */
	private int lastActiveTime;

	/**
	 * The amount of time since the creeper was close enough to the player to
	 * ignite
	 */
	private int timeSinceIgnited;

	private int fuseTime = 35;

	private AC_EntityAIIceShard aiIceShardAttack = new AC_EntityAIIceShard(this, 1.0D, 20, 60, 15.0F);

	/** Explosion radius for this creeper. */
	private int explosionRadius = 3;

	public AC_EntityIceCreeper(World par1World)
	{
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAICreeperSwell(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
		this.tasks.addTask(5, new EntityAIWander(this, 0.2F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(7, new AC_EntityAIIceShard(this, 1.0D, 20, 60, 15.0F));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void setCombatTask()
	{

		this.tasks.removeTask(this.aiIceShardAttack);
		ItemStack itemstack = this.getHeldItem();

		if(itemstack != null && itemstack.itemID == Item.bow.itemID)
		{
			this.tasks.addTask(4, this.aiIceShardAttack);
		}
	}

	public void initCreature()
	{
		this.tasks.addTask(4, this.aiIceShardAttack);
		this.addRandomArmor();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		if(this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;
			int i = this.getCreeperState();

			if(i > 0 && this.timeSinceIgnited == 0)
			{
				this.playSound("random.fuse", 1.0F, 0.5F);
			}

			this.timeSinceIgnited += i;

			if(this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}

			if(this.timeSinceIgnited >= this.fuseTime)
			{
				this.timeSinceIgnited = this.fuseTime;

				if(! this.worldObj.isRemote)
				{
					boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

					if(this.getPowered())
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) (this.explosionRadius * 2), flag);
					}
					else
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius, flag);

					}

					this.setDead();
				}
			}
		}

		super.onUpdate();
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.creeper.say";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return Item.gunpowder.itemID;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		AC_EntityIceShard AC_EntityIceShard = new AC_EntityIceShard(this.worldObj, par1EntityLivingBase, par2);
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		AC_EntityIceShard.setDamage((double) (par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double) ((float) this.worldObj.difficultySetting * 0.11F));

		if(i > 0)
		{
			AC_EntityIceShard.setDamage(AC_EntityIceShard.getDamage() + (double) i * 0.5D + 0.5D);
		}

		if(j > 0)
		{
			AC_EntityIceShard.setKnockbackStrength(j);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(AC_EntityIceShard);
	}

}
