package view.student;

import java.awt.*;
import javax.swing.*;
/**
 * SelectQuizView will display the available quizzes 
 * @author Vijaya Gadde
 *
 */
public class SelectQuizView  {
	JFrame frame = new JFrame("Student Quiz Application");
	JPanel panel = new JPanel();
	String quizzes[] = { "QuizFinal", "QuizFinal1", "QuizFinal2" };
	JComboBox comboBox= new JComboBox(quizzes);
	JButton button = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Student Dashboard");
	JLabel selectQuizName = new JLabel("Select Quiz"); 

	public SelectQuizView() {
		panel.setLayout(new GridLayout(4,1,2,30));
		panel.add(pageName);
		panel.add(selectQuizName);
		panel.add(comboBox);
		panel.add(button);	
		frame.add(panel);
		frame.pack();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new  SelectQuizView();
	}
}