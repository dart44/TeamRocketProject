/*
 *
 * Base Model class from which all other Model classes
 * are derived. 
 */
package TeamRocketProject;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 **
 *  
 * @author Robert Eckstein
 */
public abstract class AbstractModel {

    /**
     *  No information added
     */
    protected PropertyChangeSupport propertyChangeSupport;
    
    /**
     * Constructor for propertyChangeSupport object
     */
    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    /**
     * Add a property change listener
     * @param listener PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Delete property change listener. 
     * @param listener PropertyChangeListener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    /**
     * Used to signal change of game state
     * @param propertyName String
     * @param oldValue Object
     * @param newValue Object
     */
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    /**
     * Used to signal change of game state. 
     * @param propertyName String
     * @param oldValue int
     * @param newValue int
     */
    protected void firePropertyChange(String propertyName, int oldValue, int newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}
