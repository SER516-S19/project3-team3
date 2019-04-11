package controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import model.QuestionModel;
import model.QuizModel;

/*
*@author: Venkata Sairam Eadala
*@author: Joshua Drumm
*@version: 1.0 
*/

public class Controller {

	private QuizModel model;

	public void addQuestionToQuiz(QuestionModel questionModel) {
		model.addQuestion(questionModel);
	}

	public boolean saveModel() {
		return model.saveQuiz();
	}

	public void loadQuiz(String fileName) throws ParseException {
		model = QuizModel.loadQuiz(fileName);
	}

	public void updateTitle(String title) {
		model.setTitle(title);
	}

	public String getTitle() {
		return model.getTitle();
	}

}
