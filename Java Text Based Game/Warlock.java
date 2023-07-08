public class Warlock extends EnemyDecorator implements Magical{
  /**
	 * Constructor - Builds an enemy with the help of super method entity and enemy. 
	 * @param n   - name
	 * @param mHp - maxHp
   * @param e   - enemy
	 */

  public Warlock(Enemy e){
    super(e, e.getName(), 1 + e.getMaxHp());
  }
  /**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - magical attack methods.
	 */
  @Override
  public String attack(Entity e){
    
		int select = (int) (Math.random() * 2); // Random: 0 - 2
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
    super.attack(e);
		int damageHp = (int) (Math.random() * 1); // Random: 0 - 2
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
    super.attack(e);
		int damageHp = (int) (Math.random() * 2); // Random: 0 - 3
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
    super.attack(e);
		int damageHp = (int) (Math.random() * 2) + 1; // Random: 1 - 3
		e.takeDamage(damageHp);
		return (this.getName() + " hits " + e.getName() + " with a thunderclap \nfor " + damageHp + " damage.");
	}
  @Override
  public String getName(){
    return super.getName() + " Warlock";

  }
}