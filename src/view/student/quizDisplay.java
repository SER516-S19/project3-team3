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
	static String[] correctAnswers = null;
	static ArrayList<QuestionModel> questions = new ArrayList<>();
	static List<Integer> questionNumbers = new ArrayList<>();
	static List<Integer> incorrectQuestion = new ArrayList<>();
	static int round = 0;
	static int i = 0;


	public quizDisplay(QuestionModel ques) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 1 / 2;
		int width = screenSize.width * 1 / 2;
		setSize(new Dimension(width, height));
		setTitle("Take Quiz");

		getContentPane().setLayout(null);

		questionLabel = new JLabel(ques.getTitle());
		questionLabel.setBounds(24, 42, 368, 36);

		getContentPane().add(questionLabel);

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

	void updateFrame(int i) {
		QuestionModel ques = questions.get(i);
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

	public static void main(String[] args) {

		QuizModel file = new QuizModel();

		try {
			file = QuizModel.loadQuiz("exampleQuiz");
		} catch (Exception e) {
			e.printStackTrace();
		}

		questions = file.getQuestions();
		correctAnswers = new String[questions.size()];
		for(int i = 0; i < questions.size(); i++){
			correctAnswers[i] = questions.get(i).getCorrectOption();
			questionNumbers.add(i);
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

	public void actionPerformed(ActionEvent e) {
		boolean flag = true;
		boolean finished = false;
		try {
			if (group.getSelection().getActionCommand() == null) {
				flag = false;
			}
			if (flag) {
				if (!((group.getSelection().getActionCommand()).equals(correctAnswers[i]))) {
					incorrectQuestion.add(i);
				}

				questionNumbers.remove(0);

				if (questionNumbers.isEmpty()) {
					finished = true;
				}
				if (round == 0) {
					updateFrame(++i);
				} else {
					updateFrame(questionNumbers.get(0));
				}
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			if (finished && !incorrectQuestion.isEmpty()) {
				questionNumbers = incorrectQuestion;
				incorrectQuestion = new ArrayList<>();
				i = questionNumbers.get(0);
				finished = false;
				round++;
				updateFrame(i);
			} else {
				JOptionPane.showMessageDialog(
						null, "You successfully completed the Quiz in first Attempt",
						"",
						JOptionPane.INFORMATION_MESSAGE
				);
				System.exit(0);
			}
		} catch (NullPointerException ne) {
			JOptionPane.showMessageDialog(
					null,
					"Please Select One Option",
					"",
					JOptionPane.ERROR_MESSAGE
			);
		} catch (IndexOutOfBoundsException ie) {
			if (!finished) {
				i = questionNumbers.get(0);
				updateFrame(i);
			} else {
				JOptionPane.showMessageDialog(null, "You successfully completed the Quiz", "", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	}


}
