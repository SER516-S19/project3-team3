package view;

import model.QuestionModel;

import javax.swing.*;

public class QuestionAndChoicesPanel extends JPanel {

    private QuestionModel question;

    QuestionAndChoicesPanel(QuestionModel question) {
        this.question = question;

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS));

        JPanel promptPanel = new JPanel();
        promptPanel.setLayout(new BoxLayout(promptPanel, BoxLayout.X_AXIS));

        JLabel promptText = new JLabel();
        promptText.setText("Question Prompt: ");

        JTextField questionPrompt = new JTextField(question.getPrompt().length());
        questionPrompt.setText(question.getPrompt());
        questionPrompt.setName("questionPrompt");

        promptPanel.add(promptText);
        promptPanel.add(questionPrompt);

        parentPanel.add(promptPanel);

        for (String choice: question.getOptions()) {
            JPanel choicePanel = new JPanel();
            choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.X_AXIS));
            JRadioButton correctAnswerButton = new JRadioButton();
            JTextField optionText = new JTextField();
            optionText.setText(choice);

            choicePanel.add(correctAnswerButton);
            choicePanel.add(optionText);

            parentPanel.add(choicePanel);
        }

        this.add(parentPanel);
    }


}
