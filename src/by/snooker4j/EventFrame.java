/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.snooker4j;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;

/**
 *
 * @author Admin
 */
public class EventFrame extends JFrame {
    
    public EventFrame() throws IOException {
        super("Events");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        EventTableModel model = new EventTableModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter(model);
        JTable table = new JTable(model);
        table.setRowSorter(sorter);
        table.getRowSorter().toggleSortOrder(1);
        JScrollPane panel = new JScrollPane();
        panel.setViewportView(table);
        JToolBar bar = new JToolBar();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < abc.length(); i++) {
            JButton b = new JButton(String.valueOf(abc.charAt(i)));
            b.setPreferredSize(new Dimension(32, 32));
            bar.add(b);
        }
        this.add(bar, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.pack();
    }
    
    public static void main(String[] args) {
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
                    EventFrame frame = null;
                    try {
                        frame = new EventFrame();
                    } catch (IOException ex) {
                        Logger.getLogger(EventFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.setVisible(true);
                }
                
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Snooker4j.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
