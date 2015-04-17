/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRocketProject;

import java.applet.Applet;
import grid.Grid;
import grid.GridController;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import Character.Character;

/**
 *
 * @author Jeremy Crook
 */
public class TeamRocketProject extends Applet implements Runnable {
    /* TeamRocketProject class constructor */
    public TeamRocketProject(){
        //TODO Create ArrayList of Character objects
        /* Get number of characters.  Use even number so both 
           players have the same number of characters
        */
        Random r = new Random(System.currentTimeMillis());
        int x;
        int[] pos;
        ArrayList<Character> allChars = new ArrayList<Character>();
        Character P1Char1 = new Character("Player1");
        Character P1Char2 = new Character("Player1");
        Character P2Char1 = new Character("Player2");
        Character P2Char2 = new Character("Player2");
        allChars.add(P1Char1);
        allChars.add(P1Char2);
        allChars.add(P2Char1);
        allChars.add(P2Char2);
        GridController gridController = new GridController(10, 10);
        //TODO Randomly distribute characters onto grid
        /* Wish list: function to return total number of cells in grid */
        Iterator i = allChars.iterator();
        // initialize x
        x = r.nextInt(100);
        while(i.hasNext()){
          while(!gridController.CheckValidSpace(pos[x])){
            x = r.nextInt(100);
          }
        }
        
        //TODO Initialize TurnOrder by passing it Character ArrayList
        //TODO Pass control to Player who owns TurnCharacter
    }
    @Override
    public void run(){
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TeamRocketProject game = new TeamRocketProject();
        game.run();
    }
}
