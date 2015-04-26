/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRocketProject;

import grid.Grid;
import grid.GridController;
import java.util.ArrayList;
import java.util.Random;
import Character.Character;
import TurnOrder.TurnOrder;
import UI.UI;

/**
 *
 * 
 * 
 * @author Jeremy Crook
 */
public class TeamRocketProject {
    
    private MasterController mc;
    private GridController grid;
    private ArrayList<Character> allChars;
    /* TeamRocketProject class constructor */
    public TeamRocketProject(){
        /* Create ArrayList of Character objects */
        /* Get number of characters.  Use even number so both 
           players have the same number of characters
        */
        Random r = new Random(System.currentTimeMillis());
        int[] pos;
        pos = new int[2];
        this.allChars = new ArrayList<>();
        int NumberOfPlayers = 2;
        int CharactersPerPlayer = 2;
        for(int i = 0; i < NumberOfPlayers; ++i){
            r.setSeed(System.currentTimeMillis()^4);
            for (int j = 0; j < CharactersPerPlayer; ++j){
                /* Assign the character a random name */
                r.setSeed(System.currentTimeMillis()^2);
                int n = r.nextInt(12);
                String[] names = {"Solomon", "Geoff", "Katelyn",
                          "Millicent", "Braxton", "Raymond",
                          "Ozzie", "Archibald", "Sark",
                          "Ashleigh", "Agatha", "Sonya"};
                String Name = names[n];
                /* Assign the character random stats */
                r.setSeed(System.currentTimeMillis()+1);
                int STR = r.nextInt(18)+1;
                r.setSeed(System.currentTimeMillis()+2);
                int DEX = r.nextInt(18)+1;
                r.setSeed(System.currentTimeMillis()+3);
                int INT = r.nextInt(18)+1;
                r.setSeed(System.currentTimeMillis()+4);
                int d3 = r.nextInt(3)+1;
                switch (d3) {
                    case 1: STR = STR +2;
                        break;
                    case 2: DEX = DEX +2;
                        break;
                    case 3: INT = INT +2;
                        break;
                    default: break;
                }
                r.setSeed(System.currentTimeMillis());
                int Init = r.nextInt(20)+1;
                allChars.add(new Character("Player"+(i+1), Name+(i+1), STR, DEX, INT, Init));
            }
        }
       
        /*Character P1Char1 = new Character("Player1");
        Character P1Char2 = new Character("Player1");
        Character P2Char1 = new Character("Player2");
        Character P2Char2 = new Character("Player2");
        allChars.add(P1Char1);
        allChars.add(P1Char2);
        allChars.add(P2Char1);
        allChars.add(P2Char2);*/
        this.grid = new GridController(10, 10);
        /* Randomly distribute characters onto grid */
        /* Wish list: function to return total number of cells in grid */
        // initialize pos
        r.setSeed(System.currentTimeMillis()^2);
        pos[0] = r.nextInt(10);
        pos[1] = r.nextInt(10);
        for(int i = 0;  i < allChars.size(); ++i){
          while(!grid.CheckValidSpace(pos)){
            r.setSeed(System.currentTimeMillis()^3);
            pos[0] = r.nextInt(10);
            pos[1] = r.nextInt(10);
          }
          grid.setPosition(allChars.get(i), pos);
        }
        mc = new MasterController(allChars, grid);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        TeamRocketProject game = new TeamRocketProject();
        game.mc.StartGame();
    }
}
