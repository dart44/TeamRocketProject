package grid;

/**
 * @module Grid
 * @author Jared M Scott
 * Class: Grid
 * Date: March 9th 2015
 * Update:3/13/15
 * Its been decided that String[][] is too limiting. I am changing it to Object[][]
 * so that a Character, Item, etc can be inserted into an [x, y] location
 */

/**
 * 
 * The Grid class contains a double array of type Object which
 * is represented by rows and columns denoted as xAxis and yAxis.
 * The class is initialized once two int parameters are passed to set the 
 * xAxis and yAxis. While the double array is of type Object, it can has two
 * set functions for placing 1)Objects and 2)Character classes inside of the grid.
 * Other than the typical getters and setters, there is also an empty function to
 * test if an Object or Character can be placed within a specific grid location
 */
public class Grid {

    //the xAxis and yAxis represent the rows and columns of the double array grid
    int xAxis;
    int yAxis;
    Object[][] grid;

    //the constructor must accept two values to determine the grid's size
    public Grid(int rows, int cols) {
        this.xAxis = rows;
        this.yAxis = cols;
        //the grid array is initialized with passed parameters
        grid = new Object[rows][cols];  
    }
  
    //determine if grid[xx][yy] contains any Object or Character
    //calls the getContent function
    boolean empty(int row, int col){
        return getContent(row, col) == null;
    }
    
    //return the contents of grid[x,y]
    Object getContent(int row, int col) {
        //error checking is performed to prevent an out of bounds exception
        //a better form of error checking will be added in later revisions
        if (row > xAxis || row < 0 || col > yAxis || col < 0) {
            System.err.println("Error: the x and/or y location is out of bounds");
            return null;
        }   
        return this.grid[row][col];
    }

    //places an instance of class Character in the specificed row and colum
      public void setPosition(Character character, int row, int col) {
        this.grid[row][col] = character;
    }
      
      //this version is for adding barriers to the parameter of the grid
      public void setPosition(Object obj, int row, int col) {
        this.grid[row][col] = obj;
    }
      
    //the following are basic setters and getters for the class variables 
    //TODO add error checking for setters and getters
    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public Object[][] getGrid() {
        return grid;
    }
}
