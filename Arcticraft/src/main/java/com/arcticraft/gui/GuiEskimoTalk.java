package com.arcticraft.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;

import com.arcticraft.entity.EntityYeti;
import com.arcticraft.item.AC_Item;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class GuiEskimoTalk extends GuiScreen
{

	Random rand = new Random();
	public String[] randomItem = {"bombs" , "ice cream" , "whiteberries" , "floran tea" , "food" , "swords" , "axes" , "shovels"};
	public String thing = randomItem[rand.nextInt(randomItem.length)];
	private int chatProgress;
	private int reward;
	public static boolean hasCollectedReward;
	private GuiButton buttonEight;

	public GuiEskimoTalk()
	{}

	public void initGui()
	{
		//id, x, y, width, height, text, b pixel width, b pixel height
		buttonList = new ArrayList();
		switch(chatProgress)
		{
		case 0:
			this.buttonList.add(new GuiButton(0, 2, this.height / 4 + 72 + - 16, 220, 20, "Who are you?"));
			this.buttonList.add(new GuiButton(1, 2, this.height / 4 + 96 + - 16, 220, 20, "Why are you keeping that Yeti captive?"));
			this.buttonList.add(new GuiButton(2, 2, this.height / 4 + 120 + - 16, 220, 20, "What's with that temple over there?"));
			this.buttonList.add(new GuiButton(3, 2, this.height / 4 + 48 + - 16, 220, 20, "Hey. Where can I get " + thing + " from?"));
			break;

		case 1:
			this.buttonList.add(new GuiButton(4, 2, this.height / 4 + 72 + - 16, 220, 20, "What if I could slay it for you?"));
			this.buttonList.add(new GuiButton(5, 2, this.height / 4 + 96 + - 16, 220, 20, "I'll slay it for you. For a price."));
			break;

		case 2:
			this.buttonList.add(new GuiButton(6, 2, this.height / 4 + 72 + - 16, 220, 20, "Erium! Lots of it!"));
			this.buttonList.add(new GuiButton(7, 2, this.height / 4 + 96 + - 16, 220, 20, "The most sacred item the village has"));
			break;

		case 3:
			this.buttonList.add(buttonEight = new GuiButton(8, 2, this.height / 4 + 96 + - 16, 220, 20, "I've killed the Yeti"));
			break;

		}

	}

	public void actionPerformed(GuiButton button)
	{
		int buttonID = button.id;
		out("" + button.id);
		switch(button.id)
		{
		case 0:
			mc.thePlayer.sendChatMessage("I am the chief of this great Eskimo village!");
			button.enabled = false;
			break;
		case 1:
			mc.thePlayer.sendChatMessage("We're not. He invaded our temple and my men are too afraid to attack him - so captivity of him is our only option.");
			chatProgress = 1;
			initGui();
			break;
		case 2:
			mc.thePlayer.sendChatMessage("That is our place of worship, well it used to be. Since the Yeti attack we haven't been able to use it");
			chatProgress = 1;
			initGui();
			break;
		case 3:
			mc.thePlayer.sendChatMessage("Speak to our men around the village. They'll trade with you - at a price, of course.");
			button.enabled = false;
			break;
		case 4:
			mc.thePlayer.sendChatMessage("The whole village will be very grateful and we shall be for ever in your debt.");
			chatProgress = 3;
			reward = 2;
			initGui();
			break;
		case 5:
			mc.thePlayer.sendChatMessage("What could you possibly want from us?");
			chatProgress = 2;
			initGui();
			break;
		case 6:
			mc.thePlayer.sendChatMessage("Then it's a deal. You kill the Yeti and you shall recieve 128 of the finest Erium");
			chatProgress = 3;
			reward = 0;
			initGui();
			break;
		case 7:
			mc.thePlayer.sendChatMessage("Hm, we'll see about that. Slay the beast and I'll see what I can do");
			reward = 1;
			chatProgress = 3;
			initGui();
			break;

		case 8:
		{

			if(! hasCollectedReward)
			{
				int offsetX = (int) Math.round(mc.thePlayer.posX);
				int offsetY = (int) Math.round(mc.thePlayer.posY);
				int offsetZ = (int) Math.round(mc.thePlayer.posZ);

				List<?> entitiesInRange = mc.theWorld.getEntitiesWithinAABB(EntityYeti.class, AxisAlignedBB.getBoundingBox(offsetX - 64, offsetY - 64, offsetZ - 64, offsetX + 64, offsetY + 64, offsetZ + 64));

				EntityYeti yetiInstance = null;

				for(int i = 0; i < entitiesInRange.size(); ++i)
				{
					Entity check = (Entity) entitiesInRange.get(i);
					if(check instanceof EntityYeti)
					{
						try
						{
							yetiInstance = (EntityYeti) check;
						}
						catch(Exception e)
						{
							out("[AC]Error occured while casting an Entity into an EntityYeti:");
							out("");
							out(e.getMessage());
						}
					}
				}

				if(yetiInstance != null)
				{
					mc.thePlayer.sendChatMessage("The beast has not been slaid yet, kill it if you want your reward");
					out("The Yeti is not dead...");
					break;
				}
				else
				{
					if(! hasCollectedReward && mc.thePlayer.inventory.getFirstEmptyStack() != - 1)
					{

						if(reward == 2)
						{
							mc.thePlayer.sendChatMessage("Thank you for the killing the Yeti. It has brought peace to my people. Heres is a reward for your efforts.");
							sendRewardToPlayer(this.mc.thePlayer, new ItemStack(AC_Item.eriumGem, 128));
							disableButton();
							break;
						}
						else if(reward == 0)
						{
							mc.thePlayer.sendChatMessage("The village is very grateful, here is your Erium");
							sendRewardToPlayer(this.mc.thePlayer, new ItemStack(AC_Item.eriumGem, 128));
							disableButton();
							break;
						}
						else if(reward == 1)
						{
							mc.thePlayer.sendChatMessage("It took me a while to convince my people, but I managed to get it. Here it is, the rare Jadeite gem - the most sacred item we have to offer ");
							sendRewardToPlayer(this.mc.thePlayer, new ItemStack(AC_Item.jadeite, 1));
							disableButton();
							break;
						}
						System.out.println(hasCollectedReward);
					}
					else
					{
						this.mc.thePlayer.sendChatMessage("Something went wrong, is your inventory full?");
					}
				}
			}

		}
		}
	}

	private void disableButton()
	{
		hasCollectedReward = true;
		if(hasCollectedReward)
		{
			out("call");
			mc.thePlayer.closeScreen();
			buttonEight.enabled = false;
			initGui();
			System.out.println(buttonEight.enabled);
		
		}
	}
	
	private static void sendRewardToPlayer(EntityClientPlayerMP player, ItemStack stack)
	{
		int item = stack.getItemDamage();
		int stackSize = stack.stackSize;
		int damageValue = stack.getItemDamage();

		ByteArrayOutputStream bos = new ByteArrayOutputStream(12);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try
		{
			outputStream.writeInt(item);
			outputStream.writeInt(stackSize);
			outputStream.writeInt(damageValue);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		/*Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Strings.CHANNEL_ESKIMO_TALK;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		player.sendQueue.addToSendQueue(packet);*/
	}

	protected void keyTyped(char par1, int par2)
	{
		if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

	public static void out(String text)
	{
		System.out.println(getSideAsString() + ": " + text);
	}
	
	@Deprecated
	public static String getSideAsString()
	{
		return FMLCommonHandler.instance().getSide() == Side.CLIENT ? "client" : "server";
	}

}
