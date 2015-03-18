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
    
    public void SetName(Character ch, String name){
        ch.SetName(name);
    };
    public String GetName(Character ch){
        return ch.GetName();
    };
    
    /* Setters for Character int variables.
     * Example: CharacterController.Set(Bob, "speed", 5) 
     * sets Bob's speed variable to 5.
     */
    public void Set(Character ch, String function, int input){
        switch (function) {
            case "HP":
                ch.SetHP(input);
                break;
            case "speed":
                ch.SetSpeed(input);
                break;
            case "AP":
                ch.SetAP(input);
                break;
            default:
                System.out.println("Invalid Set request.");
        }
    };
    
    /* Getters for Character int variables.
     * Example: CharacterController.Get(Bob, "speed") 
     * returns Bob's speed variable as an int.
     */    
    public int Get(Character ch, String function){
        switch (function){
            case "HP":
                return ch.GetHP();
            case "speed":
                return ch.GetSpeed();
            case "AP":
                return ch.GetAP();
            default:
                System.out.println("Invalid Get request.");
                return 0;
        }
    };
    
}
