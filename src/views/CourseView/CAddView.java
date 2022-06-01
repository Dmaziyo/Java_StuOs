package views.CourseView;

import data.Course;
import utils.CourseUtils.CourseManage;
import utils.base.Mytable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAddView extends JDialog {
    private CourseManage courseMng;
    private Mytable table; //
    private CourseForm courseForm;
    public CAddView(JFrame jFrame, CourseManage courseManage, Mytable table,CourseForm courseForm){
        super(jFrame,"添加课程",true);
        this.courseMng =courseManage;
        this.table=table;
        this.courseForm =courseForm;
        JPanel jPanel=new JPanel();
        JLabel numLabel=new JLabel("课程编号:");
        JTextField numText=new JTextField();
        JLabel typeLabel=new JLabel("课程类型:");
        JPanel gruoppanel=new JPanel();
        ButtonGroup buttonGroup=new ButtonGroup();
        JRadioButton select=new JRadioButton("选修",true);
        JRadioButton selectCompulsory=new JRadioButton("必修");
        buttonGroup.add(select);
        buttonGroup.add(selectCompulsory);

        JLabel hourLabel=new JLabel("课时:");
        JTextField hourText=new JTextField();
        JLabel nameLabel=new JLabel("课程名称");
        JTextField nameText=new JTextField();
        JLabel teacherLab=new JLabel("课程老师");
        JTextField teacherText=new JTextField();

        JButton add_btn=new JButton("添加");

        nameLabel.setPreferredSize(new Dimension(60,30));
        nameText.setPreferredSize(new Dimension(200,30));

        typeLabel.setPreferredSize(new Dimension(60,30));
        gruoppanel.setPreferredSize(new Dimension(150,30));

        hourLabel.setPreferredSize(new Dimension(60,30));
        hourText.setPreferredSize(new Dimension(200,30));

        teacherLab.setPreferredSize(new Dimension(60,30));
        teacherText.setPreferredSize(new Dimension(200,30));

        numLabel.setPreferredSize(new Dimension(60,30));
        numText.setPreferredSize(new Dimension(200,30));

        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseNum, courseType,  courseHour, courseName,   teacher;
                courseType=null;
                for(Component c:gruoppanel.getComponents()){
                    if(c instanceof JRadioButton){
                        if(((JRadioButton) c).isSelected()){
                            courseType = ((JRadioButton)c).getText();
                        }
                    }
                }
                courseName=nameText.getText();
                courseNum=numText.getText();
                courseHour=hourText.getText();
                teacher=teacherText.getText();
                if(courseNum.isEmpty()||courseName.isEmpty()||courseHour.isEmpty()||courseType.isEmpty()||teacher.isEmpty()){
                    JOptionPane.showMessageDialog(null,"请填好所有数据","警告",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                courseManage.addCourse(new Course(courseNum,courseType,courseHour,courseName,teacher));
                courseForm.refreshAll();
                JOptionPane.showMessageDialog(null,"添加成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jPanel.add(numLabel);
        jPanel.add(numText);
        jPanel.add(typeLabel);
        gruoppanel.add(select);
        gruoppanel.add(selectCompulsory);
        jPanel.add(gruoppanel);
        jPanel.add(hourLabel);
        jPanel.add(hourText);
        jPanel.add(nameLabel);
        jPanel.add(nameText);
        jPanel.add(teacherLab);
        jPanel.add(teacherText);

        jPanel.add(add_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
