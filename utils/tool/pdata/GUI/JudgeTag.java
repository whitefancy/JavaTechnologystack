package utils.tool.pdata.GUI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.net.URL;

 

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.SwingUtilities;

 

public class JudgeTag extends JPanel implements ActionListener {

 

   

    private static final long serialVersionUID = 1L;

 

    JButton button1,button2,button3;

    public JudgeTag() {

       //创建button上的图标

       ImageIcon imageIcon1 = createImage("images/right.gif");

       ImageIcon imageIcon2 = createImage("images/middle.gif");

       ImageIcon imageIcon3 = createImage("images/left.gif");

      

       //创建Button，并设置Button的图标

       button1 = new JButton("中间按钮不可用",imageIcon1);

       //设置Button的文本位置

       button1.setVerticalTextPosition(JButton.CENTER);

       button1.setHorizontalTextPosition(JButton.LEADING);

       //设置Button的快捷键

       button1.setMnemonic(KeyEvent.VK_D);

       //设置Button的反馈消息，消息处理者通过这个标记来辨别是哪个按钮被点击

       button1.setActionCommand("disable");

       //为Button添加监听者

       button1.addActionListener(this);

       //设置Button的提示信息

       button1.setToolTipText("点击此按键，此按键和中间按键变为不可用，右边按键变为可用");

       //将Button添加到panel中

       add(button1);

      

       //创建第二个Button

       button2 = new JButton("中间按钮",imageIcon2);

       button2.setVerticalTextPosition(JButton.CENTER);

       button2.setHorizontalTextPosition(JButton.LEFT);

       button2.setMnemonic(KeyEvent.VK_E);

       button2.addActionListener(this);

       button2.setToolTipText("点击此按键，没有任何操作");

       add(button2);

 

       //创建第三个Button

       button3 = new JButton("中间按钮可用",imageIcon3);

       button3.setVerticalTextPosition(JButton.CENTER);

       button3.setHorizontalTextPosition(JButton.RIGHT);

       button3.setMnemonic(KeyEvent.VK_R);

       button3.setActionCommand("enable");

       button3.addActionListener(this);

       button3.setToolTipText("点击此按键，中间按钮和左按钮可用，本按钮不可用");

       add(button3);

 

    }

   

   

    private ImageIcon createImage(String imageLocation) {

       //加载图片

       URL url = JudgeTag.class.getResource(imageLocation);

       //如果图片存在，返回Icon

       if(url != null)

           return new ImageIcon(url);

       return null;

    }

 

 

    @Override

    public void actionPerformed(ActionEvent e) {

       //disable为第一个按键被点击时的相应消息

       if ("disable".equals(e.getActionCommand())) {

           button1.setEnabled(false);

           button2.setEnabled(false);

           button3.setEnabled(true);

      

       }else {

           button1.setEnabled(true);

           button2.setEnabled(true);

           button3.setEnabled(false);

      

       }

    }

 

    public static void createAndShowGUI()

    {

       //创建一个frame

       JFrame frame = new JFrame("按键测试");

       //设置frame的关闭方式

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      

       //创建一个panel

       JPanel panel = new JudgeTag();

       //设置panel的透明性

       panel.setOpaque(true);

       //将panel添加到frame中

       frame.setContentPane(panel);

      

       //frame自动调整其大小，以便显示所有的空间

       frame.pack();

       //显示frame

       frame.setVisible(true);

    }

   

    public static void main(String[] args) {

       //开启界面线程

       SwingUtilities.invokeLater(new Runnable() {

          

           @Override

           public void run() {

              createAndShowGUI();

           }

       });

    }

}