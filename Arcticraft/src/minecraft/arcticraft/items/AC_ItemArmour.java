package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import arcticraft.main.MainRegistry;

public class AC_ItemArmour extends ItemArmor implements IArmorTextureProvider{

	
	
	public AC_ItemArmour(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		
		if(itemstack.itemID == MainRegistry.TekkiteHelmet.itemID || itemstack.itemID == MainRegistry.TekkitePlate.itemID || itemstack.itemID == MainRegistry.TekkiteBoots.itemID) {
			return "/mods/AC/textures/armour/tektite_1.png";
		}
		if(itemstack.itemID == MainRegistry.TekkiteLegs.itemID){
			return "/mods/AC/textures/armour/tektite_2.png";
		}
		
		if(itemstack.itemID == MainRegistry.EscariaHelmet.itemID || itemstack.itemID == MainRegistry.EscariaPlate.itemID || itemstack.itemID == MainRegistry.EscariaBoots.itemID) {
			return "/mods/AC/textures/armour/escaria_1.png";
		}
		
		if(itemstack.itemID == MainRegistry.EscariaLegs.itemID){
			return "/mods/AC/textures/armour/escaria_2.png";
		}
		
		if(itemstack.itemID == MainRegistry.RigentemHelmet.itemID || itemstack.itemID == MainRegistry.RigentemPlate.itemID || itemstack.itemID == MainRegistry.RigentemBoots.itemID) {
			return "/mods/AC/textures/armour/rigentem_1.png";
		}
		
		if(itemstack.itemID == MainRegistry.RigentemLegs.itemID){
			return "/mods/AC/textures/armour/rigentem_2.png";
		}
		
		if(itemstack.itemID == MainRegistry.GlacianHelmet.itemID || itemstack.itemID == MainRegistry.GlacianPlate.itemID || itemstack.itemID == MainRegistry.GlacianBoots.itemID) {
			return "/mods/AC/textures/armour/glacians_1.png";
		}
		
		if(itemstack.itemID == MainRegistry.GlacianLegs.itemID){
			return "/mods/AC/textures/armour/glacians_2.png";
		}
		
		else return null;
	}
	



	@Override
	public void updateIcons(IconRegister iconRegister) {
		
		if(this == MainRegistry.TekkiteHelmet){
		iconIndex = iconRegister.registerIcon("AC:tekkiteHelm");
	}
		
		if(this == MainRegistry.TekkitePlate){
			iconIndex = iconRegister.registerIcon("AC:tekkiteChest");
		}
		
		if(this == MainRegistry.TekkiteLegs){
			iconIndex = iconRegister.registerIcon("AC:tekkiteLegs");
		}
		
		if(this == MainRegistry.TekkiteBoots){
			iconIndex = iconRegister.registerIcon("AC:tekkiteBoots");
		}
		
		if(this == MainRegistry.EscariaHelmet){
			iconIndex = iconRegister.registerIcon("AC:escariaHelm");
		}
		
		if(this == MainRegistry.EscariaPlate){
			iconIndex = iconRegister.registerIcon("AC:escariaChest");
		}
		
		if(this == MainRegistry.EscariaLegs){
			iconIndex = iconRegister.registerIcon("AC:escariaLegs");
		}
		
		if(this == MainRegistry.EscariaBoots){
			iconIndex = iconRegister.registerIcon("AC:escariaBoots");
		}
		
		if(this == MainRegistry.RigentemHelmet){
			iconIndex = iconRegister.registerIcon("AC:rigentemHelm");
		}
		
		if(this == MainRegistry.RigentemPlate){
			iconIndex = iconRegister.registerIcon("AC:rigentemChest");
		}
		
		if(this == MainRegistry.RigentemLegs){
			iconIndex = iconRegister.registerIcon("AC:rigentemLegs");
		}
		
		if(this == MainRegistry.RigentemBoots){
			iconIndex = iconRegister.registerIcon("AC:rigentemBoots");
		}
		
		if(this == MainRegistry.GlacianHelmet){
			iconIndex = iconRegister.registerIcon("AC:glaciansHelm");
		}
		
		if(this == MainRegistry.GlacianPlate){
			iconIndex = iconRegister.registerIcon("AC:glaciansChest");
		}
		
		if(this == MainRegistry.GlacianLegs){
			iconIndex = iconRegister.registerIcon("AC:glaciansLegs");
		}
		
		if(this == MainRegistry.GlacianBoots){
			iconIndex = iconRegister.registerIcon("AC:glaciansBoots");
		}
	}
}