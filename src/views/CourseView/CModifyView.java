package views.CourseView;

import data.Course;
import data.Student;
import utils.CourseUtils.CourseManage;
import utils.FormUtils.StudentManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CModifyView extends JDialog {
    private CourseManage courseManage;
    private JTable table;
    private CourseForm courseForm;
    public CModifyView(JFrame jFrame, CourseManage courseManage, JTable table,CourseForm courseForm){
        super(jFrame,"修改课程信息",true);
        this.courseManage =courseManage;
        this.table=table;
        this.courseForm=courseForm;
        JPanel jPanel=new JPanel();

        JLabel numLabel=new JLabel("课程编号");
        JTextField numText=new JTextField();
        JLabel typeLabel=new JLabel("课程类型");
        JPanel gruoppanel=new JPanel();
        JRadioButton select=new JRadioButton("选修",true);
        JRadioButton selectCompulsory=new JRadioButton("必修");

        ButtonGroup group=new ButtonGroup();
        group.add(select);
        group.add(selectCompulsory);
        gruoppanel.add(select);
        gruoppanel.add(selectCompulsory);

        JLabel hourLabel=new JLabel("课时");
        JTextField hourText=new JTextField();

        JLabel nameLabel=new JLabel("课程名称");
        JTextField nameText=new JTextField();
        JLabel teacherLab=new JLabel("课程老师");
        JTextField teacherText=new JTextField();
        JButton modify_btn=new JButton("修改");

        numLabel.setPreferredSize(new Dimension(60,30));
        numText.setPreferredSize(new Dimension(200,30));
        typeLabel.setPreferredSize(new Dimension(60,15));
        gruoppanel.setPreferredSize(new Dimension(200,30));
        hourLabel.setPreferredSize(new Dimension(60,30));
        hourText.setPreferredSize(new Dimension(200,30));
        nameLabel.setPreferredSize(new Dimension(60,30));
        nameText.setPreferredSize(new Dimension(200,30));
        teacherLab.setPreferredSize(new Dimension(60,30));
        teacherText.setPreferredSize(new Dimension(200,30));

        modify_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=table.getSelectedRow();
                String courseNum,courseName,courseHour,courseType="必修",teacher;
                for(Component c:gruoppanel.getComponents()){
                    if(c instanceof JRadioButton){
                        if(((JRadioButton) c).isSelected()){
                            courseType = ((JRadioButton)c).getText();
                        }
                    }
                }
                courseNum=numText.getText();
                courseName=nameText.getText();
                courseHour=hourText.getText();
                teacher=teacherText.getText();
                Course mcourse=new Course(courseNum,courseType,courseHour,courseName,teacher);
                mcourse.setId(CourseForm.courses.get(index).getId());
                courseManage.modifyCourse(mcourse);
                courseForm.refreshAll();
                JOptionPane.showMessageDialog(null,"修改成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jPanel.add(numLabel);
        jPanel.add(numText);
        jPanel.add(typeLabel);
        jPanel.add(gruoppanel);
        jPanel.add(hourLabel);
        jPanel.add(hourText);
        jPanel.add(nameLabel);
        jPanel.add(nameText);
        jPanel.add(teacherLab);
        jPanel.add(teacherText);
        jPanel.add(modify_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
