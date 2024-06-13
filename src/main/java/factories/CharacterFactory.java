package factories;

import characters.Archer;
import characters.Character;
import characters.Mage;
import characters.Warrior;

// Class Factory du Character
public class CharacterFactory {
    public static Character createCharacter(String type) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior();
            case "mage":
                return new Mage();
            case "archer":
                return new Archer();
            default:
                throw new IllegalArgumentException("Unknown character type");
        }
    }
}
