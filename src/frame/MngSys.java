package frame;

import views.Login;
import utils.base.MyFrame;
import views.FormView.TableForm;

import javax.swing.*;
import java.awt.*;

public class MngSys {
    private JPanel cards;
    private TableForm tableForm;
    private Login login;
    private MyFrame jFrame;
    public MngSys(){

    }
    public JFrame generate(){
        jFrame=new MyFrame("学生管理系统");


        cards=new JPanel(new CardLayout());
//        管理页面
        tableForm=new TableForm(jFrame);
//        登录页面
        login=new Login(jFrame,cards,tableForm.getTableHandler());
        cards.add(login,"Login");
        cards.add(tableForm,"MngSys");
        jFrame.add(cards);
        jFrame.setLocationRelativeTo(null);
        return jFrame;
    }
}
