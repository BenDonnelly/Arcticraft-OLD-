package arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class AC_EntityPropertyTemperature implements IExtendedEntityProperties {
	
	private EntityPlayer player;
	private static final int tempID = 19;
	public static final int maxTemp = 100;
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setInteger("ACTemperature", this.getTemperature());
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		this.setTemperature(compound.getInteger("ACTemperature"));
	}

	@Override
	public void init(Entity entity, World world) {
		//TODO Datawatcher is unnecessary. Use local variable instead, remove AC_TemperatureHelper
		entity.getDataWatcher().addObject(tempID, Integer.valueOf(50));
		
		this.player = (EntityPlayer) entity;
	}
	
	public int getTemperature() {
		return this.player.getDataWatcher().getWatchableObjectInt(tempID);
	}
	
	public void setTemperature(int temp) {
		this.player.getDataWatcher().updateObject(tempID, Integer.valueOf(temp));
	}

}
