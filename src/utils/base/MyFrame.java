package utils.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyFrame extends JFrame {
    private int x;
    private int y;
    private int left;
    private int top;
    public MyFrame(String name){
        super(name);
        setSize(425,330);

        //去除标题栏

        //设置可见性
        setVisible(true);
        //设置透明度


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
//				System.out.println("鼠标按下");
                //当鼠标点击时获取距离屏幕的坐标
                x=e.getX();
                y=e.getY();
            }
        });
        //动态鼠标触发器
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
//				System.out.println("鼠标拖动");
                //获取当前位置的横坐标和纵坐标 left and top

                //横向移动距离=横向动态坐标-鼠标点击时的横向静态坐标
                //纵向移动距离=纵向动态坐标-鼠标点击时的纵向静态坐标
                //设置可变化的位置 加上原来的位置即可
                left=getLocation().x;
                top=getLocation().y;
                setLocation(left+e.getX()-x, top+e.getY()-y);
            }
        });
    }
}
