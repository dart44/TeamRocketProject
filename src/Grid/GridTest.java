package grid;
import grid.GridController;
import Character.Character;

public class GridTest {

    public static void main(String[] args) {
        GridController gc = new GridController(10, 10);
        //gc.display();
        
        //System.out.println("Location 0,0 should fail :" + gc.CheckValidSpace(0, 0));
        //System.out.println("Location 1,1 should pass :" + gc.CheckValidSpace(1, 1));
        
        System.out.println("We are now going to add a character named Joe at 1, 1");
        Character joe = new Character("Joe");
        int[] position = {1, 1};
        gc.setPosition(joe, position);
        
        int[] position2 = gc.findCharacter("Joe");
        System.out.println("Joe is at " + position2[0] + " " + position2[1]);
         
        System.out.println("Moving Joe to 2, 2");
        int[] position3 = {2, 2};
        gc.setPosition(joe, position3);       
        System.out.println("Joe is at " + position3[0] + " " + position3[1]);
        
        System.out.println("1,1 should now be empty: " + gc.CheckValidSpace(position));
    }    
}