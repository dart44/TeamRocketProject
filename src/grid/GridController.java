package grid;

import Character.Character;
import grid.Grid.Border;

/**
 * 
 *   
 * @module Grid
 * @author Jared M Scott Class: GridController and Border Date: March 9th 2015
 * Update: 3/13/15 A Border class has been added to act as the edges of the map
 */
/**
 * Following the Model View Controller pattern, the GridController deals with
 * the finer details of class Grid that go beyond simple setters, getters, and
 * initialization. This file also holds the Border class that is needed for the
 * parameter of the grid
 */
//The Random class is needed as a varible to place a character in a random spot on the grid
//the Character Controller class is required to find a specific instance of 
//class Character in the Grid
public class GridController {

    Grid grid;

    /**
     * The constructor recieves the number of rows and columns needed for the
     * Grids creation. A more robust form of error checking will be implemented
     * with function initializeGrid in a later build It also initializes the
     * Border variable here.
     *
     * @param rows int
     * @param cols int
     */
    //TODO: add an exception
    public GridController(int rows, int cols) {
//        border = new Border();
        //System.out.println("Initing the Grid");
        if (initializeGrid(rows, cols) != 1) {
            System.err.println("Error: grid was not initialized");
        }
    }

    /**
     * Class border merely has a variable and overridden toString function
     *
     */
    //the following three functions come straight from the SRS, the remaining 
    //functions are ment to be called by the first three
    /**
     * This returns a two-element array containing the row and col that the
     * character is in If the character is not found, the returned array is row
     * 0 and col 0.
     *
     * @param character String
     * @return int[]
     */
    //use character.getName
    public int[] findCharacter(String character) {
        int[] answer = {0, 0};
        Character ch;

        //find the character by searching each element in the grid
        int r, c;
        for (r = 0; r < getGrid().getyAxis(); ++r) {
            for (c = 0; c < getGrid().getxAxis(); ++c) {
                int[] position = {r, c};
                if (getGrid().getContent(position) instanceof Character) {
                    ch = (Character) getGrid().getContent(position);
                    if (ch.getName().equals(character)) {
                        System.out.println("Character found at " + r + " " + c);
                        return position;
                        //answer[0] = r;
                        //answer[1] = c;
                        //return answer;
                    }//end inner if
                }//end outer if
            }//end inner for
        }//end outer for
        //System.out.println("There is no instance of target character on grid\nReturning location [0,0]");
        return answer;
    }

    //return 1 if successfull, 0 if fail
    //remove character from old position and move to new
    /**
     * If the desired location on the grid is empty, the Character is moved
     * there, its previous position becomes empty/null, and 1 is returned. Else
     * we return 0
     *
     * @param character Character 
     * @param newLocation int[]
     * @return int
     */
    public int setPosition(Character character, int[] newLocation) {
        int[] oldLocation = findCharacter(character.getName());
        //see if newLocation desired is empty
        if (getGrid().empty(newLocation) == true) {
            //add to the new location and set the old location to null if anything was there
            getGrid().setPosition(character, newLocation);

            //if the oldLocation is 0,0 then there the character was not on the map to begin with
            //else set the old position to null
            if (oldLocation[0] != 0 && oldLocation[1] != 0) {
                System.out.println("Setting position to null...");
                getGrid().setPositionToNull(oldLocation);
                
                if(getGrid().empty(oldLocation))
                    System.out.println("Old location set to null successfully");
            }

            //we are just notifiying that the grid itself has a change (the addition of a character)
            // setModelProperty(ELEMENT_GRID_PROPERTY, character);
            return 1;
        }
        return 0;
    }

    /**
     * This determines the distance of the chracter and a specified location As
     * long as the largest of the two rows or columns has the smaller
     * substracted from it, we can still get a correct answer. ex) 5 - 12 = -7
     * and 12 - 5 = 7. Both are a difference of 7
     *
     * @param character Character
     * @param newRow int
     * @param newCol int
     * @return int
     */
    public int checkDistance(Character character, int newRow, int newCol) {
        //first call to findCharacter
        int[] location = findCharacter(character.getName());
        int oldCol = location[1];
        int oldRow = location[0];

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
     * This determines the distance of the character and its target As
     * long as the largest of the two rows or columns has the smaller
     * subtracted from it, we can still get a correct answer. ex) 5 - 12 = -7
     * and 12 - 5 = 7. Both are a difference of 7
     *
     * @param attacker Character
     * @param target Character
     * @return int[]
     */
    public int[] checkDistance(Character attacker, Character target) {
        //first call to findCharacter
        int[] location = findCharacter(attacker.getName());
        int oldRow = location[0];
        int oldCol = location[1];
        
        //now find where the target is located
        location = findCharacter(target.getName());
        int targetsRow = location[0];
        int targetsCol = location[1];
        
        int r1, r2, c1, c2;
        int[] distance = {0, 0};
        
        if (oldRow < targetsRow) {
            r1 = targetsRow;
            r2 = oldRow;
        } else {
            r2 = targetsRow;
            r1 = oldRow;
        }

        if (oldCol < targetsCol) {
            c1 = targetsCol;
            c2 = oldCol;
        } else {
            c2 = targetsCol;
            c1 = oldCol;
        }

        distance[0] = (r1 - r2);
        distance[1] = (c1 - c2);
        return distance;
    }

    
    /**
     * Check if this is a valid grid space
     *
     * @param location int[]
     * @return boolean
     */
    public boolean CheckValidSpace(int[] location) {
        return getGrid().empty(location);
    }

