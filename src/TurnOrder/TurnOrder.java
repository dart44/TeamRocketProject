/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnOrder;

import java.util.ArrayList;
import Character.Character;
import TeamRocketProject.AbstractModel;
/**
 **
 *
 * @author Jeremy Crook
 */


public class TurnOrder extends AbstractModel {
    
    public static final String
    ELEMENT_TURNCHARACTER_PROPERTY = "TurnCharacter";
    
    private Character TurnCharacter;
    private ArrayList<Character> turnOrder;
    /* Turn Order sorting */
    public TurnOrder(ArrayList<Character> characterList){
        for (int i = 0; i < characterList.size() - 1; i++){
            Character c1 = characterList.get(i);
            Character c2 = characterList.get(i+1);
            
            if ((Integer.compare(c1.getInitiative(), c2.getInitiative())) < 0){
                turnOrder.set(i+1, c1);
                turnOrder.set(i, c2);
            } else {
                turnOrder.set(i, c1);
                turnOrder.set(i+1, c2);
            }
        }
        setTurnCharacter(turnOrder.get(0));
    }
    
    public Character getTurnCharacter(){
        return TurnCharacter;
    }
    
    public int getTurnCharacterIndex(){
        return turnOrder.indexOf(TurnCharacter);
    }
    
    public int getSize(){
        return turnOrder.size();
    }
    
    public Character getCharacter(int i){
        return turnOrder.get(i);
    }
    
    public void removeCharacter(Character c){
        if(c == TurnCharacter){
            if (turnOrder.indexOf(TurnCharacter)+1 != turnOrder.size()){
                setTurnCharacter(turnOrder.get(turnOrder.indexOf(TurnCharacter)+1));
            }
            else setTurnCharacter(turnOrder.get(0));
        }
        turnOrder.remove(turnOrder.indexOf(c));
    }

    public ArrayList<Character> getTurnOrder(){
        return turnOrder;
    };
    
    public void setTurnCharacter(Character c){
        Character oldTurnCharacter = this.TurnCharacter;
        TurnCharacter = c;
        
        firePropertyChange(
            ELEMENT_TURNCHARACTER_PROPERTY,
            oldTurnCharacter, TurnCharacter);
    };
}
