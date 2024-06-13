package characters;

import strategies.SwordAttack;

public class Warrior extends Character {
    public Warrior() {
        this.name = "Warrior";
        this.healthPoints = 150;
        this.attackPoints = 50;
        this.defensePoints = 30;
        this.attackStrategy = new SwordAttack();
    }
}
