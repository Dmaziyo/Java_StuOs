package utils.ScoreUtils;

import data.Course;
import utils.base.Mytable;
import views.CourseView.CAddView;
import views.CourseView.CModifyView;
import views.CourseView.CSearchView;
import views.CourseView.CourseForm;
import views.ScoreView.SAddView;
import views.ScoreView.SModifyView;
import views.ScoreView.SSearchView;
import views.ScoreView.ScoreForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScoreHandler implements ActionListener {
    private JFrame jFrame;
    private ScoreManage scoreManage;
    private Mytable table;
    private ScoreForm tableForm;
    public static ArrayList<Course> courses;
    public ScoreHandler(JFrame jFrame, ScoreManage scoreManage, Mytable table, ScoreForm tableForm){
        this.table=table;
        this.jFrame=jFrame;
        this.scoreManage = scoreManage;
        this.tableForm=tableForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton=(JButton)e.getSource();
        String text=jButton.getText();
        if("添加".equals(text)){
            new SAddView(jFrame, scoreManage,table,tableForm);
        }
        else if("查询".equals(text)){
            new SSearchView(jFrame, scoreManage,table,tableForm);
        }
        else if("修改".equals(text)){
            int[] rowIndexes=table.getSelectedRows();
            if(rowIndexes.length==0){
                JOptionPane.showMessageDialog(null,"请选择后再进行修改");
                return;
            }
            new SModifyView(jFrame, scoreManage,table,tableForm);
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
        scoreManage.deleteCourse(id);
        tableForm.refreshAll();
    }

}
