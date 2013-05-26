package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemHoe extends ItemHoe{

	public AC_ItemHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	  @SideOnly(Side.CLIENT)
	    public void updateIcons(IconRegister par1IconRegister)
	    {
		  if(this == MainRegistry.TekkiteHoe){
	        this.iconIndex = par1IconRegister.registerIcon("AC:tekkiteHoe");
	    }
		  if(this == MainRegistry.EscariaHoe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:escariaHos");
		  }
		  
		  if(this == MainRegistry.RigentemHoe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:rigentemHoe");
		  }
		  
		  if(this == MainRegistry.GlacianHoe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:glaciansHoe");
		  }
		  
		  if(this == MainRegistry.ArcticStoneHoe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:iceHoe");
		  }
		  
		  if(this == MainRegistry.FrostWoodHoe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodHoe");
		  }
	    }
}
