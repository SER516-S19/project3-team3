package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonModel {

	private String title;
	private String fileName;

	public JsonModel(String fileName) {
		this.fileName = fileName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@SuppressWarnings("unchecked")
	public void writeData() {
		JSONObject json = new JSONObject();
		json.put("title", title);
		try {
            FileWriter file = new FileWriter(fileName);
			file.write(json.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
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
