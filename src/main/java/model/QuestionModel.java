package model;

import java.util.List;

public class QuestionModel {
    private String prompt;
    private List<String> options;
    private String correctOption;

    public QuestionModel(String prompt, List<String> options, String correctOption) {
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    private void setPrompt(String newPrompt) {
        this.prompt = newPrompt;
    }

    private void setOptions(List<String> newOptions) {
        this.options = newOptions;
    }

    private void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
