package arcticraft.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.item.Item;
import arcticraft.entities.AC_EntityChefEskimo;
import arcticraft.models.AC_ModelChefEskimo;

public class AC_RenderChefEskimo extends RenderLiving
{

	private AC_ModelChefEskimo modelChef;

	public AC_RenderChefEskimo(ModelBase modelbase, float f)
	{
		super(modelbase, 0.5F);
		this.modelChef = (AC_ModelChefEskimo) this.mainModel;
	}

	public void func_177_a(AC_EntityChefEskimo entityeskimo, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entityeskimo, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityChefEskimo) entityliving, d, d1, d2, f, f1);
	}

/*	protected void renderEskimoChefEquippedItems(AC_EntityChefEskimo eskimo, float par2)
	{
		super.renderEquippedItems(eskimo, par2);

		if (eskimo != null)
		{
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glPushMatrix();
			GL11.glRotatef(5.0F + 180.0F * this.modelChef.leftarm1.rotateAngleX / (float) Math.PI, 1.0F, 0.0F, 0.0F);
			 GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F); // dont change x ok. higher y number higher it is in the air? 
			 GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			float f1 = 0.8F;
			GL11.glScalef(f1, -f1, f1);
			int i = eskimo.getBrightnessForRender(par2);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.loadTexture("/terrain.png");
			this.renderBlocks.renderBlockAsItem(Block.cake, 0, 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
	}

	protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        this.renderEskimoChefEquippedItems((AC_EntityChefEskimo)par1EntityLiving, par2);
    }*/
	
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityChefEskimo) entity, d, d1, d2, f, f1);
	}
}
