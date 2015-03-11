/*
 * This class serves as a base class from which all other
 * other controllers in the game derive.  This is a first draft. 
 */
/**
 *
 * @author Jason
 * 2015 March 10
 */


public class MasterController {
     
    /* empty constructor.  Controller has no data of its own */
    public MasterController(){
    };
    
    /* check whether or not space is available.  Assumes grid as a
       separate type containing x & y coordinates. 
    */
    public boolean CheckValidMove(Grid grid, int x, int y){
        return grid.available(x,y);
        
    }
    /*assumes that Character is a separate class with each instance 
      having a unique name.  The type is tentatively named "Character"
    */
    public void SetSpeed(Player name, int speed){
        name.speed = speed;
    }
    
    /* get the player's speed.  Same assumption as SetSpeed */
    public int GetSpeed(Player name){
        return name.speed;
    }
    
    /* Check the availability of the position, and go there if it's
       available.
    */
    public boolean Move(Player name, Grid grid, int x, int y){
        if(CheckValidSpace(grid, x, y) == true){
            name.SetPosition(x, y);
            return true;
        }
        else return false;
    }
}
    
    

