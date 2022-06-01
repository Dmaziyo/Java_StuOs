package utils.FormUtils;

import utils.base.Mytable;
import views.FormView.AddView;
import views.CourseView.CourseForm;
import views.FormView.ModifyView;
import views.FormView.SearchView;
import views.FormView.TableForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableHandler implements ActionListener {
    private JFrame jFrame;
    private StudentManage studentManage;
    private Mytable table;
    private TableForm tableForm;
    public TableHandler(JFrame jFrame, StudentManage studentManage,Mytable table,TableForm tableForm){
        this.table=table;
        this.jFrame=jFrame;
        this.studentManage=studentManage;
        this.tableForm=tableForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem jMenuItem=(JMenuItem)e.getSource();
        String text=jMenuItem.getText();
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
        else if("课程管理".equals(text)){
            new CourseForm();
        }
//        else if("删除".equals(text)){
//            deleteAction();
//        }
    }
//    public void deleteAction(){
//        int[] rowIndexes=table.getSelectedRows();
//
//        if(rowIndexes.length==0){
//            JOptionPane.showMessageDialog(null,"请选择行后再删除");
//            return;
//        }
//        int r=JOptionPane.showConfirmDialog(null,"你确定要删除吗","确认删除",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//        if(r!=JOptionPane.YES_OPTION){
//            return;
//        }
//        for(int i=0;i<rowIndexes.length;i++){
//            String num=(String) table.getValueAt(rowIndexes[i],2);
//            studentManage.deletestudent(num);
//            //转换为Model的索引,为了能够实现对应关系
//            rowIndexes[i]=table.convertRowIndexToModel(rowIndexes[i]);
//        }
//        System.out.println(rowIndexes);
//        Arrays.sort(rowIndexes);
//        DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
//        for(int i=rowIndexes.length-1;i>=0;i--){
//            tableModel.removeRow(rowIndexes[i]);
//        }
//    }
}
