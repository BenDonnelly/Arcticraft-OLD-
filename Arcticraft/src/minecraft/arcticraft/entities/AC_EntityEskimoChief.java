package arcticraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import arcticraft.gui.AC_GuiEskimoTalk;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_EntityEskimoChief extends EntityAnimal
{

	public AC_EntityEskimoChief(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));

	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	public boolean interact(EntityPlayer plyer)
	{
		if(!AC_GuiEskimoTalk.hasCollectedReward)
		{
			FMLClientHandler.instance().displayGuiScreen(plyer, new AC_GuiEskimoTalk());
		}
		else
		{
			if(!this.worldObj.isRemote)
			{
				plyer.addChatMessage("You are our hero!");

			}
		}
		return true;
	}


	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

}
