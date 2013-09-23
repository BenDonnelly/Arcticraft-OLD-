package arcticraft.entities;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;
import arcticraft.lib.Strings;

public class AC_EntityCaptain extends EntityMob implements AC_IBossDisplayData, IRangedAttackMob
{

	public final static String[] bossNames = {"Caladan" , "Arthen" , "Farem" , "Thoran" , "Icyrus" , "Meznar" , "Kefadan" , "Lonleh" , "Ladur" , "Brens" , "Petern" , "Cevan" , "Tob"};
	private final String bossName;
	public final int hookAnimationTime = 20;
	public final int maxHookCooldown = 120;
	private int hookCooldown;
	private boolean isHookAirBorne;
	
	public AC_EntityCaptain(World par1World)
	{
		super(par1World);
		this.setEntityHealth(this.func_110138_aP());
		this.setSize(this.width, this.height + 0.4F);
		this.setAIMoveSpeed(0.2F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new AC_EntityAIHookAttack(this, 1.0D, 16.0F));
		this.tasks.addTask(2, new AC_EntityAICaptainAttack(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.experienceValue = 50;
		this.hookCooldown = this.maxHookCooldown;
		this.bossName = bossNames[this.worldObj.rand.nextInt(bossNames.length)];
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void func_82206_m()
	{
		this.func_82215_s(220);
		this.setEntityHealth(this.func_110138_aP() / 3.0F);
	}

	public void func_82215_s(int par1)
	{
		this.dataWatcher.updateObject(8, Integer.valueOf(par1));
	}

	public void onLivingUpdate()
	{

		if(!this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Float.valueOf(this.func_110143_aJ()));
		}
		
		if (this.hookCooldown > 0) {
			this.hookCooldown--;
		}
		else if (this.hookCooldown == 0) {
			this.prepareHookAttack();
		}
		
		super.onLivingUpdate();

	}
	
	private void prepareHookAttack() {
		this.hookCooldown = -1;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(0));
		this.dataWatcher.addObject(19, new Integer(0));
		this.dataWatcher.addObject(20, new Integer(0));
	}

	protected void func_110147_ax()
	{
		super.func_110147_ax();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(275.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.36000000417232513D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0D);
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if(super.attackEntityAsMob(par1Entity))
		{
			if(par1Entity instanceof EntityLivingBase)
			{
				((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 120, 0));
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	public ItemStack getHeldItem()
	{
		return new ItemStack(AC_Item.pirateSword, 1);
	}
	
	public ItemStack getHookItem()
	{
		return new ItemStack(AC_Item.pirateHook, 1);
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(AC_Item.pirateSword.itemID, 1);
		this.dropItem(AC_Block.captainStatue.blockID, 1);
		this.dropItem(AC_Item.captainLog.itemID, 1);
	}

	public boolean canDespawn()
	{
		return false;
	}

	public String getEntityName()
	{
		return "Captain " + this.bossName;
	}

	public boolean isMiniBoss()
	{
		return true;
	}
	
	public boolean canBeCollidedWith()
	{
		return ! this.isDead;
	}
	
	public boolean isAboutToThrowHook() {
		return this.hookCooldown == -1;
	}
	
	public boolean isHookAirBorne() {
		return this.isHookAirBorne;
	}
	
	public void setHookAirBorne(boolean bool) {
		this.isHookAirBorne = bool;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
		AC_EntityPirateHook hook = new AC_EntityPirateHook(this.worldObj, this);
		double rotation = (this.rotationYaw + 70.0F) / (180.0F / Math.PI);
		double hookLaunchX = Math.cos(rotation);
		double hookLaunchY = 1.4D;
		double hookLaunchZ = Math.sin(rotation);
		hook.setLocationAndAngles(this.posX + hookLaunchX, this.posY + hookLaunchY, this.posZ + hookLaunchZ, this.rotationYaw, this.rotationPitch);
		
		double dx = target.posX - hook.posX;
        double dy = target.posY + (double)target.getEyeHeight() - 1.1D - hook.posY;
        double dz = target.posZ - hook.posZ;
        float f1 = MathHelper.sqrt_double(dx * dx + dz * dz) * 0.4F;
        hook.setThrowableHeading(dx, dy + (double)f1, dz, hook.func_70182_d(), 1.0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        
        this.worldObj.spawnEntityInWorld(hook);
		
		int captainId = this.entityId;
		int hookId = hook.entityId;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try
		{
			outputStream.writeInt(captainId);
			outputStream.writeInt(hookId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Strings.CHANNEL_ROPE_POSITION;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		((WorldServer) this.worldObj).getEntityTracker().sendPacketToAllPlayersTrackingEntity(hook, packet);
		
        this.hookCooldown = this.maxHookCooldown;
        this.isHookAirBorne = true;
	}
}
