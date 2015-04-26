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

    /**
     * Constructor used to set up game. 
     */
    
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
        /*
        for(int i = 0; i < NumberOfPlayers; ++i){
            r.setSeed(System.currentTimeMillis()^4);
            for (int j = 0; j < CharactersPerPlayer; ++j){
                
                r.setSeed(System.currentTimeMillis()^2);
                int n = r.nextInt(12);
                String[] names = {"Solomon", "Geoff", "Katelyn",
                          "Millicent", "Braxton", "Raymond",
                          "Ozzie", "Archibald", "Sark",
                          "Ashleigh", "Agatha", "Sonya"};
                String Name = names[n];
                System.out.println("Character Name " + names[n]);
                // Assign the character random stats 
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
                allChars.add(new Character("Player"+(j+1), Name+(i+1), STR, DEX, INT, Init));
                
            }
        }
       */
        
        Character P1Char1 = new Character("Player1");
        Character P1Char2 = new Character("Player1");
        Character P2Char1 = new Character("Player2");
        Character P2Char2 = new Character("Player2");
        
        P1Char1.setName("Solomon");
        P1Char2.setName("Geoff");
        P2Char1.setName("Sonya");
        P2Char2.setName("Agatha");

        P1Char1.setDEX(10);
        P1Char1.setAP(10);
        P1Char1.setCurrentAP(10);
        P1Char1.setINT(10);
        P1Char1.setInitiative(10);
        P1Char1.setSTR(10);
        P1Char1.setSpeed(10);
        
        P1Char2.setAP(7);
        P1Char2.setCurrentAP(7);
        P1Char2.setDEX(7);
        P1Char2.setINT(7);
        P1Char2.setInitiative(7);
        P1Char2.setSTR(7);
        P1Char2.setSpeed(7);
        
        P2Char1.setAP(9);
        P2Char1.setCurrentAP(9);        
        P2Char1.setDEX(9);
        P2Char1.setINT(9);
        P2Char1.setInitiative(9);
        P2Char1.setSTR(9);
        P2Char1.setSpeed(9);
        
        P2Char2.setAP(8);
        P2Char2.setCurrentAP(8);
        P2Char2.setDEX(8);
        P2Char2.setINT(8);
        P2Char2.setInitiative(8);
        P2Char2.setSTR(8);
        P2Char2.setSpeed(8);
        
        //DO NOT DELETE!!! This serves as a way to test character issues
        /*
        System.out.println(
                "Character Name: " + P1Char1.getName()
                + "\nHP: " + P1Char1.getHP()
                + "\nCurrent HP: " + P1Char1.getCurrentHP()
                + "\nMax AP: " + P1Char1.getAP()
                + "\nCurrent AP: " + P1Char1.getCurrentAP()
                + "\nStrength: " + P1Char1.getSTR()
                + "\nDexterity: " + P1Char1.getDEX()
                + "\nSpeed: " + P1Char1.getSpeed()
                + "\nINT: " + P1Char1.getINT()
                + "\nInitiative: " + P1Char1.getInitiative()
        );
        
        System.out.println(
                "Character Name: " + P1Char2.getName()
                + "\nHP: " + P1Char2.getHP()
                + "\nCurrent HP: " + P1Char2.getCurrentHP()
                + "\nMax AP: " + P1Char2.getAP()
                + "\nCurrent AP: " + P1Char2.getCurrentAP()
                + "\nStrength: " + P1Char2.getSTR()
                + "\nDexterity: " + P1Char2.getDEX()
                + "\nSpeed: " + P1Char2.getSpeed()
                + "\nINT: " + P1Char2.getINT()
                + "\nInitiative: " + P1Char2.getInitiative()
        );
        
        System.out.println(
                "Character Name: " + P2Char1.getName()
                + "\nHP: " + P2Char1.getHP()
                + "\nCurrent HP: " + P2Char1.getCurrentHP()
                + "\nMax AP: " + P2Char1.getAP()
                + "\nCurrent AP: " + P2Char1.getCurrentAP()
                + "\nStrength: " + P2Char1.getSTR()
                + "\nDexterity: " + P2Char1.getDEX()
                + "\nSpeed: " + P2Char1.getSpeed()
                + "\nINT: " + P2Char1.getINT()
                + "\nInitiative: " + P2Char1.getInitiative()
        );
        
        System.out.println(
                "Character Name: " + P2Char2.getName()
                + "\nHP: " + P2Char2.getHP()
                + "\nCurrent HP: " + P2Char2.getCurrentHP()
                + "\nMax AP: " + P2Char2.getAP()
                + "\nCurrent AP: " + P2Char2.getCurrentAP()
                + "\nStrength: " + P2Char2.getSTR()
                + "\nDexterity: " + P2Char2.getDEX()
                + "\nSpeed: " + P2Char2.getSpeed()
                + "\nINT: " + P2Char2.getINT()
                + "\nInitiative: " + P2Char2.getInitiative()
        );
        
        */
        
        allChars.add(P1Char1);
        allChars.add(P1Char2);
        allChars.add(P2Char1);
        allChars.add(P2Char2);
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
     * @throws InterruptedException Exception
     */
    public static void main(String[] args) throws InterruptedException {
        TeamRocketProject game = new TeamRocketProject();
        game.mc.StartGame();
    }
}
