package arcticraft.entities;


import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;

public class AC_EntityPenguin extends EntityAnimal
{

	public AC_EntityPenguin(World world)
	{
		super(world);
		this.texture = "/mods/AC/textures/mobs/penguin.png";
		this.setSize(0.9F, 0.9F); // this sets the hit area of the mob

		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		tasks.addTask(2, new EntityAIMate(this, 0.2F));
		tasks.addTask(3, new EntityAITempt(this, 0.25F, Item.fishRaw.itemID, false));
		tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
		tasks.addTask(5, new EntityAIWander(this, 0.2F));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
		tasks.addTask(7, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound); // this saves the mob to disk
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound); // this loads the mob from disk
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "arcticraft.penguinIdle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{

		return "arcticraft.penguinHurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "arcticraft.penguinDeath";
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	public int getMaxHealth()
	{
		return 10;
	}

	public AC_EntityPenguin func_90012_b(EntityAgeable par1EntityAgeable)
	{
		AC_EntityPenguin entitypenguin = new AC_EntityPenguin(this.worldObj);
		entitypenguin.initCreature();
		return entitypenguin;
	}

	protected void dropFewItems(boolean par1, int par2)
    {
        int var3 = this.rand.nextInt(3 + par2);
        int var4;

        for (var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(MainRegistry.penguinMeat.itemID, 1);
        }

        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(MainRegistry.penguinFeather.itemID, 2);
        }
    }
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
	{
		return this.func_90012_b(par1EntityAgeable);
	}

    public boolean getCanSpawnHere()
    {
		System.out.println("Spawning Penguin");

    	for (int x = 0; x < 16; x++)
    	{
    		for (int y = 0; y < 16; y++)
    		{
    			for (int z = 0; z < 16; z++)
    			{
    				int x1 = MathHelper.floor_double(this.posX + x - 8);
    				int y1 = MathHelper.floor_double(this.posY + y - 8); 
    				int z1 = MathHelper.floor_double(this.posZ + z - 8);
    				
    				if (this.worldObj.getBlockMaterial(x1, y1, z1) == Material.water)
    				{
    					return super.getCanSpawnHere();
    				}
    			}
    		}
    	}
    	
    	return false;
    }
}
