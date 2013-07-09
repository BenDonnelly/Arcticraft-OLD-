package arcticraft.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class AC_EntityDefaultEskimo extends EntityMob implements IMerchant {

	private EntityPlayer buyingPlayer;
	private MerchantRecipeList buyingList;
	private String lastBuyingPlayer;
	private int timeUntilReset;
	private boolean needsInitilization;
	private float stock;
	
	public static final Map stockList = new HashMap();
	
	public AC_EntityDefaultEskimo(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void updateAITick() {
		if (!this.isTrading() && this.timeUntilReset > 0)
        {
            --this.timeUntilReset;

            if (this.timeUntilReset <= 0)
            {
                if (this.needsInitilization)
                {
                    if (this.buyingList.size() > 1)
                    {
                        Iterator iterator = this.buyingList.iterator();

                        while (iterator.hasNext())
                        {
                            MerchantRecipe merchantrecipe = (MerchantRecipe)iterator.next();

                            if (merchantrecipe.func_82784_g())
                            {
                                merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addRecipes(1);
                    this.needsInitilization = false;
                }

                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }
		
		super.updateAITick();
	}
	
	private float getProbability(float prob)
    {
        float f1 = prob + this.stock;
        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
    }
	
	public boolean isTrading() {
        return this.buyingPlayer != null;
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
	public MerchantRecipeList getRecipes(EntityPlayer player) {
		if (this.buyingList == null) {
            this.addRecipes(1);
        }

        return this.buyingList;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList list) {
		//why does this exist?
	}

	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();
		
		if (recipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
			this.timeUntilReset = 40;
            this.needsInitilization = true;
		}
	}
	
	private void addRecipes(int amount) {
		if (this.buyingList != null) {
            this.stock = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else {
            this.stock = 0.0F;
        }
		
		MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
		this.addRecipesToList(merchantrecipelist, this.rand);
		Collections.shuffle(merchantrecipelist);
		
		if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
		
		for (int i = 0; i < amount && i < merchantrecipelist.size(); i++) {
            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(i));
        }
	}
	
	public static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3) {
        if (par2Random.nextFloat() < par3) {
            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Item.emerald));
        }
    }
	
	private static ItemStack getRandomSizedStack(int par0, Random par1Random) {
        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
    }
	
	private static int getRandomCountForItem(int par0, Random par1Random) {
        Tuple tuple = (Tuple)stockList.get(Integer.valueOf(par0));
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + par1Random.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }
	
	private static void addStuffToStock(Item item, int minAmount, int maxAmount) {
		addStuffToStock(item.itemID, minAmount, maxAmount);
	}
	
	private static void addStuffToStock(Block block, int minAmount, int maxAmount) {
		addStuffToStock(block.blockID, minAmount, maxAmount);
	}
	
	public static void addStuffToStock(int ID, int minAmount, int maxAmount) {
		stockList.put(Integer.valueOf(ID), new Tuple(Integer.valueOf(minAmount), Integer.valueOf(maxAmount)));
	}
	
	public abstract void addRecipesToList(MerchantRecipeList list, Random rand);
	
	static {
		addStuffToStock(Block.stone, 5, 46);
	}

}
