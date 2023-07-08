public interface Magical {

	/**
	 * MAGIC_MENU - Menu of the magical attacks.
	 * 
	 * @return - String representation of the menu
	 */
	public static final String MAGIC_MENU = "1. Magic Missle\n2. Fireball\n3. Thunderclap";

	/**
	 * magicMissile - abstract method for giving the random amount of damage via
	 * magical attack on the entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representation
	 */
	public abstract String magicMissle(Entity e);

	/**
	 * fireball - abstract method for giving the random amount of damage via
	 * fireball on the entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representation
	 */
	public abstract String fireball(Entity e);

	/**
	 * thunderClap - abstract method for giving the random amount of damage via
	 * thunder clap on the entity passed in.
	 * 
	 * @param e - entity
	 * @return - String representation
	 */
	public abstract String thunderclap(Entity e);
}
