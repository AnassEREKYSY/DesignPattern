package factories;

import characters.Enemy;

public class EnemyFactory {
    public static Enemy createEnemy(int roundNumber) {
        String name = "Enemy " + roundNumber;
        int healthPoints = 30 + (int)(Math.random() * 20);
        int attackPoints = 5 + (int)(Math.random() * 5);
        int defensePoints = 2 + (int)(Math.random() * 3);

        return new Enemy(name, healthPoints, attackPoints, defensePoints);
    }
}
