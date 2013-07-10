package arcticraft.main;

import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;

public class AC_DispenserBehaviours
{

	public static void func_96467_a()
	{

		BlockDispenser.dispenseBehaviorRegistry.putObject(MainRegistry.bomb, new AC_DispenserBehaviourBomb());
		BlockDispenser.dispenseBehaviorRegistry.putObject(MainRegistry.IceShard, new AC_DispenserBehaviorIceshard());
		AC_DispenserBehaviorFilledBucket dispenserbehaviorfilledbucket = new AC_DispenserBehaviorFilledBucket();
		BlockDispenser.dispenseBehaviorRegistry.putObject(MainRegistry.bucketIcyWater, dispenserbehaviorfilledbucket);
		BlockDispenser.dispenseBehaviorRegistry.putObject(MainRegistry.bucketEmpty, new AC_DispenserBehaviorEmptyBucket());
	}
}
