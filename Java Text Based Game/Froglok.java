public class Froglok extends Enemy{
  /**
   * Froglok - monster base class constructor with name and maxHp
   * @param n   - name
	 * @param mHp - maxHp
	 */
  public Froglok(){
    super("Froglok", 3);
  }
  /**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e){
    int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3(Froglok dmg)
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");

  }
}