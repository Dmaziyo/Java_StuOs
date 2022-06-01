package views.FormView;

import data.Student;
import utils.FormUtils.StudentManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyView  extends JDialog {
    private StudentManage studentManage;
    private JTable table;
    private TableForm tableForm;
    private JDialog that;
    public ModifyView(JFrame jFrame,StudentManage studentManage,JTable table,TableForm tableForm){
        super(jFrame,"修改学生信息",true);
        this.studentManage=studentManage;
        this.table=table;
        this.tableForm=tableForm;
        that=this;
        JPanel jPanel=new JPanel();
        JLabel nameLabel=new JLabel("姓名");
        JTextField nameText=new JTextField();
        JLabel genderLabel=new JLabel("性别");
        JPanel gruoppanel=new JPanel();
        JRadioButton boy=new JRadioButton("男",true);
        JRadioButton girl=new JRadioButton("女");
        ButtonGroup group=new ButtonGroup();
        group.add(boy);
        group.add(girl);
        gruoppanel.add(boy);
        gruoppanel.add(girl);

        JLabel ageLabel=new JLabel("年龄");
        JTextField ageText=new JTextField();
        JLabel numLabel=new JLabel("学号");
        JTextField numText=new JTextField();


        JButton modify_btn=new JButton("修改");

        nameLabel.setPreferredSize(new Dimension(40,30));
        nameText.setPreferredSize(new Dimension(200,30));
        genderLabel.setPreferredSize(new Dimension(40,30));
        gruoppanel.setPreferredSize(new Dimension(200,30));
        ageLabel.setPreferredSize(new Dimension(40,30));
        ageText.setPreferredSize(new Dimension(200,30));
        numLabel.setPreferredSize(new Dimension(40,30));
        numText.setPreferredSize(new Dimension(200,30));

        modify_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=table.getSelectedRow();
                String name,age,gender="",num;
                for(Component c:gruoppanel.getComponents()){
                    if(c instanceof JRadioButton){
                        if(((JRadioButton) c).isSelected()){
                            gender = ((JRadioButton)c).getText();
                        }
                    }
                }
                name=nameText.getText();
                age=ageText.getText();
                num=numText.getText();
                int id= TableForm.students.get(index).getId();
                Student stu=new Student(name,gender,num,age);
                stu.setId(id);
                studentManage.modifyStu(stu);
                tableForm.refreshAll();
                JOptionPane.showMessageDialog(null,"修改成功","成功",JOptionPane.INFORMATION_MESSAGE);
                that.dispose();
            }
        });

        jPanel.add(nameLabel);
        jPanel.add(nameText);
        jPanel.add(genderLabel);
        jPanel.add(gruoppanel);

        jPanel.add(numLabel);
        jPanel.add(numText);
        jPanel.add(ageLabel);
        jPanel.add(ageText);
        jPanel.add(modify_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
