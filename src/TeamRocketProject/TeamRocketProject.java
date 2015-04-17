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
import TurnOrder.TurnOrder;

/**
 *
 * @author Jeremy Crook
 */
public class TeamRocketProject extends Applet implements Runnable {
    /* TeamRocketProject class constructor */
    public TeamRocketProject(){
        MasterController mc = new MasterController();
        //TODO Create ArrayList of Character objects
        /* Get number of characters.  Use even number so both 
           players have the same number of characters
        */
         Random r = new Random(System.currentTimeMillis());
        int x, y;
        int[] pos;
        pos = new int[2];
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
        // initialize pos
        pos[0] = r.nextInt(10);
        pos[1] = r.nextInt(10);
        for(int i = 0;  i < allChars.size(); ++i){
          while(!gridController.CheckValidSpace(pos)){
            pos[0] = r.nextInt(10);
            pos[1] = r.nextInt(10);
          }
          gridController.setPosition(allChars.get(i), pos);
        }
        
        TurnOrder turnOrder = new TurnOrder(allChars);
        Boolean GAME_OVER = false;
        while(GAME_OVER != true){
            mc.Turn(turnOrder);
        }
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
