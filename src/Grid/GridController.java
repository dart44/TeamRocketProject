package grid;

import Character.Character;
import Character.CharacterController;
import java.util.Random;
import teamrocketproject.MasterController; // -JC

/**
 * @module Grid
 * @author Jared M Scott 
 * Class: GridController and Border
 * Date: March 9th 2015
 * Update: 3/13/15 A Border class has been added to act
 * as the edges of the map
 */

/**
 * Following the Model View Controller pattern, the GridController deals with
 * the finer details of class Grid that go beyond simple setters, getters, and
 * initialization.
 * This file also holds the Border class that is needed for the parameter of the grid
 */

//The Random class is needed as a varible to place a character in a random spot on the grid
//the Character Controller class is required to find a specific instance of 
//class Character in the Grid
public class GridController extends MasterController {
    Grid grid;
    Border border;
    CharacterController cc;
    Random rn = new Random();
    
    /**
     * The constructor recieves the number of rows and columns needed for the Grids
     * creation. A more robust form of error checking will be implemented with function
     * initializeGrid in a later build 
     * It also initializes the Border variable here.
     * @param rows
     * @param cols 
     */
    //TODO: add an exception
    public GridController(int rows, int cols) {
        border = new Border();
        if (initializeGrid(rows, cols) != 1) {
            System.err.println("Error: grid was not initialized");
        }
    }

    /**
     * Class border merely has a variable and overridden toString function
     * 
     */
    public class Border {
        String name = "Border";

        @Override
        public String toString() {
            return name;
        }
    }
    
    //the following three functions come straight from the SRS, the remaining 
    //functions are ment to be called by the first three
    
/**
 * This returns a two-element array containing the row and col that the character is in
 * If the character is not found, the returned array is row 0 and col 0.
 * @param character
 * @return int[]
 */
    public int[] findCharacter(Character character) {
        int[] answer = {0, 0};
        Character c;

        //find the character by searching each element in the grid
        int i, j;
        for (i = 0; i < getGrid().getxAxis(); ++i) {
            for (j = 0; j < getGrid().getyAxis(); ++j) {
                if (getGrid().getContent(i, j) instanceof Character) {
                    c = (Character) getGrid().getContent(i, j);
                    if (cc.getName(c).equals(cc.getName(character))) {
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }//end inner if
                }//end outer if
            }//end inner for
        }//end outer for
        System.out.println("Error: Did not find character\nReturning location [0,0]");
        return answer;
    }

    //return 1 if successfull, 0 if fail
    //remove character from old position and move to new
    /**
     * If the desired location on the grid is empty, the Character is moved there,
     * its previous position becomes empty/null, and 1 is returned. Else we return 0
     * @param character
     * @param row
     * @param col
     * @return int
     */
    public int changePosition(Character character, int row, int col) {
        //first call to findCharacter
        int[] location = findCharacter(character);
        int oldRow = location[0];
        int oldCol = location[1];

        //see if location desired is empty
        if (getGrid().empty(row, col) == true) {
            //add to the new location and set the old location to null
            getGrid().setPosition(character, row, col);
            getGrid().setPosition(null, oldRow, oldCol);
            return 1;
        }
        return 0;
    }

    /**
     * This determines the distance of the chracter and a specified location
     * As long as the largest of the two rows or columns has the smaller substracted
     * from it, we can still get a correct answer.
     * ex) 5 - 12 = -7 and 12 - 5 = 7. Both are a difference of 7
     * @param character
     * @param newRow
     * @param newCol
     * @return int
     */
    public int checkDistance(Character character, int newRow, int newCol) {
        //first call to findCharacter
        int[] location = findCharacter(character);
        int oldRow = location[0];
        int oldCol = location[1];

        int distance, r1, r2, c1, c2;

        if (oldRow < newRow) {
            r1 = newRow;
            r2 = oldRow;
        } else {
            r2 = newRow;
            r1 = oldRow;
        }

        if (oldCol < newCol) {
            c1 = newCol;
            c2 = oldCol;
        } else {
            c2 = newCol;
            c1 = oldCol;
        }

        //find the difference of each x and y individually and add them together
        distance = (r1 - r2) + (c1 - c2);

        return distance;
    }

    /**
     * Check if this is a valid grid space
     * @param row
     * @param col
     * @return 
     */
    public boolean CheckValidSpace(int row, int col) {
        return getGrid().empty(row, col);
    }

/**
 * Initialized class Grid. A Character will be placed on it randomly after the 
 * borders are set up
 * Must be larger than 5x5
 * @param row
 * @param col
 * @return 
 */
    //TODO add better error checking via exceptions
    public int initializeGrid(int row, int col) {
        if (row < 5 || col < 5) {
            System.err.println("Error: must be not smaller than 5 x 5");
            return 0;
        }

        grid = new Grid(row, col);

        //create the border from here
        if (createBorder(row, col) != 1) {
            System.err.println("Error: Could not create border");
        }

        //add a character on the grid randomly. 
        Character character = new Character();
        int randX;
        int randY;
        
        randX = rn.nextInt(getGrid().getxAxis()) + 1;
        randY = rn.nextInt(getGrid().getyAxis()) + 1;
System.out.println("RandX and Rand Y are :" + randX + " " + randY);
      
        if(randX < 0)
            randX = 0;
        if(randY < 0)
            randY = 0;
        
        getGrid().setPosition(character, randX, randY);
        
        if(getGrid().empty(randX, randY) == false)
            System.out.println("The character is here :)\n");
        return 1;
    }

    /**
     * Adds borders around the parameter of grid[][] and returns 1 when done
     * @param x
     * @param y
     * @return 
     */
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

    
    // This was created soley for testing purposes.
    /**
     * prints out exactly what is in each location of the grid
     */
     public void display() {
        for (int i = 0; i < getGrid().getxAxis(); ++i) {
            for (int j = 0; j < getGrid().getyAxis(); ++j) {
                String s;
                if (getGrid().getContent(i, j) != null) {
                    s = getGrid().getContent(i, j).toString();
                    // System.out.print("Does not == null");
                } else {
                    s = "null";
                }
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
     
    /**
     * Remove any content in the grid location
     * @param row
     * @param col 
     */
     //make it not remove a border
    public void emptyGridLocation(int row, int col) {
        grid.setPosition(null, row, col);
    }

    /**
     * 
     * @return 
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * This will be used to change the grid (level) of each game if it's even needed
     * @param grid 
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}