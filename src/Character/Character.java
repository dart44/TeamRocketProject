/*
 * @module Character
 * @author Jeremy Crook
 * Class: Character
 * Date: March 12th, 2015
 * Last Updated: March 26th, 2015
 * Character objects store all in-game attributes of a player's character such
 * as Hit Points and Action Points.

 */
package Character;
import java.util.Random;
import TeamRocketProject.AbstractModel;

public class Character extends AbstractModel implements Comparable{
    
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
    
    /* Character Attribute Declarations
     * @param Name: Character's name
     * @param Player: Character's Player's name
     * @param HP: Character's Maximum Hit Points
     * @param Speed: Cost in AP to move Character 1 grid square
     * @param AP: Character's Maximum Action Points
     * @param Initiative: Character's priority in TurnOrder
     * @param STR: Character's Strength attribute; informs HP
     * @param DEX: Character's Dexterity attribute; informs Speed
     * @param INT: Character's Intelligence attribute; informs AP
     * @param CurrentHP: Character's current Hit Points
     * @param CurrentAP: Character's current Action Points
     */
    private String Name, Player;
    private int HP, Speed, AP, Initiative,
                STR, DEX, INT,
                CurrentHP, CurrentAP;
    /* number generator */
    private Random r = new Random(System.currentTimeMillis());
    private int dX(int x){
        int dX = r.nextInt((x - 1) + 1) + 1;
        return dX;
    }
    /* Attribute Accessors
     * When changes are made to this model they are fired such that they can
     * be propogated across all registered views.
     */
    public void setName(String name){
        String oldName = this.Name;
        this.Name = name;
        
        firePropertyChange(
            ELEMENT_NAME_PROPERTY, 
            oldName, Name);
    };
    public String getName(){
        return Name;
    };
    public void setPlayer(String player){
        String oldPlayer = this.Player;
        this.Player = player;
        
        firePropertyChange(
            ELEMENT_PLAYER_PROPERTY, 
            oldPlayer, Player);
    };
    public String getPlayer(){
        return Player;
    };
    
    public void setHP(int n){
        int oldHP = this.HP;
        HP = n;
        
        firePropertyChange(
            ELEMENT_HP_PROPERTY,
            oldHP, HP);
    };
    public int getHP(){
        return HP;
    };
    
    public void setSpeed(int n){
        int oldSpeed = this.Speed;
        Speed = n;
        
        firePropertyChange(
            ELEMENT_SPEED_PROPERTY,
            oldSpeed, Speed);
    };
    
    public int getSpeed(){
        return Speed;
    };
    
    public void setAP(int n){
        int oldAP = this.AP;
        AP = n;
        
        firePropertyChange(
            ELEMENT_AP_PROPERTY,
            oldAP, AP);
    };
    public int getAP(){
        return AP;
    };
    
    public void setInitiative(int n){
        int oldInitiative = this.Initiative;
        Initiative = n;
        
        firePropertyChange(
            ELEMENT_CURRENTAP_PROPERTY,
            oldInitiative, Initiative);
    };
    public int getInitiative(){
        return Initiative;
    };
    
    public void setSTR(int n){
        int oldSTR = this.STR;
        STR = n;
        
        firePropertyChange(
            ELEMENT_STR_PROPERTY,
            oldSTR, STR);
    };
    public int getSTR(){
        return STR;
    };
    
    public void setINT(int n){
        int oldINT = this.INT;
        INT = n;
        
        firePropertyChange(
            ELEMENT_INT_PROPERTY,
            oldINT, INT);
    };
    public int getINT(){
        return INT;
    };
    
    public void setDEX(int n){
        int oldDEX = this.DEX;
        DEX = n;
        
        firePropertyChange(
            ELEMENT_DEX_PROPERTY,
            oldDEX, DEX);
    };
    public int getDEX(){
        return DEX;
    };
    
    public void setCurrentHP(int n){
        int oldcHP = this.CurrentHP;
        CurrentHP = n;
        
        firePropertyChange(
            ELEMENT_CURRENTHP_PROPERTY,
            oldcHP, CurrentHP);
    };
    public int getCurrentHP(){
        return CurrentHP;
    };
    
    public void setCurrentAP(int n){
        int oldcAP = this.CurrentAP;
        CurrentAP = n;
        
        firePropertyChange(
            ELEMENT_CURRENTAP_PROPERTY,
            oldcAP, CurrentAP);
    };
    public int getCurrentAP(){
        return CurrentAP;
    };
    
    /* Default Class Constructor */
    public Character(String p){
        /* Assign the character to its player */
        Player = p;
        /* Assign the character a random name */
        
        int n = r.nextInt(12);
        String[] names = {"Solomon", "Geoff", "Katelyn",
                          "Millicent", "Braxton", "Raymond",
                          "Ozzie", "Archibald", "Sark",
                          "Ashleigh", "Agatha", "Sonya"};
        Name = names[n];
        /* Assign the character random stats within a range
         * Formula:
         * randomNumber.nextInt((maximum - minimum) + 1) + minimum;
         * @param dX = random number 1 to X inclusive
         */
        STR = dX(6) + dX(6) + dX(6);
        DEX = dX(6) + dX(6) + dX(6);
        INT = dX(6) + dX(6) + dX(6);
        int d3 = dX(3);
        switch (d3) {
            case 1: STR = STR +2;
                    break;
            case 2: DEX = DEX +2;
                    break;
            case 3: INT = INT +2;
                    break;
            default: break;
        }
        /* Set derived stats */
        HP = 5 * (int) Math.floor(STR/3);
        CurrentHP = HP;
        Speed = 2 - (int) Math.floor(DEX/11);
        AP = 9 + (int) Math.floor(INT/6);
        CurrentAP = AP;
        int d20 = r.nextInt((20 - 1) + 1) + 1;
        Initiative = d20;
        if (INT>DEX){
            Initiative = Initiative + ((int) Math.floor(INT/2) - 5);
        } else {
            Initiative = Initiative + ((int) Math.floor(DEX/2) - 5);
        }
        
    }

    @Override
    public int compareTo(Object t) {
        int compareinit=((Character)t).getInitiative();
        return compareinit-this.getInitiative();
    }
    
}
