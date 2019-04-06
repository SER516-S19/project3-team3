package controller;

import model.QuizModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import model.QuizModel;

public class JSONController {

	QuizModel model;

	public JSONController() {
		model = new QuizModel("exampleQuiz.json");
		try {
			model.readData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean write_data_to_model(JSONObject FinalObject, String fileTitle) {
		// TODO Auto-generated method stub
        QuizModel m = new QuizModel("exampleQuiz.json");
		boolean file_exits = m.writeData(FinalObject);
		return file_exits;
	}

//	public void writeData() {
//		model.writeData();
//	}

	public void updateTitle(String title) {
		model.setTitle(title);
	}

	public String getTitle() {
		return model.getTitle();
	}

}
