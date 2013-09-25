package arcticraft.entities;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
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

	private Random rand = new Random();
	private boolean collectedReward = false;
	private int angerLevel = 0;
	private static final ItemStack[] rewards = new ItemStack[] {new ItemStack(AC_Item.boarMeat, 4) , new ItemStack(AC_Item.sled) , new ItemStack(AC_Item.eriumGem, 10) , new ItemStack(AC_Item.lantern) , new ItemStack(AC_Item.heatPack)};

	private String[][] messages = {

			{"WOOO, Im out! Here take this!" , "Finally i'm out, it's been " + rand.nextInt(20000 - 1000 + 1) + " centuries. I suppose you can take this as a reward" , "Thank you for getting me out of there, take this as a token of my gratitude" ,
					"I can't believe it! Im actually out! I suppose you expect something now, well, this is all I have"} ,

			{"You're just going to give me it? just like that? From this day fourth, you are the one I answer to" , "This is what I've been searching for my entire life! I can never give something back which is equally amazing as this is, but if you need anything just ask!" ,
					"It's glorious! Its all that I imagined and more. I can't re-pay you back fully, but I'll do anything you want"} ,

			{"I don't have anything else to give you, sorry" , "I said I don't have anything else" , "Go away!" , "I HAVE NOTHING ELSE" , "I'll give you one last chance to leave me alone!"}

	};

	public AC_EntityCaveman(World world)
	{
		super(world);
		this.setSize(0.9F, 1.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
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
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
		// Movement Speed 
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
		//Attack damage
		this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);

	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack hand = player.inventory.getCurrentItem();

		int number = rand.nextInt(6);

		if(! worldObj.isRemote)
		{

			if(collectedReward == false )
			{

				player.addChatMessage(messages[0][rand.nextInt(messages.length)]);

				if(number < rewards.length)
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, rewards[number]));
				}
				else
				{
					worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(AC_Item.GlacierFruit, 3)));
				}

				collectedReward = true;
				return true;
			}
		}

		if(collectedReward)
		{
			if(angerLevel >= 0 && angerLevel < 5)
			{
				player.addChatMessage(messages[2][angerLevel]);
				if(angerLevel < 6)
				{
					++angerLevel;
					this.cavemanTameEffect(false);
				}
			}
			else
			{
				player.addChatMessage("Right, thats it! You're in for it now!");
				setAttackTarget(player);
			}
		}
		return super.interact(player);

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Reward", this.collectedReward);
		par1NBTTagCompound.setInteger("angerLevel", this.angerLevel);

	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.collectedReward = par1NBTTagCompound.getBoolean("Reward");
		this.angerLevel = par1NBTTagCompound.getInteger("angerLevel");
	}

	private void cavemanTameEffect(boolean par1)
	{
		String type = par1 ? "heart" : "smoke";

		for(int i = 0; i < 7; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			Minecraft.getMinecraft().theWorld.spawnParticle(type, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F)
					- (double) this.width, d0, d1, d2);
		}
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
		int var4;

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Block.acWaterIce.blockID, 3);
		}

		var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(AC_Item.woodenClub.itemID, 1);
		}
	}

	
	public ItemStack getHeldItem()
	{
		return new ItemStack(AC_Item.woodenClub);
	}
	
	protected int getDropItemId()
	{
		return 0;
	}

	@Override
	public boolean canDespawn()
	{
		return true;
	}

	@Override
	public String getLivingSound()
	{
		return "ac:mobs.caveman_living";
	}

	@Override
	public String getHurtSound()
	{
		return "ac:mobs.caveman_hurt";
	}

	@Override
	public String getDeathSound()
	{
		return "ac:mobs.caveman_death";
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.7F;
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("ac:mobs.caveman_footstep", 0.15F, 0.6F);
	}
}
