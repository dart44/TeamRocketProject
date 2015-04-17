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
package TeamRocketProject;
import Character.Character;
import TurnOrder.TurnOrder;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;



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
    
        /* Convenience methods for checking HP/AP */
    public Boolean CheckHP(Character ch){
        if (ch.getCurrentHP() <= 0){
            return false;
        }
        return true;
    }
    
    public Boolean CheckAP(Character ch){
        if (ch.getCurrentAP() <= 0) {  
            return false;
        }
        return true;
    }
    
    public void Attack(Character attacker, Character target, int AP){
        int ATK = attacker.getSTR();
        Random r = new Random(System.currentTimeMillis());
        int d100 = r.nextInt((100 - 1) + 1) + 1;
        if(d100 <= (ATK*AP)){
            int Damage = (int) Math.floor((d100 - ATK)/10);
            target.setCurrentHP(target.getCurrentHP()-Damage);
        }
    }
    
    public void Turn(TurnOrder TurnOrder){
        int i = 0;
        for (TurnOrder.getCharacter(i); i != TurnOrder.getSize(); i++){
            TurnOrder.setTurnCharacter(TurnOrder.getCharacter(i));
            Boolean PASS = false;
            while (TurnOrder.getTurnCharacter().getCurrentAP() != 0 && PASS != true){
            //TODO Game logic
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
    
    

