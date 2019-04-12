package view.student;

import model.QuestionModel;
import model.QuizModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class quizDisplay extends JFrame {

	public quizDisplay(QuestionAndChoicesPanel item) {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//		int height = screenSize.height * 1 / 2;
//		int width = screenSize.width * 1 / 2;
//		setSize(new Dimension(width, height));
//		setTitle("Take Quiz");
//
//		getContentPane().setLayout(null);
//
//		getContentPane().add(item);
	}

	public static void main(String[] args) {
		QuizModel file = new QuizModel();
		try {
			file = QuizModel.loadQuiz("exampleQuiz");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<QuestionModel> questions = file.getQuestions();

		for(int i=0; i < questions.size(); i++){
//			System.out.println(questions.get(i).getTitle());
			QuestionAndChoicesPanel item = new QuestionAndChoicesPanel(questions.get(i));

//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						quizDisplay frame = new quizDisplay(item);
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
		}
	}
}
