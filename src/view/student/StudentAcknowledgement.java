package view.student;
/*
author: Sai Vinay Gangadharabhatla.
version: 1.0.
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAcknowledgement extends JFrame {

	private JPanel contentPane;
	//Create the Submission Acknowledgement frame.
	public StudentAcknowledgement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quiz Submitted Successfully");
		lblNewLabel.setBounds(149, 86, 207, 52);
		contentPane.add(lblNewLabel);

		JButton btnDashboard = new JButton("DashBoard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student=new Student();
				setVisible(false);
				student.setVisible(true);
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
