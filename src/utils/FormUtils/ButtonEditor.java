package utils.FormUtils;

import javax.swing.*;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor
{
    private String label;
    private JButton button;
    public ButtonEditor(JCheckBox checkBox,JButton button)
    {
        super(checkBox);
        this.button=button;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column)
    {
        label = (value == null) ? "详细" : value.toString();
        button.setText(label);
        return button;
    }
    @Override
    public Object getCellEditorValue()
    {
        return new String(label);
    }
}
