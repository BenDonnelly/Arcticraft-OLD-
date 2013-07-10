package arcticraft.entities;

import java.util.Random;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;

public class AC_EntityCaptain extends EntityMob implements AC_IBossDisplayData {

	private static final IEntitySelector attackEntitySelector = null;

	public int deathTicks = 0;
	World theWorld;
	Random rand = new Random();
	public String[] bossName = { "Caladan", "Arthen", "Farem", "Thoran", "Icyrus", "Meznar", "Kefadan", "Lonleh", "Ladur", "Brens", "Petern", "Cevan", "Tob" };
	public String chooseBossName = bossName[rand.nextInt(bossName.length)];

	public AC_EntityCaptain(World par1World) {
		super(par1World);
		this.setEntityHealth(this.getMaxHealth());
		this.setSize(this.width, this.height + 0.4F);
		this.texture = "/mods/AC/textures/mobs/captain.png";
		this.moveSpeed = 0.4F;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
		this.experienceValue = 50;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (par1Entity instanceof EntityLiving) {
				int b0 = 0;

				b0 = this.getAttackStrength(this);
				((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));

			}

			return true;
		} else {
			return false;
		}
	}

	public int func_82212_n() {
		return this.dataWatcher.getWatchableObjectInt(8);
	}

	public void func_82215_s(int par1) {
		this.dataWatcher.updateObject(8, Integer.valueOf(par1));
	}

	public void onLivingUpdate() {

		if (!this.worldObj.isRemote) {
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		}

		super.onLivingUpdate();

	}

	public ItemStack getHeldItem() {
		return new ItemStack(MainRegistry.pirateSword, 1);
	}

	public void func_82206_m() {
		this.func_82215_s(220);
		this.setEntityHealth(this.getMaxHealth() / 3);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(0));
		this.dataWatcher.addObject(19, new Integer(0));
		this.dataWatcher.addObject(20, new Integer(0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Invul", this.func_82212_n());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.func_82215_s(par1NBTTagCompound.getInteger("Invul"));
		this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
	}

	@Override
	public int getMaxHealth() {
		return 250;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(MainRegistry.pirateSword.itemID, 1);
		this.dropItem(MainRegistry.captainStatue.blockID, 1);
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	public int getAttackStrength(Entity par1Entity) {
		return 8;
	}

	public boolean canDespawn() {
		return false;
	}

	public String getEntityName() {
		return chooseBossName + ", the Captain";
	}

	public boolean isMiniBoss() {
		return true;
	}

	@Override
	public int getBossHealth() {
		return this.dataWatcher.getWatchableObjectInt(16);
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

}
