public abstract class EnemyDecorator extends Enemy{
  private Enemy enemy;
  /**
	 * Constructor - Builds an enemy with the help of super method entity and enemy. 
	 * @param n   - name
	 * @param mHp - maxHp
   * @param e   - enemy
	 */
  public EnemyDecorator(Enemy e, String n, int h){
    super(n, h);
    enemy = e;
  }
  /**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
  @Override
  public String attack(Entity e) {
   return e.attack(enemy);
  }
}