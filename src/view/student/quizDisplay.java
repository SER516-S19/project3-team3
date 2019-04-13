package view.student;

import model.QuestionModel;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author: Abhishek Gupta
 * @author: Krishna Gurram
 * @author: Joshua Drumm
 * @version: 1.0
 */
public class QuizDisplay extends JPanel implements ActionListener {
	private ArrayList<JRadioButton> options;
	private ButtonGroup group;
	private JLabel questionLabel;
	private JButton giveUpButton;
	private JButton nextButton;
	private String correctAnswers;
	private QuestionModel question;
	private ArrayList<QuestionModel> questions = new ArrayList<>();
	private ArrayList<QuestionModel> incorrectQuestion = new ArrayList<>();
	private Controller controller;

	public QuizDisplay() {
		controller = Controller.getInstance();
		questions = controller.getQuizQuestions();
		question = questions.get(0);
		setLayout(null);
		questionLabel = new JLabel(question.getTitle());
		questionLabel.setBounds(24, 42, 368, 36);
		add(questionLabel);
		correctAnswers = question.getCorrectOption();
		options = new ArrayList<>(4);
		for (int i = 0; i < question.getOptions().size(); i++) {
			options.add(new JRadioButton());
			add(options.get(i));
		}
		options.get(0).setBounds(24, 92, 153, 36);
		options.get(1).setBounds(256, 92, 136, 36);
		options.get(2).setBounds(24, 156, 153, 36);
		options.get(3).setBounds(256, 156, 136, 36);
		group = new ButtonGroup();
		for (JRadioButton option : options)
			group.add(option);
		updateFrame(question);
		giveUpButton = new JButton("Give Up");
		giveUpButton.setBounds(88, 212, 89, 23);
		add(giveUpButton);
		nextButton = new JButton("Next");
		nextButton.setBounds(250, 212, 89, 23);
		add(nextButton);
		nextButton.addActionListener(this);
		setVisible(true);
	}

	void updateFrame(QuestionModel ques) {
		question = ques;
		correctAnswers = ques.getCorrectOption();
		questionLabel.setText(ques.getTitle());
		for (int i = 0; i < options.size(); i++) {
			options.get(i).setText(ques.getOptions().get(i));
			options.get(i).setActionCommand(ques.getOptions().get(i));
		}
		group.clearSelection();
	}

	public void actionPerformed(ActionEvent e) {
		if (group.getSelection() != null) {
			if (!((group.getSelection().getActionCommand()).equals(correctAnswers)))
				incorrectQuestion.add(question);
			questions.remove(0);
			if (!questions.isEmpty())
				updateFrame(questions.get(0));
			else if (!incorrectQuestion.isEmpty()) {
				questions = incorrectQuestion;
				incorrectQuestion = new ArrayList<>();
				question = questions.get(0);
				updateFrame(question);
			} else {
				StudentApp.updatePage(StudentViews.QUIZ_COMPLETION_ACKNOWLEDGEMENT);
			}
		} else
			JOptionPane.showMessageDialog(null, "Please Select an Option", "", JOptionPane.ERROR_MESSAGE);
	}
}
