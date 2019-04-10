package controller;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Model.QuestionModel;
import Model.QuizModel;

/*
*@author: Venkata Sairam Eadala
*@version: 1.0 
*/
@SuppressWarnings("unused")
public class Controller {

	QuizModel model = new QuizModel();
	QuestionModel questionModel = new QuestionModel();
	JSONObject question;

	public boolean write_data_to_model(String FileName) {
		// TODO Auto-generated method stub

		boolean exists = model.write_data_model(FileName);

		return exists;

	}

	public void add_questions_to_quiz(QuestionModel questionModel) {

		// TODO Auto-generated method stub
		model.add_questions_to_quizmodel(questionModel);
	}

}
