package arcticraft.items;

import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import arcticraft.models.AC_ModelStaff;

public class AC_ItemInvisoStaff extends Item implements IItemRenderer
{

	protected AC_ModelStaff staffModel;

	public AC_ItemInvisoStaff(int par1)
	{
		super(par1);
		this.setMaxDamage(16);
		staffModel = new AC_ModelStaff();
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Invisibility (1:30)");
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "mob.endermen.portal", 1.0F, 1.0F);
		par3EntityPlayer.addPotionEffect(new PotionEffect(14, 1800, 0));
		return par1ItemStack;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
		case EQUIPPED:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{

		switch (type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture("/mods/AC/textures/items/inviso_staff.png");

			staffModel.render((Entity) data [1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix();
		}
		default:
			break;
		}

	}
}
