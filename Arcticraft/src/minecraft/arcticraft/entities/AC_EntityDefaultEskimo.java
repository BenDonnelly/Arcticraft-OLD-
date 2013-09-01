package arcticraft.entities;

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
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class AC_EntityDefaultEskimo extends EntityMob implements IMerchant
{

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

	public AC_EntityDefaultEskimo(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 1.4F);
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(11, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public boolean canDespawn()
	{
		return false;
	}

	protected void func_110147_ax()
	{
		super.func_110147_ax();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.399D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
	}
	
	@Override
	protected void updateAITick()
	{
		if(! this.isTrading() && this.timeUntilReset > 0)
		{
			--this.timeUntilReset;

			if(this.timeUntilReset <= 0)
			{
				if(this.needsInitilization)
				{
					if(this.currentBuyingList.size() > 1)
					{
						Iterator iterator = this.currentBuyingList.iterator();

						while(iterator.hasNext())
						{
							MerchantRecipe merchantrecipe = (MerchantRecipe) iterator.next();

							if(merchantrecipe.func_82784_g())
							{
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

	private float getRarity(float prob)
	{
		float f1 = prob + this.stock;
		return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
	}

	public boolean isTrading()
	{
		return this.buyingPlayer != null;
	}

	@Override
	public void setCustomer(EntityPlayer player)
	{
		this.buyingPlayer = player;
	}

	@Override
	public EntityPlayer getCustomer()
	{
		return this.buyingPlayer;
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
	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList list)
	{
		//why does this exist?
	}

	@Override
	public void useRecipe(MerchantRecipe recipe)
	{
		recipe.incrementToolUses();

		if(recipe.hasSameIDsAs((MerchantRecipe) this.currentBuyingList.get(this.currentBuyingList.size() - 1)))
		{
			this.timeUntilReset = 10;
			this.needsInitilization = true;
		}
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		boolean flag = itemstack != null && itemstack.itemID == Item.monsterPlacer.itemID;

		if(! flag && this.isEntityAlive() && ! this.isTrading() && ! this.isChild())
		{
			if(! this.worldObj.isRemote)
			{
				this.setCustomer(par1EntityPlayer);
				par1EntityPlayer.displayGUIMerchant(this, "Eskimo");
			}

			return true;
		}
		else
		{
			return super.interact(par1EntityPlayer);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		if(this.currentBuyingList != null)
		{
			par1NBTTagCompound.setCompoundTag("Offers", this.currentBuyingList.getRecipiesAsTags());
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if(par1NBTTagCompound.hasKey("Offers"))
		{
			NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
			this.currentBuyingList = new MerchantRecipeList(nbttagcompound1);
		}
	}

	private void addTrades(int amount)
	{
		if(this.currentBuyingList != null)
		{
			this.stock = MathHelper.sqrt_float((float) this.currentBuyingList.size()) * 0.2F;
		}
		else
		{
			this.stock = 0.0F;
		}

		MerchantRecipeList merchantrecipelist = new MerchantRecipeList();

		for(Object obj : buyingList.keySet())
		{
			int ID = (Integer) obj;
			float prob = (Float) rarityBuyingList.get(obj);
			addBuyingItem(merchantrecipelist, ID, this.rand, this.getRarity(prob));
		}

		for(Object obj : stockList.keySet())
		{
			int ID = (Integer) obj;
			float prob = (Float) rarityStockList.get(obj);
			addSellingItem(merchantrecipelist, ID, this.rand, this.getRarity(prob));
		}

		Collections.shuffle(merchantrecipelist);

		if(this.currentBuyingList == null)
		{
			this.currentBuyingList = new MerchantRecipeList();
		}

		for(int i = 0; i < amount && i < merchantrecipelist.size(); i++)
		{
			this.currentBuyingList.addToListWithCheck((MerchantRecipe) merchantrecipelist.get(i));
		}
	}

	private static void addBuyingItem(MerchantRecipeList par0MerchantRecipeList, int ID, Random par2Random, float prob)
	{
		if(par2Random.nextFloat() < prob)
		{
			par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(ID, par2Random), AC_Item.eriumGem));
		}
	}

	private static void addSellingItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
	{
		if(par2Random.nextFloat() < par3)
		{
			int j = getRandomCountForSellingItem(par1, par2Random);
			ItemStack itemstack;
			ItemStack itemstack1;

			if(j < 0)
			{
				itemstack = new ItemStack(AC_Item.eriumGem, 1, 0);
				itemstack1 = new ItemStack(par1, - j, 0);
			}
			else
			{
				itemstack = new ItemStack(AC_Item.eriumGem, j, 0);
				itemstack1 = new ItemStack(par1, 1, 0);
			}

			par0MerchantRecipeList.add(new MerchantRecipe(itemstack, itemstack1));
		}
	}

	@Override
	public String getLivingSound()
	{
		return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
	}

	@Override
	public String getHurtSound()
	{
		return "mob.villager.hit";
	}

	@Override
	public String getDeathSound()
	{
		return "mob.villager.death";
	}

	
	private static int getRandomCountForSellingItem(int par0, Random par1Random)
	{
		Tuple tuple = (Tuple) stockList.get(Integer.valueOf(par0));
		return tuple == null ? 1 : (((Integer) tuple.getFirst()).intValue() >= ((Integer) tuple.getSecond()).intValue() ? ((Integer) tuple.getFirst()).intValue() : ((Integer) tuple.getFirst()).intValue()
				+ par1Random.nextInt(((Integer) tuple.getSecond()).intValue() - ((Integer) tuple.getFirst()).intValue()));
	}

	private static int getRandomCountForBuyingItem(int ID, Random par1Random)
	{
		Tuple tuple = (Tuple) buyingList.get(Integer.valueOf(ID));
		return tuple == null ? 1 : (((Integer) tuple.getFirst()).intValue() >= ((Integer) tuple.getSecond()).intValue() ? ((Integer) tuple.getFirst()).intValue() : ((Integer) tuple.getFirst()).intValue()
				+ par1Random.nextInt(((Integer) tuple.getSecond()).intValue() - ((Integer) tuple.getFirst()).intValue()));
	}

	private static ItemStack getRandomSizedStack(int ID, Random par1Random)
	{
		return new ItemStack(ID, getRandomCountForBuyingItem(ID, par1Random), 0);
	}
	
	/** Adds a trade for this eskimo to carry out.
	 * @param item The item to add for trading
	 * @param minAmount The minimum amount of erium gems each individual item costs
	 * @param maxAmount The maximum amount of erium gems each individual item costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToBuy(Item item, int minAmount, int maxAmount, float rarity)
	{
		addStuffToBuy(item.itemID, minAmount, maxAmount, rarity);
	}

	/** Adds a trade for this eskimo to carry out.
	 * @param item The block to add for trading
	 * @param minAmount The minimum amount of erium gems each individual block costs
	 * @param maxAmount The maximum amount of erium gems each individual block costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToBuy(Block block, int minAmount, int maxAmount, float rarity)
	{
		addStuffToBuy(block.blockID, minAmount, maxAmount, rarity);
	}

	/** Adds a trade for this eskimo to carry out.
	 * @param item The item to add for trading
	 * @param minAmount The minimum amount of erium gems each individual item costs
	 * @param maxAmount The maximum amount of erium gems each individual item costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToBuy(int ID, int minAmount, int maxAmount, float rarity)
	{
		buyingList.put(Integer.valueOf(ID), new Tuple(Integer.valueOf(minAmount), Integer.valueOf(maxAmount)));
		rarityBuyingList.put(Integer.valueOf(ID), Float.valueOf(rarity));
	}

	/** Adds a selling trade for this eskimo to carry out.
	 * @param item The item to add for trading
	 * @param minAmount The minimum amount of erium gems each individual item costs
	 * @param maxAmount The maximum amount of erium gems each individual item costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToSell(Item item, int minAmount, int maxAmount, float rarity)
	{
		addStuffToSell(item.itemID, minAmount, maxAmount, rarity);
	}

	/** Adds a selling trade for this eskimo to carry out.
	 * @param item The block to add for trading
	 * @param minAmount The minimum amount of erium gems each individual block costs
	 * @param maxAmount The maximum amount of erium gems each individual block costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToSell(Block block, int minAmount, int maxAmount, float rarity)
	{
		addStuffToSell(block.blockID, minAmount, maxAmount, rarity);
	}

	/** Adds a selling trade for this eskimo to carry out.
	 * @param item The item to add for trading
	 * @param minAmount The minimum amount of erium gems each individual item costs
	 * @param maxAmount The maximum amount of erium gems each individual item costs
	 * @param rarity the rarity of the trade, between 0 and 1 **/
	protected static void addStuffToSell(int ID, int minAmount, int maxAmount, float rarity)
	{
		stockList.put(Integer.valueOf(ID), new Tuple(Integer.valueOf(minAmount), Integer.valueOf(maxAmount)));
		rarityStockList.put(Integer.valueOf(ID), Float.valueOf(rarity));
	}

}
