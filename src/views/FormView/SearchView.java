package views.FormView;

import utils.base.Mytable;
import utils.FormUtils.StudentManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchView extends JDialog{
    private StudentManage studentManage;
    private Mytable table;
    private JComboBox select_type;
    private JTextField search_text;
    private TableForm tableForm;
    public SearchView(JFrame jFrame,StudentManage studentManage,Mytable table,TableForm tableForm){
        super(jFrame,"查询学生",true);
        this.studentManage=studentManage;
        this.table=table;
        this.tableForm=tableForm;
        JPanel jPanel=new JPanel();
        JLabel type=new JLabel("请选择查询方式");
         select_type=new JComboBox();
        select_type.addItem("--请选择--");
        select_type.addItem("姓名");
        select_type.addItem("性别");
        select_type.addItem("年龄");
        select_type.addItem("学号");
        search_text=new JTextField(15);
        JButton search_btn=new JButton("查询");
        jPanel.add(type);
        jPanel.add(select_type);
        jPanel.add(search_text);
        jPanel.add(search_btn);
        search_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterType=(String)select_type.getSelectedItem();
                String filterText=search_text.getText();

                tableForm.refreshFilter(filterType,filterText);
            }
        });



        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(200,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
