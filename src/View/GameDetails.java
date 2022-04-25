package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameDetails extends JPanel {

    // Table for game data
    private JTable gameTable;
    // table column
    private String[] gameTableColumn = {"Time","White Player","Black Player","Result","Game"};

    // back button
    private JButton backButton;
    
    public GameDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        gameTable = new JTable();
        // scroll bar for table
        JScrollPane gameTableScroll = new JScrollPane(gameTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(gameTableScroll);

    }

 
    
 // gets Games from database and loads to table
    public void getGames(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) gameTable.getModel();
        defaultTableModel.setColumnIdentifiers(gameTableColumn);
        int i = 0;
        defaultTableModel.getDataVector().removeAllElements();
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }
    
 // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
