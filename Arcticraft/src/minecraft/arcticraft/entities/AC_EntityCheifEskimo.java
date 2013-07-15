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

public class AC_EntityCheifEskimo extends EntityAnimal
{

	public AC_EntityCheifEskimo(World par1World)
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

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		FMLClientHandler.instance().displayGuiScreen(par1EntityPlayer, new AC_GuiEskimoTalk());
		System.out.println("Opening the eskimo talking sequence...");
		return true;
	}
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public int getMaxHealth()
	{
		return 1000;
	}

	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

}
