public abstract class Entity {
	private String name;
	private int maxHp;
	private int hp;

	/**
	 * Constructor - Creates an character with name, hp and maxHp
	 * 
	 * @param n   - name
	 * @param mHp - Maximum Hp
	 */
	public Entity(String n, int mHp) {
		name = n;
		maxHp = mHp;
		hp = mHp;
	}

	/**
	 * attack - Abstract class
	 * 
	 * @param e - entity
	 * @return - type of attack in String
	 */
	public abstract String attack(Entity e);

	/**
	 * getName
	 * 
	 * @return - Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getHp
	 * 
	 * @return - Hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * getMaxHp
	 * 
	 * @return - Maximum Hp
	 */
	public int getMaxHp() {
		return maxHp;
	}

	/**
	 * heal - heal the character with certain amount
	 * 
	 * @param h - amount to heal
	 */
	public void heal(int h) {
		hp += h;
		if (hp > maxHp) {
			hp = maxHp;
		}
	}

	/**
	 * takeDamage - give certain damage to the character
	 * 
	 * @param d - amount of damage
	 */
	public void takeDamage(int d) {
		hp -= d;
		if (hp < 0) {
			hp = 0;
		}
	}

	/**
	 * toString- String representation
	 * 
	 * @return - String representation
	 */
	@Override
	public String toString() {
		return "\n" + name + "\nHP: " + hp + "/" + maxHp;
	}
}