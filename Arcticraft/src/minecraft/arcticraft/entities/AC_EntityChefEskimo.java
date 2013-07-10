package arcticraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityChefEskimo extends AC_EntityDefaultEskimo
{

	public AC_EntityChefEskimo(World par1World)
	{
		super(par1World);
		this.texture = "/mods/AC/textures/mobs/eskimo_chef.png";
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
