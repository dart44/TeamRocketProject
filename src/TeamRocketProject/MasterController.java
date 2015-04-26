/*
 * This class provides the base level abstraction for Controller classes.
 *  Changes to the properties of the Model classes controlled
 * are fired such that they can be propogated to all views. -JC
 */
/**
 *
 *  
 * 
 * @author Jeremy Crook
 *
 */
package TeamRocketProject;
import Character.Character;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import TurnOrder.TurnOrder;
import grid.GridController;
import UI.UI;

/**
 *
 * @author Jason
 */
public class MasterController implements PropertyChangeListener {
    private ArrayList<Character> allCharacters;
    private GridController gc;
    private UI ui;
    private TurnOrder turnOrder;
    private Boolean endTurn = false;
    private int GAME_OVER = 0;
    
    /**
     * Default Constructor contains list of Models being controlled
     * as well as views to populate.
     * @param allCharacters ArrayList
     * @param gridController GridController
     */
    public MasterController(ArrayList<Character> allCharacters, GridController gridController){
        this.allCharacters = allCharacters;
        this.turnOrder = new TurnOrder(allCharacters);
        this.gc = gridController;
        this.ui = new UI(this); //Edit UI to take MC as argument -JC
        
        for(Character c: allCharacters){
            c.addPropertyChangeListener(this);
        }
        turnOrder.addPropertyChangeListener(this);
        gridController.getGrid().addPropertyChangeListener(this);
    };
    
        /* Convenience methods for checking HP/AP */

    /**
     * Determine if the parameter's hit point count is greater than 0.
     * Return true iff ch.AP is greater than 0. 
     * @param ch Character
     * @return boolean
     */
    
    public Boolean CheckHP(Character ch){
        if (ch.getCurrentHP() <= 0){
            return false;
        }
        return true;
    }
    
    /**
     * Determine if the parameter's Action Point count is greater than 0. 
     * Return true if ch.AP is greater than 0. 
     * @param ch Character
     * @return boolean
     */
    public Boolean CheckAP(Character ch){
        if (ch.getCurrentAP() <= 0) {  
            return false;
        }
        return true;
    }
    
    /**
     * Attacker attacks target, and attacker's action points are deducted 
     * according to the type of attack. 
     * @param attacker Character
     * @param target Character
     * @param AP int
     */
    public void Attack(Character attacker, Character target, int AP){
        if (AP <= attacker.getCurrentAP()){
            attacker.setCurrentAP(attacker.getCurrentAP() - AP);
            int ATK = attacker.getSTR();
            Random r = new Random(System.currentTimeMillis());
            int d100 = r.nextInt((100 - 1) + 1) + 1;
            if(d100 <= (ATK*AP)){
                int Damage = (int) Math.floor((d100 - ATK)/10);
                target.setCurrentHP(target.getCurrentHP()-Damage);
            }
        } else {
            //Insufficient AP
        }
    }
    
    /**
     * Move the character whose turn it is to the position indicated by pos. 
     * @param pos int[]
     */
    public void Move(int[] pos){
        Character c = turnOrder.getTurnCharacter();
        int distance = gc.checkDistance(c, pos[0], pos[1]);
        int AP = c.getSpeed() * distance;
        if (AP <= c.getCurrentAP()){
            c.setCurrentAP(c.getCurrentAP() - AP);
            gc.setPosition(c, pos);
        } else {
            //Insufficient AP
        }
    }
    
    /**
     * Starts the game. 
     * @throws InterruptedException Exception
     */
    public void StartGame() throws InterruptedException{
        turnOrder.setTurnCharacter(turnOrder.getCharacter(0));
        gameLoop();
    }
    
    /**
     * The loop that drives the game. 
     * @throws InterruptedException Exception
     */
    public void gameLoop() throws InterruptedException{
        while(GAME_OVER == 0){
            while(!endTurn){
                if (turnOrder.getTurnCharacter().getCurrentAP() == 0){
                    break;
                }
                Thread.sleep(100);
            }
            GAME_OVER = GameOver(allCharacters);
            if(GAME_OVER != 0){
                if(GAME_OVER == -1){
                    //Player 2 wins!
                    break;
                }
                if(GAME_OVER == 1){
                    //Player 1 wins!
                    break;
                }
            }
            endTurn = false;
            NextTurn();
        }
        //TODO Display winner, prompt for new game
    }
    
    /**
     * Calculates the stats of the character whose turn it is. 
     */
    public void Stats() {
        Character c = turnOrder.getTurnCharacter();
        System.out.println(
                "Character Name: " + c.getName()
                + "\nHP: " + c.getHP()
                + "\nCurrent HP: " + c.getCurrentHP()
                + "\nMax AP: " + c.getAP()
                + "\nCurrent AP: " + c.getCurrentAP()
                + "\nStrength: " + c.getSTR()
                + "\nDexterity: " + c.getDEX()
                + "\nSpeed: " + c.getSpeed()
                + "\nINT: " + c.getINT()
                + "\nInitiative: " + c.getInitiative()
        );
    }
    
    /**
     * Determine next player turn. 
     */
    public void NextTurn(){
        int nextIndex;
        if (turnOrder.getTurnCharacterIndex()+1 != turnOrder.getSize()){
            nextIndex = turnOrder.getTurnCharacterIndex()+1;
        } else {
            nextIndex = 0;
            for (Character c : turnOrder.getTurnOrder()){
                c.setCurrentAP(c.getAP());
            }
        }
        Character c = turnOrder.getCharacter(nextIndex);
            if(!CheckHP(c)){
                turnOrder.removeCharacter(c);
                NextTurn();
            } else {
                turnOrder.setTurnCharacter(c);
            }
        turnOrder.setTurnCharacter(turnOrder.getCharacter(nextIndex));
        endTurn = false;
    }
    
    /**
     * Signal end of current player's turn. 
     */
    public void EndTurn(){
        endTurn = true;
    }
    
    /**
     * Calculate if game is over.  
     * Return 1 if Player 1 wins, -1 if player 2 wins, and 0 if game is not over
     * @param Characters ArrayList
     * @return ArrayList
     */
    public int GameOver(ArrayList<Character> Characters){
        int result = 0;
        int half = Characters.size() / 2;
        for(int i = 0; i < half; ++i){
            result = -1;
            if(CheckHP(Characters.get(i)) == true){
                result = 0;
                break;
            }                
        }        
        for(int i = half; i < Characters.size(); ++i){
            result = 1;
            if(CheckHP(Characters.get(i)) == true){
                result = 0;
                break;
            }
        }
        return result;
    }
    
    /**
     * Access GridController.
     * @return GridController
     */
    public GridController getGridController(){
        return gc;
    }
    
    /**
     * Access Get character whose next turn it is. 
     * @see TurnOrder
     * @return Character
     */
    public Character getTurnCharacter(){
        return turnOrder.getTurnCharacter();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ui.propertyChange(evt);
    }
}
    
    

