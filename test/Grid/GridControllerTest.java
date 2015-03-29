/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public void testFindCharacter() {
        System.out.println("findCharacter");
        Character TestDummy = new Character("TestDummy");
        Grid grid = new Grid(5, 5);
        grid.setPosition(TestDummy, 3,2);
        GridController instance = new GridController(5,5);
        int[] expResult = {3, 2};        
        int[] result = instance.findCharacter(TestDummy);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Test value does not match baseline value.");
    }

    /**
     * Test of changePosition method, of class GridController.
     */
    @Test
    public void testChangePosition() {
        System.out.println("changePosition");
        Grid grid = new Grid (5, 5);
        Character TestDummy = new Character("TestDummy");
        Character Lurch = new Character("Lurch");
        grid.setPosition(TestDummy, 1, 1);
        grid.setPosition(Lurch, 2, 3);
        GridController instance = new GridController(5, 5);
        int expResult = 0;
        int result = instance.changePosition(TestDummy, 4, 4);
        assertEquals(expResult, result);
        if(result == 1)
            System.out.println("changePosition() successful");
        // TODO review the generated test code and remove the default call to fail.
        else
          fail("Requested position is not empty. Cannot move to that space.");
    }

    /**
     * Test of checkDistance method, of class GridController.
     */
    @Test
    public void testCheckDistance() {
        System.out.println("checkDistance");
        Character TestDummy = new Character("TestDummy");
        Grid grid = new Grid(5, 5);
        grid.setPosition(TestDummy, 2, 2);        
        int newRow = 3;
        int newCol = 4;
        GridController instance = new GridController(5, 5);
        int expResult = 3;
        int result = instance.checkDistance(TestDummy, newRow, newCol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("CheckDistance() failed testing.");
    }

    /**
     * Test of CheckValidSpace method, of class GridController.
     */
    @Test
    public void testCheckValidSpace() {
        System.out.println("CheckValidSpace");
        int row1 = 3;
        int col1 = 3;
        int row2 = 2;
        int col2 = 2;
        GridController instance = new GridController(5, 5);
        Character obstacle = new Character("obstacle");
        Grid grid = new Grid(5, 5);
        grid.setPosition(obstacle, row1, col1);
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.CheckValidSpace(row1, col1);
        assertEquals(expResult1, result1);
        // TODO review the generated test code and remove the default call to fail.
        fail("CheckValidSpace() failed for invalid space.");
        boolean result2 = instance.CheckValidSpace(row2, col2);
        assertEquals(expResult2, result2);
        fail("CheckValidSpace() failed for valid space.");
    }

    /**
     * Test of initializeGrid method, of class GridController.
     */
    @Test
    public void testInitializeGrid() {
        System.out.println("initializeGrid");
        int row1 = 4;
        int col1 = 4;
        int row2 = 6;
        int col2 = 6;
        GridController instance = new GridController(5, 5);
        int expResult1 = 0;
        int result1 = instance.initializeGrid(row1, col1);
        assertEquals(expResult1, result1);
        // TODO review the generated test code and remove the default call to fail.
        fail("InitializeGrid() failed on invalid size.");
        int expResult2 = 1;
        int result2 = instance.initializeGrid(row2, col2);
        assertEquals(expResult2, result2);
        fail("InitializeGrid() failed on valid size");
    }

    /**
     * Test of createBorder method, of class GridController.
     */
    @Test
    public void testCreateBorder() {
        System.out.println("createBorder");
        int x1 = 5;
        int y1 = 5;
        //Grid grid = new Grid(5, 5);
        GridController instance = new GridController(5, 5);
        int expResult = 1;
        int result = instance.createBorder(x1, y1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("createBorder() failed.");
    }

    /**
     * Test of display method, of class GridController.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        GridController instance = new GridController(5, 5);
        instance.display();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emptyGridLocation method, of class GridController.
     */
    @Test
    public void testEmptyGridLocation() {
        System.out.println("emptyGridLocation");
        Grid grid = new Grid(5, 5);
        int row = 2;
        int col = 3;
        Character obstacle = new Character("obstacle");
        GridController instance = new GridController(5, 5);
        grid.setPosition(obstacle, row, col);
        boolean spaceState = instance.CheckValidSpace(row, col);
        if( spaceState == true )
            System.err.println("Before EmptyGridLocation(): Test space is empty");
        else
            System.err.println("Before EmptyGridLocation(): Test space is full");
        instance.emptyGridLocation(row, col);
        spaceState = instance.CheckValidSpace(row, col);
        if( spaceState == true )
            System.err.println("After EmptyGridLocation(): Test space is empty");
        else
            System.err.println("After EmptyGridLocation(): Test space is full");
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
