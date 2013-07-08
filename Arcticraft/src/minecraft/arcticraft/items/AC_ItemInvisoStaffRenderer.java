package arcticraft.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import arcticraft.models.AC_ModelStaff;

public class AC_ItemInvisoStaffRenderer implements IItemRenderer
{

	protected AC_ModelStaff staffModel;

	public AC_ItemInvisoStaffRenderer()
	{
		staffModel = new AC_ModelStaff();
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

			//			GL11.glTranslatef(0.095F, 0.4F, 0.66F);

			staffModel.render((Entity) data [1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix();
		}
		default:
			break;
		}

	}

}
