/**
 * CECS 277 Project 01 Group 34 : Richard Nguyen
 * 
 * This program builds up an game for the user. First it builds an hero (user)
 * and load up the map to the user. At first the hero (user) will be at the
 * start point on the map. User then allowed to move in all four directions in
 * the map. User will not be allowed to move out of the map. When moving in
 * different directions user will find health potion, monster or a finish point.
 * User may find nothing at some locations. Upon finding the monster, the user
 * will be able to fight with different attacks or run away. If the user reaches
 * the finish point, the level will be proceeded and a new map will be loaded.
 * All the inputs are checked and validated.
 */

public class Main {

	public static void main(String[] args) {
		char letter = ' ';

		// generating an enemy
		EnemyGenerator genEnemy = new EnemyGenerator();

		// asking for user name
		System.out.print("What is your name, traveler? ");
		String name = CheckInput.getString();

		// creating an hero
		Hero mainCharacter = new Hero(name);
		boolean run = true;

		// loop till the hero is in the game
		while (run) {
			Map map = Map.getInstance();
			// printing out the user info, map and the asking user to move in a direction
			System.out.println(mainCharacter.toString());
			System.out.println("1. Go North");
			System.out.println("2. Go South");
			System.out.println("3. Go East");
			System.out.println("4. Go West");
			System.out.println("5. Quit");
			int selection = CheckInput.getIntRange(1, 5);
			System.out.println();

			// moving the hero as per the user's choice
			switch (selection) {
			case 1:
				letter = mainCharacter.goNorth();
				break;
			case 2:
				letter = mainCharacter.goSouth();
				break;
			case 3:
				letter = mainCharacter.goEast();
				break;
			case 4:
				letter = mainCharacter.goWest();
				break;
			case 5:
				System.out.println("Game Over");
				run = false;
				break;
			}
			map.reveal(mainCharacter.getLoc());
// if the hero is in the game
			if (run) {
				if (letter == 'x') {
					// Cannot move outside the box
					System.out.println("Location was out of bounds");
				} else if (letter == 'n') {
					// Some location have nothing there
					System.out.println("There was nothing here.");
				} else if (letter == 's') {
					// if the user reaches at the start
					store(mainCharacter);
				} else if (letter == 'f') {
					if(mainCharacter.hasKey()) {
						// if the user reaches the end and increase the level if the user has a key
						System.out.println("You found the exit.  Proceeding to the \nnext level.");
						mainCharacter.levelUp();
            mainCharacter.useKey();
					} else {
						System.out.println("You don't have a key to open the door.");
					}
				} else if (letter == 'i') {
					//70% chance for a key spawn
					int randKey = (int)(Math.random()*10); //0 - 9
					if(randKey > 2) {
						System.out.println("You found a Health Potion! You drink it \nto restore your health.");
						System.out.println("You also found a key!");
						mainCharacter.pickUpKey();
            mainCharacter.heal(25);
					} else {
						// if the user finds a potion for healing
						System.out.println("You found a Health Potion!  You drink it \nto restore your health.");
						map.removeCharAtLoc(mainCharacter.getLoc());
						mainCharacter.heal(25);
					}
					
				} else if (letter == 'm') {
					// if the user encounters a monster
					run = monsterRoom(mainCharacter, genEnemy.generateEnemy(mainCharacter.getLevel()));
				}
			}
			System.out.println();
		}
	}

	/**
	 * monsterRoom - Describes the situation when the hero come across the monster
	 * and then ask user for multiple options.
	 * 
	 * @param h - hero
	 * @param e - enemy
	 * @return - Signal if the user alive or not
	 */
		public static boolean monsterRoom(Hero h, Enemy e) {
    EnemyGenerator genEnemy = new EnemyGenerator();
		Map map = Map.getInstance();
		boolean continueFight = true;
		boolean alive = true;
		char letter = ' ';

		// Introducing the enemy to the user
		
		System.out.println("You have encountered a " + e.getName() + ".");

		// while the fight goes on and both are alive
		while (continueFight && e.getHp() > 0) {
			// Printing out the monster info.
      System.out.println();
			System.out.println(e.getName() + "\nHP: " + e.getHp() + "/" + e.getMaxHp());
			System.out.println();
      // Printing out player health info during battle.
      System.out.println(h.getName() + "\nHP: " + h.getHp() + "/" + h.getMaxHp());
      System.out.println();
			// Asking user either to fight or run away.
			System.out.println("1. Fight \n2. Run Away");
			int choice = CheckInput.getIntRange(1, 2);
			if (choice == 1) {
				// when user chooses to fight
				alive = fight(h, e);
				if (!alive) {
					return alive;
					
				}
			} else {
				// when the user chooose to run away.
				int randomMove = (int) (Math.random() * 4); // Random: 0-3
				switch (randomMove) {
				case 0:
					letter = h.goNorth();
					map.reveal(h.getLoc());
					break;
				case 1:
					letter = h.goSouth();
					map.reveal(h.getLoc());
					break;
				case 2:
					letter = h.goEast();
					map.reveal(h.getLoc());
					break;
				case 3:
					letter = h.goWest();
					map.reveal(h.getLoc());
					break;
				}

				System.out.println();
				if (letter == 'x') {
					// Cannot move outside the box
					System.out.println("Location was out of bounds");
				} else if (letter == 'n') {
					// Some location have nothing there
					System.out.println("There was nothing here.");
				} else if (letter == 's') {
					// if the user reaches at the start
					store(h);
				} else if (letter == 'f') {
					if(h.hasKey()) {
						// when the user reaches the end and increase in the level
						System.out.println("You found the exit.  Proceeding to the \nnext level.");
						h.levelUp();
            h.useKey();
					} else {
            System.out.println("You found the exit.");
						System.out.println("You don't have a key to open the door.");
					}
				} else if (letter == 'i') {
					//70% chance for a key spawn
					int randKey = (int)(Math.random()*10); //0 - 9
					if(randKey > 2) {
						System.out.println("You found a Health Potion! You drink it \nto restore your health.");
						System.out.println("You also found a key!");
						h.pickUpKey();
            h.heal(25);
					} else {
						// when the user found potion for healing up
						System.out.println("You found a Health Potion!  You drink it \nto restore your health.");
						map.removeCharAtLoc(h.getLoc());
						h.heal(25);
					}
				} else if (letter == 'm') {
          monsterRoom(h, genEnemy.generateEnemy(h.getLevel()));
        }
				System.out.println();
				continueFight = false;
			}
		}
		return alive;
	}

