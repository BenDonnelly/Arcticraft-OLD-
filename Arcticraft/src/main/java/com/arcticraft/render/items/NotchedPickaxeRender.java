package com.arcticraft.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.arcticraft.lib.Strings;
import com.arcticraft.model.item.AC_ModelNPickaxe;

import cpw.mods.fml.client.FMLClientHandler;

public class NotchedPickaxeRender implements IItemRenderer
{

	protected AC_ModelNPickaxe pickModel;

	public NotchedPickaxeRender()
	{
		pickModel = new AC_ModelNPickaxe();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
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
		if(type == type.EQUIPPED || type == type.EQUIPPED_FIRST_PERSON)
		{

			GL11.glPushMatrix();

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Strings.MODID + ":textures/items/notched_pickaxe.png"));

			GL11.glRotatef(- 32, 3F, 3F, 300F);
			GL11.glRotatef(300, 1F, 1F, 300F);

			boolean isFirstPerson = false;

			if(data[1] != null && data[1] instanceof EntityPlayer)
			{
				if(! ((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && ! ((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
				{
					GL11.glTranslatef(- 0.35F, - 0.500F, - 0.0F);
				}
				else
				{
					isFirstPerson = true;
					GL11.glRotatef(- 32, 3F, 3F, 300F);
					GL11.glRotatef(300, 1F, 1F, 500F);
					GL11.glTranslatef(- 0.454F, - 0.800F, - 0.3F);
				}
			}
			else
			{
				GL11.glTranslatef(- 0.35F, - 0.500F, - 0.0F);
			}

			GL11.glScalef(0.9F, 0.9F, 0.43F);

			pickModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix();

		}
	}
}
