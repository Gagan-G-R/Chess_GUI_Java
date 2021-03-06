package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserDetails extends JPanel {

    // Table for user data
    private JTable playerTable;
    // table column
    private String[] playerTableColumn = {"Player Name", "Wins","Loss","Draw"};

    // back button
    private JButton backButton;

    public UserDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        playerTable = new JTable();
        // scroll bar for table
        JScrollPane userTableScroll = new JScrollPane(playerTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }
    
    

    // gets users from database and loads to table
    public void getPlayers(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) playerTable.getModel();
        defaultTableModel.setColumnIdentifiers(playerTableColumn);
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
