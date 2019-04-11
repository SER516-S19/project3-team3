package model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuizModel {

	private String title;
	private String fileName;
	private List<QuestionModel> questions;

	public QuizModel() {

    }

	public QuizModel(String fileName) {
	    this.fileName = fileName;
	}

    public QuizModel(String title, String fileName, List<QuestionModel> questions) {
	    this.title = title;
        this.fileName = fileName;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

	public void setTitle(String title) {
	    this.title = title;
	}

    public void setQuestions(List<QuestionModel> newQuestions) {
	    this.questions = newQuestions;
    }

    public void addQuestion(QuestionModel newQuestion) {
	    this.questions.add(newQuestion);
    }

	@SuppressWarnings("unchecked")
	public boolean writeData(JSONObject QuizJSON) {
		try {
            FileWriter file = new FileWriter(fileName);
			file.write(QuizJSON.toString());
            System.out.println(QuizJSON.toString());
            file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public JSONObject readData() throws ParseException {
		JSONObject json = new JSONObject();
		try {
			FileReader file = new FileReader(fileName);
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
		title = (String) json.get("title");
		System.out.println(json);
		return json;
	}

}
