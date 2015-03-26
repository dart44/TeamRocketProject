/*
 * @module Character
 * @author Jeremy Crook
 * Class: Character
 * Date: March 12th, 2015
 * Last Updated: March 26th, 2015
 * This class serves as a Controller for the Character
 * class.
 */
package Character;

import teamrocketproject.MasterController;

public class CharacterController extends MasterController {
    /* Properties for PropertyChangeEvents */
    public static final String
    ELEMENT_NAME_PROPERTY = "Name",
    ELEMENT_HP_PROPERTY = "HP",
    ELEMENT_SPEED_PROPERTY = "Speed",
    ELEMENT_AP_PROPERTY = "AP",
    ELEMENT_INITIATIVE_PROPERTY = "Initiative",
    ELEMENT_STR_PROPERTY = "STR",
    ELEMENT_DEX_PROPERTY = "DEX",
    ELEMENT_INT_PROPERTY = "INT",
    ELEMENT_CURRENTHP_PROPERTY = "CurrentHP",
    ELEMENT_CURRENTAP_PROPERTY = "CurrentAP";
    
    
    public CharacterController(){
    };
    
    public void setName(Character ch, String name){
        setModelProperty(ELEMENT_NAME_PROPERTY, name);
    };
    public String getName(Character ch){
        return ch.getName();
    };
    
    /* Setters for Character int variables.
     * Example: CharacterController.Set(Character, "Speed", 2) 
     * sets Character's speed variable to 2.
     */
    public void set(Character ch, String function, int input){
        switch (function) {
            case "HP":
                setModelProperty(ELEMENT_HP_PROPERTY, input);
                break;
            case "Speed":
                setModelProperty(ELEMENT_SPEED_PROPERTY, input);
                break;
            case "AP":
                setModelProperty(ELEMENT_AP_PROPERTY, input);
                break;
            case "Initiative":
                setModelProperty(ELEMENT_INITIATIVE_PROPERTY, input);
                break;
            case "STR":
                setModelProperty(ELEMENT_STR_PROPERTY, input);
                break;
            case "DEX":
                setModelProperty(ELEMENT_DEX_PROPERTY, input);
                break;
            case "INT":
                setModelProperty(ELEMENT_INT_PROPERTY, input);
                break;
            case "CurrentHP":
                setModelProperty(ELEMENT_CURRENTHP_PROPERTY, input);
                break;
            case "CurrentAP":
                setModelProperty(ELEMENT_CURRENTAP_PROPERTY, input);
                break;
            default:
                System.out.println("Invalid Set request.");
        }
    };
    
    /* Getters for Character int variables.
     * Example: CharacterController.Get(Character, "Speed") 
     * returns Character's speed variable as an int.
     */    
    public int get(Character ch, String function){
        switch (function){
            case "HP":
                return ch.getHP();
            case "Speed":
                return ch.getSpeed();
            case "AP":
                return ch.getAP();
            case "Initiative":
                return ch.getInitiative();
            case "STR":
                return ch.getSTR();
            case "DEX":
                return ch.getDEX();
            case "INT":
                return ch.getINT();
            case "CurrentHP":
                return ch.getCurrentHP();
            case "CurrentAP":
                return ch.getCurrentAP();
            default:
                System.out.println("Invalid Get request.");
                return 0;
        }
    };
    
}
