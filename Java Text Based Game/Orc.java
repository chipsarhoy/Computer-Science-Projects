public class Orc extends Enemy{
  /**
   * Orc - monster base class constructor with name and maxHp
   * @param n   - name
	 * @param mHp - maxHp
	 */
  public Orc(){
    super("Orc", 4);

  }/**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e){
    int damageHp = (int) (Math.random() * 4); // Random: 0 - 4(Orc dmg)
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");

  }
}