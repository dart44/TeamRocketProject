/*
 * @module Character
 * @author Jeremy Crook
 * Class: CharacterController
 * Date: March 12th, 2015
 * Last Updated: March 26th, 2015
 * This class serves as a Controller for the Character Model class.
 * TODO code Attack attributes
 */
package Character;

import java.util.Random;
import teamrocketproject.MasterController;

public class CharacterController extends MasterController {
    /* Properties for PropertyChangeEvents */
    public static final String
    ELEMENT_NAME_PROPERTY = "Name",
    ELEMENT_PLAYER_PROPERTY = "Player",
    ELEMENT_HP_PROPERTY = "HP",
    ELEMENT_SPEED_PROPERTY = "Speed",
    ELEMENT_AP_PROPERTY = "AP",
    ELEMENT_INITIATIVE_PROPERTY = "Initiative",
    ELEMENT_STR_PROPERTY = "STR",
    ELEMENT_DEX_PROPERTY = "DEX",
    ELEMENT_INT_PROPERTY = "INT",
    ELEMENT_CURRENTHP_PROPERTY = "CurrentHP",
    ELEMENT_CURRENTAP_PROPERTY = "CurrentAP";
    
    /* Empty Constructor */
    public CharacterController(){
    };
    
    /* Constructor for Character */
    public void addCharacter(String player){
        addModel(new Character(player));
    };
    
    /* Destrcutor for Character */
    public void removeCharacter(Character c){
        removeModel(c);
    };
    
    /* Setter/Getter for Character names */
    public void setName(Character ch, String name){
        ch.setName(name);
    };
    public String getName(Character ch){
        return ch.getName();
    };
    /* Setter/Getter for Character's Player name */
    public void setPlayer(Character ch, String player){
        ch.setPlayer(player);
    };
    public String getPlayer(Character ch){
        return ch.getPlayer();
    };
    
    /* Setters for Character int attributes.
     * Example: CharacterController.Set(Character, "Speed", 2) 
     * sets Character's speed variable to 2.
     */
    public void set(Character ch, String function, int input){
        switch (function) {
            case "HP": case "hp":
                ch.setHP(input);
                break;
            case "Speed": case "speed":
                ch.setSpeed(input);
                break;
            case "AP": case "ap":
                ch.setAP(input);
                break;
            case "Initiative": case "initiative":
                ch.setInitiative(input);
                break;
            case "STR": case "str":
                ch.setSTR(input);
                break;
            case "DEX": case "dex":
                ch.setDEX(input);
                break;
            case "INT": case "int":
                ch.setINT(input);
                break;
            case "CurrentHP": case "currenthp": case "currentHP":
                ch.setCurrentHP(input);
                break;
            case "CurrentAP": case "currentap": case "currentAP":
                ch.setCurrentAP(input);;
                break;
            default:
                System.out.println("Invalid Set request.");
        }
    };
    
    /* Getters for Character int attributes.
     * Example: CharacterController.Get(Character, "Speed") 
     * returns Character's speed variable as an int.
     */    
    public int get(Character ch, String function){
        switch (function){
            case "HP": case "hp":
                return ch.getHP();
            case "Speed": case "speed":
                return ch.getSpeed();
            case "AP": case "ap":
                return ch.getAP();
            case "Initiative": case "initiative":
                return ch.getInitiative();
            case "STR": case "str":
                return ch.getSTR();
            case "DEX": case "dex":
                return ch.getDEX();
            case "INT": case "int":
                return ch.getINT();
            case "CurrentHP": case "currenthp": case "currentHP":
                return ch.getCurrentHP();
            case "CurrentAP": case "currentap": case "currentAP":
                return ch.getCurrentAP();
            default:
                System.out.println("Invalid Get request.");
                return 0;
        }
    };
    
    /* Convenience methods for checking HP/AP */
    public Boolean CheckHP(Character ch){
        if (ch.getCurrentHP() <= 0){
            return false;
        }
        return true;
    }
    
    public Boolean CheckAP(Character ch){
        if (ch.getCurrentAP() <= 0) {  
            return false;
        }
        return true;
    }
    
    /* Attack method */
    public void Attack(Character attacker, Character target, int AP){
        if (AP > attacker.getCurrentAP()){
            //TODO display invalid AP input
            return;
        }
        int ATK = attacker.getSTR();
        //TODO Check if attacker is in range of target
        //TODO implement Weapons with different stats/ranges
        /* Determine % chance to hit */
        int hitChance = AP * ATK;
        if (hitChance > 100){
            hitChance = 100;
        }
        //TODO Display HitChance to player
        //TODO Confirm attack
        
        /* Determine if the attack hits */
        Random r = new Random();
        int d100 = r.nextInt((100 - 1) + 1) + 1;
        if (d100 <= hitChance){
            /* Determine and deal damage */
            int damage = (int) Math.floor(ATK/4) * (int) Math.floor((AP - d100)/10);
            target.setCurrentHP(target.getCurrentHP()-damage);
        }
        //TODO Display miss
    }
}
