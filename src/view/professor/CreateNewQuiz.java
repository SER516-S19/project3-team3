package view.professor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.QuestionModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

@SuppressWarnings({ "serial", "unused" })
public class CreateNewQuiz extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private String quizTitle;
    private JLabel lblQuizTitle;
    private JTextField textField_5;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CreateNewQuiz frame = new CreateNewQuiz();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CreateNewQuiz() {

        Controller controller = new Controller();
        QuestionModel questionModel =  new QuestionModel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(21, 61, 292, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JRadioButton radioButton = new JRadioButton("");
        buttonGroup.add(radioButton);
        radioButton.setName("radioButton");
        radioButton.setBounds(18, 89, 21, 23);
        contentPane.add(radioButton);

        textField_1 = new JTextField();
        textField_1.setBounds(45, 92, 268, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JRadioButton radioButton_1 = new JRadioButton("");
        buttonGroup.add(radioButton_1);
        radioButton_1.setName("radioButton_1");
        radioButton_1.setBounds(21, 120, 21, 23);
        contentPane.add(radioButton_1);

        textField_2 = new JTextField();
        textField_2.setBounds(45, 123, 268, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JRadioButton radioButton_2 = new JRadioButton("");
        buttonGroup.add(radioButton_2);
        radioButton_2.setName("radioButton_1");
        radioButton_2.setBounds(21, 151, 21, 23);
        contentPane.add(radioButton_2);

        textField_3 = new JTextField();
        textField_3.setBounds(45, 154, 268, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JRadioButton radioButton_3 = new JRadioButton("");
        buttonGroup.add(radioButton_3);
        radioButton_3.setName("radioButton_3");
        radioButton_3.setBounds(21, 182, 21, 23);
        contentPane.add(radioButton_3);

        textField_4 = new JTextField();
        textField_4.setBounds(45, 185, 268, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        lblQuizTitle = new JLabel("Quiz Title");
        lblQuizTitle.setBounds(24, 23, 66, 14);
        contentPane.add(lblQuizTitle);

        textField_5 = new JTextField();
        textField_5.setBounds(88, 20, 173, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JButton btnAddQuestions = new JButton("Add Questions");
        btnAddQuestions.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {

                JSONObject object =	new JSONObject();
                JSONArray Array =  new JSONArray();
                String selectedText=null;
                String text=textField.getText ();

                String option1=textField_1.getText ();
                String option2=textField_2.getText ();
                String option3=textField_3.getText ();
                String option4=textField_4.getText ();



                Enumeration<AbstractButton> selectedButton = buttonGroup.getElements();

                while(selectedButton.hasMoreElements())
                {

                    JRadioButton selectedRadio =(JRadioButton) selectedButton.nextElement();
                    if(selectedRadio.isSelected())
                    {
                        String selectionRadioButton = selectedRadio.getName();

                        switch(selectionRadioButton) {
                            case "radioButton":
                                selectedText=textField_1.getText ();
                                break;
                            case "radioButton_1":
                                selectedText=textField_2.getText ();
                                break;
                            case "radioButton_2":
                                selectedText=textField_3.getText ();
                                break;
                            case "radioButton_3":
                                selectedText=textField_4.getText ();
                                break;
                        }

                        object.put("CorrectAnswer",selectedText);
                    }
                }

                object.put("title", text);
                Array.add(option1);
                Array.add(option2);
                Array.add(option3);
                Array.add(option4);
                object.put("Options",Array);
                QuestionModel questionModel =  new QuestionModel();
                questionModel.setQuestion(Array,text,selectedText);
                controller.add_questions_to_quiz(questionModel);
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                textField.setText("");
                buttonGroup.clearSelection();
            }
        });
        btnAddQuestions.setBounds(171, 227, 110, 23);
        contentPane.add(btnAddQuestions);




        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {

                JSONObject object=	new JSONObject();
                JSONArray Array =  new JSONArray();
                String selectedText=null;
                String text=textField.getText ();

                String option1=textField_1.getText ();
                String option2=textField_2.getText ();
                String option3=textField_3.getText ();
                String option4=textField_4.getText ();



                Enumeration<AbstractButton> selectedbutton=buttonGroup.getElements();

                while(selectedbutton.hasMoreElements())
                {

                    JRadioButton selectedradio=(JRadioButton) selectedbutton.nextElement();
                    if(selectedradio.isSelected())
                    {
                        String selectionradiobutton=selectedradio.getName();

                        switch(selectionradiobutton) {
                            case "radioButton":
                                selectedText=textField_1.getText ();
                                break;
                            case "radioButton_1":
                                selectedText=textField_2.getText ();
                                break;
                            case "radioButton_2":
                                selectedText=textField_3.getText ();
                                break;
                            case "radioButton_3":
                                selectedText=textField_4.getText ();
                                break;
                        }

                        object.put("CorrectAnswer",selectedText);
                    }
                }

                object.put("title", text);
                Array.add(option1);
                Array.add(option2);
                Array.add(option3);
                Array.add(option4);
                object.put("Options",Array);

                questionModel.setQuestion(Array,text,selectedText);
                controller.add_questions_to_quiz(questionModel);

                QuizCreationAcknowledgement Acknowledgement = new QuizCreationAcknowledgement();
                quizTitle=textField_5.getText();
                boolean isFile= controller.write_data_to_model(quizTitle);
                if(isFile)
                {
                    JOptionPane.showMessageDialog(null, "File Exits,Change Quiz Title");
                }
                else
                {
                    setVisible(false);
                    Acknowledgement.setVisible(true);
                }
            }
        });
        btnSubmit.setBounds(319, 227, 89, 23);
        contentPane.add(btnSubmit);
    }
}
