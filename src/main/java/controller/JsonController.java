package controller;

import org.json.simple.parser.ParseException;
import model.JsonModel;

public class JsonController {

	JsonModel model;

	public JsonController() {
		model = new JsonModel("exampleQuiz.json");
		try {
			model.readData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void writeData() {
		model.writeData();
	}

	public void updateTitle(String title) {
		model.setTitle(title);
	}

	public String getTitle() {
		return model.getTitle();
	}

}
