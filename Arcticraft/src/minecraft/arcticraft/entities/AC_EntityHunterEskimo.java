package arcticraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AC_EntityHunterEskimo extends AC_EntityDefaultEskimo
{

	public AC_EntityHunterEskimo(World par1World)
	{
		super(par1World);
		this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AC_EntityBoar.class, 16, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, AC_EntityPenguin.class, 16, true));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, AC_EntityPenguin.class, 1.0D, false));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, AC_EntityBoar.class, 1.0D, false));
	      this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
	}
	
	static
	{
		addStuffToBuy(Block.stone, 5, 46, 0.5F);
		addStuffToBuy(Block.dirt, 10, 20, 0.3F);
		addStuffToBuy(Item.stick, 12, 54, 0.6F);
		addStuffToSell(Block.blockGold, 2, 6, 0.8F);
		addStuffToSell(Item.emerald, 1, 1, 0.99F);
	}

	@Override
	public void func_110297_a_(ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}

}
