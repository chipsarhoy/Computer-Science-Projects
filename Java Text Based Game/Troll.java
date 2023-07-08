public class Troll extends Enemy{
  /**
   * Troll - monster base class constructor with name and maxHp
   * @param n   - name
	 * @param mHp - maxHp
	 */
  public Troll(){
    super("Troll", 5);
 
  }/**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e){
    int damageHp = (int) (Math.random() * 5); // Random: 0 - 5(Troll dmg)
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");

  }
}