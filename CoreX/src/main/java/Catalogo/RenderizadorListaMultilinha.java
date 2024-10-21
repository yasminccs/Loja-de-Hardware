package Catalogo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RenderizadorListaMultilinha extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JTextArea textArea = new JTextArea(value.toString());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5)); // Add some padding
        textArea.setOpaque(true);
        
        if (isSelected) {
            textArea.setBackground(Color.BLUE); // Set selected background color
            textArea.setForeground(Color.WHITE); // Set selected text color
        } else {
            textArea.setBackground(list.getBackground()); // Default background
            textArea.setForeground(list.getForeground()); // Default text color
        }
        
        return textArea;
    }
}

