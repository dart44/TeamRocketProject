/*
 * Character data class. Behaves like a Dungeons and Dragons
 * character sheet.
 */
package Character;
import java.util.Random;

/**
 *
 * Tutorial Change demonstration
 * @author Jeremy Crook
 * 2015 March 12
 */
public class Character {
    private String Name;
    private int HP;
    private int speed;
    private int AP;
    /* Getters and Setters */
    public void SetName(String name){
        Name = name;
    };
    public String GetName(){
        return Name;
    };
    public void SetHP(int n){
        HP = n;
    };
    public int GetHP(){
        return HP;
    };
    public void SetSpeed(int n){
        speed = n;
    };
    
    public int GetSpeed(){
        return speed;
    };
    public void SetAP(int n){
        AP = n;
    };
    public int GetAP(){
        return AP;
    };
    

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
        HP = r.nextInt((30 - 10) + 1) + 10;
        speed = r.nextInt((6 - 4) + 1) + 4;
        /* AP is constant for this build */
        AP = 10;
    }
    public Character(String name, int hp, int spd, int ap){
        Name = name;
        HP = hp;
        speed = spd;
        AP = ap;
    };
    
}
