public class Goblin extends Enemy{
  /**
  * Goblin - monster base class constructor with name and maxHp
   * @param n   - name
	 * @param mHp - maxHp
	 */
  public Goblin(){
    super("Goblin", 2);
		
  }
  /**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e){
    int damageHp = (int) (Math.random() * 2); // Random: 0 - 2(Goblin dmg)
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");

  }
}