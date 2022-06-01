package views.ScoreView;

import data.Score;
import utils.ScoreUtils.ScoreManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SModifyView extends JDialog {
    private ScoreManage scoreManage;
    private JTable table;
    private ScoreForm scoreForm;
    public SModifyView(JFrame jFrame, ScoreManage scoreManage, JTable table, ScoreForm scoreForm){
        super(jFrame,"修改成绩",true);
        this.scoreManage = scoreManage;
        this.table=table;
        this.scoreForm = scoreForm;
        JPanel jPanel=new JPanel();

        JLabel scoreLab=new JLabel("成绩");
        JTextField scoreText=new JTextField();

        JButton modify_btn=new JButton("修改");

        scoreLab.setPreferredSize(new Dimension(60,30));
        scoreText.setPreferredSize(new Dimension(180,30));

        modify_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=table.getSelectedRow();
                String score;
                score=scoreText.getText();

                Score mscore=ScoreForm.scores.get(index);
                mscore.setScore(score);
                scoreManage.modifyCourse(mscore);
                scoreForm.refreshAll();
                JOptionPane.showMessageDialog(null,"修改成功","成功",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jPanel.add(scoreLab);
        jPanel.add(scoreText);

        jPanel.add(modify_btn);

        Container contentPane=getContentPane();
        contentPane.add(jPanel);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
