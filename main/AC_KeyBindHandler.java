package arcticraft.main;

import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class AC_KeyBindHandler extends KeyHandler
{

	//public static KeyBinding keyName = new KeyBinding("DisplayName", Keyboard.KEY_M);
	public static KeyBinding [] arrayOfKeys = new KeyBinding []
		{/*keyName*/};
	public static boolean [] areRepeating = new boolean []
		{false};

	public AC_KeyBindHandler()
	{
		super(arrayOfKeys, areRepeating);
	}

	@Override
	public String getLabel()
	{
		return "Arcticraft KeyBindings";
	}

	@Override
	public void keyDown(EnumSet <TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		if (tickEnd)
		{
			/*if(kb.keyCode == keyName.keyCode)
			{
			 //What you want to happen when the key is pressed
			}*/
		}
	}

	@Override
	public void keyUp(EnumSet <TickType> types, KeyBinding kb, boolean tickEnd)
	{

	}

	@Override
	public EnumSet <TickType> ticks()
	{
		return EnumSet.of(TickType.CLIENT);
	}
}
