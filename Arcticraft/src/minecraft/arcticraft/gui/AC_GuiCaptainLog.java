package arcticraft.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import arcticraft.lib.Strings;

public class AC_GuiCaptainLog extends GuiScreen {

	//Actually not implemented.
	private static final int maxPages = 100;
	private static final ResourceLocation texture = new ResourceLocation(Strings.MOD_ID, "textures/gui/captain_log.png");
	private static final String[][] logs = {
		{ 	"Day 1: Navigation to the North",
			"",
			"It is unthinkable that if there ever was one land, which man had never set foot on before, and one sea, which a ship has never sailed, we would be the first enter that land and sail that sea. Where all of our previous travels had been going to the south, in the north our treasure was sought now. A rumor of castle, so great and wealthy, it is said their dungeons and towers contain treasure equal to that of all others combined.",
			"And thus our mission was set, but not without peril: as every castle constains a king, so does this great castle. Referred to as 'The mad king', he poses a great danger against its own civilization: every few days, an inhibitant of the ice lands (called an eskimo), would come to visit the king to discuss royal matters. Access to the castle is granted to a single eskimo: the chief. To give him this privilege a sacred item, our crew suspects it's a key, is hidden in their village. However, since the arrival of the mad king - the cause of his madness remains unknown - no chief has ever dared to visit the castle again. And that's where our crew, currently at a count of 13 (unsurprisingly almost doubled since the rumor), comes in.",
			"We will set sail to the arctic, we will find the sacred item and we will kill the mad king and take his treasure."
		}, {
			"Day 11: Nightfall",
			"",
			"By then day had broken everywhere, but here it was still night - no, more than night. It's been 2 days since we've seen the sun: when the moon is just about to disappear below the horizon, he goes back up. Our crew has a hard time dealing with it: a deck is a dangerous place to be on when your eyes have trouble seeing. We have already lost 1 man, after one of the ropes caught his leg and brutally launched him up in the air - may his ghost rest in peace.",
			"What we've seen today however exceeds every event that has happened so far: a sea monster, its size equal to that of our ship, with arms and legs similar to that of a fish, twisted itself about 15 feet above the water with an enormous force: the waves extended far beyond our vision. In fear of losing more crew, some of the members figured it would be best to kill the creature. We cannot allow anything to get near this ship."
		}, { 
			"Day 14: Ice Rocks",
			"",
			"It seems we are getting close to our destination: as the temperature keeps dropping, we encounter more and more ice floating on the surface. We have been trying to calculate where it origins from, but so far it has led to no success.",
			"The water is covered with fog, so it's very hard to notice the ice rocks. For this reason, we have lost another man, and nearly our ship: when our crew was asleep, the ship collided with one of the rocks. A leak was inevitable, but fortunately it could quickly be repaired by 2 men, at the cost of one. The water that gushed inside was so cold, his ears were freezing when he passed out. Despite all of this, the night has proven itself useful at last: the stars are excellent guides to stay on course. Let's just hope we don't encounter another collision."
		}, {
			"Day 19: Wrecked",
			"",
			"Our days are coming to an end: it happened suddenly, like before, but I was expecting it - the ship collided with another ice rock, but much bigger than the rock we collided with a few days ago. This is indeed no place for a ship, or man for that matter. With almost no supplies left, I sent out a few men to search for land, but I fear the worst. They have not returned yet.",
			"If anyone may ever read this; you must find the mad king. I will not die for nothing..."
		} 
	};
	private static List[] textForPage = new ArrayList[maxPages];
	
	private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int writablePageWidth = 112;
    private int writablePageHeight = 140;
    private int indentX = 40;
    private int indentY = 20;
    private int currPage;
    private int bookTotalPages;
    private AC_GuiCaptainLogButtonNextPage buttonNextPage;
    private AC_GuiCaptainLogButtonNextPage buttonPreviousPage;
	
	public AC_GuiCaptainLog() {
		
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(texture);
		int x = (this.width - this.bookImageWidth) / 2;
		int y = (this.height - this.bookImageHeight) /2;
		this.drawTexturedModalRect(x, y, 0, 0, this.bookImageWidth, this.bookImageHeight);
		
		String s = this.currPage + " / " + this.bookTotalPages;

        this.fontRenderer.drawString(s, x + (this.bookImageWidth - this.fontRenderer.getStringWidth(s) - 10) / 2, y + 158, 4210752);
        
        int i = y + this.indentY;
        
        if (this.currPage != 1) {
        	for (Iterator iterator = textForPage[this.currPage].iterator(); iterator.hasNext(); i += this.fontRenderer.FONT_HEIGHT) {
        		String s1 = (String)iterator.next();
        		this.fontRenderer.drawSplitString(s1, x + this.indentX, i, this.writablePageWidth, 0x111111);
        	}
        }
        else {
        //	String title1 = "\u00a7lJournal of \u00a7kCaptain";
        	String title1 = "The Captain's Journal";
        	String title2 = "\u00a7oAn arctic expedition";
        	this.fontRenderer.drawString(title1, x + (this.bookImageWidth - this.fontRenderer.getStringWidth(title1)) / 2, i + 10, 0x111111);
        	this.fontRenderer.drawString(title2, x + (this.bookImageWidth - this.fontRenderer.getStringWidth(title2)) / 2, i + 20, 0x111111);
        }
		super.drawScreen(par1, par2, par3);
	}
	
	@Override
	public void initGui() {
		int pageNumber = 2;
		int linesPerPage = (int) Math.floor((double) this.writablePageHeight / (double) this.fontRenderer.FONT_HEIGHT);
		
		for (String[] log : logs) {
			List lines = new ArrayList();
			
			for (int i = 0; i < log.length; i++) {
				String text = i == 0 ? "\u00a7o" + log[i] : "\u00a7r" + log[i];
				lines.addAll(this.fontRenderer.listFormattedStringToWidth(text, this.writablePageWidth));
			}
			
			while (lines.size() > linesPerPage) {
				List subList = new ArrayList(lines.subList(0, linesPerPage));
				lines.removeAll(subList);
				
				textForPage[pageNumber] = subList;
				pageNumber++;
			}
			
			textForPage[pageNumber] = lines;
			pageNumber++;
		}
		
		this.bookTotalPages = pageNumber - 1;
		this.currPage = 1;
		
		int x = (this.width - this.bookImageWidth) / 2;
        int y = (this.height - this.bookImageHeight) / 2;
        this.buttonList.add(this.buttonNextPage = new AC_GuiCaptainLogButtonNextPage(0, x + 120, y + 154, true));
        this.buttonList.add(this.buttonPreviousPage = new AC_GuiCaptainLogButtonNextPage(1, x + 38, y + 154, false));
        this.updateButtons();
	}
	
	@Override
	protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id == 0)
            {
                if (this.currPage < this.bookTotalPages)
                {
                    ++this.currPage;
                }
            }
            else if (par1GuiButton.id == 1)
            {
                if (this.currPage > 1)
                {
                    --this.currPage;
                }
            }

            this.updateButtons();
        }
    }
	
	private void updateButtons() {
		this.buttonNextPage.drawButton = this.currPage < this.bookTotalPages;
        this.buttonPreviousPage.drawButton = this.currPage > 1;
	}

	@Override
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
        {
            this.mc.thePlayer.closeScreen();
            this.mc.setIngameFocus();
        }
    }
	
	@Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	public static ResourceLocation getTexture()
    {
        return texture;
    }

}
