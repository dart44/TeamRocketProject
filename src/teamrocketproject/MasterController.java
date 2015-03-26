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
package teamrocketproject;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    
    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName = The name of the property.
     * @param newValue = An object that represents the new value
     * of the property.
     */
    protected void setModelProperty(String propertyName, Object newValue) {

        for (MasterModel model: registeredModels) {
            try {

                Method method = model.getClass().
                    getMethod("set"+propertyName, new Class[] {
                                                      newValue.getClass()
                                                  }


                             );
                method.invoke(model, newValue);

            } catch (NoSuchMethodException
                    | SecurityException
                    | IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException ex) {
                //  Handle exception.
            }
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
    
    

