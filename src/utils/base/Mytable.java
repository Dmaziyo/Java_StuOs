package utils.base;

import javax.swing.*;

public class Mytable  extends JTable {
        public Mytable(){
            super();
        }
    // 表格不可编辑

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column==4){
            return true;
        }
        else{
            return false;
        }
    }
}
