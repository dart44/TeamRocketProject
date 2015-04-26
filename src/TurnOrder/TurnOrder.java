/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnOrder;

import java.util.ArrayList;
import java.util.Collections;
import Character.Character;
import TeamRocketProject.AbstractModel;
/**
 **
 * 
 * 
 * 
 * @author Jeremy Crook
 */


public class TurnOrder extends AbstractModel {
    
    public static final String
    /**
     * Used to drive turn order
     */
    ELEMENT_TURNCHARACTER_PROPERTY = "TurnCharacter";
    
    private Character TurnCharacter;
    private ArrayList<Character> turnOrder;
    /* Turn Order sorting */

    /**
     * Constructor. 
     * @param characterList ArrayList
     */
    
    public TurnOrder(ArrayList<Character> characterList){
        Collections.sort(characterList);
        turnOrder = characterList;
        setTurnCharacter(turnOrder.get(0));
    }
    
    /**
     * Gets the character whose turn it is. 
     * @return Character
     */
    public Character getTurnCharacter(){
        return TurnCharacter;
    }
    
    /**
     * Gets the index of character whose turn it is in the TurnOrder ArrayList. 
     * @return int 
     */
    public int getTurnCharacterIndex(){
        return turnOrder.indexOf(TurnCharacter);
    }
    
    /**
     * Gets the size of the turnOrder arrayList. 
     * @return int
     */
    public int getSize(){
        return turnOrder.size();
    }
    
    /**
     * Gets the character at index i in the turnOrder arrayList. 
     * @param i int 
     * @return Character
     */
    public Character getCharacter(int i){
        return turnOrder.get(i);
    }
    
    /**
     * Removes a character from the turnOrder arrayList. 
     * Used when one character dies in game play. 
     * @param c Character
     */
    public void removeCharacter(Character c){
        if(c == TurnCharacter){
            if (turnOrder.indexOf(TurnCharacter)+1 != turnOrder.size()){
                setTurnCharacter(turnOrder.get(turnOrder.indexOf(TurnCharacter)+1));
            }
            else setTurnCharacter(turnOrder.get(0));
        }
        turnOrder.remove(turnOrder.indexOf(c));
    }

    /**
     * Gets the turnOrder arrayList.
     * @return ArrayList
     */
    public ArrayList<Character> getTurnOrder(){
        return turnOrder;
    };
    
    /**
     * Update the turnCharacter for game play.
     * @param c Character
     */
    public void setTurnCharacter(Character c){
        Character oldTurnCharacter = this.TurnCharacter;
        TurnCharacter = c;
        
        firePropertyChange(
            ELEMENT_TURNCHARACTER_PROPERTY,
            oldTurnCharacter, TurnCharacter);
    };
}
