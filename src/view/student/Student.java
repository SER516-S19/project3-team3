package view.student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.parser.ParseException;

import controller.Controller;

/**
 * To display the list of available quizzes
 * @author Vijaya Gadde
 */
public class Student extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	JButton button = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Student Dashboard");
	JLabel selectQuizName = new JLabel("Select Quiz");
	JFileChooser fc = new JFileChooser();
	Controller controller;

	public Student() {
		panel.setLayout(new GridLayout(4, 1, 2, 30));
		panel.add(pageName);
		panel.add(selectQuizName);
		panel.add(button);
		button.addActionListener(this);
		this.add(panel);
		this.pack();
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		fc.setCurrentDirectory(new File("").getAbsoluteFile());
		FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("json files (*.json)", "json");
		fc.addChoosableFileFilter(jsonFilter);
		fc.setFileFilter(jsonFilter);
		controller = Controller.getInstance();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			int returnVal = fc.showOpenDialog(Student.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					controller.readQuiz(file);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			} else {
				System.out.println("Cancelled");
			}
		}
	}

	public static void main(String[] args) {
		JFrame student = new Student();
		student.setVisible(true);
	}
}
