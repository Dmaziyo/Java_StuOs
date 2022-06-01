package views.CourseView;


import data.Course;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.CourseUtils.CourseHandler;
import utils.CourseUtils.CourseManage;
import utils.base.Mytable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author 24794
 */
public class CourseForm extends JFrame{
    private Mytable table;
    private utils.CourseUtils.CourseManage CourseManage;
    public static ArrayList<Course> courses;
    private CourseHandler courseHandler;
    static {
        new CourseManage().getCourses();
    }
    public CourseForm(){
        this.setTitle("课程管理");
        CourseManage =new CourseManage();
        JPanel allPanel=new JPanel();
        allPanel.setBorder(new EmptyBorder(5,5,5,5));
        allPanel.setLayout(new BorderLayout(0,0));

//        底部按钮
        JPanel panel=new JPanel();

        JButton delete_btn=new JButton("删除");
        JButton add_btn=new JButton("添加");
        JButton search_btn=new JButton("查询");
        JButton modify_btn=new JButton("修改");


        table=new Mytable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        courseHandler =new CourseHandler(this, CourseManage,table,this);

        add_btn.addActionListener(courseHandler);
        search_btn.addActionListener(courseHandler);
        delete_btn.addActionListener(courseHandler);
        modify_btn.addActionListener(courseHandler);
        panel.add(delete_btn);
        panel.add(modify_btn);
        panel.add(add_btn);
        panel.add(search_btn);
        JScrollPane scrollPane=new JScrollPane();
//
        allPanel.add(panel,BorderLayout.SOUTH);
        allPanel.add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(table);
        this.add(allPanel);

        init();
        this.setSize(new Dimension(600,500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }


    public void init() {
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"课程编号","课程名称","课时数","课程性质","授课教授"});
        this.refreshAll();
        table.setRowHeight(30);
        table.setModel(tableModel);
    }


    //    通过刷新来更新数据
    public void refresh(){
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
        tableModel.getDataVector().clear();
        tableModel.fireTableDataChanged();

        for (int i = 0; i < courses.size(); i++) {
            tableModel.addRow(courses.get(i).getAllData());
        }
        table.updateUI();
    }
    public void refreshAll(){
        CourseManage.getCourses();
        this.refresh();
    }
    public void refreshFilter(String filterType,String filterText){
        switch (filterType){
            case "--请选择--":
                CourseManage.getCourses();
                break;
            case "课程编号":
                CourseManage.getCourseByNum(filterText);
                break;
            case "课程类型":
                CourseManage.getCourseByType(filterText);
                break;
            case "课时":
                CourseManage.getCourseByHour(filterText);
                break;
            case "课程名称":
                CourseManage.getCourseByName(filterText);
                break;
            case "老师":
                CourseManage.getCourseByTeacher(filterText);
                break;
        }
        this.refresh();
    }
}
