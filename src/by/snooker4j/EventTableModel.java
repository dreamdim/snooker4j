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
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class EventTableModel extends AbstractTableModel {
    
    private Database _database;
    
    private Table _source;
    
    private ArrayList<Row> data =  new ArrayList<>();
    
    public EventTableModel() throws IOException {
        super();
        _database = DatabaseBuilder.open(new File("D:/My Sport/Snooker/Info.mdb"));        
        _source = _database.getTable("t_events");
        Iterator<Row> it = _source.iterator();
        while (it.hasNext()) {
            data.add(it.next());
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Event";
            case 1: return "Start";
            case 2: return "Finish";
            case 3: return "Type";
            case 4: return "Venue";
            case 5: return "City";
            case 6: return "Country";
            default: return "Unknown";
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return Date.class;
            case 2: return Date.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return String.class;
                        case 6: return String.class;
                        default: return Object.class;
        }
    }

    @Override
    public int getRowCount() {
        return _source.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Row row = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return row.get("event_name");
            case 1: return row.get("start");
            case 2: return row.get("finish");
            case 3: return row.get("event_type");
            case 4: return row.get("venue");
            case 5: return row.get("city");
            case 6: return row.get("country");
            default: return null;
        }
    }
    
}
