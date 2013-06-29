package arcticraft.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import arcticraft.entities.AC_EntityYeti;
import arcticraft.main.AC_TickHandler;

public class AC_GuiEskimoTalk extends GuiScreen
{

	Random rand = new Random();
	public String [] randomItem =
		{"bombs", "ice cream", "whiteberries", "floran tea", "food", "swords", "axes", "shovels"};
	public String thing = randomItem [rand.nextInt(randomItem.length)];
	private int chatProgress;
	private int reward;

	public AC_GuiEskimoTalk()
	{
	}

	public void initGui()
	{
		//id, x, y, width, height, text, b pixel width, b pixel height
		buttonList = new ArrayList();
		switch (chatProgress)
		{
		case 0:
			this.buttonList.add(new GuiButton(0, 2, this.height / 4 + 72 + -16, 220, 20, "Who are you?"));
			this.buttonList.add(new GuiButton(1, 2, this.height / 4 + 96 + -16, 220, 20, "Why are you keeping that Yeti captive?")); //this one i pressed
			this.buttonList.add(new GuiButton(2, 2, this.height / 4 + 120 + -16, 220, 20, "What's with that temple over there?"));
			this.buttonList.add(new GuiButton(3, 2, this.height / 4 + 48 + -16, 220, 20, "Hey. Where can I get " + thing + " from?"));
			break;

		case 1:
			this.buttonList.add(new GuiButton(4, 2, this.height / 4 + 72 + -16, 220, 20, "What if I could slay it for you?")); //Im not even double clicking aha, wtff. 
			this.buttonList.add(new GuiButton(5, 2, this.height / 4 + 96 + -16, 220, 20, "I'll slay it for you. For a price."));
			break;

		case 2:
			this.buttonList.add(new GuiButton(6, 2, this.height / 4 + 72 + -16, 220, 20, "Erium! Lots of it!"));
			this.buttonList.add(new GuiButton(7, 2, this.height / 4 + 96 + -16, 220, 20, "The most sacred item the village has"));
			break;

		case 3:
			this.buttonList.add(new GuiButton(8, 2, this.height / 4 + 96 + -16, 220, 20, "I've killed the Yeti"));
//			this.buttonList.add(new GuiButton(9, 2, this.height / 4 + 72 + -16, 220, 20, "I'm still working on killing the Yeti"));
			break;

		case 4:
			this.buttonList.add(new GuiButton(10, 2, this.height / 4 + 96 + -16, 220, 20, "Sacred Item"));
			this.buttonList.add(new GuiButton(11, 2, this.height / 4 + 72 + -16, 220, 20, "Erium"));
			break;
		}

	}

	public void actionPerformed(GuiButton button)
	{
		int buttonID = button.id;
		out("" + button.id);
		switch (button.id)
		{
		case 0:
			mc.thePlayer.sendChatToPlayer("I am the chief of this great Eskimo village!");
			button.enabled = false;
			break;
		case 1:
			mc.thePlayer.sendChatToPlayer("We're not. He invaded our temple and my men are too afraid to attack him - so captivity of him is our only option.");
			chatProgress = 1;
			initGui();
			break;
		case 2:
			mc.thePlayer.sendChatToPlayer("That is our place of worship, well it used to be. Since the Yeti attack we haven't been able to use it");
			chatProgress = 1;
			initGui();
			break;
		case 3:
			mc.thePlayer.sendChatToPlayer("Speak to our men around the village. They'll trade with you - at a price, of course.");
			button.enabled = false;
			break;
		case 4:
			mc.thePlayer.sendChatToPlayer("The whole village will be very grateful and we shall be for ever in your debt.");
			chatProgress = 3;
			reward = 2;
			initGui();
			break;
		case 5:
			mc.thePlayer.sendChatToPlayer("What could you possibly want from us?");
			chatProgress = 2;
			initGui();
			break;
		case 6:
			mc.thePlayer.sendChatToPlayer("Then it's a deal. You kill the Yeti and you shall recieve 128 of the finest Erium");
			chatProgress = 3;
			reward = 0;
			initGui();
			break;
		case 7:
			mc.thePlayer.sendChatToPlayer("Hm, we'll see about that. Slay the beast and I'll see what I can do");
			reward = 1;
			chatProgress = 3;
			initGui();
			break;
		}
		if (button.id == 8)
		{
			out("case 8");
			int offsetX = (int) Math.round(mc.thePlayer.posX);
			int offsetY = (int) Math.round(mc.thePlayer.posY);
			int offsetZ = (int) Math.round(mc.thePlayer.posZ);

			List <?> entitiesInRange = mc.theWorld.getEntitiesWithinAABB(AC_EntityYeti.class, AxisAlignedBB.getBoundingBox(offsetX - 32, offsetY - 32, offsetZ - 32, offsetX + 32, offsetY + 32, offsetZ + 32));

			AC_EntityYeti yetiInstance = null;

			for (int i = 0; i < entitiesInRange.size(); ++i)
			{
				Entity check = (Entity) entitiesInRange.get(i);
				if (check instanceof AC_EntityYeti) 
				{
					try
					{
						yetiInstance = (AC_EntityYeti) check;
					}
					catch (Exception e)
					{
						out("[AC]Error occured while casting an Entity into an EntityYeti:");
						out("");
						out(e.getMessage());
					}
				}
			}

			if (yetiInstance != null)
			{
				mc.thePlayer.sendChatToPlayer("The beast has not been slaid yet, kill it if you want your reward");
				out("The Yeti is not dead...");
			}
			else
			{
				mc.thePlayer.sendChatToPlayer("Thank you for the killing the Yeti. It has brought peace to my people. Heres is a reward for your efforts.");
				chatProgress = 4;
				initGui();	
			}
		}
		
	}

	protected void keyTyped(char par1, int par2)
	{
		if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
		{
			this.mc.thePlayer.closeScreen();
		}
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}
	public void drawScreen(int x, int y, float f)
	{
		super.drawScreen(x, y, f);
	}
	
	public static void out(String text)
	{
		System.out.println(AC_TickHandler.getSideAsString() + ": " + text);
	}

}
