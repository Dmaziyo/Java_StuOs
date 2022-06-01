package views.FormView;

import data.Student;
import utils.FormUtils.StudentManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddView extends JDialog {
    private StudentManage studentManage;
    private TableForm table;
    public AddView(JFrame jFrame,StudentManage studentManage,TableForm table){
        super(jFrame,"添加学生",true);
        this.studentManage=studentManage;
        this.table=table;
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

        JLabel numLabel=new JLabel("学号:");
        JTextField numText=new JTextField();
        JLabel ageLabel=new JLabel("年龄");
        JTextField ageText=new JTextField();


        JButton add_btn=new JButton("添加");

        nameLabel.setPreferredSize(new Dimension(40,30));
        nameText.setPreferredSize(new Dimension(200,30));
        genderLabel.setPreferredSize(new Dimension(60,30));
        numLabel.setPreferredSize(new Dimension(40,30));
        numText.setPreferredSize(new Dimension(200,30));
        ageLabel.setPreferredSize(new Dimension(40,30));
        ageText.setPreferredSize(new Dimension(200,30));
        gruoppanel.setPreferredSize(new Dimension(150,30));

        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name ,num,age,gender="";
                name=nameText.getText();
                for(Component c:gruoppanel.getComponents()){
                    if(c instanceof JRadioButton){
                        if(((JRadioButton) c).isSelected()){
                            gender = ((JRadioButton)c).getText();
                        }
                    }
                }
                num=numText.getText();
                age=ageText.getText();
                if(num.isEmpty()||age.isEmpty()||gender.isEmpty()||name.isEmpty()){
                    JOptionPane.showMessageDialog(null,"请填好所有数据","警告",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                studentManage.addstudent(new Student(name,gender,num,age));
                table.refreshAll();
                JOptionPane.showMessageDialog(null,"添加成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jPanel.add(nameLabel);
        jPanel.add(nameText);
        jPanel.add(genderLabel);
        gruoppanel.add(boy);
        gruoppanel.add(girl);
        jPanel.add(gruoppanel);
        jPanel.add(numLabel);
        jPanel.add(numText);
        jPanel.add(ageLabel);
        jPanel.add(ageText);
        jPanel.add(add_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
