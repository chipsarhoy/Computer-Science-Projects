public class Warrior extends EnemyDecorator{
  /**
	 * Constructor - Builds an enemy with the help of super method entity and enemy. 
	 * @param n   - name
	 * @param mHp - maxHp
   * @param e   - enemy
	 */

  public Warrior(Enemy e){
    super(e, e.getName(), 2 + e.getMaxHp());
  }
  /**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e){
    super.attack(e);
    int damageHp = (int) (Math.random() * 2) + 1; // Random: 1 - 3(Warriors dmg)
		e.takeDamage(damageHp);
		return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");

  }
  @Override
  public String getName(){
    return super.getName() + " Warrior";

  }
}