package views;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import utils.FormUtils.MyMenuBar;
import utils.FormUtils.TableHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 24794
 */
public class Login extends JPanel {
      private JPanel cards;
      private JFrame jFrame;
      public TableHandler getHandler() {
            return handler;
      }

      private TableHandler handler;
      public Login(JFrame jFrame,JPanel cards, TableHandler handler){
            this.handler=handler;
            this.jFrame=jFrame;
            //账号密码
            JPanel userpanel=new JPanel();
            JPanel pwdpanel=new JPanel();

            //中心面板
            JPanel centerpanel=new JPanel();
            //登录界面

            //标题设置
            JLabel title=new JLabel("学生管理系统");



            title.setPreferredSize(new Dimension(500,100));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("黑体",1,20));


            JLabel user=new JLabel("用户名");
            user.setFont(new Font("黑体",1,13));

            JLabel password=new JLabel("密码  ");
            password.setHorizontalAlignment(SwingConstants.RIGHT);
            password.setFont(new Font("黑体",1,13));
            //账号密码框
            JTextField usef=new JTextField(15);
            JTextField pwdf=new JTextField(15);

            JButton login_btn=new JButton("登录");
            login_btn.setUI((new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue)));

            login_btn.addActionListener(new LoginListener(usef,pwdf,cards));
            JButton reset=new JButton("重置");
            reset.setUI((new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red)));
            //账号密码面板添加
            userpanel.add(user);
            userpanel.add(usef);
            pwdpanel.add(password);
            pwdpanel.add(pwdf);
            centerpanel.add(userpanel);
            centerpanel.add(pwdpanel);

            this.add(title);
            this.add(centerpanel);
            this.add(login_btn);
            this.add(reset);

      }

     class  LoginListener implements ActionListener{
          JTextField user;
          JTextField password;
          JPanel cards;
          public LoginListener(JTextField user,JTextField password,JPanel cards) {
                this.user=user;
                this.password=password;
                this.cards=cards;
          }

          @Override
          public void actionPerformed(ActionEvent e) {
                if(user.getText().equals("admin")&&password.getText().equals("123456")){
                      System.out.println("登录成功");
                      ((CardLayout)this.cards.getLayout()).show(this.cards,"MngSys");
                      jFrame.setSize(new Dimension(800,700));
                      jFrame.setLocationRelativeTo(null);
//                      目的是为了实现分离

                      jFrame.setJMenuBar( new MyMenuBar(handler));
                }
                else{
                      System.out.println("登录失败");
                      JOptionPane.showMessageDialog(null,"账号或密码错误","警告",JOptionPane.WARNING_MESSAGE);
                }
          }
    }
}
