package view.student;

import model.QuestionModel;
import model.QuizModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 *@author: Abhishek Gupta
 *@version: 1.0
 */
public class quizDisplay extends JFrame implements ActionListener {

	JRadioButton optionOne = null;
	JRadioButton optionTwo = null;
	JRadioButton optionThree = null;
	JRadioButton optionFour = null;
	ButtonGroup group = null;
	JLabel questionLabel = null;
	JButton giveUpButton = null;
	JButton nextButton = null;
	static String correctAnswers = null;
	static QuestionModel question = null;
	static ArrayList<QuestionModel> questions = new ArrayList<>();
	static ArrayList<QuestionModel> questionStream = new ArrayList<>();
	static ArrayList<QuestionModel> incorrectQuestion = new ArrayList<>();
	static int round = 0;
	static int i = 0;
	static boolean flag = true;
	static boolean finished = false;

/*Get's the data from Controller and displays the quiz when the JFrame is launched initially */
	public quizDisplay(QuestionModel ques) {
		question = ques;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 1 / 2;
		int width = screenSize.width * 1 / 2;
		setSize(new Dimension(width, height));
		setTitle("Take Quiz");

		getContentPane().setLayout(null);

		questionLabel = new JLabel(ques.getTitle());
		questionLabel.setBounds(24, 42, 368, 36);

		getContentPane().add(questionLabel);

		correctAnswers = ques.getCorrectOption();

		optionOne = new JRadioButton(ques.getOptions().get(0));
		optionOne.setBounds(24, 92, 153, 36);
		optionOne.setActionCommand(ques.getOptions().get(0));
		getContentPane().add(optionOne);

		optionTwo = new JRadioButton(ques.getOptions().get(1));
		optionTwo.setBounds(256, 92, 136, 36);
		optionTwo.setActionCommand(ques.getOptions().get(1));
		getContentPane().add(optionTwo);

		optionThree = new JRadioButton(ques.getOptions().get(2));
		optionThree.setBounds(24, 156, 153, 36);
		optionThree.setActionCommand(ques.getOptions().get(2));
		getContentPane().add(optionThree);

		optionFour = new JRadioButton(ques.getOptions().get(3));
		optionFour.setBounds(256, 156, 136, 36);
		optionFour.setActionCommand(ques.getOptions().get(3));
		getContentPane().add(optionFour);

		giveUpButton = new JButton("Give Up");
		giveUpButton.setBounds(88, 212, 89, 23);
		getContentPane().add(giveUpButton);

		nextButton = new JButton("Next");
		nextButton.setBounds(250, 212, 89, 23);
		getContentPane().add(nextButton);
		nextButton.addActionListener(this);// Registering ActionListener to the button

		group = new ButtonGroup();
		group.add(optionOne);
		group.add(optionTwo);
		group.add(optionThree);
		group.add(optionFour);
	}

/* Updates the Frame with questions and options when student clicks next button */ 
	void updateFrame(QuestionModel ques) {
		question = ques;
		correctAnswers = ques.getCorrectOption();
		questionLabel.setText(ques.getTitle());
		optionOne.setText(ques.getOptions().get(0));
		optionOne.setActionCommand(ques.getOptions().get(0));
		optionTwo.setText(ques.getOptions().get(1));
		optionTwo.setActionCommand(ques.getOptions().get(1));
		optionThree.setText(ques.getOptions().get(2));
		optionThree.setActionCommand(ques.getOptions().get(2));
		optionFour.setText(ques.getOptions().get(3));
		optionFour.setActionCommand(ques.getOptions().get(3));
		group.clearSelection();
	}

/* Main method to create an Instance of the JFrame */
	public static void main(String[] args) {

		QuizModel file = new QuizModel();

		try {
			file = QuizModel.loadQuiz("exampleQuiz");
		} catch (Exception e) {
			e.printStackTrace();
		}

		questions = file.getQuestions();
		for(int i = 0; i < questions.size(); i++){
			questionStream.add(questions.get(i));
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizDisplay frame = new quizDisplay(questions.get(0));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/* Checks the correct answers, Updates data and calls updateFrame() function whenever the user clicks the next button  */
	public void actionPerformed(ActionEvent e) {
		try {
			if (group.getSelection().getActionCommand() == null) {
				flag = false;
			}
			if (flag) {
				if (!((group.getSelection().getActionCommand()).equals(correctAnswers))) {
					incorrectQuestion.add(question);
				}

				questionStream.remove(0);

				if (questionStream.isEmpty()) {
					finished = true;
				}
				updateFrame(questionStream.get(0));
			}
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(
					null,
					"Please Select an Option",
					"",
					JOptionPane.ERROR_MESSAGE
			);
		} catch (IndexOutOfBoundsException ie) {
			if (finished && !incorrectQuestion.isEmpty()) {
				finished = false;
				questionStream = incorrectQuestion;
				incorrectQuestion = new ArrayList<>();
				question = questionStream.get(0);
				round++;
				updateFrame(question);
			} else if (!finished) {
					question = questionStream.get(0);
					updateFrame(question);
			} else {
				JOptionPane.showMessageDialog(
						null, "You successfully completed the Quiz ",//in first Attempt",
						"",
						JOptionPane.INFORMATION_MESSAGE
				);
				System.exit(0);
			}
		}
	}


}
