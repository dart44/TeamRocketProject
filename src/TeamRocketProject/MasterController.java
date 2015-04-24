/*
 * This class provides the base level abstraction for Controller classes.
 *  Changes to the properties of the Model classes controlled
 * are fired such that they can be propogated to all views. -JC
 */
/**
 *
 * @author Jason
 * 2015 March 10
 * Edited March 26 by Jeremy Crook
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



public class MasterController implements PropertyChangeListener {
    private ArrayList<Character> allCharacters;
    private GridController gc;
    private TurnOrder turnOrder;
    private UI ui;
    private Boolean endTurn = false;
    private int GAME_OVER = 0;
    /* Default Constructor contains list of Models being controlled
     * as well as views to populate.
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
    

    public void StartGame() throws InterruptedException{
        turnOrder.setTurnCharacter(turnOrder.getCharacter(0));
        gameLoop();
    }
    
    public void gameLoop() throws InterruptedException{
        while(GAME_OVER == 0){
            while(!endTurn || turnOrder.getTurnCharacter().getCurrentAP() != 0){
                Thread.sleep(1000);
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
    
    public void EndTurn(){
        endTurn = true;
    }
    
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
    
    public GridController getGridController(){
        return gc;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ui.propertyChange(evt);
    }
}
    
    

