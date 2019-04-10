package model;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.json.simple.JSONObject;
/*
*@author: Venkata Sairam Eadala
*@Description: Quiz Model for writing the quiz details into JSON file.
*@version: 1.0 
*/

public class QuizModel {

	Collection<Object> questions = new ArrayList<Object>();
	JSONObject finalobject = new JSONObject();

	@SuppressWarnings("unchecked")
	public void add_questions_to_quizmodel(QuestionModel questionmodel) {
		// TODO Auto-generated method stub

		questions.add(questionmodel.getQuestion());
		finalobject.put("questions", questions);
	}

	public boolean write_data_model(String quiztitle) {

		
		File filename = new File(quiztitle + ".json");

		boolean fileexists = false;
		// Create the file
		try {
			if (filename.createNewFile()) {
				System.out.println("File is created!");
				fileexists = false;
				try (FileWriter file = new FileWriter(filename)) {
					file.write(finalobject.toString());
					file.flush();
					System.out.println(finalobject);

				} catch (IOException e) {

					e.printStackTrace();

				}

			} else {
				System.out.println("File already exists.");
				fileexists = true;

			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileexists;
	}

}

	