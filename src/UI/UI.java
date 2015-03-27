/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Character.CharacterController;
import UI.UI.bottomPanel;
import UI.UI.topPanel;
import grid.GridController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import teamrocketproject.MasterViewPanel; // - JC


public class UI {

    private JButton attackButton;
    private JButton abilityButton;
    private JButton moveButton;
    private JButton statsButton;
    private JButton passButton;
    private JLabel turnPlayer;
    private JLabel turnCharacter;
    private JLabel actionPoints;

    //private Character ch; 
    private CharacterController cc;
    private GridController grid;
    private GridBagConstraints gbc;

    public UI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                gbc = new GridBagConstraints();
                JFrame frame = new JFrame("Team Rocket");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                topPanel tp = new topPanel(gbc);
                frame.add(tp);
                frame.add(new bottomPanel(), BorderLayout.PAGE_END);
                frame.pack();
                frame.setVisible(true);
                frame.setBounds(0, 0, 400, 450);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);  //do we want resizable window?
                

                initializeGame();
            }
        });

    }

    public void initializeGame() {
        
        grid = new GridController(5, 5); //currently giving error
        
        //setCharacterPos(grid.findCharacter(ch)); // can't use with CharacterController
        
    }

   // public Character getCurrentCharacter(){
    //   return ch;
    //}
    public void setCurrentCharacter() {
        
    }

    public void setCharacterPos(int pos[]) {        
        gbc.gridx = pos[0];
        gbc.gridy = pos[1];

    }

    private class textPanel extends MasterViewPanel {
        
        //TODO Code to account for changes to models -JC
        @Override
        public void modelPropertyChange(PropertyChangeEvent evt){}

        public textPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.WHITE);
            turnPlayer = new JLabel("Turn Player:");
            turnCharacter = new JLabel("Turn Character:");
            actionPoints = new JLabel("Action Points:");
            
            Border buttonBorders = new MatteBorder(15,10,0,0, Color.WHITE);
            //turnPlayer.setBorder(buttonBorders);
            //turnPlayer.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 0));
            add(turnPlayer);
            add(turnCharacter);
            add(actionPoints);
            
            turnPlayer.setBorder(buttonBorders);
            turnCharacter.setBorder(buttonBorders);
            actionPoints.setBorder(buttonBorders);
            
            turnPlayer.setFont(new Font(this.getName(),Font.BOLD,13));
            turnCharacter.setFont(new Font(this.getName(),Font.BOLD,13));
            actionPoints.setFont(new Font(this.getName(),Font.BOLD,13));
        }
    }

    //bottom panel where text and buttons are located.
    public class bottomPanel extends MasterViewPanel {
        
        //TODO Code to account for changes to models -JC
        @Override
        public void modelPropertyChange(PropertyChangeEvent evt){}

        public bottomPanel() {
            setLayout(new BorderLayout());
            add(new actionPanel(), BorderLayout.LINE_END);
            setBackground(Color.white);
            Border border = new MatteBorder(12, 12, 12, 12, Color.BLACK);
            setBorder(border);
            
            add(new textPanel(), BorderLayout.LINE_START);
            
           
            
            //turnPlayer.setBorder(buttonBorders);
            
            

        }
    }

    //Panel where buttons are located
    public class actionPanel extends MasterViewPanel {
        
        //TODO Code to account for changes to models -JC
        @Override
        public void modelPropertyChange(PropertyChangeEvent evt){}

        public actionPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(100, 120));
            attackButton = new JButton("Attack");
            abilityButton = new JButton("Use Ability");
            moveButton = new JButton("Move");
            statsButton = new JButton("Check Stats");
            passButton = new JButton("Pass");

            add(attackButton);
            add(abilityButton);
            add(moveButton);
            add(statsButton);
            add(passButton);

            attackButton.setAlignmentX(CENTER_ALIGNMENT);
            abilityButton.setAlignmentX(CENTER_ALIGNMENT);
            moveButton.setAlignmentX(CENTER_ALIGNMENT);
            statsButton.setAlignmentX(CENTER_ALIGNMENT);
            passButton.setAlignmentX(CENTER_ALIGNMENT);

        }
    }
    
    //Top panel of the UI where grid is located
    public class topPanel extends MasterViewPanel {
        
        //TODO Code to account for changes to models -JC
        @Override
        public void modelPropertyChange(PropertyChangeEvent evt){}

        public topPanel(GridBagConstraints gbc) {
            setLayout(new GridBagLayout());

            //adds a JPanel to each grid tile and draw the grid by
            //changing border colors of each tile.
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane();
                    Border border = null;
                    if (row < 4) {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    cellPane.setBackground(Color.WHITE);
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }

        }        

    }

    //each tile on grid has a JPanel with its own mouseListener.
    public class CellPane extends MasterViewPanel {
        
        //TODO Code to account for changes to models -JC
        @Override
        public void modelPropertyChange(PropertyChangeEvent evt){}

        private Color defaultBackground=Color.WHITE;

        public CellPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setBackground(Color.BLUE);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(defaultBackground);
                }

            });
        }
        
        //Panel size for each panel
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}
