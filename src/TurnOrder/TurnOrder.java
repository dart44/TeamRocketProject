/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnOrder;

import java.util.ArrayList;
import Character.Character;
import TeamRocketProject.MasterModel;
/**
 *
 * @author Jeremy Crook
 */


public class TurnOrder extends MasterModel {
    
    public static final String
    ELEMENT_TURNCHARACTER_PROPERTY = "TurnCharacter";
    
    private Character TurnCharacter;
    private ArrayList<Character> turnOrder;
    /* Turn Order sorting */
    public TurnOrder(ArrayList<Character> characterList){
        for (int i = 0; i < characterList.size(); i++){
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
    }
    
    public Character getTurnCharacter(){
        return TurnCharacter;
    }
    
    public int getSize(){
        return turnOrder.size();
    }
    
    public Character getCharacter(int i){
        return turnOrder.get(i);
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
