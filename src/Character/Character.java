/*
 * @module Character
 * @author Jeremy Crook
 * Class: Character
 * Date: March 12th, 2015
 * Last Updated: March 26th, 2015
 * Character objects store all in-game attributes of
 * a player's character such as Hit Points and 
 * Action Points. They are also responsible for
 * keeping track of the character's remaining
 * hit/action points as they change throughout a
 * game session. When Hit Points reach 0, the character
 * is considered dead and removed from play.
 * When Action Points reach 0, the character class
 * calls TurnOrder to change the TurnCharacter to
 * the next character in the order.
 */
package Character;
import java.util.Random;
import teamrocketproject.MasterModel;
/**
 *
 * @author Jeremy Crook
 * 2015 March 12
 */
public class Character extends MasterModel {
    private String Name;
    private int HP, speed, AP, initiative,
                STR, DEX, INT,
                CurrentHP, CurrentAP;
    /* Getters and Setters */
    public void setName(String name){
        String oldName = this.Name;
        this.Name = name;
        
        firePropertyChange(
            CharacterController.ELEMENT_NAME_PROPERTY, 
            oldName, name);
    };
    public String getName(){
        return Name;
    };
    public void setHP(int n){
        HP = n;
    };
    public int getHP(){
        return HP;
    };
    public void setSpeed(int n){
        speed = n;
    };
    
    public int getSpeed(){
        return speed;
    };
    public void setAP(int n){
        AP = n;
    };
    public int getAP(){
        return AP;
    };
    
    /* Class Constructors */
    public Character(){
        /* Assign the character a random name */
        Random r = new Random();
        int n = r.nextInt(12)+1;
        String[] names = {"Solomon", "Geoff", "Katelyn",
                          "Millicent", "Braxton", "Raymond",
                          "Ozzie", "Archibald", "Sark",
                          "Ashleigh", "Agatha", "Sonya"};
        Name = names[n];
        /* Assign the character random stats within a range
         * Formula:
         * randomNumber.nextInt((maximum - minimum) + 1) + minimum;
         */
        int d6 = r.nextInt((6 - 1) + 1) + 1;
        STR = 3 * d6;
        DEX = 3 * d6;
        INT = 3 * d6;
        int d3 = r.nextInt((3 - 1) + 1) + 1;
        switch (d3) {
            case 1: STR = STR +2;
                    break;
            case 2: DEX = DEX +2;
                    break;
            case 3: INT = INT +2;
                    break;
            default: break;
        }
        HP = (int) Math.floor(STR/3);
        speed = 2 - (int) Math.floor(DEX/10);
        AP = 9 + (int) Math.floor(INT/6);
        int d20 = r.nextInt((20 - 1) + 1) + 1;
        initiative = d20;
        if (INT>DEX){
            initiative = initiative + ((int) Math.floor(INT/2) - 5);
        } else {
            initiative = initiative + ((int) Math.floor(DEX/2) - 5);
        }
        
    }
    
}
