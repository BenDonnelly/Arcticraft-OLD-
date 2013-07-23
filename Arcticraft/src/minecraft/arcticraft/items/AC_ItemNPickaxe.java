package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemNPickaxe extends ItemPickaxe
{

	public AC_ItemNPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);

	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if((par3EntityPlayer.rayTrace(10, 1.0F) != null))
		{
			double blockHitX = par3EntityPlayer.rayTrace(10, 1.0F).blockX;
			double blockHitY = par3EntityPlayer.rayTrace(10, 1.0F).blockY;
			double blockHitZ = par3EntityPlayer.rayTrace(10, 1.0F).blockZ;
			double blockHitSide = par3EntityPlayer.rayTrace(10, 1.0F).sideHit;
			float f = 4F;
			par2World.createExplosion(null, blockHitX, blockHitY, blockHitZ, f, true);
			par1ItemStack.damageItem(50, par3EntityPlayer);
		}
		return par1ItemStack;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("ac:notched_pickaxe_icon");
	}

}
