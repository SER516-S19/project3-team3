package model;

import java.util.ArrayList;

/**
 * @author: Venkata Sairam Eadala
 * @author: Joshua Drumm
 * @author: Trevor Forrey
 * @version: 1.0
 */
public class QuestionModel {
	private String title;
	private ArrayList<String> options;
	private String correctOption;

	public QuestionModel(String title) {
		this.title = title;
		this.options = new ArrayList<String>(4);
	}

	public QuestionModel(String title, ArrayList<String> options, String correctOption) {
		this.title = title;
		this.options = options;
		this.correctOption = correctOption;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public void setOptions(ArrayList<String> newOptions) {
		this.options = newOptions;
	}

	public void addOption(String newOption) {
		options.add(newOption);
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
}
