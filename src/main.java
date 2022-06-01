import frame.MngSys;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        //框架初始化
        try
        {
            System.setProperty("sun.java2d.noddraw", "true");
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible",false);

        }
        catch(Exception e)
        {
            //TODO exception
        }
        //界面生成
        MngSys mngSys=new MngSys();
        JFrame jFrame=mngSys.generate();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
