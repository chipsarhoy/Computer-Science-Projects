public abstract class Enemy extends Entity {

	/**
	 * Constructor - Builds an enemy with the help of super method entity. 
	 * @param n   - name
	 * @param mHp - maxHp
	 */
	public Enemy(String n, int mHp) {
		super(n, mHp);
	}
}