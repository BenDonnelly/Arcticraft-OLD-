package arcticraft.helpers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import arcticraft.entities.AC_EskimoTrade;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class AC_PacketHandler implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		if(packet.channel.equals("AC_EskimoTrade"))
		{
			this.handleEskimoTrade(packet, player);
		}
		else if(packet.channel.equals("AC_EskimoTalk"))
		{
			this.handleEskimoTalk(packet, player);
		}
	}

	private void handleEskimoTalk(Packet250CustomPayload packet, Player plyr)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		int itemID;
		int stackSize;
		int damageValue;

		try
		{
			itemID = inputStream.readInt();
			stackSize = inputStream.readInt();
			damageValue = inputStream.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}

		ItemStack stack = new ItemStack(itemID, stackSize, damageValue);
		EntityPlayer player;

		if(plyr instanceof EntityPlayer)
		{
			player = (EntityPlayer) plyr;
		}
		else
		{
			return;
		}

		player.inventory.addItemStackToInventory(stack);
	}

	private void handleEskimoTrade(Packet250CustomPayload packet, Player plyr)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		int itemID;
		int stackSize;
		int damageValue;
		int gems;

		try
		{
			itemID = inputStream.readInt();
			stackSize = inputStream.readInt();
			damageValue = inputStream.readInt();
			gems = inputStream.readInt();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}

		ItemStack stack = new ItemStack(itemID, stackSize, damageValue);
		EntityPlayer player;

		if(plyr instanceof EntityPlayer)
		{
			player = (EntityPlayer) plyr;
		}
		else
		{
			return;
		}

		if(AC_EskimoTrade.removeGemsFromInventory(player.inventory, gems))
		{
			player.addChatMessage("You have bought: " + stack.stackSize + "x " + stack.getDisplayName());
			player.inventory.addItemStackToInventory(stack);
		}
	}
}
