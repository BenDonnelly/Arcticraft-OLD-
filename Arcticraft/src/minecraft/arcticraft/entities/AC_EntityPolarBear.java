package arcticraft.entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityPolarBear extends EntityMob
{

	/** Above zero if this PolarBear is Angry. */
	private int angerLevel = 0;

	/** A random delay until this PolarBear next makes a sound. */
	private int randomSoundDelay = 0;

	public AC_EntityPolarBear(World par1World)
	{
		super(par1World);
		this.texture = "/mods/AC/textures/mobs/polar_bear.png";
		this.moveSpeed = 0.4F;
		this.setSize(1.9F, 1.8F);
		this.tasks.addTask(0, new EntityAIWander(this, 0.5F));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, AC_EntityPenguin.class, 16.0F, 0, true));

	}

	public int getMaxHealth()
	{
		return 13;
	}

	public int attackStrenght(Entity par1Entity)
	{
		return 6;
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return false;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		this.moveSpeed = this.entityToAttack != null ? 0.95F : 0.5F;

		if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
		{
			double x = 0;
			double y = 0;
			double z = 0;
			worldObj.playSoundEffect(x, y, z, "arcticraft.bearAngry", 1.0F, 1.0F);
		}

		super.onUpdate();
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere()
	{
		return this.worldObj.difficultySetting > 0 && this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Anger", (short) this.angerLevel);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		Entity var3 = par1DamageSource.getEntity();

		if (var3 instanceof EntityPlayer)
		{
			List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

			for (int var5 = 0; var5 < var4.size(); ++var5)
			{
				Entity var6 = (Entity) var4.get(var5);

				if (var6 instanceof AC_EntityPolarBear)
				{
					AC_EntityPolarBear var7 = (AC_EntityPolarBear) var6;
					var7.becomeAngryAt(var3);
				}
			}

			this.becomeAngryAt(var3);
		}

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	/**
	 * Causes this PigZombie to become angry at the supplied Entity (which will
	 * be a player).
	 */
	private void becomeAngryAt(Entity par1Entity)
	{
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "arcticraft.bearIdle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "arcticraft.bearHurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "arcticraft.bearDeath";
	}

}
