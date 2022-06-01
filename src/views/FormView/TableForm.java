package views.FormView;


import data.Student;

import utils.FormUtils.*;
import utils.base.Mytable;
import views.CourseView.CourseForm;
import views.ScoreView.ScoreForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author 24794
 */
public class TableForm  extends JPanel{
    private Mytable table;
    private JFrame jFrame;
    private JPanel cards;
    private StudentManage studentManage;
    public static ArrayList<Student> students;
    public TableHandler getTableHandler() {
        return tableHandler;
    }

    private TableHandler tableHandler;
    private ButtonHandler buttonHandler;
    public TableForm(JFrame jFrame){

        studentManage=new StudentManage();

        this.setBorder(new EmptyBorder(5,5,5,5));
        this.setLayout(new BorderLayout(0,0));

        JPanel panel=new JPanel();

        JButton delete_btn=new JButton("删除");
        JButton add_btn=new JButton("添加");
        JButton search_btn=new JButton("查询");
        JButton modify_btn=new JButton("修改");

        table=new Mytable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableHandler=new TableHandler(jFrame,studentManage,table,this);
        buttonHandler=new ButtonHandler(jFrame,studentManage,table,this);

        add_btn.addActionListener(buttonHandler);
        search_btn.addActionListener(buttonHandler);
        delete_btn.addActionListener(buttonHandler);
        modify_btn.addActionListener(buttonHandler);
        panel.add(delete_btn);
        panel.add(modify_btn);
        panel.add(add_btn);
        panel.add(search_btn);
        JScrollPane scrollPane=new JScrollPane();
        this.add(panel,BorderLayout.SOUTH);
        this.add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(table);
        init();

    }


    public void init() {
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"姓名","性别","学号","年龄","操作"});
        table.setRowHeight(30);
        table.setModel(tableModel);
        table.getColumn("操作").setCellRenderer(new ButtonRenderer());
        JButton button=new JButton();
        table.getColumn("操作").setCellEditor(new ButtonEditor(new JCheckBox(),button));
        button.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        int[] rowIndexes=table.getSelectedRows();
                        int s_id= TableForm.students.get(rowIndexes[0]).getId();
                        new ScoreForm(s_id);
                    }
                }
        );
        this.refreshAll();
    }
    //    通过刷新来更新数据
    public void refresh(){
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
        tableModel.getDataVector().clear();
        tableModel.fireTableDataChanged();

        for (int i = 0; i < students.size(); i++) {
            tableModel.addRow(students.get(i).getAllData());
        }
        table.updateUI();
    }
    public void refreshAll(){
        studentManage.getStudents();
        this.refresh();
    }
    public void refreshFilter(String filterType,String filterText){
        switch (filterType){
            case "--请选择--":
                studentManage.getStudents();
                break;
            case "姓名":
                studentManage.getStudentByName(filterText);
                break;
            case "性别":
                studentManage.getStudentByGender(filterText);
                break;
            case "年龄":
                studentManage.getStudentByAge(filterText);
                break;
            case "学号":
                studentManage.getStudentByNumber(filterText);
                break;
        }
        this.refresh();
    }
}
