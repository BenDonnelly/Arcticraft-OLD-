package arcticraft.renderers;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Timer;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import arcticraft.entities.AC_EntityCaveman;
import arcticraft.helpers.AC_TickHandler;
import arcticraft.items.AC_Item;
import arcticraft.lib.Strings;
import arcticraft.models.AC_ModelEntityCaveman;

public class AC_RenderCaveman extends RenderLiving
{

	public static final ResourceLocation caveman = new ResourceLocation(Strings.MOD_ID, "textures/mobs/caveman.png");
	private Timer timer;
	private AC_EntityCaveman cavemanInstance;

	public AC_RenderCaveman(ModelBase modelbase, float par2)
	{
		super(modelbase, par2);
		Field[] fields = Minecraft.getMinecraft().getClass().getDeclaredFields();
		for(Field field : fields)
		{
			if(field.getType().isAssignableFrom(Timer.class))
			{
				try
				{
					field.setAccessible(true);
					timer = (Timer) field.get(Minecraft.getMinecraft());
					if(timer == null)
					{
						System.out.println("***THIS MESSAGE SHOULD NOT APPEAR, CRASH IS IMMINENT\n***DO NOT START SINGLE/MULTIPLAYER");
						try
						{
							throw new Exception("NULL TIMER");
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.out.println("Send crash log to the AC team!");
						}
					}
				}
				catch(IllegalArgumentException e)
				{
					e.printStackTrace();
				}
				catch(IllegalAccessException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	protected void func_130005_c(EntityLiving par1EntityLiving, float par2)
	{
		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack itemstack = par1EntityLiving.getHeldItem();
		float f2;

		if(itemstack != null)
		{
			GL11.glPushMatrix();

			AC_ModelEntityCaveman.rightarm.postRender(0.0625F);
			GL11.glTranslatef(- 0.1625F, 0.700F, 0.400F);

			IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

			if(itemstack.getItem() instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())))
			{
				f2 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, - 0.3125F);
				f2 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(- f2, - f2, f2);
			}

			else if(Item.itemsList[itemstack.itemID].isFull3D())
			{
				f2 = 0.625F;

				if(Item.itemsList[itemstack.itemID].shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, - 0.125F, 0.0F);
				}

				this.func_82422_c();
				GL11.glScalef(f2, - f2, f2);
				GL11.glRotatef(- 100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				f2 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, - 0.1875F);
				GL11.glScalef(f2, f2, f2);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(- 90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);

			if(itemstack.getItem().requiresMultipleRenderPasses())
			{
				for(int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
				{
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, x);
				}
			}

			GL11.glPopMatrix();
		}
	}

	protected void func_82422_c()
	{
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.func_130005_c((EntityLiving) par1EntityLivingBase, par2);
	}

	public void func_177_a(AC_EntityCaveman caveman, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(caveman, d, d1, d2, f, f1);
	}

	@Override
	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityCaveman) entityliving, d, d1, d2, f, f1);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((AC_EntityCaveman) entity, d, d1, d2, f, f1);
		//renderCavemanHealth((AC_EntityCaveman) entity);
	}

	/*public void renderCavemanHealth(AC_EntityCaveman entity)
	{
	if(entity.isCompanion())
	{
		float interp = timer.renderPartialTicks;
		EntityLivingBase e = (EntityLivingBase) entity;
		float healthLength = 1;
		float healthHeight = 0.25f;
		EntityPlayer p = Minecraft.getMinecraft().thePlayer;
		double diffX = e.prevPosX + interp * (e.posX - e.prevPosX) - (p.prevPosX + interp * (p.posX - p.prevPosX));
		double diffY = e.prevPosY + interp * (e.posY - e.prevPosY) - (p.prevPosY + interp * (p.posY - p.prevPosY));
		double diffZ = e.prevPosZ + interp * (e.posZ - e.prevPosZ) - (p.prevPosZ + interp * (p.posZ - p.prevPosZ));
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glPushMatrix();
		double height = e.boundingBox.maxY - e.boundingBox.minY + 0.5;
		GL11.glTranslated(diffX, diffY + height, diffZ);
		GL11.glRotated(- (p.prevRotationYaw + interp * (p.rotationYaw - p.prevRotationYaw)), 0, 1, 0);
		GL11.glRotated(p.prevRotationPitch + interp * (p.rotationPitch - p.prevRotationPitch), 1, 0, 0);
		GL11.glScaled(- 1, 1, 1);
		Tessellator t = Tessellator.instance;
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "/textures/gui/health_bar.png"));
		float currentHealth = e.getDataWatcher().func_111145_d(6);
		float maxHealth = e.func_110138_aP();
		float sizeOfActiveHealth = healthLength * (currentHealth / maxHealth);
		GL11.glTranslated(- healthLength / 2f, 0, 0);
		t.startDrawingQuads();
		t.setColorOpaque(100, 205, 100);
		t.addVertexWithUV(0, 0, 0, 0, 0);
		t.addVertexWithUV(sizeOfActiveHealth, 0, 0, 1, 0);
		t.addVertexWithUV(sizeOfActiveHealth, healthHeight, 0, 1, 1);
		t.addVertexWithUV(0, healthHeight, 0, 0, 1);
		t.draw();
		float rest = healthLength - sizeOfActiveHealth;
		GL11.glTranslated(sizeOfActiveHealth, 0, 0);
		t.startDrawingQuads();
		t.setColorOpaque(255, 0, 0);
		t.addVertexWithUV(0, 0, 0, 0, 0);
		t.addVertexWithUV(rest, 0, 0, 1, 0);
		t.addVertexWithUV(rest, healthHeight, 0, 1, 1);
		t.addVertexWithUV(0, healthHeight, 0, 0, 1);
		t.draw();
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
	}
	}*/
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return caveman;
	}
}
