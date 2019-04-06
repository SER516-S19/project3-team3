package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.QuestionModel;
import model.QuizModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controller.JSONController;

import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import java.util.List;

@SuppressWarnings({ "serial", "unused" })
public class QuizEditView extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String prompt = "Which mountain is located in Washington?";
                    List<String> choices = new ArrayList<String>(Arrays.asList("Mt. Rainer", "Mt. Saint Helens", "Mt. Rushmore", "Peter Jackson"));
                    String correctChoice = "Mt. Rainer";
                    QuestionModel exampleQuestion = new QuestionModel(prompt, choices, correctChoice);

                    List<QuestionModel> questions = new ArrayList<QuestionModel>();
                    questions.add(exampleQuestion);

                    QuizModel exampleQuiz = new QuizModel("my hardcoded quiz title", "exampleQuiz.json", questions);
                    QuizEditView frame = new QuizEditView(exampleQuiz);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public QuizEditView(QuizModel quiz) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 539, 506);

        JPanel parentPanel = new JPanel();
        parentPanel.setName("parentPanel");
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setName("titlePanel");
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Quiz Title: ");

        JTextField quizTitle = new JTextField(quiz.getTitle().length());
        quizTitle.setText(quiz.getTitle());
        quizTitle.setName("quizTitle");

        titlePanel.add(titleLabel);
        titlePanel.add(quizTitle);

        parentPanel.add(titlePanel);

        JLabel questionsHeader = new JLabel();
        questionsHeader.setText("Questions");
        parentPanel.add(questionsHeader);

        for (QuestionModel question : quiz.getQuestions()) {
            QuestionAndChoicesPanel choicesPanel = new QuestionAndChoicesPanel(question);
            parentPanel.add(choicesPanel);
        }

        JButton saveButton = new JButton();
        saveButton.setText("Save Changes");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuizModel quizToEdit = new QuizModel();

                // Get quiz title out of first panel
                quizToEdit.setTitle(quizTitle.getText());

                int numberOfComponents = parentPanel.getComponents().length;
                System.out.println(numberOfComponents);
                System.out.println(parentPanel.getComponents());

                for (int questionComponent = 2; questionComponent < numberOfComponents - 1; questionComponent++) {
                    String questionPrompt;
                    ArrayList<String> choices = new ArrayList<String>();
                    String correctAnswer = "No Correct Answer Provided";

                    QuestionAndChoicesPanel currentQuestionPanel = (QuestionAndChoicesPanel) parentPanel.getComponent(questionComponent);

                    JPanel parentComponent = (JPanel) currentQuestionPanel.getComponent(0);
                    JPanel promptPanel = (JPanel) parentComponent.getComponent(0);
                    JTextField promptPanelText = (JTextField) promptPanel.getComponent(1);

                    questionPrompt = promptPanelText.getText();

                    Component[] allComponents = parentComponent.getComponents();

                    for (int i = 1; i < allComponents.length; i++) {
                        JPanel choicePanel = (JPanel) allComponents[i];
                        JTextField choiceOption = (JTextField) choicePanel.getComponent(1);
                        JRadioButton isCorrectButton = (JRadioButton) choicePanel.getComponent(0);
                        if (isCorrectButton.isSelected()) {
                            correctAnswer = choiceOption.getText();
                        }
                        choices.add(choiceOption.getText());
                    }

                    QuestionModel question = new QuestionModel(questionPrompt, choices, correctAnswer);

                    quizToEdit.addQuestion(question);
                }

            }
        });


        parentPanel.add(saveButton);

        this.add(parentPanel);

    }
}