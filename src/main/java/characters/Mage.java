package characters;

import strategies.MagicAttack;

public class Mage extends Character {
    public Mage() {
        this.name = "Mage";
        this.healthPoints = 100;
        this.attackPoints = 70;
        this.defensePoints = 20;
        this.attackStrategy = new MagicAttack();
    }
}
