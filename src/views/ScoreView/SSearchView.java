package views.ScoreView;

import utils.CourseUtils.CourseManage;
import utils.ScoreUtils.ScoreManage;
import utils.base.Mytable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SSearchView extends JDialog{
    private ScoreManage scoreManage;
    private Mytable table;
    private JComboBox select_type;
    private JTextField search_text;
    private ScoreForm courseForm;
    public SSearchView(JFrame jFrame, ScoreManage scoreManage, Mytable table, ScoreForm courseForm){
        super(jFrame,"查询课程",true);
        this.scoreManage = scoreManage;
        this.table=table;
        this.courseForm=courseForm;
        JPanel jPanel=new JPanel();
        JLabel type=new JLabel("请选择查询方式");
         select_type=new JComboBox();
        select_type.addItem("--请选择--");
        select_type.addItem("课程编号");
        select_type.addItem("课程类型");
        select_type.addItem("课时");
        select_type.addItem("课程名称");
        select_type.addItem("老师");
        search_text=new JTextField(15);
        JButton search_btn=new JButton("查询");
        jPanel.add(type);
        jPanel.add(select_type);
        jPanel.add(search_text);
        jPanel.add(search_btn);
//        模糊查询
        search_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterType=(String)select_type.getSelectedItem();
                String filterText=search_text.getText();
                courseForm.refreshFilter(filterType,filterText);
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
