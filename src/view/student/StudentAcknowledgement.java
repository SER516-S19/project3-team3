package view.student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Sai Vinay Gangadharabhatla.
 * @version: 1.0.
 */
public class StudentAcknowledgement extends JPanel {

	public StudentAcknowledgement() {
		setBounds(100, 100, 450, 300);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Quiz Submitted Successfully");
		lblNewLabel.setBounds(149, 86, 207, 52);
		add(lblNewLabel);
		JButton btnDashboard = new JButton("DashBoard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentApp.updatePage(StudentViews.WELCOME_VIEW);
			}
		});
		btnDashboard.setBounds(165, 176, 121, 23);
		add(btnDashboard);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentApp.updatePage(StudentViews.CLOSED);
			}
		});
		btnExit.setBounds(301, 176, 89, 23);
		add(btnExit);
	}
}
