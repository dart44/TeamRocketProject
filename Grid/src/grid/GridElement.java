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
public class GridElement {

    /**
     * This simply contains two enums. One for contents and one for border They
     * each have a value that lets us select what the single border or content
     * is
     */
    /**
     * Begin declarations of enums
     */
    Border border;
    Content content;

    //Constructor
    public GridElement(int b, int c) {
        if (b < 0 || b > 8) {
            System.out.println("Error: b must be between 0 and 8...\nSetting to 0...");
            b = 0;
        }

        if (c < 0 || c > 8) {
            System.out.println("Error: c must be between 0 and 8...\nSetting to 0...");
            c = 0;
        }

        setBorder(b);
        setContent(c);
    }

    public enum Border {

        LEFT, RIGHT, UP, DOWN, UPPER_LEFT_CORNER,
        UPPER_RIGHT_CORNER, LOWER_LEFT_CORNER, LOWER_RIGHT_CORNER, NONE
    };

    public enum Content {

        POTION, PLAYER, EMPTY
    };

    String getBorder() {
        return border.name();
    }

    String getContent() {
        return content.name();
    }

    public void setBorder(int i) {
        if (i >= 8 || i <= 0) {
            i = 0;
        }

        switch (i) {
            case 0:
                border = Border.NONE;
                break;
            case 1:
                border = Border.LEFT;
                break;
            case 2:
                border = Border.RIGHT;
                break;
            case 3:
                border = Border.UP;
                break;
            case 4:
                border = Border.DOWN;
                break;
            case 5:
                border = Border.UPPER_LEFT_CORNER;
                break;
            case 6:
                border = Border.UPPER_RIGHT_CORNER;
                break;
            case 7:
                border = Border.LOWER_LEFT_CORNER;
                break;
            case 8:
                border = Border.LOWER_RIGHT_CORNER;
                break;
            default:
                System.out.println("Nothing for border\n");
        }//end switch
    }//end setBorder

    public void setContent(int i) {
        if (i >= 3 || i <= 0) {
            i = 0;
        }
        switch (i) {
            case 0:
                content = Content.EMPTY;
                break;
            case 1:
                content = Content.PLAYER;
                break;
            case 2:
                content = Content.POTION;
                break;
        }//end switch
    }//end set content

}//end GridElement class

