package grid;

/**
 *
 * @author Jared M Scott
 * Update:3/13/15
 * Its been decided that String[][] is too limiting. I am changing it to Object[][]
 * so that a Character, Item, etc can be inserted into an [x, y] location
 */
public class Grid {

    //create a 2 vector grid, and two ints repreenting an axiz
    int xAxis;
    int yAxis;
    Object[][] grid;

    public Grid(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        grid = new Object[xAxis][yAxis];  
    }
  
    //this method is no longer needed. THis kind of functionality should be 
    //used in a controller for MVC
    /*
    void displayEntireGrid() {

        for (int i = 0; i < this.xAxis; ++i) {
            for (int j = 0; j < this.yAxis; ++j) {
                System.out.print(getContent(i, j) + " ");
            }
            System.out.println();
        }
    }
*/
    Object getContent(int xx, int yy) {
        if (xx > xAxis || xx < 0 || yy > yAxis || yy < 0) {
            System.err.println("Error: the x and/or y location is out of bounds");
            return null;
        }   
        return this.grid[xx][yy];
    }

    //TODO add error checking for setters and getters
    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setGridElement(int x, int y, Object obj) {
        this.grid[x][y] = obj;
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