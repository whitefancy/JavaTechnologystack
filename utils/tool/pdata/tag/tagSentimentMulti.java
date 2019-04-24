package utils.tool.pdata.tag;

import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class tagSentimentMulti extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	String csvFile = "E:/github/ToolLib/input/signal_multi2.csv";
	String csvOutFile = "E:/github/ToolLib/output/signal_multi2_munual.csv";
	static BufferedReader br;
	static PrintWriter outFile;

	static JFrame frame;
	static tagSentimentMulti panel;
	static JTextArea label;
	static JLabel  label_sen, label_obj;
	JButton btnConfirm, btnPos, btnNeg, btnNul, btnclose, btnstrt;
	JButton[] btn =null;
	static int i = 1;
	static int i_now = 1;
	static String line = "";
	static String csvSpliBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
	static String[] Sentense = null;

	static String[] Sentiment=null;
	static int obj_count=0;
	int btn_close =-1;
	int btn_strt =-2;
	int btn_Confirm =-3;
	public tagSentimentMulti() {


		loadcsvfiles();
		
		btnConfirm = new JButton("确认");
		btnclose = new JButton("close");
		btnstrt = new JButton("start");
		
		btnConfirm.setBounds(80, 90, 70, 29);
		btnclose.setBounds(80, 220, 70, 29);
		btnstrt.setBounds(80, 180, 70, 29);

		btnConfirm.setActionCommand(String.valueOf(btn_Confirm));
		btnclose.setActionCommand(String.valueOf(btn_close));
		btnstrt.setActionCommand(String.valueOf(btn_strt));

		btnConfirm.addActionListener(this);
		btnclose.addActionListener(this);
		btnstrt.addActionListener(this);

		add(btnConfirm);
		add(btnclose);
		add(btnstrt);
		loadsentibtn(obj_count);
		
		
	}

	private void loadsentibtn(int obj_count) {
		// TODO Auto-generated method stub
		int bound= 30,head = 250;
		int seg_count = obj_count *3;
		btn = new JButton[seg_count];
		for(int i = 0;i<seg_count;i++) {
			btn[i] = new JButton();
			if(i%3==0) {

				btn[i].setText("积极");
				btn[i].setBounds(head+bound*i, 300, 60, 29);
			}else if(i%3==1)
			{

				btn[i].setText("中立");
				btn[i].setBounds(head+bound*(i-1), 340, 60, 29);
			}else if(i%3==2)
			{

				btn[i].setText("消极");
				btn[i].setBounds(head+bound*(i-2), 380, 60, 29);
			}
			String btn_value =String.valueOf(i);
			btn[i].setActionCommand(btn_value);
			btn[i].addActionListener(this);
			add(btn[i]);
		}

	}

	public static void createAndShowGUI()

	{

		frame = new JFrame("Data Tag Judge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new tagSentimentMulti();
		
		// 创建一个frame

		label = new JTextArea("hello world");
		label_sen = new JLabel("sentiment");
		label_obj = new JLabel("object");
		panel.setOpaque(true);
		panel.setLayout(null);
		label.setBounds(250, 90, 800, 100);
		label.setLineWrap(true); 
		label_sen.setFont(new Font("宋体",Font.BOLD, 16));
		label_sen.setBounds(250, 180, 400, 100);
		label_obj.setBounds(250, 150, 400, 100);
		frame.setSize(1500, 600);
		frame.setVisible(true);
		panel.add(label);
		panel.add(label_sen);
		panel.add(label_obj);
		frame.getContentPane().add(panel);
		frame.setVisible(true);


		label.setText(Sentense[1]);
		label_sen.setText(Sentense[3]);
		label_obj.setText(Sentense[2]);
		panel.repaint();
	}

	public void loadcsvfiles() {
		FileWriter outputFile = null;
		try {
			outputFile = new FileWriter(csvOutFile, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outFile = new PrintWriter(outputFile);
		try {

			while (i <= i_now) {
				line = br.readLine();
				i++;
			}
			try {
				if (line != null) {
					Sentense = line.split(csvSpliBy);
					Sentiment=Sentense[3].substring(2, Sentense[3].length()-2).split(",");
					obj_count =Sentiment.length;
				} else {

					br.close();
					outFile.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override

			public void run() {

				createAndShowGUI();

			}

		});
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		
		int act = Integer.parseInt(e.getActionCommand());
		switch(act) {
		
		case -1:
			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			outFile.close();
			frame.dispose();
			break;
			
		case -3:
			String Senti_wbh=Sentiment.toString();
			outFile.write(String.valueOf(i++) + "," + Sentense[1] + "," + Sentense[2] + "," + Sentense[3] + ",'"
					+ Senti_wbh + "'\n");
			break;
		case -2:
			try {
				line = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			switch(act%3) {
			case 0:
				Sentiment[act]="1.0";
				break;
			case 1:
				Sentiment[act]="0.0";
				break;
			case 2:
				Sentiment[act]="-1.0";
				break;
			}
			try {
				line = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		try {
			if (line != null) {
				Sentense = line.split(csvSpliBy);
				Sentiment=Sentense[3].split(csvSpliBy);
				obj_count =Sentiment.length;
				label.setText(Sentense[1]);
				label_sen.setText(Sentense[3]);
				label_obj.setText(Sentense[2]);
				loadsentibtn(obj_count);
				panel.repaint();
			} else {

				br.close();
				outFile.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
