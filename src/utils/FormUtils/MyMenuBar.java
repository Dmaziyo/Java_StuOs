package utils.FormUtils;

import utils.FormUtils.TableHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author 24794
 */
public class MyMenuBar extends JMenuBar {
    private TableHandler handler;
    public MyMenuBar(TableHandler handler){
        this.handler=handler;
        add(createOperate());
        setVisible(true);
    }

    private JMenu createOperate() {
        JMenu menu=new JMenu("操作(alt+O)");
        menu.setMnemonic(KeyEvent.VK_O);
        JMenuItem add_btn=new JMenuItem("添加",KeyEvent.VK_N);
        add_btn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        add_btn.addActionListener(handler);
        menu.add(add_btn);
        JMenuItem search_btn=new JMenuItem("查询",KeyEvent.VK_N);
        search_btn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        search_btn.addActionListener(handler);
        menu.add(search_btn);
        JMenuItem change_btn=new JMenuItem("修改",KeyEvent.VK_N);
        change_btn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        change_btn.addActionListener(handler);
        menu.add(change_btn);
        JMenuItem course_btn=new JMenuItem("课程管理",KeyEvent.VK_N);
        course_btn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        course_btn.addActionListener(handler);
        menu.add(course_btn);

        return menu;
    }
}
