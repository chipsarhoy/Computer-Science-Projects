public class Hero extends Entity implements Magical {
	private Map map = Map.getInstance();
	private Point loc;
	private int level;
  private int gold;
  private int key;

	/**
	 * Constructor - Builds an hero(user) with the help of super class entity, load
	 * the map and find the start location of the hero on the map
	 * 
	 * @param n - name
	 */
	public Hero(String n) {
		super(n, 1);
		level = 1;
    gold = 20;
    key = 0;

		// loading the map of the specific level
		map.loadMap(level);

		// finding the start point in the map
		loc = new Point(map.findStart().x, map.findStart().y);
	}

	/**
	 * toString- String representation
	 * 
	 * @return - String representation
	 */
	@Override
	public String toString() {
		return super.toString() + "\nGold: " + gold + "\nTotal Keys: " + this.key + "\nLevel: " + level + map.mapToString(loc);
	}

	/**
	 * attack- give the random amount of the damage to the certain entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
	@Override
	public String attack(Entity e) {
		int damageHp = (int) (Math.random() * 2) + 1; // Random: 1 - 2
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
	}

	/**
	 * magicMissile - give the random amount of damage via magical attack on the
	 * entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
	@Override
	public String magicMissle(Entity e) {
		int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " hits " + e.getName() + " with Magical Missle \nfor " + damageHp + " damage.");
	}

	/**
	 * fireball - give the random amount of damage via fireball on the entity passed
	 * in.
	 * 
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
	@Override
	public String fireball(Entity e) {
		int damageHp = (int) (Math.random() * 4) + 1;// Random: 1 - 4
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " hits " + e.getName() + " with a fireball \nfor " + damageHp + " damage.");
	}

	/**
	 * thunderClap - give the random amount of damage via thunder clap on the entity
	 * passed in.
	 * 
	 * @param e - entity
	 * @return - String representation of the damage.
	 */
	@Override
	public String thunderclap(Entity e) {
		int damageHp = (int) (Math.random() * 5) + 1;// Random: 1 - 5
		e.takeDamage(damageHp);
		return ("\n" + this.getName() + " hits " + e.getName() + " with a thunderclap \nfor " + damageHp + " damage.");
	}

	/**
	 * levelUp - increase the level, then load the new map and show the start
	 * location.
	 */
	public void levelUp() {
		level += 1;
		int newLevel = level % 3;
		map.loadMap(newLevel);
		map.reveal(loc);
	}

  /**
   * getLevel - returns the level.
   */
  public int getLevel(){
    return level;
  }

	/**
	 * goNorth - move one step in the north direction
	 * 
	 * @return - character at new location.
	 */
	public char goNorth() {
		if (loc.x > 0) {
			loc.x -= 1;
			char character = map.getCharAtLoc(loc);
			return character;
		}
		return 'x';
	}

	/**
	 * goSouth - move one step in the south direction
	 * 
	 * @return - character at new location.
	 */
	public char goSouth() {
		if (loc.x < 4) {
			loc.x += 1;
			char character = map.getCharAtLoc(loc);
			return character;
		}
		return 'x';
	}

	/**
	 * goEast - move one step in the east direction
	 * 
	 * @return - character at new location.
	 */
	public char goEast() {
		if (loc.y < 4) {
			loc.y += 1;
			char character = map.getCharAtLoc(loc);
			return character;
		}
		return 'x';
	}

	/**
	 * goWest - move one step in the west direction
	 * 
	 * @return - character at new location.
	 */
	public char goWest() {
		if (loc.y > 0) {
			loc.y -= 1;
			char character = map.getCharAtLoc(loc);
			return character;
		}
		return 'x';
	}
  /**
   * getLoc - retrieve hero's location
   * @return loc - hero's location
   */
  public Point getLoc() {
		return loc;
	}

  public int getGold(){
    return gold; 
  }
  public void collectGold(int g) {
    gold += g;
  }
  public void spendGold(int g) {
    gold -= g;
    
  }
  /**
   * hasKey - check if hero has a key
   * @return true if hero has more than 0 keys
   * @return false if hero has 0 keys
   */
  public boolean hasKey() {
	if(key > 0) {
		return true;
	}
	  return false;
	}
	/*
   * pickUpKey - increments number of keys
   */
	public void pickUpKey() {
		key += 1;
	}
	/**
   * useKey - remove hero's key(s) by one if hero has a key
   * @return true if a key has been removed
   * @return false if hero does not have a key
   */
	public boolean useKey() {
		if(hasKey() == true) {
			key -= 1;
			return true;
		}
		return false;
	}
}