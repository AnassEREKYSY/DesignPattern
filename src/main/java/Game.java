import characters.Character;
import characters.Enemy;
import factories.CharacterFactory;
import manager.GameManager;
import strategies.BowAttack;
import strategies.MagicAttack;
import strategies.SwordAttack;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-*-*-*-*-*-*-* Game -*-*-*-*-*-*-*");
        System.out.println("Choose your character (warrior, mage, archer): ");
        String characterType = scanner.nextLine();

        Character playerCharacter = CharacterFactory.createCharacter(characterType);
        gameManager.addCharacter(playerCharacter);

        for (int i = 0; i < 10; i++) {
            Enemy enemy = generateEnemyForRound(i + 1);
            simulateCombatRound(i + 1, playerCharacter, enemy, scanner, gameManager);

            if (!playerCharacter.isAlive()) {
                System.out.println("Game Over! You were defeated by " + enemy.getName());
                break;
            }
        }

        displayCombatHistory(gameManager);

        scanner.close();
    }

    private static Enemy generateEnemyForRound(int roundNumber) {
        return new Enemy("Enemy " + roundNumber, 30 + (int)(Math.random() * 20), 10 + (int)(Math.random() * 5), 2 + (int)(Math.random() * 3), new SwordAttack());
    }

    private static void simulateCombatRound(int roundNumber, Character playerCharacter, Enemy enemy, Scanner scanner, GameManager gameManager) {
        System.out.println("\n-*-*-* Combat " + roundNumber + " -*-*-*");
        System.out.println("Enemy: " + enemy.getName() + " (HP: " + enemy.getHealthPoints() + ")");

        while (playerCharacter.isAlive() && enemy.isAlive()) {
            playerCharacter.performAttack(enemy);

            if (enemy.isAlive()) {
                enemy.attack(playerCharacter);
            }

            System.out.println("Player HP: " + playerCharacter.getHealthPoints());
            System.out.println("Enemy HP: " + enemy.getHealthPoints());
        }

        if (!playerCharacter.isAlive()) {
            System.out.println("You were defeated by " + enemy.getName());
        } else {
            System.out.println("You defeated " + enemy.getName());
        }

        System.out.println("Do you want to change your attack strategy? (yes/no)");
        String changeStrategy = scanner.nextLine();
        if (changeStrategy.equalsIgnoreCase("yes")) {
            changeAttackStrategy(playerCharacter, scanner);
        }

        gameManager.addCombatHistory("Combat " + roundNumber + ": " + playerCharacter.getName() + " attacked " + enemy.getName());
    }

    private static void changeAttackStrategy(Character playerCharacter, Scanner scanner) {
        System.out.println("Choose new strategy (sword, magic, bow): ");
        String newStrategy = scanner.nextLine();
        switch (newStrategy.toLowerCase()) {
            case "sword":
                playerCharacter.setAttackStrategy(new SwordAttack());
                break;
            case "magic":
                playerCharacter.setAttackStrategy(new MagicAttack());
                break;
            case "bow":
                playerCharacter.setAttackStrategy(new BowAttack());
                break;
            default:
                System.out.println("Unknown strategy, keeping current strategy.");
        }
    }

    private static void displayCombatHistory(GameManager gameManager) {
        System.out.println("\n-*-*-* Combat History -*-*-*");
        for (String record : gameManager.getCombatHistory()) {
            System.out.println(record);
        }
    }
}