	/**
	 * fight - Builds up an fight between the hero and the monster.
	 * 
	 * @param h - hero
	 * @param e - enemy
	 * @return - true if the hero alive or false otherwise.
	 */
	public static boolean fight(Hero h, Enemy e) {
		// Asking user for either physical attack or magic attack
		System.out.println("\n1. Physical Attack");
		System.out.println("2. Magic Attack");
		int attackType = CheckInput.getIntRange(1, 2);

		if (attackType == 1) {
			// if the user choose for physical attack
			System.out.println(h.attack(e));
		} else {
			// if the user choose for magical attack, then asking user to select one of
			// three types.
			System.out.println("\n1. Magic Missle\n2. Fireball\n3. Thunderclap");
			int magicAttack = CheckInput.getIntRange(1, 3);
			if (magicAttack == 1) {
				System.out.println(h.magicMissle(e));
			} else if (magicAttack == 2) {
				System.out.println(h.fireball(e));
			} else
				System.out.println(h.thunderclap(e));
		}

		if (e.getHp() > 0) {
			// if the monster is still alive, it will attack back
			System.out.println(e.attack(h));
		} else {
      int g = (int) (Math.random() * 10) + 3;// Random: 3 - 10
		  h.collectGold(g);
      System.out.println("\n" + h.getName() + " has defeated the " + e.getName() + " and collected " + g + " gold coins");
    }
		
		if (h.getHp() > 0 && e.getHp() <= 0) {
			Map map = Map.getInstance();
			map.removeCharAtLoc(h.getLoc());
		}

		if (h.getHp() > 0) {
			// if the hero is still alive then return true.
			return true;
		} else {
			// if the user dies then the game is finished.
			System.out.println(h.getName() + " was defeated by " + e.getName());
			System.out.println("\nYou're dead.\nYou're friends are dead.\nYou're family's dead.\nYou're fucking pets are being skinned alive.\nYour moms a fuckin' whore.\nYou suck at life.\nThe whole world hates you.\nYou're going to hell.\nLive with it.\n\n Game Over");
			return false;
		}
	}
  
  /* store - New menu to buy either keys or health potions.
   *
   * @param h - Hero
   */
  public static void store(Hero h) {
    // The store will keep running as long as shop is true.
    boolean shop = true;
  
    while(shop != false) {
      System.out.println("\nGold: " + h.getGold());
      if (h.hasKey() == true) {
        // The shop will notify the player if a key is already in possession.
        System.out.println("You have a key!");
      } else { System.out.println("You do not have a key!");}
        // The shop's menu will then be displayed .
      System.out.println();
        System.out.println("Welcome to the store " + h.getName() + "!");
        System.out.println("What would you like to buy?");
        System.out.println("1. Health Potion (25 Gold)");
        System.out.println("2. Key (50 Gold)");
        System.out.println("3. Exit Shop");
        
        int selection = CheckInput.getIntRange(1, 3);
      
        if (selection == 1 && h.getGold() >= 25) {
          // if the player has at least 25 gold then they can buy a potion.
          h.spendGold(25);
          h.heal(25);
          System.out.println("You bought a potion! You drink it\n to restore health!");
        } else if (selection == 2 && h.getGold() >= 50) {
          // if the player has at least 50 gold then they can buy a key.
            h.spendGold(50);
            h.pickUpKey();
            System.out.println("You bought a key! You can now proceed through the exit!");
        } else if (selection == 1 && h.getGold() < 25) {
          // if the player attempts to buy a potion without enough gold,
          // the store will notify the player.
            System.out.println("You cannot afford this item!");
        } else if (selection == 2 && h.getGold() < 50) {
          // if the player attempts to buy a key without enough gold,
          // the store will notify the player
            System.out.println("You cannot afford this item!");
        } else if (selection == 3) {
          // if the player exits the shop, they will be brought back to the start
          // space of the map.
            shop = false;
            System.out.println("\nYou are back to the start.");
            break;
        }  
      }
    }
  }