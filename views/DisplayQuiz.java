package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DisplayQuiz extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int i = 0;
	static String Question = "";
	static JSONArray[] optionsArray = null;
	static String[][] options;
	JRadioButton optionOne = null;
	JRadioButton optionTwo = null;
	JRadioButton optionThree = null;
	JRadioButton optionFour = null;
	ButtonGroup group = null;
	JLabel questionLabel = null;
	JButton giveUpButton = null;
	JButton nextButton = null;
	static String[] questions = null;
	static String[] correctAnswers = null;
	 static List<Integer> questionNumbers = new ArrayList<>();
	 int round = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		String path = "src/controller/exampleQuiz.json";
		try {
			Object obj = parser.parse(new FileReader(path));
			// JSONObject array = loadJSONObject("array.json");
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arrayData = (JSONArray) jsonObject.get("questions");
			questions = new String[arrayData.size()];
			correctAnswers = new String[arrayData.size()];
			optionsArray = new JSONArray[arrayData.size()];
			for (int i = 0; i < arrayData.size(); i++) {
				JSONObject Obj1 = (JSONObject) arrayData.get(i);
				questions[i] = (String) Obj1.get("title");
				optionsArray[i] = (JSONArray) Obj1.get("options");
				correctAnswers[i] = (String) Obj1.get("correctAnswer");
				System.out.println(questions[i]);
				System.out.println(optionsArray[i]);
				System.out.println(correctAnswers[i]);
			}
			// System.out.println(array);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(optionsArray.length);
		options = new String[optionsArray.length][4];

		for (int i = 0; i < options.length; i++) {
			for (int j = 0; j < options[0].length; j++) {
				options[i][j] = (String) optionsArray[i].get(j);
			}
		}
		for (int i = 0; i < options.length; i++) {
			questionNumbers.add(i);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayQuiz frame = new DisplayQuiz(i);
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
	public DisplayQuiz(int i) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 1 / 2;
		int width = screenSize.width * 1 / 2;
		setSize(new Dimension(width, height));
		setTitle("Take Quiz");

		getContentPane().setLayout(null);

		questionLabel = new JLabel(questions[0]);
		questionLabel.setBounds(24, 42, 368, 36);

		getContentPane().add(questionLabel);

		optionOne = new JRadioButton(options[i][0]);
		optionOne.setBounds(24, 92, 153, 36);
		optionOne.setActionCommand(options[i][0]);
		getContentPane().add(optionOne);

		optionTwo = new JRadioButton(options[i][1]);
		optionTwo.setBounds(256, 92, 136, 36);
		optionTwo.setActionCommand(options[i][1]);
		getContentPane().add(optionTwo);

		optionThree = new JRadioButton(options[i][2]);
		optionThree.setBounds(24, 156, 153, 36);
		optionThree.setActionCommand(options[i][2]);
		getContentPane().add(optionThree);

		optionFour = new JRadioButton(options[i][3]);
		optionFour.setBounds(256, 156, 136, 36);
		optionFour.setActionCommand(options[i][3]);
		getContentPane().add(optionFour);

		giveUpButton = new JButton("Give Up");
		giveUpButton.setBounds(88, 212, 89, 23);
		getContentPane().add(giveUpButton);

		nextButton = new JButton("Next");
		nextButton.setBounds(250, 212, 89, 23);
		getContentPane().add(nextButton);
		nextButton.addActionListener(this);// Registering ActionListener to the button

		group = new ButtonGroup();
		group.add(optionOne);
		group.add(optionTwo);
		group.add(optionThree);
		group.add(optionFour);

	}

	public void actionPerformed(ActionEvent e) {
		boolean flag = true;
		boolean finished = false;
		
		//
		// System.out.println(group.getSelection().getActionCommand() == null);
		
		try {
			
			if (group.getSelection().getActionCommand() == null) {
				flag = false;
				
			}
			//if()
			if (flag) {
				
				if((group.getSelection().getActionCommand()).equals(correctAnswers[i])) {
					questionNumbers.remove(new Integer(i));
				}
				
				System.out.println(i+" round: "+ round);
				System.out.println(group.getSelection().getActionCommand()+ " "+correctAnswers[i]);
				if(questionNumbers.isEmpty())
					finished = true;
				System.out.println(questionNumbers);
				if (round == 0)
				updateScreen(++i);
				else
					updateScreen(questionNumbers.get(i++));

			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			
			if(!finished) {
				System.out.println("ASFfsd");
				i = 0;
				i = questionNumbers.get(i);
				round++;
				updateScreen(i);
				
			}else {
			JOptionPane.showMessageDialog(null, "You successfully completed the Quiz in first Attempt", "", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);}
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(null, "Please Select One Option", "", JOptionPane.ERROR_MESSAGE);
		}catch(IndexOutOfBoundsException ie) {
			if(!finished)
				i=0;
			else
			JOptionPane.showMessageDialog(null, "You successfully completed the Quiz", "", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);}
		}
	
		
	
	
	void updateScreen(int i){
		questionLabel.setText(questions[i]);
		optionOne.setText(options[i][0]);
		optionOne.setActionCommand(options[i][0]);
		optionTwo.setText(options[i][1]);
		optionTwo.setActionCommand(options[i][1]);
		optionThree.setText(options[i][2]);
		optionThree.setActionCommand(options[i][2]);
		optionFour.setText(options[i][3]);
		optionFour.setActionCommand(options[i][3]);
		group.clearSelection();
	}

}
