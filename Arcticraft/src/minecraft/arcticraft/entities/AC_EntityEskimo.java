package arcticraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AC_EntityEskimo extends AC_EntityDefaultEskimo
{

	public AC_EntityEskimo(World par1World)
	{
		super(par1World);
		this.texture = "/mods/AC/textures/mobs/eskimo.png";
		this.setSize(1.5F, 1.4F);
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
