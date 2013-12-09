package arcticraft.entities;

import java.util.List;
import java.util.UUID;

import arcticraft.items.AC_Item;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class AC_EntityMiner extends AC_EntityCastleMobDefault
{

	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.28D, 0)).func_111168_a(false);

	/** Above zero if this Miner is Angry. */
	private int angerLevel = 0;

	/** A random delay until this Miner next makes a sound. */
	private int randomSoundDelay = 0;
	private Entity field_110191_bu;
	
	public AC_EntityMiner(World par1World)
	{
		super(par1World);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		if(this.field_110191_bu != this.entityToAttack && ! this.worldObj.isRemote)
		{
			AttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.field_111263_d);
			attributeinstance.func_111124_b(field_110190_br);

			if(this.entityToAttack != null)
			{
				attributeinstance.func_111121_a(field_110190_br);
			}
		}

		this.field_110191_bu = this.entityToAttack;

		if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
		{
			this.playSound("", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
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

					if(entity1 instanceof AC_EntityMiner)
					{
						AC_EntityMiner AC_EntityMiner = (AC_EntityMiner) entity1;
						AC_EntityMiner.becomeAngryAt(entity);
					}
				}

				this.becomeAngryAt(entity);
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	/**
	 * Causes this Miner to become angry at the supplied Entity (which will be a player).
	 */
	private void becomeAngryAt(Entity par1Entity)
	{
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}
	
	public ItemStack getHeldItem()
	{
		return new ItemStack(AC_Item.notchedPickaxe, 1);
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
		int var4;

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.eriumGem.itemID, 3);
		}

		var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.rigentemIngot.itemID, 2);
		}
	}

	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(AC_Item.notchedPickaxe, 1), 0.0F);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return null;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		return null;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return null;
	}

}

