package utils.tool.pdata.tag;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class tagSentiment extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	String csvFile = "E:/github/ToolLib/input/unlabeled_single_2500.csv";
	String csvOutFile = "E:/github/ToolLib/output/single_2500_munual.csv";
	static BufferedReader br;
	static PrintWriter outFile;

	static JFrame frame;
	static tagSentiment panel;
	static JTextArea label;
	static JLabel  label_sen, label_obj;
	JButton btnConfirm, btnPos, btnNeg, btnNul, btnclose, btnstrt;

	static int i = 1;
	static int i_now = 2426;//default value =1
	static String line = "";
	static String csvSpliBy = ",";
	String[] Sentense = null;

	public tagSentiment() {

		btnConfirm = new JButton("对的");
		btnPos = new JButton("积极");
		btnNeg = new JButton("消极");
		btnNul = new JButton("中立");
		btnclose = new JButton("close");
		btnstrt = new JButton("start");

		btnConfirm.setBounds(80, 90, 70, 29);
		btnPos.setBounds(0, 120, 60, 29);
		btnNeg.setBounds(160, 120, 60, 29);
		btnNul.setBounds(80, 120, 60, 29);
		btnclose.setBounds(80, 220, 70, 29);
		btnstrt.setBounds(80, 180, 70, 29);

		btnConfirm.setActionCommand("btnConfirm");
		btnPos.setActionCommand("btnPos");
		btnNeg.setActionCommand("btnNeg");
		btnNul.setActionCommand("btnNul");
		btnclose.setActionCommand("btnclose");

		btnConfirm.addActionListener(this);
		btnPos.addActionListener(this);
		btnNeg.addActionListener(this);
		btnNul.addActionListener(this);
		btnclose.addActionListener(this);
		btnstrt.addActionListener(this);

		add(btnConfirm);
		add(btnPos);
		add(btnNeg);
		add(btnNul);
		add(btnclose);
		add(btnstrt);

		loadcsvfiles();
		
	}

	public static void createAndShowGUI()

	{

		// 创建一个frame

		frame = new JFrame("Data Tag Judge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new tagSentiment();
		label = new JTextArea("hello world");
		label_sen = new JLabel("sentiment");
		label_obj = new JLabel("object");
		panel.setOpaque(true);
		panel.setLayout(null);
		label.setBounds(250, 90, 800, 100);
		label.setLineWrap(true); 
		label_sen.setBounds(450, 150, 100, 100);
		label_obj.setBounds(250, 150, 200, 100);
		frame.setSize(1500, 600);
		frame.setVisible(true);
		panel.add(label);
		panel.add(label_sen);
		panel.add(label_obj);
		frame.getContentPane().add(panel);
		frame.setVisible(true);

		try {

			while (i <= i_now) {
				line = br.readLine();
				i++;
			}
			try {
				if (line != null) {
					String[] Sentense = line.split(csvSpliBy);
					label.setText(Sentense[1]);
					label_sen.setText(Sentense[3]);
					label_obj.setText(Sentense[2]);
					panel.repaint();
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
		
		if ("btnclose".equals(e.getActionCommand())) {

			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			outFile.close();
			frame.dispose();
		}
		else if ("btnConfirm".equals(e.getActionCommand())) {
			outFile.write(String.valueOf(i++) + "," + Sentense[1] + "," + Sentense[2] + "," + Sentense[3] + ","
					+ Sentense[3] + "\n");

		} else if ("btnPos".equals(e.getActionCommand())) {
			outFile.write(String.valueOf(i++) + "," + Sentense[1] + "," + Sentense[2] + "," + Sentense[3] + ",[1.0]\n");

		} else if ("btnNeg".equals(e.getActionCommand())) {

			outFile.write(
					String.valueOf(i++) + "," + Sentense[1] + "," + Sentense[2] + "," + Sentense[3] + ",[-1.0]\n");

		} else if ("btnNul".equals(e.getActionCommand())) {
			outFile.write(String.valueOf(i++) + "," + Sentense[1] + "," + Sentense[2] + "," + Sentense[3] + ",[0.0]\n");

		}
		try {
			line = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (line != null) {
				Sentense = line.split(csvSpliBy);
				label.setText(Sentense[1]);
				label_sen.setText(Sentense[3]);
				label_obj.setText(Sentense[2]);
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
