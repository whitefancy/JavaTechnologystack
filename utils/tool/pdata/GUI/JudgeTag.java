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

       //����button�ϵ�ͼ��

       ImageIcon imageIcon1 = createImage("images/right.gif");

       ImageIcon imageIcon2 = createImage("images/middle.gif");

       ImageIcon imageIcon3 = createImage("images/left.gif");

      

       //����Button��������Button��ͼ��

       button1 = new JButton("�м䰴ť������",imageIcon1);

       //����Button���ı�λ��

       button1.setVerticalTextPosition(JButton.CENTER);

       button1.setHorizontalTextPosition(JButton.LEADING);

       //����Button�Ŀ�ݼ�

       button1.setMnemonic(KeyEvent.VK_D);

       //����Button�ķ�����Ϣ����Ϣ������ͨ����������������ĸ���ť�����

       button1.setActionCommand("disable");

       //ΪButton��Ӽ�����

       button1.addActionListener(this);

       //����Button����ʾ��Ϣ

       button1.setToolTipText("����˰������˰������м䰴����Ϊ�����ã��ұ߰�����Ϊ����");

       //��Button��ӵ�panel��

       add(button1);

      

       //�����ڶ���Button

       button2 = new JButton("�м䰴ť",imageIcon2);

       button2.setVerticalTextPosition(JButton.CENTER);

       button2.setHorizontalTextPosition(JButton.LEFT);

       button2.setMnemonic(KeyEvent.VK_E);

       button2.addActionListener(this);

       button2.setToolTipText("����˰�����û���κβ���");

       add(button2);

 

       //����������Button

       button3 = new JButton("�м䰴ť����",imageIcon3);

       button3.setVerticalTextPosition(JButton.CENTER);

       button3.setHorizontalTextPosition(JButton.RIGHT);

       button3.setMnemonic(KeyEvent.VK_R);

       button3.setActionCommand("enable");

       button3.addActionListener(this);

       button3.setToolTipText("����˰������м䰴ť����ť���ã�����ť������");

       add(button3);

 

    }

   

   

    private ImageIcon createImage(String imageLocation) {

       //����ͼƬ

       URL url = JudgeTag.class.getResource(imageLocation);

       //���ͼƬ���ڣ�����Icon

       if(url != null)

           return new ImageIcon(url);

       return null;

    }

 

 

    @Override

    public void actionPerformed(ActionEvent e) {

       //disableΪ��һ�����������ʱ����Ӧ��Ϣ

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

       //����һ��frame

       JFrame frame = new JFrame("��������");

       //����frame�Ĺرշ�ʽ

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      

       //����һ��panel

       JPanel panel = new JudgeTag();

       //����panel��͸����

       panel.setOpaque(true);

       //��panel��ӵ�frame��

       frame.setContentPane(panel);

      

       //frame�Զ��������С���Ա���ʾ���еĿռ�

       frame.pack();

       //��ʾframe

       frame.setVisible(true);

    }

   

    public static void main(String[] args) {

       //���������߳�

       SwingUtilities.invokeLater(new Runnable() {

          

           @Override

           public void run() {

              createAndShowGUI();

           }

       });

    }

}