package utils.tool.pdata.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
/**
 * 测试点击按钮后，部分字体加粗
 * doc.setCharacterAttributes(0, 100, boldStyle, true); 该方法设置加粗字体数量
 * @author lance
 */
public class KeyWordsStyle {
	public static void main(String[] args) {
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    JFrame f = new JFrame("Styles Example 3");
	    
	    StyleContext sc = new StyleContext();
	    final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
	    JTextPane pane = new JTextPane(doc);
	    
	    Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
	    final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
	    StyleConstants.setLeftIndent(mainStyle, 16);
	    StyleConstants.setRightIndent(mainStyle, 16);
	    StyleConstants.setFirstLineIndent(mainStyle, 16);
	    StyleConstants.setFontFamily(mainStyle, "serif");
	    StyleConstants.setFontSize(mainStyle, 12);
	    
	    final Style boldStyle = sc.addStyle("MainStyle", defaultStyle);
	    StyleConstants.setBold(boldStyle, true);
 
	    try {
	      SwingUtilities.invokeAndWait(new Runnable() {
	        public void run() {
	          try {
	            doc.setLogicalStyle(0, mainStyle);
 
	            doc.insertString(0, text, null);          
	          } catch (BadLocationException e) {
	          }
	          doc.dump(System.out);
	        }
	      });
	    } catch (Exception e) {
	      System.out.println("Exception when constructing document: " + e);
	      System.exit(1);
	    }   
	    
	    JButton button = new JButton("apply");
	    button.addActionListener(new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置多少字体加粗 
				String substring = "methods for";
				int fc =text.lastIndexOf(substring);
				doc.setCharacterAttributes(fc, substring.length(), boldStyle, true);
			}
	    	
	    });
	    
	    JScrollPane scrollPane = new JScrollPane(pane);
	    
	    JPanel panel = new JPanel();
	    panel.add(button, BorderLayout.NORTH);
	    panel.add(scrollPane, BorderLayout.CENTER);
	              
	    f.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    f.getContentPane().add(button, BorderLayout.SOUTH);
	    f.setSize(400, 300);
	    f.setVisible(true);
	  }
 
	  public static final String text = 
	          "Attributes, Styles and Style Contexts\n" +
	          "The simple PlainDocument class that you saw in the previous " + 
	          "chapter is only capable of holding text. The more complex text " +
	          "components use a more sophisticated model that implements the " +
	          "StyledDocument interface. StyledDocument is a sub-interface of " +
	          "Document that contains methods for manipulating attributes that " +
	          "control the way in which the text in the document is displayed. " + "\n\r" + 
	          "The Swing text package contains a concrete implementation of " +
	          "StyledDocument called DefaultStyledDocument that is used as the " +
	          "default model for JTextPane and is also the base class from which " +
	          "more specific models, such as the HTMLDocument class that handles " +
	          "input in HTML format, can be created. In order to make use of " +
	          "DefaultStyledDocument and JTextPane, you need to understand how " +
	          "Swing represents and uses attributes.\n";
	
 
}
 