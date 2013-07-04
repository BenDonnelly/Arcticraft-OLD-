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
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import arcticraft.gui.AC_GuiTraderEskimo;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_EntityTraderEskimo extends EntityMob
{

	private AC_EskimoTrade [] trades = new AC_EskimoTrade [35];

	public AC_EntityTraderEskimo(World par1World)
	{
		super(par1World);
		this.moveSpeed = 0.3F;
		this.texture = "/mods/AC/textures/mobs/eskimo_trader.png";
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.addTrades();
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (player.inventory.hasItem(MainRegistry.eriumGem.itemID))
		{
			FMLClientHandler.instance().displayGuiScreen(player, new AC_GuiTraderEskimo(player.inventory, this));
			return true;
		}
		else
		{
			if (player.worldObj.isRemote)
			{
				player.sendChatToPlayer("You require Erium gems if you want to trade with me");
			}
			return false;
		}
	}

	private void addTrades()
	{
		this.addTrade(0, MainRegistry.bucketEmpty, 3);
		this.addTrade(1, Block.fenceIron, 6, 5);
		this.addTrade(2, MainRegistry.campfire, 2); 
		this.addTrade(3, MainRegistry.boarMeat, 2, 2);
		this.addTrade(4, MainRegistry.floranSeed,  1);
		this.addTrade(5, MainRegistry.frostChest,  2, 1);
		this.addTrade(6, MainRegistry.frostPlanks, 32, 4);
		this.addTrade(7, MainRegistry.emptyCup, 3, 1);
		this.addTrade(8, MainRegistry.GlacianPickaxe, 35);
		this.addTrade(9, MainRegistry.heatPack, 3, 3);
		this.addTrade(10, MainRegistry.hikingBoots, 9);
		this.addTrade(11, MainRegistry.bomb, 4, 20);
		this.addTrade(12, MainRegistry.itemLantern, 1, 3);
		this.addTrade(13, MainRegistry.iceCream, 1, 4, 20);
		this.addTrade(14, MainRegistry.iceCream, 1, 7, 20);
		this.addTrade(15, MainRegistry.iceCream, 1, 2, 20);
		this.addTrade(16, MainRegistry.mysticalSnow, 8, 5);
		this.addTrade(17, MainRegistry.GlacierFruit, 2);
		this.addTrade(18, MainRegistry.ArcticStoneSword, 1);
		this.addTrade(19, MainRegistry.snowPressurePlate, 4, 1);
		this.addTrade(20, MainRegistry.teaDrinks, 1, 1, 2);
		this.addTrade(21, MainRegistry.tekkiteGem, 1, 5);
		this.addTrade(22, MainRegistry.whiteberry, 2, 1);
		this.addTrade(23, Item.cake, 2);
		this.addTrade(24, Block.anvil, 10);
		this.addTrade(25, MainRegistry.TekkiteHelmet, 6);
		this.addTrade(26, Block.jukebox, 5);
		this.addTrade(27, Item.bow, 5);
		this.addTrade(28, Item.bed,	1);
		this.addTrade(29, MainRegistry.frigus, 8, 5);
		this.addTrade(30, MainRegistry.arcticFurnaceIdle, 1);
		this.addTrade(31, Item.enderPearl, 3);
		this.addTrade(32, Item.arrow, 32, 7);
		this.addTrade(33, MainRegistry.EscariaPlate, 5);
		this.addTrade(34, Item.appleRed, 1);
		}

	public void addTrade(int slotIndex, int ID, int amount, int damage, int price)
	{
		int lastID = this.trades.length - 1;
		int index = lastID - MathHelper.clamp_int(slotIndex, 0, lastID);

		if (this.trades [index] != null)
		{
			throw new IllegalArgumentException("Slot " + index + " is already occupied by " + this.trades [index]);
		}
		else
		{
			this.trades [index] = new AC_EskimoTrade(new ItemStack(ID, amount, damage), price);
		}
	}

	public AC_EskimoTrade [] getTrades()
	{
		return this.trades;
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean canDespawn()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	public int getMaxHealth()
	{
		return 40;
	}

	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}

	public void addTrade(int slotIndex, Block block, int amount, int damage, int price)
	{
		this.addTrade(slotIndex, block.blockID, amount, damage, price);
	}

	public void addTrade(int slotIndex, Block block, int amount, int price)
	{
		this.addTrade(slotIndex, block.blockID, amount, 0, price);
	}

	public void addTrade(int slotIndex, Block block, int price)
	{
		this.addTrade(slotIndex, block.blockID, 1, 0, price);
	}

	public void addTrade(int slotIndex, Item item, int amount, int damage, int price)
	{
		this.addTrade(slotIndex, item.itemID, amount, damage, price);
	}

	public void addTrade(int slotIndex, Item item, int amount, int price)
	{
		this.addTrade(slotIndex, item.itemID, amount, 0, price);
	}

	public void addTrade(int slotIndex, Item item, int price)
	{
		this.addTrade(slotIndex, item.itemID, 1, 0, price);
	}

}
