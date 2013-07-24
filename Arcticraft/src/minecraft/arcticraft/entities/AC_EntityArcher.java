package arcticraft.entities;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;

public class AC_EntityArcher extends EntityMob implements IRangedAttackMob
{

	private AC_EntityAIIceShard aiArrowAttack = new AC_EntityAIIceShard(this, 1.0D, 20, 60, 15.0F);

	public AC_EntityArcher(World par1World)
	{
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		if(par1World != null && ! par1World.isRemote)
		{
			this.setCombatTask();
		}
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

	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte) 0));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
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

	/**
	 * Makes entity wear random armor based on difficulty
	 */
	protected void addRandomArmor()
	{
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(AC_Item.archerBow));
	}

	public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.func_110161_a(par1EntityLivingData);

		this.tasks.addTask(4, this.aiArrowAttack);
		this.addRandomArmor();
		this.enchantEquipment();

		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_110746_b(this.posX, this.posY, this.posZ));

		if(this.getCurrentItemOrArmor(4) == null)
		{
			Calendar calendar = this.worldObj.getCurrentDate();

			if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern : Block.pumpkin));
				this.equipmentDropChances[4] = 0.0F;
			}
		}

		return par1EntityLivingData;
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void setCombatTask()
	{

		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();

		if(itemstack != null && itemstack.itemID == AC_Item.archerBow.itemID)
		{
			this.tasks.addTask(4, this.aiArrowAttack);
		}

	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		AC_EntityIceShard iceshard = new AC_EntityIceShard(this.worldObj, this, par1EntityLivingBase, 1.6F, (float) (14 - this.worldObj.difficultySetting * 4));
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		iceshard.setDamage((double) (par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double) ((float) this.worldObj.difficultySetting * 0.11F));

		if(i > 0)
		{
			iceshard.setDamage(iceshard.getDamage() + (double) i * 0.5D + 0.5D);
		}

		if(j > 0)
		{
			iceshard.setKnockbackStrength(j);
		}

		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0)
		{
			iceshard.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(iceshard);
	}

	/**
	 * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
	 */
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
	{
		super.setCurrentItemOrArmor(par1, par2ItemStack);

		if(! this.worldObj.isRemote && par1 == 0)
		{
			this.setCombatTask();
		}
	}

	/**
	 * Returns the Y Offset of this entity.
	 */
	public double getYOffset()
	{
		return super.getYOffset() - 0.5D;
	}
}
