package view.professor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import controller.Controller;
import model.QuestionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

/*
 *@author: Bharat Goel
 *@author: Joshua Drumm
 *@version: 1.0
 */
@SuppressWarnings({ "serial", "unused" })
public class CreateNewQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String quizTitle;
	private JLabel lblQuizTitle;
	private JTextField textField_5;
	private Controller controller;
	JFileChooser fileChooser;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CreateNewQuiz frame = new CreateNewQuiz();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CreateNewQuiz() {

		controller = Controller.getInstance();
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("").getAbsoluteFile());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(21, 61, 292, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JRadioButton radioButton = new JRadioButton("");
		buttonGroup.add(radioButton);
		radioButton.setName("radioButton");
		radioButton.setBounds(18, 89, 21, 23);
		contentPane.add(radioButton);

		textField_1 = new JTextField();
		textField_1.setBounds(45, 92, 268, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JRadioButton radioButton_1 = new JRadioButton("");
		buttonGroup.add(radioButton_1);
		radioButton_1.setName("radioButton_1");
		radioButton_1.setBounds(21, 120, 21, 23);
		contentPane.add(radioButton_1);

		textField_2 = new JTextField();
		textField_2.setBounds(45, 123, 268, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JRadioButton radioButton_2 = new JRadioButton("");
		buttonGroup.add(radioButton_2);
		radioButton_2.setName("radioButton_1");
		radioButton_2.setBounds(21, 151, 21, 23);
		contentPane.add(radioButton_2);

		textField_3 = new JTextField();
		textField_3.setBounds(45, 154, 268, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JRadioButton radioButton_3 = new JRadioButton("");
		buttonGroup.add(radioButton_3);
		radioButton_3.setName("radioButton_3");
		radioButton_3.setBounds(21, 182, 21, 23);
		contentPane.add(radioButton_3);

		textField_4 = new JTextField();
		textField_4.setBounds(45, 185, 268, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		lblQuizTitle = new JLabel("Quiz Title");
		lblQuizTitle.setBounds(24, 23, 66, 14);
		contentPane.add(lblQuizTitle);

		textField_5 = new JTextField();
		textField_5.setBounds(88, 20, 173, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnAddQuestions = new JButton("Add Questions");
		btnAddQuestions.addActionListener(new AddQuestionActionListener());
		btnAddQuestions.setBounds(171, 227, 110, 23);
		contentPane.add(btnAddQuestions);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new AddAndSaveQuestionActionListener());
		btnSubmit.setBounds(319, 227, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnDirectory = new JButton("Set Directory");
		btnDirectory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fileChooser.showOpenDialog(CreateNewQuiz.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					controller.setPath(file.getAbsolutePath());
				} else {
					System.out.println("Cancelled");
				}
			}
		});
		btnDirectory.setBounds(25, 227, 125, 23);
		contentPane.add(btnDirectory);

		controller.createQuiz();
	}

	public boolean checkAnyFieldsEmpty() {
		String option1 = textField_1.getText();
		String option2 = textField_2.getText();
		String option3 = textField_3.getText();
		String option4 = textField_4.getText();
		String title = textField.getText();
		return option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || title.isEmpty()
				|| buttonGroup.getSelection() == null;
	}

	public boolean checkFieldsCompletelyEmpty() {
		String option1 = textField_1.getText();
		String option2 = textField_2.getText();
		String option3 = textField_3.getText();
		String option4 = textField_4.getText();
		String title = textField.getText();
		String combined = option1 + option2 + option3 + option4 + title;
		return combined.isEmpty();
	}

	private class AddQuestionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String selectedText = null;
			String title = textField.getText();

			String option1 = textField_1.getText();
			String option2 = textField_2.getText();
			String option3 = textField_3.getText();
			String option4 = textField_4.getText();

			Enumeration<AbstractButton> selectedButton = buttonGroup.getElements();

			while (selectedButton.hasMoreElements()) {

				JRadioButton selectedRadio = (JRadioButton) selectedButton.nextElement();
				if (selectedRadio.isSelected()) {
					String selectionRadioButton = selectedRadio.getName();

					switch (selectionRadioButton) {
					case "radioButton":
						selectedText = textField_1.getText();
						break;
					case "radioButton_1":
						selectedText = textField_2.getText();
						break;
					case "radioButton_2":
						selectedText = textField_3.getText();
						break;
					case "radioButton_3":
						selectedText = textField_4.getText();
						break;
					}
				}
			}

			if (!checkAnyFieldsEmpty()) {
				ArrayList<String> options = new ArrayList<String>(4);
				options.add(option1);
				options.add(option2);
				options.add(option3);
				options.add(option4);
				controller.addQuestion(title, options, selectedText);
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");
				buttonGroup.clearSelection();
				JOptionPane.showMessageDialog(null, "Question Has Been Saved!");
			} else if (!checkFieldsCompletelyEmpty())
				JOptionPane.showMessageDialog(null, "Please fill out all fields");
		}
	}

	private class AddAndSaveQuestionActionListener extends AddQuestionActionListener {
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);

			quizTitle = textField_5.getText();
			if (quizTitle.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Name your Quiz");
				return;
			}
			if (!checkAnyFieldsEmpty() || !checkFieldsCompletelyEmpty())
				return;

			ProfessorAcknowledgement acknowledgement = new ProfessorAcknowledgement();
			controller.setQuizTitle(quizTitle);
			boolean isFile = controller.saveModel();
			if (!isFile)
				JOptionPane.showMessageDialog(null, "File Exits, Change Quiz Title");
			else {
				setVisible(false);
				acknowledgement.setVisible(true);
			}
		}
	}
}
