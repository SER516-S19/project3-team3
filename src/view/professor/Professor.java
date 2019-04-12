package view.professor;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/*
 *@author: Sakshi Gautam
 *@Description: Professor Dashboard View
 *@version: 1.1 
 */
public class Professor extends JPanel {
	
	public Professor() {
		JLabel welcomeLabel = new JLabel("Welcome Professor!");
		welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(20.0f));
		this.add(welcomeLabel);
		JButton createQuizButton = new JButton("Create Quiz");
		createQuizButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfessorApp.updatePage(View.CREATE_QUIZ_VIEW);
			}
		});
		this.add(createQuizButton);
		this.setVisible(true);
	}
}
