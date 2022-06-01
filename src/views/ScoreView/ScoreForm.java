package views.ScoreView;


import data.Score;
import utils.ScoreUtils.ScoreHandler;
import utils.ScoreUtils.ScoreManage;
import utils.base.Mytable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author 24794
 */
public class ScoreForm extends JFrame{
    private Mytable table;
    private ScoreManage scoreManage;
    public static ArrayList<Score> scores;
    private ScoreHandler scoreHandler;
    public static int s_id;
    public ScoreForm(int s_id){
        ScoreForm.s_id=s_id;
        this.setTitle("成绩管理");
        scoreManage =new ScoreManage();
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
        scoreHandler =new ScoreHandler(this, scoreManage,table,this);

        add_btn.addActionListener(scoreHandler);
        search_btn.addActionListener(scoreHandler);
        delete_btn.addActionListener(scoreHandler);
        modify_btn.addActionListener(scoreHandler);
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
        tableModel.setColumnIdentifiers(new Object[]{"学生姓名","课程名称","成绩"});
        this.refreshAll();
        table.setRowHeight(30);
        table.setModel(tableModel);
    }


    //    通过刷新来更新数据
    public void refresh(){
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
        tableModel.getDataVector().clear();
        tableModel.fireTableDataChanged();

        for (int i = 0; i < scores.size(); i++) {
            tableModel.addRow(scores.get(i).getAllData());
        }
        table.updateUI();
    }
    public void refreshAll(){
        scoreManage.getAllScore(s_id);
        this.refresh();
    }
    public void refreshFilter(String filterType,String filterText){
        switch (filterType){
            case "--请选择--":
                scoreManage.getAllScore(s_id);
                break;
            case "课程名称":
                scoreManage.getScoreByName(s_id,filterText);
                break;
            case "课程类型":
                scoreManage.getScoreByType(s_id,filterText);
                break;
            case "成绩":
                scoreManage.getScoreByScore(s_id,filterText);
                break;
        }
        this.refresh();
    }
}
