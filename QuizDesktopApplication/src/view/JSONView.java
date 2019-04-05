package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controller.JSONController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class JSONView extends JFrame {

	private JPanel contentPane;
	private JTextField titletextField;
	private JLabel questionsAnswers;
	private JTextField textFieldQuestion1;
	private ButtonGroup radiobuttongroup=new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSONView frame = new JSONView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JSONView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titletextField = new JTextField();
		titletextField.setBounds(75, 11, 172, 20);
		contentPane.add(titletextField);
		titletextField.setColumns(10);
		
		JLabel quiztitle = new JLabel("QuizTitle");
		quiztitle.setBounds(10, 14, 61, 14);
		contentPane.add(quiztitle);
		
		questionsAnswers = new JLabel("Questions & Answers");
		questionsAnswers.setBounds(10, 48, 154, 14);
		contentPane.add(questionsAnswers);
		
		textFieldQuestion1 = new JTextField();
		textFieldQuestion1.setBounds(6, 73, 259, 23);
		contentPane.add(textFieldQuestion1);
		textFieldQuestion1.setColumns(10);
		
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
		rdbtnNewRadioButton_1.setBounds(6, 126, 21, 23);
		rdbtnNewRadioButton_1.setName("rdbtnNewRadioButton_1");
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();
		rdbtnNewRadioButton_2.setBounds(6, 154, 21, 23);
		rdbtnNewRadioButton_2.setName("rdbtnNewRadioButton_2");
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton();
		rdbtnNewRadioButton_3.setBounds(6, 180, 21, 23);
		rdbtnNewRadioButton_3.setName("rdbtnNewRadioButton_3");
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton();
		rdbtnNewRadioButton.setBounds(6, 100, 21, 23);
		rdbtnNewRadioButton.setName("rdbtnNewRadioButton");

		contentPane.add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(31, 100, 234, 20);
		contentPane.add(textField);

		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(31, 126, 234, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 154, 235, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(31, 180, 234, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		radiobuttongroup.add(rdbtnNewRadioButton_3);
		radiobuttongroup.add(rdbtnNewRadioButton_2);
		radiobuttongroup.add(rdbtnNewRadioButton_1);
		radiobuttongroup.add(rdbtnNewRadioButton);

		textField_4 = new JTextField();
		textField_4.setBounds(6, 232, 259, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("");
		buttonGroup.add(radioButton);
		radioButton.setBounds(10, 269, 17, 23);
		radioButton.setName("radioButton");
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(10, 298, 21, 23);
		radioButton_1.setName("radioButton_1");
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(10, 324, 21, 23);
		radioButton_2.setName("radioButton_2");
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(10, 350, 21, 23);
		radioButton_3.setName("radioButton_3");
		contentPane.add(radioButton_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(33, 272, 232, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(31, 301, 234, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(31, 327, 234, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(31, 350, 234, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				List<JTextField> textFields = new ArrayList<JTextField>();
				JSONObject object=	new JSONObject();
				JSONArray Array =  new JSONArray();
				JSONObject object1=	new JSONObject();
				JSONArray Array1 =  new JSONArray();
				JSONObject FinalObject=	new JSONObject();
				String text=textFieldQuestion1.getText ();
				String option1=textField.getText ();
				String option2=textField_1.getText ();
				String option3=textField_2.getText ();
				String option4=textField_3.getText ();
				String text1=textField_4.getText ();
				String options1=textField_5.getText ();
				String options2=textField_6.getText ();
				String options3=textField_7.getText ();
				String options4=textField_8.getText ();
				String FileTitle=titletextField.getText();
				 Enumeration<AbstractButton> selectedbutton=radiobuttongroup.getElements();
				 Enumeration<AbstractButton> selectedbutton1=buttonGroup.getElements();
				 Collection<JSONObject> questions = new ArrayList<JSONObject>();
				 while(selectedbutton.hasMoreElements())
				 {
					 
					 JRadioButton selectedradio=(JRadioButton) selectedbutton.nextElement();
					 if(selectedradio.isSelected())
					 {
						String selectionradiobutton=selectedradio.getName();
						String selectedText=null;
						switch(selectionradiobutton) {
						case "rdbtnNewRadioButton_3":
							selectedText=textField_3.getText ();
							break;
						case "rdbtnNewRadioButton_2":
							selectedText=textField_2.getText ();
							break;
						case "rdbtnNewRadioButton_1":
							selectedText=textField_1.getText ();
							break;
						case "rdbtnNewRadioButton":
							selectedText=textField.getText ();
							break;
						}
						
						 object.put("CorrectAnswer",selectedText); 
					 }
				 }
				 while(selectedbutton1.hasMoreElements())
				 {
					 
					 JRadioButton selectedradio1=(JRadioButton) selectedbutton1.nextElement();
					 if(selectedradio1.isSelected())
					 {
						String selectionradiobutton1=selectedradio1.getName();
						String selectedText1=null;
						switch(selectionradiobutton1) {
						case "radioButton_3":
							selectedText1=textField_8.getText ();
							break;
						case "radioButton_2":
							selectedText1=textField_7.getText ();
							break;
						case "radioButton_1":
							selectedText1=textField_6.getText ();
							break;
						case "radioButton":
							selectedText1=textField_5.getText ();
							break;
						}
						
						 object1.put("CorrectAnswer",selectedText1); 
					 }
				 }
				 
				 object1.put("title", text1);
					Array1.add(option1);
					Array1.add(option2);
					Array1.add(option3);
					Array1.add(option4);
					object1.put("Options",Array1);
			        
			        	      
				object.put("title", text);
				Array.add(option1);
				Array.add(option2);
				Array.add(option3);
				Array.add(option4);
				object.put("Options",Array);
				questions.add(object);
				questions.add(object1);
				FinalObject.put("questions", questions);
				JSONController controller = new JSONController(); 
				boolean isfile=controller.write_data_to_model(FinalObject,FileTitle);
				if (isfile)
				{
					JOptionPane.showMessageDialog(null, "File Exits,Change Quiz Title");
				}
				
			}
		});
		btnSave.setBounds(411, 433, 89, 23);
		contentPane.add(btnSave);
		
		
	}
}
