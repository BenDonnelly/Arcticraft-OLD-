package arcticraft.main;

import arcticraft.helpers.AC_DamageSource;
import arcticraft.helpers.AC_TemperatureHelper;
import arcticraft.lib.Strings;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

public class AC_Potion extends Potion {

	public AC_Potion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}
	
	@Override
	public int getStatusIconIndex() {
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "textures/gui/inventory.png"));
		return super.getStatusIconIndex();
	}
	
	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2) {
		if (this.id == MainRegistry.freezePotion.id) {
			if (par2 == 0) {
				if (par1EntityLivingBase.func_110143_aJ() > 2.0F)
	            {
	                par1EntityLivingBase.attackEntityFrom(AC_DamageSource.freezing, 3F);
	                
	                if (par1EntityLivingBase instanceof EntityPlayer) {
	                	EntityPlayer player = (EntityPlayer) par1EntityLivingBase;
	                	
	                	AC_TemperatureHelper.changeTemperature(player, -1);
	                }
	            }
			}
			else {
				par1EntityLivingBase.attackEntityFrom(AC_DamageSource.freezing, 3);
			}
		}
	}
	
	@Override
	public boolean isReady(int par1, int par2) {
		int k;
		
		if (this.id == MainRegistry.freezePotion.id)
		{
			k = par2 == 0 ? 80 : 10 >> par2;
			return k > 0 ? par1 % k == 0 : true;
		}
		else {
			return false;
		}
	}

}
