package view.professor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author: Bharat Goel
 * @author: Joshua Drumm
 * @author: Trevor Forrey
 * @version: 1.0
 */
public class CreateNewQuiz extends JPanel {

	private ArrayList<JTextField> options;
	private ArrayList<JRadioButton> radioButtons;
	private ArrayList<JLabel> optionLabels;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String quizTitle;
	private JLabel labelQuizTitle, labelQuestionTitle;
	private JTextField textFieldQuizTitle, textFieldQuestionTitle;;
	private Controller controller;
	private JFileChooser fileChooser;

	public CreateNewQuiz() {
		controller = Controller.getInstance();
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("").getAbsoluteFile());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		options = new ArrayList<>(4);
		radioButtons = new ArrayList<>(4);
		optionLabels = new ArrayList<>(4);
		for (int i = 0; i < 4; i++) {
			JTextField newOption = new JTextField();
			newOption.setColumns(10);
			options.add(newOption);
			add(newOption);
			JRadioButton radioButton = new JRadioButton("");
			radioButtons.add(radioButton);
			buttonGroup.add(radioButton);
			radioButton.setName("radioButton_" + i);
			add(radioButton);
			JLabel optionLabel = new JLabel("Option " + (i + 1));
			optionLabels.add(optionLabel);
			add(optionLabel);
		}
		options.get(0).setBounds(125, 92, 268, 20);
		options.get(1).setBounds(125, 123, 268, 20);
		options.get(2).setBounds(125, 154, 268, 20);
		options.get(3).setBounds(125, 185, 268, 20);
		radioButtons.get(0).setBounds(100, 89, 21, 23);
		radioButtons.get(1).setBounds(100, 120, 21, 23);
		radioButtons.get(2).setBounds(100, 151, 21, 23);
		radioButtons.get(3).setBounds(100, 182, 21, 23);
		optionLabels.get(0).setBounds(50, 92, 268, 20);
		optionLabels.get(1).setBounds(50, 123, 268, 20);
		optionLabels.get(2).setBounds(50, 154, 268, 20);
		optionLabels.get(3).setBounds(50, 185, 268, 20);
		labelQuizTitle = new JLabel("Quiz Title");
		labelQuizTitle.setBounds(25, 23, 66, 14);
		this.add(labelQuizTitle);
		textFieldQuizTitle = new JTextField();
		textFieldQuizTitle.setBounds(88, 20, 173, 20);
		labelQuestionTitle = new JLabel("Question");
		labelQuestionTitle.setBounds(25, 60, 66, 14);
		this.add(labelQuestionTitle);
		textFieldQuestionTitle = new JTextField();
		textFieldQuestionTitle.setBounds(88, 60, 292, 20);
		this.add(textFieldQuestionTitle);
		textFieldQuestionTitle.setColumns(10);
		this.add(textFieldQuizTitle);
		textFieldQuizTitle.setColumns(10);
		JButton btnAddQuestions = new JButton("Add Question");
		btnAddQuestions.addActionListener(new AddQuestionActionListener());
		btnAddQuestions.setBounds(171, 227, 130, 23);
		this.add(btnAddQuestions);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new AddAndSaveQuestionActionListener());
		btnSubmit.setBounds(319, 227, 89, 23);
		this.add(btnSubmit);
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
		this.add(btnDirectory);
		controller.createQuiz();
	}

	public boolean checkAnyFieldsEmpty() {
		return options.get(0).getText().isEmpty() || options.get(1).getText().isEmpty()
				|| options.get(2).getText().isEmpty() || options.get(3).getText().isEmpty()
				|| textFieldQuestionTitle.getText().isEmpty() || buttonGroup.getSelection() == null;
	}

	public boolean checkFieldsCompletelyEmpty() {
		return options.get(0).getText().isEmpty() && options.get(1).getText().isEmpty()
				&& options.get(2).getText().isEmpty() && options.get(3).getText().isEmpty()
				&& textFieldQuestionTitle.getText().isEmpty();
	}

	private class AddQuestionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedText = null;
			String title = textFieldQuestionTitle.getText();
			Enumeration<AbstractButton> selectedButton = buttonGroup.getElements();
			while (selectedButton.hasMoreElements()) {
				JRadioButton selectedRadio = (JRadioButton) selectedButton.nextElement();
				if (selectedRadio.isSelected()) {
					String selectionRadioButton = selectedRadio.getName();
					switch (selectionRadioButton) {
					case "radioButton":
						selectedText = options.get(0).getText();
						break;
					case "radioButton_1":
						selectedText = options.get(1).getText();
						break;
					case "radioButton_2":
						selectedText = options.get(2).getText();
						break;
					case "radioButton_3":
						selectedText = options.get(3).getText();
						break;
					}
				}
			}
			if (!checkAnyFieldsEmpty()) {
				ArrayList<String> inputOptions = new ArrayList<String>(4);
				for (JTextField option : options) {
					inputOptions.add(option.getText());
					option.setText("");
				}
				controller.addQuestion(title, inputOptions, selectedText);
				textFieldQuestionTitle.setText("");
				buttonGroup.clearSelection();
				JOptionPane.showMessageDialog(null, "Question Has Been Saved!");
			} else if (!checkFieldsCompletelyEmpty())
				JOptionPane.showMessageDialog(null, "Please fill out all fields");
		}
	}

	private class AddAndSaveQuestionActionListener extends AddQuestionActionListener {
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			quizTitle = textFieldQuizTitle.getText();
			if (quizTitle.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Name your Quiz");
				return;
			}
			if (!checkAnyFieldsEmpty() || !checkFieldsCompletelyEmpty())
				return;
			controller.setQuizTitle(quizTitle);
			boolean isFile = controller.saveModel();
			if (!isFile)
				JOptionPane.showMessageDialog(null, "File Exits, Change Quiz Title");
			else {
				ProfessorApp.updatePage(ProfessorViews.QUIZ_CREATION_ACKNOWLEDGEMENT);
			}
		}
	}
}
