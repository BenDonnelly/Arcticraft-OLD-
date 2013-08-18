package arcticraft.entities;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import arcticraft.blocks.AC_Block;
import arcticraft.items.AC_Item;

public class AC_EntityCaveman extends EntityMob
{

	Random rand = new Random();
	public boolean collectedReward = false;
	int angerLevel = 0;
	public static boolean isAngry = false;

	public AC_EntityCaveman(World world)
	{
		super(world);
		this.setSize(0.9F, 1.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new AC_EntityAICavemanAttack(this, EntityPlayer.class, 1.0D, false));
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
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0D);
		// Movement Speed 
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{

		int number = rand.nextInt(5 + 1);

		if(! worldObj.isRemote)
		{
			if(collectedReward == false && !isAngry)
			{
				player.addChatMessage("Thankyou for getting me out of there, I don't have much but take this as a reward!");

				if(number == 5)
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.heatPack)));
				}
				else if(number == 4)
				{
					//worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Block.Lantern)));
				}
				else if(number == 3)
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.eriumGem, 10)));
				}
				else if(number == 2)
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.sled)));
				}
				else if(number == 1)
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.boarMeat, 4)));
				}
				else
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.GlacierFruit, 3)));
				}

				collectedReward = true;
				return true;
			}
			if(collectedReward == true)
			{
				if(angerLevel == 0)
				{
					player.addChatMessage("I don't have anything else to give you, sorry");
					angerLevel = 1;
				}
				else if(angerLevel == 1)
				{
					player.addChatMessage("I said I don't have anything else");
					angerLevel = 2;
				}
				else if(angerLevel == 2)
				{
					player.addChatMessage("Go away!");
					angerLevel = 3;
				}
				else if(angerLevel == 3)
				{
					player.addChatMessage("I HAVE NOTHING ELSE");
					angerLevel = 4;
				}
				else if(angerLevel == 4)
				{
					player.addChatMessage("I'll give you one last chance to leave my alone!");
					angerLevel = 5;
				}
				else
				{
					player.addChatMessage("Right, thats it! You're in for it now!");
					isAngry = true;
				}

			}
		}
		return false;
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Reward", this.collectedReward);
		par1NBTTagCompound.setBoolean("isAngry", isAngry);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.collectedReward = par1NBTTagCompound.getBoolean("Reward");
		this.isAngry = par1NBTTagCompound.getBoolean("isAngry");
	}


	
	@Override
	public boolean canDespawn()
	{
		return true;
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

	

}
