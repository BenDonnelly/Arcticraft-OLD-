package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemShovel extends ItemSpade{

	public AC_ItemShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	  @SideOnly(Side.CLIENT)
	    public void updateIcons(IconRegister par1IconRegister)
	    {
		  if(this == MainRegistry.TekkiteShovel){
	        this.iconIndex = par1IconRegister.registerIcon("AC:tekkiteShovel");
	    }
		  
		  if(this == MainRegistry.EscariaShovel){
		        this.iconIndex = par1IconRegister.registerIcon("AC:escariaShovel");
		    }
		  
		  if(this == MainRegistry.RigentemShovel){
		        this.iconIndex = par1IconRegister.registerIcon("AC:rigentemShovel");
		    }
		  
		  if(this == MainRegistry.GlacianShovel){
		        this.iconIndex = par1IconRegister.registerIcon("AC:glaciansShovel");
		    }
		  
		  if(this == MainRegistry.ArcticStoneShovel){
		        this.iconIndex = par1IconRegister.registerIcon("AC:iceShovel");
		    }
		  
		  if(this == MainRegistry.FrostWoodShovel){
		        this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodShovel");
		    }
	    }
}
