import java.io.*;
import java.util.Random;


public class EnemyGenerator {


  /**
   * generateEnemy - randomly generates and recieves enemy info from their 
   * respective class and decorates warrior and warlock while progressing 
   * through game.
   *
   * @param level - int
   * @return enemy/MagicEnemy
   */
  public Enemy generateEnemy(int level) {
    Random rand = new Random();

    // Randomly generate a base enemy 
    int rand_enemy = rand.nextInt(4);
    if (rand_enemy == 0) {
      Enemy g = new Goblin();
      // Randomly decorates base enemy if level is greater than 1.
      if (level > 1) {
        int decorator = rand.nextInt(2);
        for (int i = 1; level > i; i++) {
          // for loop to decorate the enemy as player progresses to a new level.
          if (decorator == 0) {
            g = new Warrior(g);
          } else if (decorator == 1) {
            g = new Warlock(g);  
          }
        } 
        // returns decorated enemy 
        return g;
      } else {
        // returns base enemy when level is still 1
        return g;
      }
    } else if (rand_enemy == 1) {
      Enemy f = new Froglok();
      if (level > 1) {
        int decorator = rand.nextInt(2);
        for (int i = 1; level > i; i++) {
          if (decorator == 0) {
            f = new Warrior(f);
          } else if (decorator == 1) {
            f = new Warlock(f);
          }
        }
        return f;
      } else {
        return f;
      }
    } else if (rand_enemy == 2) {
      Enemy o = new Orc();
      if (level > 1) {
        int decorator = rand.nextInt(2);
        for (int i = 1; level > i; i++) {
          if (decorator == 0) {
            o = new Warrior(o);
          } else if (decorator == 1) {
            o = new Warlock(o);
          }
        }
        return o;
      } else {
        return o;
      }
    } else {
      Enemy t = new Troll();
      if (level > 1) {
        int decorator = rand.nextInt(2);
        for (int i = 1; level > i; i++) {
          if (decorator == 0) {
            t = new Warrior(t);
            return t;
          } else if (decorator == 1) {
            t = new Warlock(t);
            return t;
          }
        }
      return t;
      } else {
        return t;
      }
    }
  }
}
