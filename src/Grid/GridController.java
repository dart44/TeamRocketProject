package grid;

import Character.Character;
import Character.CharacterController;
import java.util.Random;

/**
 *
 * @author Jared M Scott Update: 3/13/15 A Border class has been added to server
 * as the edges of the map
 */
public class GridController {

    Grid grid;
    Border border;
    CharacterController cc;
    Random rn = new Random();
    
    public GridController(int x, int y) {
        border = new Border();
        if (initializeGrid(x, y) != 1) {
            System.err.println("Error: grid was not initialized");
        }
    }

    public class Border {

        String name = "Border";

        @Override
        public String toString() {
            return name;
        }
    }

    //the following three functions come straight from the SRS, the remaining 
    //functions are ment to be called by the three
    public int[] findCharacter(Character character) {
        int[] answer = {0, 0};
        Character c;

        //find the character
        int i, j;
        for (i = 0; i < getGrid().getxAxis(); ++i) {
            for (j = 0; j < getGrid().getyAxis(); ++j) {
                if (getGrid().getContent(i, j) instanceof Character) {
                    c = (Character) getGrid().getContent(i, j);
                    if (cc.GetName(c).equals(cc.GetName(character))) {
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }
                }
            }
        }//end outer for
        System.out.println("Error: Did not find character\nReturning location [0,0]");
        return answer;
    }

    //return 1 if successfull, 0 if fail
    //remove character from old position and move to new
    public int changePosition(Character character, int x, int y) {
        //first call to findCharacter
        int[] location = findCharacter(character);
        int oldX = location[0];
        int oldY = location[1];

        //see if location desired is empty
        if (getGrid().empty(x, y) == true) {
            //add to the new location and set the old location to null
            getGrid().setPosition(character, x, y);
            getGrid().setPosition(null, oldX, oldY);
            return 1;
        }
        return 0;
    }

    //check how far a character and a location is
    //as long as the largest x or y has the smallest on subtracted from it
    //we should still get an accurate answer
    //ex)5 - 12 = -7 and 12 - 5 = 7. Both are a difference of 7
    public int checkDistance(Character character, int newX, int newY) {
        //first call to findCharacter
        int[] location = findCharacter(character);
        int oldX = location[0];
        int oldY = location[1];

        int distance, x1, x2, y1, y2;

        if (oldX < newX) {
            x1 = newX;
            x2 = oldX;
        } else {
            x2 = newX;
            x1 = oldX;
        }

        if (oldY < newY) {
            y1 = newY;
            y2 = oldY;
        } else {
            y2 = newY;
            y1 = oldY;
        }

        //find the difference of each x and y individually and add them together
        distance = (x1 - x2) + (y1 - y2);

        return distance;
    }

    //check if anything is in the specified grid location
    public boolean CheckValidSpace(int x, int y) {
        return getGrid().empty(x, y);
    }
    /*
     Inititialized the Grid (duh), and calls createBorder
     */

    public int initializeGrid(int x, int y) {
        if (x < 5 || y < 5) {
            System.err.println("Error: must be nto smaller than 5 x 5");
            return 0;
        }

        grid = new Grid(x, y);

        //create the border from here
        if (createBorder(x, y) != 1) {
            System.err.println("Error: Could not create border");
        }

        //add a characte on the grid randomly. 
        Character character = new Character();
        int randX, randY;
        randX = rn.nextInt(getGrid().getxAxis()) + 1;
        randY = rn.nextInt(getGrid().getyAxis()) + 1;

        randX -= 1;
        randY -= 1;
        if(randX < 0)
            randX = 0;
        if(randY < 0)
            randY = 0;
        
        getGrid().setPosition(character, randX, randY);
        
        if(getGrid().empty(randX, randY) == false)
            System.out.println("The character is here :)\n");
        return 1;
    }

    //create a method that makes the border by adding an instance of
    //Border border in the proper gird locations
    //returns 1 when completed. 
    public int createBorder(int x, int y) {
        //System.out.println("Setting border");

        int row, col;

        //[row0, col0] -> [row0, colmax - 1];   
        for (col = 0; col < getGrid().getyAxis() - 1; ++col) {
            getGrid().setPosition(border, 0, col);
        }

        //System.out.println("Part 1 done ");
        //[row0, col0] ->[rowmax - 1, col0]
        for (row = 0; row < getGrid().getxAxis() - 1; ++row) {
            getGrid().setPosition(border, row, 0);
        }
        //System.out.println("Part 2 done");

        //[rowMax - 1, col0] -> [rowMax, colMax - 1];
        for (col = 0; col < getGrid().getyAxis() - 1; ++col) {
            getGrid().setPosition(border, getGrid().getxAxis() - 1, col);
        }

        //System.out.println("Part 3 done");
        //[row0, colMax - 2] ->[rowMax -1, colMax - 1]
        for (row = 0; row < getGrid().getxAxis(); ++row) {
            getGrid().setPosition(border, row, getGrid().getyAxis() - 1);
        }

        //System.out.println("Part 4 done");
        return 1;
    }

    /*
     This was created soley for testing purposes.
     public void display() {
     for(int i = 0; i < getGrid().getxAxis(); ++i){
     for(int j = 0; j < getGrid().getyAxis(); ++j){
     String s;
     if(getGrid().getContent(i, j) != null){
     s = getGrid().getContent(i, j).toString();
     // System.out.print("Does not == null");
     }
     else 
     s = "null";
     System.out.print(s + " ");
     }
     System.out.println();
     }

     }
     */
    //remove enemy/player/item
    public void emptyGridLocation(int x, int y) {
        grid.setPosition(null, x, y);
    }

    public Grid getGrid() {
        return grid;
    }

    //we'll only need this if we're changing levels i think
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
