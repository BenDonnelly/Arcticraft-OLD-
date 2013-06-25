package arcticraft.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemHoe extends Item
{

	protected EnumToolMaterial theToolMaterial;

	public AC_ItemHoe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1);
		this.theToolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
	}

	  public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	        {
	            return false;
	        }
	        else
	        {
	            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
	            if (MinecraftForge.EVENT_BUS.post(event))
	            {
	                return false;
	            }

	            if (event.getResult() == Result.ALLOW)
	            {
	                par1ItemStack.damageItem(1, par2EntityPlayer);
	                return true;
	            }

	            int i1 = par3World.getBlockId(par4, par5, par6);
	            int j1 = par3World.getBlockId(par4, par5 + 1, par6);

	            if ((par7 == 0 || j1 != 0 || i1 != MainRegistry.frostGrass.blockID) && i1 != MainRegistry.frostDirt.blockID)
	            {
	                return false;
	            }
	            else
	            {
	                Block block = MainRegistry.tilledFrostField;
	                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

	                if (par3World.isRemote)
	                {
	                    return true;
	                }
	                else
	                {
	                    par3World.setBlock(par4, par5, par6, block.blockID);
	                    par1ItemStack.damageItem(1, par2EntityPlayer);
	                    return true;
	                }
	            }
	        }
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Returns True is the item is renderer in full 3D when hold.
	     */
	    public boolean isFull3D()
	    {
	        return true;
	    }

	    public String func_77842_f()
	    {
	        return this.theToolMaterial.toString();
	    }
	    
	    
	
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		if (this == MainRegistry.TekkiteHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:tekkiteHoe");
		}
		if (this == MainRegistry.EscariaHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:escariaHoe");
		}

		if (this == MainRegistry.RigentemHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:rigentemHoe");
		}

		if (this == MainRegistry.GlacianHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:glaciansHoe");
		}

		if (this == MainRegistry.ArcticStoneHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:iceHoe");
		}

		if (this == MainRegistry.FrostWoodHoe)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:frostWoodHoe");
		}
	}
}
