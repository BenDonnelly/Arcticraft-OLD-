package arcticraft.entities;

import java.util.Random;

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

	private AC_EskimoTrade[] trades = new AC_EskimoTrade[35];
	
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
	public boolean interact(EntityPlayer player) {
		if (player.inventory.hasItem(MainRegistry.eriumGem.itemID)) {
			FMLClientHandler.instance().displayGuiScreen(player, new AC_GuiTraderEskimo(player.inventory, this));
			return true;
		}
		else {
			if (player.worldObj.isRemote) {
				player.sendChatToPlayer("You require Erium gems if you want to trade with me");
			}
			return false;
		}
	}
	
	private void addTrades() {
		for (int i = 0; i < this.trades.length; i++) {
			Random rand = new Random();
			
			this.addTrade(i, i + 1, rand.nextInt(64) + 1, 0, rand.nextInt(64) + 1);
		}
	}
	
	public void addTrade(int slotIndex, int ID, int amount, int damage, int price) {
		int lastID = this.trades.length - 1;
		int index = lastID - MathHelper.clamp_int(slotIndex, 0, lastID);
		
		if (this.trades[index] != null) {
			throw new IllegalArgumentException("Slot " + index + " is already occupied by " + this.trades[index]);
		}
		else {
			this.trades[index] = new AC_EskimoTrade(new ItemStack(ID, amount, damage), price);
		}
	}
	
	public AC_EskimoTrade[] getTrades() {
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
	
	public void addTrade(int slotIndex, Block block, int amount, int damage, int price) {
		this.addTrade(slotIndex, block.blockID, amount, damage, price);
	}
	
	public void addTrade(int slotIndex, Block block, int amount, int price) {
		this.addTrade(slotIndex, block.blockID, amount, 0, price);
	}
	
	public void addTrade(int slotIndex, Block block, int price) {
		this.addTrade(slotIndex, block.blockID, 1, 0, price);
	}
	
	public void addTrade(int slotIndex, Item item, int amount, int damage, int price) {
		this.addTrade(slotIndex, item.itemID, amount, damage, price);
	}
	
	public void addTrade(int slotIndex, Item item, int amount, int price) {
		this.addTrade(slotIndex, item.itemID, amount, 0, price);
	}
	
	public void addTrade(int slotIndex, Item item, int price) {
		this.addTrade(slotIndex, item.itemID, 1, 0, price);
	}

}
