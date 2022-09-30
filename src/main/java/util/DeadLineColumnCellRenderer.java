/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import models.Task;

/**
 *
 * @author Hector
 */
public class DeadLineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);

        label.setHorizontalAlignment(CENTER);
        label.setForeground(Color.white);

        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        Task task = taskTableModel.getTasks().get(row);

        if (task.getDeadline().after(new Date())) {
            label.setBackground(Color.green);
        } else {
            label.setBackground(Color.red);
        }

        return label;
    }
}
