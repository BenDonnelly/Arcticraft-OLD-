package com.arcticraft.entity.mob;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import com.arcticraft.item.AC_Item;

public abstract class AC_EntityEskimoDefault extends EntityMob implements IMerchant {

	private EntityPlayer buyingPlayer;
	private MerchantRecipeList currentBuyingList;
	private String lastBuyingPlayer;
	private int timeUntilReset;
	private boolean needsInitilization;
	private float stock;

	public static final Map stockList = new HashMap();
	public static final Map rarityStockList = new HashMap();

	public static final Map buyingList = new HashMap();
	public static final Map rarityBuyingList = new HashMap();

	public AC_EntityEskimoDefault(World par1World) {
		super(par1World);
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);

		if (this.currentBuyingList != null) {
			par1NBTTagCompound.setTag("Offers", this.currentBuyingList.getRecipiesAsTags());
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("Offers")) {
			NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
			this.currentBuyingList = new MerchantRecipeList(nbttagcompound1);
		}
	}

	@Override
	public String getLivingSound() {
		return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
	}

	@Override
	public String getHurtSound() {
		return "mob.villager.hit";
	}

	@Override
	public String getDeathSound() {
		return "mob.villager.death";
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	protected void updateAITick() {
		if (!this.isTrading() && this.timeUntilReset > 0) {
			--this.timeUntilReset;

			if (this.timeUntilReset <= 0) {
				if (this.needsInitilization) {
					if (this.buyingList.size() > 1) {
						Iterator iterator = this.currentBuyingList.iterator();

						while (iterator.hasNext()) {
							MerchantRecipe merchantrecipe = (MerchantRecipe) iterator.next();

							if (merchantrecipe.isRecipeDisabled()) {
								merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
							}
						}
					}

					this.addTrades(1);
					this.needsInitilization = false;
				}

				this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
			}
		}

		super.updateAITick();
	}

	public boolean isTrading() {
		return this.buyingPlayer != null;
	}

	private float getRarity(float prob) {
		float f1 = prob + this.stock;
		return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
	}

	@Override
	public void setCustomer(EntityPlayer player) {
		this.buyingPlayer = player;
	}

	@Override
	public EntityPlayer getCustomer() {
		return this.buyingPlayer;
	}
	
	@Override
	public void setRecipes(MerchantRecipeList var1) {
		//this is not really needed
		
	}
	
	@Override
	public MerchantRecipeList getRecipes(EntityPlayer player)
	{
		if(this.currentBuyingList == null)
		{
			this.addTrades(1);
		}

		return this.currentBuyingList;
	}

	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();

		if (recipe.hasSameIDsAs((MerchantRecipe) this.currentBuyingList.get(this.currentBuyingList.size() - 1))) {
			this.timeUntilReset = 10;
			this.needsInitilization = true;
		}
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		boolean flag = itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.mob_spawner);

		if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild()) {
			if (!this.worldObj.isRemote) {
				this.setCustomer(par1EntityPlayer);
				par1EntityPlayer.displayGUIMerchant(this, "Eskimo");
			}

			return true;
		} else {
			return super.interact(par1EntityPlayer);
		}
	}

	private void addTrades(int amount) {
		if (this.currentBuyingList != null) {
			this.stock = MathHelper.sqrt_float((float) this.currentBuyingList.size()) * 0.2F;
		} else {
			this.stock = 0.0F;
		}

		MerchantRecipeList merchantrecipelist = new MerchantRecipeList();

		for (Object obj : buyingList.keySet()) {
			Item item = (Item) obj;
			float prob = (Float) rarityBuyingList.get(obj);
			addBuyingItem(merchantrecipelist, item, this.rand, this.getRarity(prob));
		}

		for (Object obj : stockList.keySet()) {
			Item item = (Item) obj;
			float prob = (Float) rarityStockList.get(obj);
			addSellingItem(merchantrecipelist, item, this.rand, this.getRarity(prob));
		}

		Collections.shuffle(merchantrecipelist);

		if (this.currentBuyingList == null) {
			this.currentBuyingList = new MerchantRecipeList();
		}

		for (int i = 0; i < amount && i < merchantrecipelist.size(); i++) {
			this.currentBuyingList.addToListWithCheck((MerchantRecipe) merchantrecipelist.get(i));
		}
	}

	private static int getRandomCountForSellingItem(Item p_146092_0_, Random p_146092_1_) {
		Tuple tuple = (Tuple) stockList.get(p_146092_0_);
		return tuple == null ? 1 : (((Integer) tuple.getFirst()).intValue() >= ((Integer) tuple.getSecond()).intValue() ? ((Integer) tuple.getFirst()).intValue() : ((Integer) tuple.getFirst()).intValue() + p_146092_1_.nextInt(((Integer) tuple.getSecond()).intValue() - ((Integer) tuple.getFirst()).intValue()));
	}

	private static int getRandomCountForBuyingItem(Item item, Random par1Random) {
		Tuple tuple = (Tuple) buyingList.get(item);
		return tuple == null ? 1 : (((Integer) tuple.getFirst()).intValue() >= ((Integer) tuple.getSecond()).intValue() ? ((Integer) tuple.getFirst()).intValue() : ((Integer) tuple.getFirst()).intValue() + par1Random.nextInt(((Integer) tuple.getSecond()).intValue() - ((Integer) tuple.getFirst()).intValue()));
	}

	private static ItemStack getRandomSizedStack(Item item, Random par1Random) {
		return new ItemStack(item, getRandomCountForBuyingItem(item, par1Random), 0);
	}

	private static void addBuyingItem(MerchantRecipeList par0MerchantRecipeList, Item item, Random par2Random, float prob) {
		if (par2Random.nextFloat() < prob) {
			par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(item, par2Random), AC_Item.eriumGem));
		}
	}

	private static void addSellingItem(MerchantRecipeList par0MerchantRecipeList, Item par1, Random par2Random, float par3) {
		if (par2Random.nextFloat() < par3) {
			int j = getRandomCountForSellingItem(par1, par2Random);
			ItemStack itemstack;
			ItemStack itemstack1;

			if (j < 0) {
				itemstack = new ItemStack(AC_Item.eriumGem, 1, 0);
				itemstack1 = new ItemStack(par1, -j, 0);
			} else {
				itemstack = new ItemStack(AC_Item.eriumGem, j, 0);
				itemstack1 = new ItemStack(par1, 1, 0);
			}

			par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
		}
	}

	/**
	 * Adds a trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The item to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual item costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual item costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToBuy(Item item, int minAmount, int maxAmount, float rarity) {
		addStuffToBuy(item, minAmount, maxAmount, rarity);
	}

	/**
	 * Adds a trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The block to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual block costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual block costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToBuy(Block block, int minAmount, int maxAmount, float rarity) {
		addStuffToBuy(block, minAmount, maxAmount, rarity);
	}

	/**
	 * Adds a trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The item to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual item costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual item costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToBuy(int ID, int minAmount, int maxAmount, float rarity) {
		buyingList.put(Integer.valueOf(ID), new Tuple(Integer.valueOf(minAmount), Integer.valueOf(maxAmount)));
		rarityBuyingList.put(Integer.valueOf(ID), Float.valueOf(rarity));
	}

	/**
	 * Adds a selling trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The item to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual item costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual item costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToSell(Item item, int minAmount, int maxAmount, float rarity) {
		addStuffToSell(item, minAmount, maxAmount, rarity);
	}

	/**
	 * Adds a selling trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The block to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual block costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual block costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToSell(Block block, int minAmount, int maxAmount, float rarity) {
		addStuffToSell(block, minAmount, maxAmount, rarity);
	}

	/**
	 * Adds a selling trade for this eskimo to carry out.
	 * 
	 * @param item
	 *            The item to add for trading
	 * @param minAmount
	 *            The minimum amount of erium gems each individual item costs
	 * @param maxAmount
	 *            The maximum amount of erium gems each individual item costs
	 * @param rarity
	 *            the rarity of the trade, between 0 and 1
	 **/
	protected static void addStuffToSell(int ID, int minAmount, int maxAmount, float rarity) {
		stockList.put(Integer.valueOf(ID), new Tuple(Integer.valueOf(minAmount), Integer.valueOf(maxAmount)));
		rarityStockList.put(Integer.valueOf(ID), Float.valueOf(rarity));
	}

}