package grid;

/**
 *
 * @author Jared M Scott
 * Update: 3/13/15
 * A Border class has been added to server as the edges of the map
 */
public class GridController {

    Grid grid;
    Border border;
    
    GridController(int x, int y) {
        border = new Border();
        if(initializeGrid(x, y) != 1)
            System.err.println("Error: grid was not initialized");
    }
    
    /** 
     * Default Border Constructor
     */
    public class Border {
        String name = "Border";

        @Override
        public String toString() {
            return name;
        }
    }
    
    /**
     * 
     * Inititialize the Grid, and calls createBorder
     * 
     * @param x
     * @param y
     * @return int
    */
    int initializeGrid(int x, int y) {
        if (x < 5 || y < 5) {
            System.err.println("Error: must be nto smaller than 5 x 5");
            return 0;
        }

        grid = new Grid(x, y);

        //create the border from here
        if (createBorder(x, y) != 1) {
            System.err.println("Error: Could not create border");
        }

        return 1;
    }

    //create a method that makes the border by adding an instance of
    //Border border in the proper gird locations
    //returns 1 when completed. 
    int createBorder(int x, int y) {
        //System.out.println("Setting border");

        int row, col;
        
        //[row0, col0] -> [row0, colmax - 1];   
        for (col = 0; col < getGrid().getyAxis() - 1; ++col) {
            getGrid().setGridElement(0, col, border);
        }
        
        //System.out.println("Part 1 done ");

        //[row0, col0] ->[rowmax - 1, col0]
        for (row = 0; row < getGrid().getxAxis() - 1; ++row) {
            getGrid().setGridElement(row, 0, border);
        }
        //System.out.println("Part 2 done");

        
        //[rowMax - 1, col0] -> [rowMax, colMax - 1];
        for (col = 0; col < getGrid().getyAxis() - 1; ++col) {
            getGrid().setGridElement(getGrid().getxAxis() - 1, col, border);
        }
                
        //System.out.println("Part 3 done");

        
        //[row0, colMax - 2] ->[rowMax -1, colMax - 1]
        for (row = 0; row < getGrid().getxAxis(); ++row) {
            getGrid().setGridElement(row, getGrid().getyAxis() - 1, border);
        }
                
        //System.out.println("Part 4 done");
        return 1;
    }

    /*
    This was created soley for testing purposes.
    Displays each element in grid via for loops and toString
    null cant use to string so i create an if statement as a workaround
    */
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

    /**
     *  remove enemy/player/item
     *  @param x
     *  @param y 
     */
    public void emptyGridLocation(int x, int y) {
        grid.setGridElement(x, y, null);
    }

    /**
     * Get the grid
     * @return Grid
     */
    public Grid getGrid() {
        return grid;
    }

    //we'll only need this if we're changing levels i think
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
