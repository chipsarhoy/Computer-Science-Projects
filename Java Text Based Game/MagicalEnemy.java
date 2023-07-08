public class MagicalEnemy extends Enemy implements Magical {

	/**
	 * Constructor - Creates an Magical Enemy with the help of super method Enemy,
	 * 
	 * @param n   - name
	 * @param mHp - max Hp
	 */
	public MagicalEnemy(String n, int mHp) {
		super(n, mHp);
	}

	/**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representaion of the damage.
	 */
	@Override
	public String attack(Entity e) {
		int select = (int) (Math.random() * 3); // Random: 0 - 2
		if (select == 0) {
			return magicMissle(e);
		} else if (select == 1) {
			return fireball(e);
		} else
			return thunderclap(e);
	}

	/**
	 * magicMissile - give the random amount of damage via magical attack on the
	 * entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representaion of the damage.
	 */
	@Override
	public String magicMissle(Entity e) {
		int damageHp = (int) (Math.random() * 1) + 2; // Random: 2 - 3
		e.takeDamage(damageHp);
		return (this.getName() + " hits " + e.getName() + " with Magical Missle \nfor " + damageHp + " damage.");
	}

	/**
	 * fireball - give the random amount of damage via fireball on the entity passed
	 * in.
	 * 
	 * @param e - entity
	 * @return - String representaion of the damage.
	 */
	@Override
	public String fireball(Entity e) {
		int damageHp = (int) (Math.random() * 3) + 3; // Random: 3 - 5
		e.takeDamage(damageHp);
		return (this.getName() + " hits " + e.getName() + " with a fireball \nfor " + damageHp + " damage.");
	}

	/**
	 * thunderClap - give the random amount of damage via thunder clap on the entity
	 * passed in.
	 * 
	 * @param e - entity
	 * @return - String representaion of the damage.
	 */
	@Override
	public String thunderclap(Entity e) {
		int damageHp = (int) (Math.random() * 2) + 5; // Random: 5 - 6
		e.takeDamage(damageHp);
		return (this.getName() + " hits " + e.getName() + " with a thunderclap \nfor " + damageHp + " damage.");
	}

}