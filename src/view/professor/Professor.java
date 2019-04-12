package view.professor;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/*
 *@author: Sakshi Gautam
 *@Description: Professor application to create and edit quiz.
 *@version: 1.1 
 */
public class Professor extends JFrame {
	private JFrame profFrame;
	private JPanel contentPane;
	 // Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Professor frame = new Professor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Professor() {
		profFrame = new JFrame("Professor Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		profFrame.setSize(500, 500);
		JLabel welcomeLabel = new JLabel("Welcome Professor!");
		welcomeLabel.setBounds(120, 98, 226, 50);
		welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(20.0f));
		contentPane.add(welcomeLabel);
		JButton createQuizButton = new JButton("Create Quiz");
		createQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateNewQuiz createQuiz = new CreateNewQuiz();
				setVisible(false);
				createQuiz.setVisible(true);
			}
		});
		createQuizButton.setBounds(30, 197, 180, 23);
		contentPane.add(createQuizButton);
	}
}