    /**
     * Initialized class Grid. A Character will be placed on it randomly after
     * the borders are set up Must be larger than 5x5
     *
     * @param row int
     * @param col int
     * @return int 
     */
    //TODO add better error checking via exceptions
    public int initializeGrid(int row, int col) {
        if (row < 5 || col < 5) {
            System.err.println("Error: must be not smaller than 5 x 5");
            return 0;
        }

        grid = new Grid(row, col);
        //System.out.println("New Grid successfuly created");

        //create the border from here
        //System.out.println("Creating the Border");
        if (createBorder() != 1) {
            System.err.println("Error: Could not create border");
        }
        return 1;
    }

    public Border getBorder() {
        return getGrid().getBorder();
    }

    /**
     * Adds borders around the parameter of grid[][] and returns 1 when done
     *
     *
     * @return int 
     */
    public int createBorder() {
        //System.out.println("Setting border");

        int row, col;
        int[] location = {0, 0};

        //[row0, col0] -> [row0, colmax - 1];   
        for (col = 0; col < getGrid().getxAxis() - 1; ++col) {
            location[1] = col;
            getGrid().setBorderPosition(location);
        }

        //System.out.println("Part 1 done ");
        //[row0, col0] ->[rowmax - 1, col0]
        location[0] = location[1] = 0;

        for (row = 0; row < getGrid().getyAxis() - 1; ++row) {
            location[0] = row;
            getGrid().setBorderPosition(location);
        }
        //System.out.println("Part 2 done");

        //[rowMax - 1, col0] -> [rowMax, colMax - 1];
        location[0] = getGrid().getyAxis() - 1;
        location[1] = 0;
        for (col = 0; col < getGrid().getxAxis() - 1; ++col) {
            location[1] = col;
            getGrid().setBorderPosition(location);
        }

        //System.out.println("Part 3 done");
        //[row0, colMax - 2] ->[rowMax -1, colMax - 1]
        location[0] = 0;
        location[1] = getGrid().getxAxis() - 1;
        for (row = 0; row < getGrid().getyAxis(); ++row) {
            location[0] = row;
            getGrid().setBorderPosition(location);
        }

        //System.out.println("Part 4 done");
        return 1;
    }

    // This was created soley for testing purposes.
    /**
     * prints out exactly what is in each location of the grid
     */
    public void display() {
        int[] location = {0, 0};
        for (int i = 0; i < getGrid().getyAxis(); ++i) {
            for (int j = 0; j < getGrid().getxAxis(); ++j) {
                String s;
                location[0] = i;
                location[1] = j;
                if (getGrid().getContent(location) != null) {
                    s = getGrid().getContent(location).toString();
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
     *
     * @param location int[]
     */
    //make it not remove a border
    public void emptyGridLocation(int[] location) {
        grid.setPositionToNull(location);
        //setModelProperty(ELEMENT_GRID_PROPERTY, location);
    }

    /**
     *
     * @return Grid
     */
    public Grid getGrid() {
        return grid;
    }
    
    public int getGridSize(){
        return getGrid().getSize();
    }

    public Object getContent(int[] position) {
        return getGrid().getContent(position);
    }

    /**
     * Checks if the item in position is of class Character
     *
     * @param position int[]
     * @return boolean
     */
    public boolean isCharacter(int[] position) {
        return getContent(position) instanceof Character;
    }

    /**
     * Checks if the item in position is of class Border
     *
     * @param position int[]
     * @return boolean
     */
    public boolean isBorder(int[] position) {
        return getContent(position) instanceof Border;
    }

    /**
     * This will be used to change the grid (level) of each game if it's even
     * needed
     *
     * @param grid Grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}