/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

/**
 *
 * @author jms12_000
 */
public class GridTest {
    /**
 *
 * @author jms12_000
 */

    /**
     * Create test with one controller and several grid classes. Test for size,
     * contents, and contents
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        GridElement ge = new GridElement(3,0);
        System.out.println(ge.getBorder());
        ge.setBorder(0);
        System.out.println(ge.getBorder());
        */
        /**
         * Create a GridElement test.
         * Create 25 GEs (50 enums) with each enum set differently.
         * Print out what they should say, then what they say
         * Test each function on several of them.
         * Add cout to each method so we see if they are called
         */
        
        /**
         * First, test using correctly sized b and c
         */
        System.out.println("Beggening GridElement test...\n");
        int b = 0;
        int c = 0;
        //GridElement[] array;
        
        for(int i = 0; i < 25; ++i){

            if( b >= 8 || b <= 0)
                b = 0;
            if( c >= 3 || c <= 0)
                c = 0;
            
            
            GridElement ge = new GridElement(b, c);
            System.out.println( "GridElement" + (i+1) + ": border = " + 
                    ge.getBorder() + " : content = "+ ge.getContent() + "...\n");
            
            ++b;
            ++c;
        }
        
     
        
        /**
         * Create a Grid Test
         * Create on Grid with 25 GEs in the Grid
         * Use a nested for loop to print each [row, column], element, and border
         */
        
        /**
         * Follow suit for the Grid Controller Class
         */
    }
    
}