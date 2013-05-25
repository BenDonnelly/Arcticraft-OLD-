package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemPickaxe extends ItemPickaxe
{

	public AC_ItemPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
	}

	  @SideOnly(Side.CLIENT)
	    public void updateIcons(IconRegister par1IconRegister)
	    {
		  if(this == MainRegistry.TekkitePickaxe){
	        this.iconIndex = par1IconRegister.registerIcon("AC:tekkitePickaxe");
	    }
		  if(this == MainRegistry.EscariaPickaxe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:escariaPickaxe");
		  }
		  
		  if(this == MainRegistry.RigentemPickaxe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:rigentemPickaxe");
		  }
		  
		  if(this == MainRegistry.GlacianPickaxe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:glaciansPickaxe");
		  }
		  
		  if(this == MainRegistry.ArcticStonePickaxe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:icePickaxe");
		  }
		  
		  if(this == MainRegistry.FrostWoodPickaxe){
			  this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodPickaxe");
		  }
	    }
}
