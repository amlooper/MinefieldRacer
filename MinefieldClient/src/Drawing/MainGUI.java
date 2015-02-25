
package Drawing;

import GameMechanics.Entity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represents the primary visuals for the client.
 * @author Joseph Ryan
 */
public class MainGUI {
    
    //Hud setup vars
    private int Width = 1050;
    private int Height = 650;
    private JFrame frame = new JFrame();
    private myJPanel mainpanel = new myJPanel();
    
    //Player interation vars
    private boolean[] keyPresses = {false,false,false,false};
    
    //Drawing data
    private ArrayList<Entity> coords = new ArrayList<Entity>();
    
    /**
     * Default Constructor: Sets up all of the drawing
     */
    public MainGUI(){
        frame = new JFrame("SURVIVE!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Width, Height);
        
        mainpanel.setPreferredSize(new Dimension(Width, Height));
        mainpanel.setLayout(null);
        mainpanel.addKeyListener(new Push());
        mainpanel.setFocusable(true);
        
        //Start up the magic
        frame.getContentPane().add(mainpanel);
        frame.setVisible(true);
        frame.pack();
        
        this.display();
    }
    
    /**
     * This is called whenever it is time to update the GUI
     */
    public void display(){
        mainpanel.repaint();
    }
    
    /**
     * Returns the key presses made by the Client
     * @return 
     *          The key presses 
     */
    public boolean[] keyPresses(){
        return this.keyPresses;
    }
    
    /**
     * This resets the key presses
     */
    public void resetKeyPresses(){
    	for(int k = 0; k < this.keyPresses.length; k++ )
    		this.keyPresses[k] = false;
    }
    /**
     * Sets up the data of all of the visible entities
     * @param c 
     *          The data of the entities
     */
    public void coords(ArrayList<Entity> c){
        this.coords = c;
    }
    
    /**
     * This class represents the panel that the player sees
     */
    private class myJPanel extends JPanel{
       
        /**
         * Paints the panel
         * @param g 
         *          The graphics being used to draw
         */
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            super.setBackground(Color.WHITE);
            
            ArrayList<Entity> temp = coords; //So data is not affected when coords is changed
            
            for(int e = 0; e < temp.size(); e++){
                DrawEntity.draw(g, temp.get(e));
            }
        }
    }
    
    /**
     * This class represents the button pushes by the client
     */
    private class Push extends myJPanel implements KeyListener{
        
        /**
         * The default constructor (not in use)
         */
        public Push(){}
        
        /**
         * The event that occurs when a key is pressed
         * @param e 
         *          The event
         */
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                //Movement Keys
                case KeyEvent.VK_A:
                keyPresses[0] = true;    
                break;
                case KeyEvent.VK_W:
                keyPresses[1] = true;    
                break;
                case KeyEvent.VK_D:
                keyPresses[2] = true;    
                break;
                case KeyEvent.VK_S:
                keyPresses[3] = true;    
                break;
                case KeyEvent.VK_LEFT:
                keyPresses[0] = true;    
                break;
                case KeyEvent.VK_UP:
                keyPresses[1] = true;    
                break;
                case KeyEvent.VK_RIGHT:
                keyPresses[2] = true;    
                break;
                case KeyEvent.VK_DOWN:
                keyPresses[3] = true;    
                break;
            }
        }

        /**
         * The event that occurs when a key is typed (not in use)
         * @param e 
         *          The event
         */
        public void keyTyped(KeyEvent e) {}

        /**
         * The event that occurs when a key is released (temporarily in use)
         * @param e 
         *          The event
         */
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                //Movement Keys
                case KeyEvent.VK_A:
                keyPresses[0] = false;    
                break;
                case KeyEvent.VK_W:
                keyPresses[1] = false;    
                break;
                case KeyEvent.VK_D:
                keyPresses[2] = false;    
                break;
                case KeyEvent.VK_S:
                keyPresses[3] = false;    
                break;
                case KeyEvent.VK_LEFT:
                keyPresses[0] = false;    
                break;
                case KeyEvent.VK_UP:
                keyPresses[1] = false;    
                break;
                case KeyEvent.VK_RIGHT:
                keyPresses[2] = false;    
                break;
                case KeyEvent.VK_DOWN:
                keyPresses[3] = false;    
                break;
            }
        
        
        }
    }
}
