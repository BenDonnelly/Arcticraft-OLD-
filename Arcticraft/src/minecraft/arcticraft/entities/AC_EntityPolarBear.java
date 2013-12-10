package arcticraft.entities;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;

public class AC_EntityPolarBear extends EntityMob
{

	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.45D, 0)).setSaved(false);

	/** Above zero if this PolarBear is Angry. */
	private int angerLevel = 0;

	/** A random delay until this PolarBear next makes a sound. */
	private int randomSoundDelay = 0;
	private Entity field_110191_bu;

	public AC_EntityPolarBear(World par1World)
	{
		super(par1World);
		this.setSize(1.9F, 1.8F);

	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled()
	{
		return false;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(25.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.699D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		if(this.field_110191_bu != this.entityToAttack && ! this.worldObj.isRemote)
		{
			AttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			attributeinstance.removeModifier(field_110190_br);

			if(this.entityToAttack != null)
			{
				attributeinstance.applyModifier(field_110190_br);
			}
		}

		this.field_110191_bu = this.entityToAttack;

		if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
		{
			this.playSound("ac:mobs.bear_angry", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}

		super.onUpdate();
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
	 * Called when the entity is attacked.
	 */
	/**
	* Called when the entity is attacked.
	*/
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if(this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = par1DamageSource.getEntity();

			if(entity instanceof EntityPlayer)
			{
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

				for(int i = 0; i < list.size(); ++i)
				{
					Entity entity1 = (Entity) list.get(i);

					if(entity1 instanceof AC_EntityPolarBear)
					{
						AC_EntityPolarBear AC_EntityPolarBear = (AC_EntityPolarBear) entity1;
						AC_EntityPolarBear.becomeAngryAt(entity);
					}
				}

				this.becomeAngryAt(entity);
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	/**
	 * Causes this PigZombie to become angry at the supplied Entity (which will be a player).
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
		return "ac:mobs.bear_idle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "ac:mobs.bear_hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "ac:mobs.bear_death";
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
		int var4;

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.penguinMeat.itemID, 1);
		}

		var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(Item.fishRaw.itemID, 1);
		}
	}

}
