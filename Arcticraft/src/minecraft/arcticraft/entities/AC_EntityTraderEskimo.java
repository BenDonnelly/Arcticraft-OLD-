package arcticraft.entities;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
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
import arcticraft.blocks.AC_Block;
import arcticraft.gui.AC_GuiTraderEskimo;
import arcticraft.items.AC_Item;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_EntityTraderEskimo extends EntityMob
{

	private AC_EskimoTrade [] trades = new AC_EskimoTrade [35];

	public AC_EntityTraderEskimo(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.addTrades();
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if (player.inventory.hasItem(AC_Item.eriumGem.itemID))
		{
			FMLClientHandler.instance().displayGuiScreen(player, new AC_GuiTraderEskimo(player.inventory, this));
			return true;
		}
		else
		{
			if (player.worldObj.isRemote)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage("You require Erium gems if you want to trade with me");
			}
			return false;
		}
	}

	private void addTrades()
	{
		this.addTrade(0, AC_Item.bucketEmpty, 3);
		this.addTrade(1, Block.fenceIron, 6, 5);
		this.addTrade(2, AC_Block.campfire, 2); 
		this.addTrade(3, AC_Item.boarMeat, 2, 2);
		this.addTrade(4, AC_Item.floranSeed,  1);
		this.addTrade(5, AC_Block.frostChest,  2, 1);
		this.addTrade(6, AC_Block.frostPlanks, 32, 4);
		this.addTrade(7, AC_Item.emptyCup, 3, 1);
		this.addTrade(8, AC_Item.GlacianPickaxe, 35);
		this.addTrade(9, AC_Item.heatPack, 3, 3);
		this.addTrade(10, AC_Item.hikingBoots, 9);
		this.addTrade(11, AC_Item.bomb, 4, 20);
		this.addTrade(12, AC_Item.itemLantern, 1, 3);
		this.addTrade(13, AC_Item.iceCream, 1, 4, 20);
		this.addTrade(14, AC_Item.iceCream, 1, 7, 20);
		this.addTrade(15, AC_Item.iceCream, 1, 2, 20);
		this.addTrade(16, AC_Block.mysticalSnow, 8, 5);
		this.addTrade(17, AC_Item.GlacierFruit, 2);
		this.addTrade(18, AC_Item.ArcticStoneSword, 1);
		this.addTrade(19, AC_Block.snowPressurePlate, 4, 1);
		this.addTrade(20, AC_Item.teaDrinks, 1, 1, 2);
		this.addTrade(21, AC_Item.tekkiteGem, 1, 5);
		this.addTrade(22, AC_Block.whiteberry, 2, 1);
		this.addTrade(23, Item.cake, 2);
		this.addTrade(24, Block.anvil, 10);
		this.addTrade(25, AC_Item.TekkiteHelmet, 6);
		this.addTrade(26, Block.jukebox, 5);
		this.addTrade(27, Item.bow, 5);
		this.addTrade(28, Item.bed,	1);
		this.addTrade(29, AC_Item.frigus, 8, 5);
		this.addTrade(30, AC_Block.arcticFurnaceIdle, 1);
		this.addTrade(31, Item.enderPearl, 3);
		this.addTrade(32, Item.arrow, 32, 7);
		this.addTrade(33, AC_Item.EscariaPlate, 5);
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
