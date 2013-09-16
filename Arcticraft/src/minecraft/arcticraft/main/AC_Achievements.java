package arcticraft.main;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import arcticraft.blocks.AC_Block;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AC_Achievements
{

	public static AchievementPage AC_ACHIEVEMENT_PAGE;
	
	public static Achievement AC_ENTER;
	public static Achievement BACK_TO_BASICS;

	public static void initAchievements()
	{
		
		AC_ENTER = new Achievement(4750, "ENTER_AC", 0, 0, AC_Block.campfire, null).registerAchievement();
		BACK_TO_BASICS = new Achievement(4751, "BACK_TO_BASICS", 2, 0, AC_Block.frostLog, AC_ENTER).registerAchievement();

		addAchievementName("ENTER_AC", "BRRRRR.. It's cold!");
		addAchievementName("BACK_TO_BASICS", "Back To Basics");

		addAchievementDesc("ENTER_AC", "Enter The Arctic");
		addAchievementDesc("BACK_TO_BASICS", "Attack an Arctic tree until a block of wood comes out");
	
		AC_ACHIEVEMENT_PAGE = new AchievementPage("Achievements", AC_ENTER, 
				BACK_TO_BASICS
				);
		AchievementPage.registerAchievementPage(AC_ACHIEVEMENT_PAGE);
	}

	private static void addAchievementName(String ach, String name)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}

}
