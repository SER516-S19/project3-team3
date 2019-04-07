package view;
import javax.swing.*;
import java.awt.*;
	/*
	 *@author: Abhishek Gupta
	 *@Description: Added to move to next question or give up on the quiz.
	 *@version: 1.2
	 */
	public class QuizCreation extends JFrame {
		JFrame frame = new JFrame("Question");
		JPanel panel = new JPanel();
		JButton nextButton = new JButton("Next");
		JButton giveUpButton = new JButton("Give Up");
		public QuizCreation() {
			panel.setLayout(new GridLayout(4,1,2,30));
			panel.add(nextButton);
			panel.add(giveUpButton);
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



