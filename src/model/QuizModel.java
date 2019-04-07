package model;

import java.util.ArrayList;
import java.util.List;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
*@author: Venkata Sairam Eadala
*@author: Joshua Drumm
*@author: Trevor Forrey
*@version: 1.0 
*/
public class QuizModel {

	private String title;
	private String fileName;
	private ArrayList<QuestionModel> questions;

	public QuizModel() {

	}

	public QuizModel(String fileName) {
		this.fileName = fileName;
		this.questions = new ArrayList();
	}

	public QuizModel(String title, ArrayList<QuestionModel> questions) {
		this.title = title;
		this.fileName = title.replaceAll(" ", "_");
		this.questions = questions;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<QuestionModel> getQuestions() {
		return questions;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setQuestions(ArrayList<QuestionModel> newQuestions) {
		this.questions = newQuestions;
	}

	public void addQuestion(QuestionModel newQuestion) {
		this.questions.add(newQuestion);
	}

	private boolean writeData(JSONObject QuizJSON) {
		try {
			FileWriter file = new FileWriter(fileName + ".json");
			file.write(QuizJSON.toString());
			System.out.println(QuizJSON.toString());
			file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveQuiz() {
		JSONObject jsonQuiz = new JSONObject();
		JSONArray jsonQuestions = new JSONArray();
		ArrayList<QuestionModel> questions = getQuestions();
		for (QuestionModel question : questions) {
			JSONObject jsonQuestion = new JSONObject();
			JSONArray jsonOptions = new JSONArray();
			jsonQuestion.put("title", question.getTitle());
			for (String option : question.getOptions())
				jsonOptions.add(option);
			jsonQuestion.put("options", jsonOptions);
			jsonQuestion.put("correctAnswer", question.getCorrectOption());
			jsonQuestions.add(jsonQuestion);
		}
		jsonQuiz.put("questions", jsonQuestions);
		return writeData(jsonQuiz);
	}

	private JSONObject readData() throws ParseException {
		JSONObject json = new JSONObject();
		try {
			FileReader file = new FileReader(fileName + ".json");
			BufferedReader br = new BufferedReader(file);
			String currentLine;
			String output = "";

			while ((currentLine = br.readLine()) != null)
				output += currentLine + '\n';
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}

	public static QuizModel loadQuiz(String fileName) throws ParseException {
		QuizModel quiz = new QuizModel(fileName);
		JSONObject jsonFile = quiz.readData();
		quiz.setTitle(fileName.replaceAll("[_]", " "));
		JSONArray jsonQuestions = (JSONArray) jsonFile.get("questions");
		for (int questionNumber = 0; questionNumber < jsonQuestions.size(); questionNumber++) {
			JSONObject jsonQuestion = (JSONObject) jsonQuestions.get(questionNumber);
			JSONArray jsonOptions = (JSONArray) jsonQuestion.get("options");
			QuestionModel question = new QuestionModel((String) jsonQuestion.get("title"));
			for (int optionNumber = 0; optionNumber < jsonOptions.size(); optionNumber++)
				question.addOption((String) jsonOptions.get(optionNumber));
			question.setCorrectOption((String) jsonQuestion.get("correctAnswer"));
			quiz.addQuestion(question);
		}

		return quiz;

	}

}