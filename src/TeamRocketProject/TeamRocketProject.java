/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRocketProject;

import java.applet.Applet;
import grid.Grid;
import grid.GridController;
import Character.CharacterController;
/**
 *
 * @author Jeremy Crook
 */
public class TeamRocketProject extends Applet implements Runnable {
    /* TeamRocketProject class constructor */
    public TeamRocketProject(){
        //TODO Create character objects
        GridController gridController = new GridController(10, 10);   
    }
    @Override
    public void run(){
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TeamRocketProject game = new TeamRocketProject();
    }
}
