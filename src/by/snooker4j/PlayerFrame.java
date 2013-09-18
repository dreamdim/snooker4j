/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.snooker4j;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.query.Query;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.jdesktop.swingx.JXTreeTable;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;

/**
 *
 * @author Admin
 */
public class PlayerFrame extends JFrame {
    
    public PlayerFrame() throws IOException {
        super("Players");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JScrollPane scrollView = new JScrollPane();
        JXTreeTable table = new JXTreeTable(new PlayerTreeTableModel());
        scrollView.setViewportView(table);
        this.add(scrollView, BorderLayout.CENTER);
        this.pack();
    }
    
    public static void main(String[] args) throws IOException {
        try {            
            //SubstanceLookAndFeel laf = new SubstanceCremeCoffeeLookAndFeel();
            NimbusLookAndFeel laf = new NimbusLookAndFeel();
            UIManager.setLookAndFeel(laf);
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    try {
                        PlayerFrame frame = new PlayerFrame();
                        frame.setLocationRelativeTo(null);
                        frame.setPreferredSize(new Dimension(600, 400));
                        frame.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(EventFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                }
                
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Snooker4j.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
