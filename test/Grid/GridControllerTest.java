/*
 *  JUnit test for GridController class.  
    Robert Mooneyham
    28 March 2015
*/
package Grid;
import grid.GridController;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
import Character.Character;
import grid.Grid;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason
 */
public class GridControllerTest {
    
    public GridControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findCharacter method, of class GridController.
     */
    @Test
    public void testFindCharacter(){
        System.out.println("Testing findCharacter...\n");
        int position[] = {2, 3};
        Character TestDummy = new Character("TestDummy");
        Grid grid = new Grid(5, 5);
        grid.setPosition(TestDummy, position);
        GridController instance = new GridController(5,5);
        int[] expResult = position;
        int[] result = instance.findCharacter(TestDummy.getName());
        if(expResult == result)
            System.out.println("Test passed");
        else
            System.out.println("Test Failed");
        System.out.println("findCharacter test complete...\n");
    }

    /**
     * Test of changePosition method, of class GridController.
     */
    @Test
    public void testSetPosition(){
        System.out.println("Begin test of changePosition...\n");
        Grid grid = new Grid (5, 5);
        Character TestDummy = new Character("TestDummy");
        Character Lurch = new Character("Lurch");
        int position[] = {4, 4};
        int position2[] = {2, 3};
        grid.setPosition(TestDummy, position);
        grid.setPosition(Lurch, position2);
        GridController instance = new GridController(5, 5);
        int expResult = 1;
        int result = instance.setPosition(TestDummy, position);
        assertEquals(expResult, result);
        if(result == 1)
            System.out.println("changePosition() successful");
        // TODO review the generated test code and remove the default call to fail.
        else
          System.out.println("Requested position is not empty. Cannot move to that space.");
        System.out.println("Test of setPosition complete...\n");
    }

    /**
     * Test of checkDistance method, of class GridController.
     * @param position
     */
    @Test
    public void testCheckDistance() {
        System.out.println("Begin test of checkDistance...\n");
        Character TestDummy = new Character("TestDummy");
        Grid grid = new Grid(5, 5);
        int position[] = {1, 1};
        grid.setPosition(TestDummy, position);        
        int newRow = 3;
        int newCol = 4;
        GridController instance = new GridController(5, 5);
        int result = instance.checkDistance(TestDummy, newRow, newCol);
        System.out.printf("Distance from test position: %d\n", result);
        System.out.println("Test of checkDistance complete...\n");
        
    }

     /*
      * Test of CheckValidSpace method, of class GridController.
      */
    @Test
    public void testCheckValidSpace() {
        System.out.println("Begin test of CheckValidSpace...\n");
        int position[] = {2, 1};
        int position2[] = {2, 2};
        GridController instance = new GridController(5, 5);
        Character obstacle = new Character("obstacle");
        Grid grid = new Grid(5, 5);
        grid.setPosition(obstacle, position2);
        boolean expResult = false;
        boolean result = instance.CheckValidSpace(position);
        if(expResult == result)
            System.out.println("Valid space: obtacle in {2,2}");
        else
            System.out.println("Invalid space: obstacle in {2,2}");
        System.out.println("Test of checkValidSpace complete...\n");
    }

    /**
     * Test of initializeGrid method, of class GridController.
     */
    @Test
    public void testInitializeGrid() {
        int row = 5, col = 5;
        System.out.println("Begin test of InitializeGrid...\n");
        GridController instance = new GridController(row, col);
        int result = instance.initializeGrid(row, col);
        if(result == 1)
            System.out.println("InitializeGrid successful");
        if(result == 0)
            System.out.println("InitializeGrid failed");
        System.out.println("Test of InitializeGrid complete...\n");
    }

     /**
     * Test of createBorder method, of class GridController.
     */
    @Test
    public void testCreateBorder() {
        int row = 5, col = 5;
        System.out.println("Begin test of createBorder...\n");
        //Grid grid = new Grid(5, 5);
        GridController instance = new GridController(row, col);
        int result = instance.createBorder(row, col);
        if(result == 1)
            System.out.println("CreateBorder successful");
        else
            System.out.println("CreateBorder failed");
        System.out.println("Test of createBorder complete...\n");
    }

    /**
     * Test of display method, of class GridController.
     */
    @Test
    public void testDisplay() {
        System.out.println("Testing display...\n");
        GridController instance = new GridController(5, 5);
        instance.display();
        System.out.println("Test of display complete...\n");
    }

    /**
     * Test of emptyGridLocation method, of class GridController.
     * 
     */
    @Test
    public void testEmptyGridLocation() {
        System.out.println("Begin test of emptyGridLocation...\n");
        Grid grid = new Grid(5, 5);
        int position[] = {4, 4};
        int position1[] = {2, 3};
        Character obstacle = new Character("obstacle");
        GridController instance = new GridController(5, 5);
        boolean spaceState = instance.CheckValidSpace(position);
        if(spaceState == true)
            System.out.println("Space {2,3} is empty before testing");
        grid.setPosition(obstacle, position1);
        System.out.println("Space {2, 3} is full after setting position");
        instance.emptyGridLocation(position);
        spaceState = instance.CheckValidSpace(position);
        if( spaceState == true )
            System.out.println("After EmptyGridLocation(): Test space is empty");
        else
            System.out.println("After EmptyGridLocation(): Test space is full");
        System.out.println("Test of emptyGridLocation complete...\n");
    }



    /**
     * Test of getBorder method, of class GridController.
       These are tests of getters and setters.  They are not required for unit
       testing.  They are included for completeness and can be modified as need
       arises.
     
    @org.junit.Test
    public void testGetBorder() {
        System.out.println("getBorder");
        GridController instance = null;
        Grid.Border expResult = null;
        Grid.Border result = instance.getBorder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrid method, of class GridController.
     
    @org.junit.Test
    public void testGetGrid() {
        System.out.println("getGrid");
        GridController instance = null;
        Grid expResult = null;
        Grid result = instance.getGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of getContent method, of class GridController.
     
    @org.junit.Test
    public void testGetContent() {
        System.out.println("getContent");
        int[] position = null;
        GridController instance = null;
        Object expResult = null;
        Object result = instance.getContent(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGrid method, of class GridController.
    
    @org.junit.Test
    public void testSetGrid() {
        System.out.println("setGrid");
        Grid grid = null;
        GridController instance = null;
        instance.setGrid(grid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /** 
     * These are tests of getters and setters.  Not required for unit testing, 
     * but left for completeness

    @Test
    public void testGetGrid() {
        System.out.println("getGrid");
        GridController instance = null;
        Grid expResult = null;
        Grid result = instance.getGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetGrid() {
        System.out.println("setGrid");
        Grid grid = null;
        GridController instance = null;
        instance.setGrid(grid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */    
}
