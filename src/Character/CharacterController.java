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
    
    /* Setter/Getter for Character names */
    public void setName(Character ch, String name){
        setModelProperty(ELEMENT_NAME_PROPERTY, name);
    };
    public String getName(Character ch){
        return ch.getName();
    };
    /* Setter/Getter for Character's Player name */
    public void setPlayer(Character ch, String player){
        setModelProperty(ELEMENT_PLAYER_PROPERTY, player);
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
                setModelProperty(ELEMENT_HP_PROPERTY, input);
                break;
            case "Speed": case "speed":
                setModelProperty(ELEMENT_SPEED_PROPERTY, input);
                break;
            case "AP": case "ap":
                setModelProperty(ELEMENT_AP_PROPERTY, input);
                break;
            case "Initiative": case "initiative":
                setModelProperty(ELEMENT_INITIATIVE_PROPERTY, input);
                break;
            case "STR": case "str":
                setModelProperty(ELEMENT_STR_PROPERTY, input);
                break;
            case "DEX": case "dex":
                setModelProperty(ELEMENT_DEX_PROPERTY, input);
                break;
            case "INT": case "int":
                setModelProperty(ELEMENT_INT_PROPERTY, input);
                break;
            case "CurrentHP": case "currenthp": case "currentHP":
                setModelProperty(ELEMENT_CURRENTHP_PROPERTY, input);
                break;
            case "CurrentAP": case "currentap": case "currentAP":
                setModelProperty(ELEMENT_CURRENTAP_PROPERTY, input);
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
    
}
