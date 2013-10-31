package arcticraft.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.entities.AC_EntityEskimoTrader;
import arcticraft.entities.AC_EskimoTrade;
import arcticraft.lib.Strings;
import cpw.mods.fml.client.FMLClientHandler;

public class AC_GuiTraderEskimo extends GuiScreen
{

	public InventoryPlayer inventory;
	private AC_EntityEskimoTrader eskimo;
	private int traderWidth = 256;
	private int traderHeight = 256;

	public AC_GuiTraderEskimo(InventoryPlayer inv, AC_EntityEskimoTrader entity)
	{
		this.inventory = inv;
		this.eskimo = entity;
	}

	@Override
	public void initGui()
	{
		AC_EskimoTrade[] trades = this.eskimo.getTrades();
		for(int ID = 0; ID < trades.length; ID++)
		{
			AC_EskimoTrade trade = trades[ID];
			if(trade != null)
			{
				int x = (this.width + this.traderWidth) / 2 - 46 - 32 * (ID % 7);
				int y = (this.height + this.traderHeight) / 2 - 69 - 38 * (ID / 7);
				this.buttonList.add(new AC_GuiTraderButton(ID, x, y, trade, this));
			}
		}
	}

	@Override
	public void actionPerformed(GuiButton button)
	{
		if(button.enabled)
		{
			AC_EskimoTrade trade = this.eskimo.getTrades()[button.id];
			if(trade != null && this.inventory.getFirstEmptyStack() != - 1)
			{
				ItemStack stack = ItemStack.copyItemStack(trade.itemstack);
				int itemID = stack.itemID;
				int stackSize = stack.stackSize;
				int damageValue = stack.getItemDamage();
				int gems = trade.gemAmount;

				ByteArrayOutputStream bos = new ByteArrayOutputStream(16);
				DataOutputStream outputStream = new DataOutputStream(bos);

				try
				{
					outputStream.writeInt(itemID);
					outputStream.writeInt(stackSize);
					outputStream.writeInt(damageValue);
					outputStream.writeInt(gems);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}

				Packet250CustomPayload packet = new Packet250CustomPayload();
				packet.channel = Strings.CHANNEL_ESKIMO_TRADE;
				packet.data = bos.toByteArray();
				packet.length = bos.size();

				if(this.inventory.player instanceof EntityClientPlayerMP)
				{
					EntityClientPlayerMP player = (EntityClientPlayerMP) this.inventory.player;
					player.sendQueue.addToSendQueue(packet);
				}
			}
			else
			{
				this.inventory.player.addChatMessage("Something went wrong, is your inventory full?");
			}
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation(Strings.MOD_ID, "textures/gui/trading.png"));
		int x = (this.width - this.traderWidth) / 2;
		int y = (this.height - this.traderHeight) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.traderWidth, this.traderHeight);
		String gems = AC_EskimoTrade.getGemsFromInventory(this.inventory) + " Gems";
		this.fontRenderer.drawString(gems, x + 41 - (this.fontRenderer.getStringWidth(gems) / 2), y + 6, 0xDC631E);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
			this.mc.setIngameFocus();
		}
	}
}
