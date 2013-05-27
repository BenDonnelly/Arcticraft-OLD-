package arcticraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class AC_ItemLantern extends ItemBlock
{
	public AC_ItemLantern(int itemID)
	{
		super(itemID);
		this.maxStackSize = 1;
		this.setMaxDamage(16); //A lantern shouldn't get removed when it is empty, which equals 15
	}

	public int getMetadata(int meta)
	{
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List descriptiveList, boolean b)
	{
		if (stack.getItemDamage() == 0) descriptiveList.add("Full");
		else if (stack.getItemDamage() == 15) descriptiveList.add("Empty");
		else descriptiveList.add("Fuel level: " + (15-stack.getItemDamage) + "/15";
	}
}
