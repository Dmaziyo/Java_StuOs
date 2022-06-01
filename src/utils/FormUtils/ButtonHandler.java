package utils.FormUtils;

import utils.base.Mytable;
import views.FormView.AddView;
import views.FormView.ModifyView;
import views.FormView.SearchView;
import views.FormView.TableForm;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonHandler implements ActionListener {
    private JFrame jFrame;
    private StudentManage studentManage;
    private Mytable table;
    private TableForm tableForm;
    public ButtonHandler(JFrame jFrame, StudentManage studentManage,Mytable table,TableForm tableForm){
        this.table=table;
        this.jFrame=jFrame;
        this.studentManage=studentManage;
        this.tableForm=tableForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton=(JButton)e.getSource();
        String text=jButton.getText();
        if("添加".equals(text)){
            new AddView(jFrame,studentManage,tableForm);
        }
        else if("查询".equals(text)){
            new SearchView(jFrame,studentManage,table,tableForm);
        }
        else if("修改".equals(text)){
            int[] rowIndexes=table.getSelectedRows();
            if(rowIndexes.length==0){
                JOptionPane.showMessageDialog(null,"请选择后再进行修改");
                return;
            }
            new ModifyView(jFrame,studentManage,table,tableForm);
        }
        else if("删除".equals(text)){
            deleteAction();
        }
    }
    public void deleteAction(){
        int[] rowIndexes=table.getSelectedRows();

        if(rowIndexes.length==0){
            JOptionPane.showMessageDialog(null,"请选择行后再删除");
            return;
        }
        int r=JOptionPane.showConfirmDialog(null,"你确定要删除吗","确认删除",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(r!=JOptionPane.YES_OPTION){
            return;
        }

        int id=TableForm.students.get(rowIndexes[0]).getId();
        studentManage.deletestudent(id);
        tableForm.refreshAll();
    }
}
