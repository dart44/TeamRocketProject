package grid;
import grid.GridController;
import Character.Character;

public class GridTest {

    public static void main(String[] args) {
        GridController gc = new GridController(10, 7);
       // gc.display();
        //gc.display();
        
        //System.out.println("Location 0,0 should fail :" + gc.CheckValidSpace(0, 0));
        //System.out.println("Location 1,1 should pass :" + gc.CheckValidSpace(1, 1));
        
        System.out.println("We are now going to add a character named Joe at 8, 5");
        Character joe = new Character("Joe");
        int[] position = {8, 5};
        System.out.println("Is 8:5 valid?: " + gc.CheckValidSpace(position));
        gc.setPosition(joe, position);
        
        System.out.println("Position 8:5 now contains " + gc.getContent(position).toString());
        
        System.out.println("Now moving to 4:4...");
        
        int[] old = position;
        position[0] = position[1] = 4;
        gc.setPosition(joe, position);
        
        System.out.println("Position 8:5 is empty? " + gc.CheckValidSpace(old));
        System.out.println("Position 4:4 now contains " + gc.getContent(position));
    }    
}