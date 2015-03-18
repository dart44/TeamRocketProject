/*
 * This class serves as a Controller for the Character
 * class. First draft.
 */
package Character;
/**
 *
 * @author Jeremy Crook
 * 2015 March 12
 */
public class CharacterController {
    /* empty constructor. Controllers hold no data */
    public CharacterController(){
    };
    
    /* Setters for Character variables.
     * Example: CharacterController.Set(Bob, speed, 5) 
     * sets Bob's speed variable to 5.
     */
    public void Set(Character name, String function, int input){
        switch (function) {
            case "HP":
                name.SetHP(input);
                break;
            case "speed":
                name.SetSpeed(input);
                break;
            case "AP":
                name.SetAP(input);
                break;
            default:
                System.out.println("Invalid Set request.");
        }
    };
    
    /* Getters for Character variables.
     * Example: CharacterController.Get(Bob, speed) 
     * returns Bob's speed variable as an int.
     */    
    public int Get(Character name, String function){
        switch (function){
            case "HP":
                return name.GetHP();
            case "speed":
                return name.GetSpeed();
            case "AP":
                return name.GetAP();
            default:
                System.out.println("Invalid Get request.");
                return 0;
        }
    };
    
}
