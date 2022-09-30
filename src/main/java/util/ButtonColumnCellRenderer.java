/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Hector
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private String iconName;

    public ButtonColumnCellRenderer(String nameIcon) {
        this.iconName = nameIcon;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String nameIcon) {
        this.iconName = nameIcon;
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);

        label.setHorizontalAlignment(CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("../images/" + iconName + ".png")));
        label.setSize(label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

        return label;
    }
}
