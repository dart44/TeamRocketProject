/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnOrder;

import java.util.ArrayList;
import Character.Character;
/**
 *
 * @author Jeremy Crook
 */


public class TurnOrder {
    
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
    //TODO TurnCharacter, Accessors for TurnCharacter
    //TODO Count, Accessors for Count
}
