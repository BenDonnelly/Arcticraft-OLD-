package arcticraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityBomb;
import arcticraft.entities.AC_EntityNPickThing;
import arcticraft.helpers.AC_TickHandler;
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
		if(! par2World.isRemote && AC_TickHandler.canFireExplosion == true)
		{
			par2World.spawnEntityInWorld(new AC_EntityNPickThing(par2World, par3EntityPlayer));

			par1ItemStack.damageItem(50, par3EntityPlayer);
			AC_TickHandler.canFireExplosion = false;
			AC_TickHandler.cooldown = 1200;
		}
		return par1ItemStack;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Summons explosions on right click");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("ac:notched_pickaxe_icon");
	}

}
