package arcticraft.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public abstract class AC_EntityDefaultEskimo extends EntityMob implements IMerchant {

	private EntityPlayer buyingPlayer;
	private MerchantRecipeList buyingList;
	private String lastBuyingPlayer;
	private int wealth;
	
	public AC_EntityDefaultEskimo(World par1World) {
		super(par1World);
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
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList list) {
		
	}

	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();
	}

}
