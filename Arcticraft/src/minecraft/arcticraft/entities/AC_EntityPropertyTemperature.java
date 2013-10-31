package arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import arcticraft.gui.AC_GuiEskimoTalk;
import arcticraft.helpers.AC_TemperatureHelper;

public class AC_EntityPropertyTemperature implements IExtendedEntityProperties
{

	private EntityPlayer player;


	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		compound.setInteger("ACTemperature", this.player.getDataWatcher().getWatchableObjectInt(AC_TemperatureHelper.tempID));
		compound.setBoolean("CollectedReward", AC_GuiEskimoTalk.hasCollectedReward);
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		this.player.getDataWatcher().updateObject(AC_TemperatureHelper.tempID, Integer.valueOf(compound.getInteger("ACTemperature")));
		AC_GuiEskimoTalk.hasCollectedReward = compound.getBoolean("CollectedReward");
	}

	@Override
	public void init(Entity entity, World world)
	{
		entity.getDataWatcher().addObject(AC_TemperatureHelper.tempID, Integer.valueOf(50));

		this.player = (EntityPlayer) entity;
	}

}
