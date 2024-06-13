package characters;

import strategies.BowAttack;

public class Archer extends Character {
    public Archer() {
        this.name = "Archer";
        this.healthPoints = 120;
        this.defensePoints = 25;
        this.attackStrategy = new BowAttack();
    }
}
