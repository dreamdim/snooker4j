/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.snooker4j;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.TreeMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

/**
 *
 * @author Admin
 */
public class PlayerTreeTableModel extends AbstractTreeTableModel {
    
    public PlayerTreeTableModel() throws IOException {
        super(new DefaultMutableTreeNode());
        DefaultMutableTreeNode r = (DefaultMutableTreeNode) getRoot();
        TreeMap<String, DefaultMutableTreeNode> list = new TreeMap<>();
        try (Database db = DatabaseBuilder.open(new File("d:/My Sport/Snooker/Info.mdb"))) {
            Table table = db.getTable("t_snooker_players");
            Iterator<Row> it = table.iterator();
            while (it.hasNext()) {
                Row item = it.next();                
                String nation = (String) item.get("nation");
                if (list.containsKey(nation)) {
                    DefaultMutableTreeNode node = list.get(nation);
                    node.add(new DefaultMutableTreeNode(new Player(item)));
                } else {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(nation);
                    node.add(new DefaultMutableTreeNode(new Player(item)));
                    list.put(nation, node);
                }
            }
            for (String key : list.keySet()) {
                r.add(list.get(key));
            }
        }
    }
    
    @Override
    public Class<?> getColumnClass(int i) {
        switch (i) {
            case 0: return String.class;
            case 1: return Date.class;
            default: return Object.class;
        }
    }
    
    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0: return "Name";
            case 1: return "Birthday";
            default: return "Unknown";
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(Object node, int i) {
        DefaultMutableTreeNode n = (DefaultMutableTreeNode) node;
        switch (n.getUserObject().getClass().getSimpleName()) {
            case "String": 
                String name = (String) n.getUserObject();
                switch(i) {
                    case 0: return name;
                    case 1: return null;
                    default: return null;
                }
            case "Player": 
                Player obj = (Player)n.getUserObject();
                switch(i) {
                    case 0: return obj.getName();
                    case 1: return obj.getBirthDate();
                    default: return null;
                }
            default : return null;
        }
    }

    @Override
    public Object getChild(Object parent, int index) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;
        return node.getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;
        return node.getChildCount();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) parent;
        return node.getIndex((TreeNode)child);
    }
    
}
