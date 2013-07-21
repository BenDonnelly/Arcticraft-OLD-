package arcticraft.entities;

public interface AC_IBossDisplayData
{

	/**
	 * Max health of the boss.
	 */

	float func_110138_aP();

	/**
	 * Returns the health points of the boss.
	 */
	float func_110143_aJ();

	/**
	 * Gets the username of the entity.
	 */
	String getEntityName();

	boolean isMiniBoss();
}
