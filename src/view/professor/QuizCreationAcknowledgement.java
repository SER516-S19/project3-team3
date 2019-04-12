package view.professor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizCreationAcknowledgement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizCreationAcknowledgement frame = new QuizCreationAcknowledgement();
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
	public QuizCreationAcknowledgement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz Created Successfully");
		lblNewLabel.setBounds(149, 86, 207, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnDashboard = new JButton("DashBoard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorDashBoard DashBoard = new ProfessorDashBoard();
				setVisible(false);
				DashBoard.setVisible(true);
			}
		});
		btnDashboard.setBounds(165, 176, 121, 23);
		contentPane.add(btnDashboard);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(301, 176, 89, 23);
		contentPane.add(btnExit);
	}

}
