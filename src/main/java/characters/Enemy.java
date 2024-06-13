package characters;

import strategies.IAttackStrategy;

public class Enemy {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private IAttackStrategy attackStrategy;

    public Enemy(String name, int healthPoints, int attackPoints, int defensePoints, IAttackStrategy attackStrategy) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.attackStrategy=attackStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void attack(Character player) {
        int damage = Math.max(0, getAttackPoints());
        if (damage > 0) {
            player.takeDamage(damage);
        } else {
            // If the calculated damage is zero or negative, apply a minimum damage
            player.takeDamage(1);
            damage = 1;
        }
        System.out.println(name + " attaque ! " + player.getName() + " subit " + damage + " points de dégâts.");
    }
}