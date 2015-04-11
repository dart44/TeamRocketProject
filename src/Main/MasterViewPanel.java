/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;
/**
 * This class provides the base level abstraction for views.
 * All views that extend this class also extend JPanel.
 * @author Jeremy Crook
 */
public abstract class MasterViewPanel extends JPanel {
    public abstract void modelPropertyChange(PropertyChangeEvent evt);
}
