package controller;

import java.io.File;
import java.util.ArrayList;

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
	
	public ArrayList<QuestionModel> getQuizQuestions()
	{
		return model.getQuestions();
	}
	
	public void createQuiz()
	{
		model = new QuizModel();
	}
	
	public void createQuiz(String title)
	{
		model = new QuizModel(title);
	}
	
	public void readQuiz(File file) throws ParseException
	{
		model = QuizModel.readQuiz(file);
	}

	public void addQuestion(String title, ArrayList<String> options, String correctOption)
	{
		QuestionModel question = new QuestionModel(title, options, correctOption);
		model.addQuestion(question);
	}

	public void setQuizTitle(String quizTitle)
	{
		model.setTitle(quizTitle);
	}

}
