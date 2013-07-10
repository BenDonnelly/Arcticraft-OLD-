package arcticraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityHunterEskimo extends AC_EntityDefaultEskimo
{

	public AC_EntityHunterEskimo(World par1World)
	{
		super(par1World);
		this.texture = "/mods/AC/textures/mobs/eskimo_hunter.png";
		this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AC_EntityBoar.class, 16.0F, 0, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, AC_EntityPenguin.class, 16.0F, 0, true));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, AC_EntityPenguin.class, this.moveSpeed, false));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, AC_EntityBoar.class, this.moveSpeed, false));
		this.tasks.addTask(10, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
	}
	
	static
	{
		addStuffToBuy(Block.stone, 5, 46, 0.5F);
		addStuffToBuy(Block.dirt, 10, 20, 0.3F);
		addStuffToBuy(Item.stick, 12, 54, 0.6F);
		addStuffToSell(Block.blockGold, 2, 6, 0.8F);
		addStuffToSell(Item.emerald, 1, 1, 0.99F);
	}

}
