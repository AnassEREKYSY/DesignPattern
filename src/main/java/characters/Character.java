package characters;

import strategies.IAttackStrategy;

//Model du character
public abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int defensePoints;
    protected IAttackStrategy attackStrategy;



    // Getters and Setters

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
    public int getDefensePoints() {
            return defensePoints;
    }
    public void setDefensePoints(int defensePoints) {
            this.defensePoints = defensePoints;
    }
    public IAttackStrategy getAttackStrategy() {
        return attackStrategy;
    }


    public void takeDamage(int damage) {
        healthPoints -= damage;
    }
    public boolean isAlive() {
        return healthPoints > 0;
    }
    public void performAttack(Enemy enemy) {
        int damage = attackStrategy.attack(); // Assuming the attack method returns damage points
        enemy.takeDamage(damage);
        System.out.println(name + " attacks " + enemy.getName() + " for " + damage + " damage.");
    }
    public void setAttackStrategy(IAttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

}
