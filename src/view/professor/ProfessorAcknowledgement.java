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

public class ProfessorAcknowledgement extends JPanel {
	public ProfessorAcknowledgement() {
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quiz Created Successfully");
		lblNewLabel.setBounds(149, 86, 207, 52);
		this.add(lblNewLabel);

		JButton btnDashboard = new JButton("DashBoard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorApp.updatePage(View.WELCOME_VIEW);
			}
		});
		btnDashboard.setBounds(165, 176, 121, 23);
		this.add(btnDashboard);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorApp.updatePage(View.CLOSED);
			}
		});
		btnExit.setBounds(301, 176, 89, 23);
		this.add(btnExit);
	}
}
