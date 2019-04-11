package view.professor;
import javax.swing.*;
import java.awt.*;
	/*
	 *@author: Sakshi Gautam
	 *@Description: Creating a quiz with quiz title and quiz details.
	 *@version: 1.1 
	 */
	public class QuizCreation extends JFrame {
		JFrame frame = new JFrame("Create Quiz");
		JPanel panel = new JPanel();
		JButton submitButton = new JButton("Submit");
		JButton exitButton = new JButton("Exit");
		JLabel selectQuizName = new JLabel("Select Quiz");
		JLabel quizTitle =new JLabel("Quiz Title");
		JLabel quizDescription= new JLabel("Quiz Description");
		JTextField quizDetails=new JTextField();
		JTextField quizName= new JTextField();
		public QuizCreation() {
			panel.setLayout(new GridLayout(4,1,2,30));
			panel.add(quizTitle);
			panel.add(quizName);
			panel.add(quizDescription);
			panel.add(quizDetails);
			panel.add(submitButton);
			panel.add(exitButton);
			frame.add(panel);
			frame.pack();
			frame.setSize(500,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		public static void main(String[] args) {
		
			new  QuizCreation();
		}

	}



