/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.UI.bottomPanel;
import UI.UI.topPanel;
import grid.Grid;
import grid.GridController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Character.Character;
import TurnOrder.TurnOrder;

public class UI {

    private JFrame frame;
    private JButton attackButton;
    private JButton abilityButton;
    private JButton moveButton;
    private JButton statsButton;
    private JButton passButton;
    private JLabel turnPlayer;
    private JLabel turnCharacter;
    private JLabel actionPoints;
    private JLabel iconLabel;
    private topPanel tp;
    private ImageIcon borderImage;
    private ImageIcon grassImage;
    private ImageIcon characterImage;
    //private Character character; 
    //private CharacterController cc;
    private GridController gridController;
    private GridBagConstraints gbc;
    private TurnOrder turnOrder;
    private int rows,cols;
    private CellPane cellPane;
    
/*
    public UI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                rows=5; //temporarily fixed values
                cols=5;
                
                gbc = new GridBagConstraints();
                frame = new JFrame("Team Rocket");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                tp = new topPanel(gbc);
                frame.add(tp);
                frame.add(new bottomPanel(), BorderLayout.PAGE_END);
                frame.pack();
                frame.setVisible(true);
                frame.setBounds(0, 0, 400, 450);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);  //do we want resizable window?
                
                InputStream borderStream = this.getClass().getResourceAsStream("/resources/border.png");
                InputStream grassStream = this.getClass().getResourceAsStream("/resources/grass.png");
                InputStream characterStream = this.getClass().getResourceAsStream("/resources/character.png");
                try {
                     BufferedImage border = ImageIO.read(borderStream);
                     borderImage = new ImageIcon(border);
                     BufferedImage grass = ImageIO.read(grassStream);
                     grassImage = new ImageIcon(grass);
                     BufferedImage character = ImageIO.read(characterStream);
                     characterImage = new ImageIcon(character);
                     
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }              
                
                               
                initializeGame();
                                
                gbc.gridx=0;
                gbc.gridy=0;
                gbc.fill=GridBagConstraints.BOTH;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.insets=new Insets(-1,-1,-1,-1);                                              
            }
        });
    }
    */
    /**
     * Jared Scott
     * This will take a Grid parameter and use it's variables for initialization
     * @param grid
     */
    public UI(final Grid grid){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                rows = grid.getxAxis();
                cols = grid.getyAxis();
                
                gbc = new GridBagConstraints();
                frame = new JFrame("Team Rocket");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                tp = new topPanel(gbc);
                frame.add(tp);
                frame.add(new bottomPanel(), BorderLayout.PAGE_END);
                frame.pack();
                frame.setVisible(true);
                frame.setBounds(0, 0, 400, 450);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);  //do we want resizable window?
                
                InputStream borderStream = this.getClass().getResourceAsStream("/resources/border.png");
                InputStream grassStream = this.getClass().getResourceAsStream("/resources/grass.png");
                InputStream characterStream = this.getClass().getResourceAsStream("/resources/character.png");
                try {
                     BufferedImage border = ImageIO.read(borderStream);
                     borderImage = new ImageIcon(border);
                     BufferedImage grass = ImageIO.read(grassStream);
                     grassImage = new ImageIcon(grass);
                     BufferedImage character = ImageIO.read(characterStream);
                     characterImage = new ImageIcon(character);                     
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }                             
                gridController = new GridController(grid.getxAxis(), grid.getyAxis());
                initializeGame();
                                
