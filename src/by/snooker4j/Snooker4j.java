/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.snooker4j;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;

/**
 *
 * @author Admin
 */
public class Snooker4j {   
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
                
        JXTaskPaneContainer taskPane = new JXTaskPaneContainer();
        
        JXTaskPane playerPane = new JXTaskPane("Players");
        JXTaskPane nationPane = new JXTaskPane("Nations");
        JXTaskPane eventPane = new JXTaskPane("Events");
        JXHyperlink player = new JXHyperlink(new PlayerAction());
        playerPane.add(player);
        
        taskPane.add(playerPane);
        taskPane.add(nationPane);
        taskPane.add(eventPane);
        
        frame.setContentPane(taskPane);
        frame.setOpacity(0.95f);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SubstanceLookAndFeel laf = new SubstanceCremeCoffeeLookAndFeel();
            UIManager.setLookAndFeel(laf);
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    createAndShowGUI(); 
                }
                
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Snooker4j.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
