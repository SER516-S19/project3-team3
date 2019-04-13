package view.professor;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Raju Koushik
 * @version: 1.0
 */
public class ProfessorAcknowledgement extends JPanel {
	public ProfessorAcknowledgement() {
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		JLabel labelMessage = new JLabel("Quiz Created Successfully");
		labelMessage.setBounds(149, 86, 207, 52);
		this.add(labelMessage);
		JButton buttonDashboard = new JButton("DashBoard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorApp.updatePage(ProfessorViews.WELCOME_VIEW);
			}
		});
		buttonDashboard.setBounds(165, 176, 121, 23);
		this.add(buttonDashboard);
		JButton buttonExit = new JButton("Exit");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorApp.updatePage(ProfessorViews.CLOSED);
			}
		});
		buttonExit.setBounds(301, 176, 89, 23);
		this.add(buttonExit);
	}
}
