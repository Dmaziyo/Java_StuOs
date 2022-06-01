package utils.CourseUtils;

import data.Course;
import utils.base.Mytable;
import views.CourseView.CAddView;
import views.CourseView.CModifyView;
import views.CourseView.CSearchView;
import views.CourseView.CourseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CourseHandler implements ActionListener {
    private JFrame jFrame;
    private CourseManage courseManage;
    private Mytable table;
    private CourseForm tableForm;
    public static ArrayList<Course> courses;
    public CourseHandler(JFrame jFrame, CourseManage courseManage, Mytable table,CourseForm tableForm){
        this.table=table;
        this.jFrame=jFrame;
        this.courseManage=courseManage;
        this.tableForm=tableForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton=(JButton)e.getSource();
        String text=jButton.getText();
        if("添加".equals(text)){
            new CAddView(jFrame,courseManage,table,tableForm);
        }
        else if("查询".equals(text)){
            new CSearchView(jFrame,courseManage,table,tableForm);
        }
        else if("修改".equals(text)){
            int[] rowIndexes=table.getSelectedRows();
            if(rowIndexes.length==0){
                JOptionPane.showMessageDialog(null,"请选择后再进行修改");
                return;
            }
            new CModifyView(jFrame,courseManage,table,tableForm);
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

        int id=CourseForm.courses.get(rowIndexes[0]).getId();
        courseManage.deleteCourse(id);
        tableForm.refreshAll();
    }

}