                gbc.gridx = grid.getxAxis();
                gbc.gridy = grid.getyAxis();
                gbc.fill=GridBagConstraints.BOTH;
                gbc.anchor=GridBagConstraints.CENTER;
                gbc.insets=new Insets(-1,-1,-1,-1);                         
            }
        });
    }
    
    public void propertyChange(PropertyChangeEvent evt){
        //TODO add the code to respond to property changes -JC
        
    //added by Jared Scott
        if (evt.getPropertyName().equals(turnOrder.ELEMENT_TURNCHARACTER_PROPERTY)) {
            turnOrder.getTurnCharacter();
        } else if (evt.getPropertyName().equals(gridController.getGrid().ELEMENT_XAXIS_PROPERTY)) {
            //cols = (int) evt.getNewValue();
            fillGrid();
        } else if (evt.getPropertyName().equals(gridController.getGrid().ELEMENT_YAXIS_PROPERTY)){
          //  rows = (int) evt.getNewValue();
            fillGrid();
        } else if (evt.getPropertyName().equals(gridController.getGrid().ELEMENT_GRID_PROPERTY)){
            Grid newGrid = (Grid) evt.getNewValue();          
          // gridController.setGrid(newGrid);
            fillGrid();
        } else if (evt.getPropertyName().equals(gridController.getGrid().ELEMENT_NULL_LOCATION_PROPERTY)){
            //int[] nullLocation = (int[]) evt.getNewValue();
            //gridController.setPosition(null, nullLocation);
            fillGrid();
        }else if (evt.getPropertyName().equals(gridController.getGrid().ELEMENT_GRID_CONTENTS_PROPERTY)){
            if (evt.getNewValue() instanceof Character) {
            //    Character newCharacterValue = (Character) evt.getNewValue();
              //  int[] location = gridController.findCharacter(newCharacterValue.getName());
               // gridController.setPosition(newCharacterValue, location);
            fillGrid();
            }else{
            System.err.println("Error: a Character should have been passed, not a " + evt.getNewValue().toString());
            }
        }               
    }

    public void initializeGame() { 
       fillGrid();     
    }

   // public Character getCurrentCharacter(){
    //   return ch;
    //}
    
    /**
     *
     */
        
    public void fillGrid() {
        int[] gridarray=new int[2];
        
    
        for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    
                    gbc.fill=GridBagConstraints.BOTH;
                    gbc.anchor=GridBagConstraints.CENTER;
                    gbc.insets=new Insets(-0,-0,-0,-0);
                    
                    gridarray[0]=row;
                    gridarray[1]=col;
                    gbc.gridx=row;
                    gbc.gridy=col;
                    Border border = null;
                    iconLabel=new JLabel();
                    
                     if (row < rows) {
                        if (col < cols) {
                            border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                        }
                    } else {
                        if (col < cols) {
                            border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        }
                     }
                        
                        iconLabel.setBorder(border);
                    if(gridController.getContent(gridarray)==null){                      
                        
                        iconLabel.setIcon(grassImage);
                        tp.add(iconLabel,gbc);
                        tp.revalidate();
                        tp.repaint();
                        tp.updateUI();
                    } 
                    else if(gridController.getContent(gridarray)== gridController.getBorder()){ 
                        
                        iconLabel.setIcon(borderImage);
                        tp.add(iconLabel,gbc);                        
                        tp.revalidate();
                        tp.repaint();
                        tp.updateUI();
                    }
                    else if(gridController.isCharacter(gridarray)){
                        
                        iconLabel.setIcon(characterImage);
                        tp.add(iconLabel,gbc);                        
                        tp.revalidate();
                        tp.repaint();
                        tp.updateUI();
                                                
                    }    
                }
        }
          
    }
    
    public void setCharacterPos(Character ch, int pos[]) {        
       gridController.setPosition(ch, pos);
    }     
   
    private void doAttack() {        
        tp.updateUI();
        frame.repaint();               
    }

    private void doAbility() {
        
    }
   
    private void doStats() {       
    }
        
    private void doMove() {        
    }
    private void doPass() {        
    }

    private class textPanel extends JPanel {
        
        //TODO Code to account for changes to models -JC

        public textPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.WHITE);
            turnPlayer = new JLabel("Turn Player:");
            turnCharacter = new JLabel("Turn Character:");
            actionPoints = new JLabel("Action Points:");
            
            Border buttonBorders = new MatteBorder(15,10,0,0, Color.WHITE);            
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
    public class bottomPanel extends JPanel {
        
        //TODO Code to account for changes to models -JC

        public bottomPanel() {
            setLayout(new BorderLayout());
            add(new actionPanel(), BorderLayout.LINE_END);
            setBackground(Color.white);
            Border border = new MatteBorder(12, 12, 12, 12, Color.BLACK);
            setBorder(border);
            
            add(new textPanel(), BorderLayout.LINE_START);  
                   
            

        }
    }

    //Panel where buttons are located
    public class actionPanel extends JPanel implements ActionListener, MouseListener {
        
        //TODO Code to account for changes to models -JC

        public actionPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(100, 120));
            
            
            attackButton = new JButton("Attack");
            abilityButton = new JButton("Use Ability");
            moveButton = new JButton("Move");
            statsButton = new JButton("Check Stats");
            passButton = new JButton("Pass");
            
            attackButton.addActionListener(this);            
            abilityButton.addActionListener(this);
            moveButton.addActionListener(this);
            statsButton.addActionListener(this);
            passButton.addActionListener(this);
            
            
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
            
            
           attackButton.setMaximumSize(this.getPreferredSize());
           abilityButton.setMaximumSize(this.getPreferredSize());
           moveButton.setMaximumSize(this.getPreferredSize());
           statsButton.setMaximumSize(this.getPreferredSize());
           passButton.setMaximumSize(this.getPreferredSize());

        }

        @Override
        public void actionPerformed(ActionEvent e) {
         Object src = e.getSource();
        if (src == attackButton)         
         doAttack();
        if (src == abilityButton)
         doAbility();
        if (src == moveButton)
         doMove();
        if (src == statsButton)
          doStats();
        if (src == passButton)
         doPass();       
        }

        @Override
        public void mouseClicked(MouseEvent e) {         
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }

        
    }
    
    
    //Top panel of the UI where grid is located
    public class topPanel extends JPanel {
        
        //TODO Code to account for changes to models -JC

        public topPanel(GridBagConstraints gbc) {
            setLayout(new GridBagLayout());

            //adds a JPanel to each grid tile and draw the grid by
            //changing border colors of each tile.
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    cellPane = new CellPane();
                    Border border = null;
                    
                    if (row < rows) {
                        if (col < cols) {
                            border = new MatteBorder(1, 1, 0, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                        }
                    } else {
                        if (col < cols) {
                            border = new MatteBorder(1, 1, 1, 0, Color.BLACK);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        }
                    }
                    
                    /*gbc.fill=GridBagConstraints.BOTH;
                    gbc.anchor=GridBagConstraints.CENTER;
                    gbc.insets=new Insets(-1,-1,-1,-1);
                    gbc.weightx=-1;
                    gbc.weighty=-1;
                    cellPane.setBackground(Color.WHITE);
                    cellPane.setBorder(border);
                    add(cellPane, gbc);*/
                }
            }

        }        

    }

    //each tile on grid has a JPanel with its own mouseListener.
    public class CellPane extends JPanel {
        
        //TODO Code to account for changes to models -JC

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
                
                @Override
                public void mouseClicked(MouseEvent e) {
       
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
