package views.ScoreView;

import data.Course;
import data.Score;
import utils.ScoreUtils.ScoreManage;
import utils.base.Mytable;
import views.CourseView.CourseForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SAddView extends JDialog {
    private ScoreManage scoreManage;
    private Mytable table;
    private ScoreForm scoreForm;

    public SAddView(JFrame jFrame, ScoreManage scoreManage, Mytable table, ScoreForm scoreForm){
        super(jFrame,"添加课程",true);
        this.scoreManage =scoreManage;
        this.table=table;
        this.scoreForm = scoreForm;
        ArrayList<Course> courses=CourseForm.courses;
        HashMap<String,Integer> map=new HashMap<>();
        JPanel jPanel=new JPanel();
        JLabel nameLab=new JLabel("课程名称");
        JPanel selectPanel=new JPanel();
        JComboBox cmb=new JComboBox();
        if(courses.size()==0){
            JOptionPane.showMessageDialog(null,"暂时还没有课程哦","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        cmb.addItem("--请选择课程--");
        for (int i = 0; i < courses.size(); i++) {
               String name = courses.get(i).getCourseName();
               Integer tc_id=courses.get(i).getId();
                cmb.addItem(name);
                map.put(name,tc_id);
        }
        JLabel scoreLab=new JLabel("成绩");
        JTextField scoreText=new JTextField();
        JButton add_btn=new JButton("添加");

        nameLab.setPreferredSize(new Dimension(60,30));
        selectPanel.setPreferredSize(new Dimension(200,30));
        scoreLab.setPreferredSize(new Dimension(40,30));
        scoreText.setPreferredSize(new Dimension(200,30));


        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName, score;
                courseName=(String)cmb.getSelectedItem();
                score=scoreText.getText();
                if(score.isEmpty()||courseName.equals("--请选择课程--")){
                    JOptionPane.showMessageDialog(null,"请填好所有数据","警告",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int c_id=map.get(courseName);
                scoreManage.addScore(new Score(ScoreForm.s_id,c_id,courseName,score));
                scoreForm.refreshAll();
                JOptionPane.showMessageDialog(null,"添加成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        selectPanel.add(cmb);
        jPanel.add(nameLab);
        jPanel.add(selectPanel);
        jPanel.add(scoreLab);
        jPanel.add(scoreText);

        jPanel.add(add_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
