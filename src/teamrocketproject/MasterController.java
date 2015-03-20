/*
 * This class serves as a base class from which all other
 * other controllers in the game derive.  This is a first draft. 
 */
/**
 *
 * @author Jason
 * 2015 March 10
 */
package TeamRocketProject;
import grid.Grid;


public abstract class MasterController {
     
    /* empty constructor.  Controller has no data of its own */
    public MasterController(){
    };
    
    /* check whether or not space is available.  Assumes grid as a
       separate type containing x & y coordinates. 
    */
    public abstract boolean CheckValidMove(Grid grid, int x, int y);
        /* return grid.available(x,y); */
   
    /*assumes that Character is a separate class with each instance 
      having a unique name.  The type is tentatively named "Character"
    */
    public abstract void SetSpeed(Character name, int speed);
        /* name.speed = speed; */
  
    
    /* get the player's speed.  Same assumption as SetSpeed */
    public abstract int GetSpeed(Character name);
        /* return name.speed; */
    
    
    /* Check the availability of the position, and go there if it's
       available.
    */
    public boolean Move(Character name, Grid grid, int x, int y){
        if(CheckValidSpace(grid, x, y) == true){
            grid.SetPosition(name, x, y);
            return true;
        }
        else return false;
    }
}
    
    

