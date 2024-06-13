package manager;

import characters.Character;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    // l'instance unique
    private static GameManager instance;

    private int score;
    private int currentTurn;
    private List<Character> characters;
    private List<String> combatHistory;


    //constructeur privé pour empeché l'instanciation de cette classe
    private GameManager() {
        this.score = 0;
        this.currentTurn = 0;
        this.characters = new ArrayList<>();
        this.combatHistory = new ArrayList<>();
    }


    //methode qui assure le principe du design pattern singleton on s'assurant qu'il y'a une seule
    //instance de cette classe dans tout le systeme
    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }


    //Getters and Setters

    public void addCharacter(Character playerCharacter) {
        characters.add(playerCharacter);
    }

    public void addCombatHistory(String record) {
        combatHistory.add(record);
    }

    public List<String> getCombatHistory() {
        return combatHistory;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void incrementTurn() {
        currentTurn++;
    }

}

