package model;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
*@author: Venkata Sairam Eadala
*@Description: Quiz Model for writing the quiz details into JSON file.
*@version: 1.0 
*/
@SuppressWarnings("unused")
public class QuestionModel {

	private JSONObject question = new JSONObject();
	private JSONArray options;
	private String questions;
	private String correctanswer;

	@SuppressWarnings("unchecked")
	public void setQuestion(JSONArray array, String text, String selectedtext)

	{

		options = array;
		questions = text;
		correctanswer = selectedtext;
		question.put("options", options);
		question.put("CorrectAnswer", correctanswer);
		question.put("questions", questions);
	}

	public JSONObject getQuestion() {
		return question;
	}
}
