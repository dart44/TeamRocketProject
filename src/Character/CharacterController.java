/*
 * This class serves as a Controller for the Character
 * class.
 */
package Character;

import teamrocketproject.MasterController;
/**
 *
 * @author Jeremy Crook
 * 2015 March 12
 */
public class CharacterController extends MasterController {
    /* PropertyChangeEvents */
    public static final String
    ELEMENT_NAME_PROPERTY = "Name",
    ELEMENT_HP_PROPERTY = "HP",
    ELEMENT_SPEED_PROPERTY = "speed",
    ELEMENT_AP_PROPERTY = "AP",
    ELEMENT_INITIATIVE_PROPERTY = "initiative",
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
     * Example: CharacterController.Set(Bob, "speed", 5) 
     * sets Bob's speed variable to 5.
     */
    public void set(Character ch, String function, int input){
        switch (function) {
            case "HP":
                setModelProperty(ELEMENT_HP_PROPERTY, input);
                break;
            case "speed":
                setModelProperty(ELEMENT_SPEED_PROPERTY, input);
                break;
            case "AP":
                setModelProperty(ELEMENT_AP_PROPERTY, input);
                break;
            default:
                System.out.println("Invalid Set request.");
        }
    };
    
    /* Getters for Character int variables.
     * Example: CharacterController.Get(Bob, "speed") 
     * returns Bob's speed variable as an int.
     */    
    public int get(Character ch, String function){
        switch (function){
            case "HP":
                return ch.getHP();
            case "speed":
                return ch.getSpeed();
            case "AP":
                return ch.getAP();
            default:
                System.out.println("Invalid Get request.");
                return 0;
        }
    };
    
}
