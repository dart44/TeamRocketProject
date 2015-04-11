/*
 * This class provides the base level abstraction for Controller classes.
 *  Changes to the properties of the Model classes controlled
 * are fired such that they can be propogated to all views. -JC
 */
/**
 *
 * @author Jason
 * 2015 March 10
 * Edited March 26 by Jeremy Crook
 */
package Main;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;



public abstract class MasterController implements PropertyChangeListener {
    private ArrayList<MasterModel> registeredModels;
    private ArrayList<MasterViewPanel> registeredViews;
    /* Default Constructor contains list of Models being controlled
     * as well as views to populate.
     */
    public MasterController(){
        registeredModels = new ArrayList<>();
        registeredViews = new ArrayList<>();
    };
    
    public void addModel(MasterModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }
    public void removeModel(MasterModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }
    
    public void addView(MasterViewPanel view) {
        registeredViews.add(view);  
    }
    
    public void removeView(MasterViewPanel view) {
        registeredViews.remove(view);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for (MasterViewPanel view: registeredViews) {
            view.modelPropertyChange(evt);
        }
    }
    /* Robert's old code below for reference - JC */
    /* check whether or not space is available.  Assumes grid as a
       separate type containing x & y coordinates. 
    
    public abstract boolean CheckValidMove(Grid grid, int x, int y);
         return grid.available(x,y); */
   
    /*assumes that Character is a separate class with each instance 
      having a unique name.  The type is tentatively named "Character"
    
    public abstract void SetSpeed(Character name, int speed);
        name.speed = speed; */
  
    
    /* get the player's speed.  Same assumption as SetSpeed 
    public abstract int GetSpeed(Character name);
         return name.speed; */
    
    
    /* Check the availability of the position, and go there if it's
       available.
    */
    /* public boolean Move(Character name, Grid grid, int x, int y){
        if(GridController.CheckValidSpace(x, y) == true){
            grid.setPosition(name, x, y);
            return true;
        } else {
            return false; 
        }
    }*/
}
    
    

