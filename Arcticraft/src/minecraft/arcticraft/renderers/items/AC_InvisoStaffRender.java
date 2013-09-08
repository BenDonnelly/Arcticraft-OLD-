package arcticraft.renderers.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import arcticraft.lib.Strings;
import arcticraft.models.items.AC_ModelStaff;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_InvisoStaffRender implements IItemRenderer
{

	protected AC_ModelStaff staffModel;

	public AC_InvisoStaffRender()
	{
		staffModel = new AC_ModelStaff();
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

			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/items/inviso_staff.png"));
			GL11.glTranslatef(0.7F, 0.1F, 0.01F);

			staffModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glPopMatrix();
		}

	}

}
