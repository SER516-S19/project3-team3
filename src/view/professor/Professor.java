package view.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author: Sakshi Gautam
 * @Description: Professor Dashboard View
 * @version: 1.1
 */
public class Professor extends JPanel {

	public Professor() {
		JLabel welcomeLabel = new JLabel("Welcome Professor!");
		welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(20.0f));
		this.add(welcomeLabel);
		JButton createQuizButton = new JButton("Create Quiz");
		createQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfessorApp.updatePage(ProfessorViews.CREATE_QUIZ_VIEW);
			}
		});
		this.add(createQuizButton);
		this.setVisible(true);
	}
}
