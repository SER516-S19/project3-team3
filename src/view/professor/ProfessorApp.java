package view.professor;

import javax.swing.*;
import java.awt.*;

/*
 *@author: Trevor Forrey
 *@Description: Professor Application Main Frame
 *@version: 1.1
 */
public final class ProfessorApp extends JFrame {

    private static Container contentPane;

    public ProfessorApp() {
        super("Professor Application");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new Professor(), BorderLayout.CENTER);
        contentPane.repaint();
        contentPane.revalidate();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ProfessorApp();
    }

    public static void updatePage(View viewToChange) {
        switch (viewToChange) {
            case CREATE_QUIZ_VIEW:
                contentPane.removeAll();
                contentPane.add(new CreateNewQuiz(), BorderLayout.CENTER);
                contentPane.repaint();
                contentPane.revalidate();
                break;
            case WELCOME_VIEW:
                contentPane.removeAll();
                contentPane.add(new Professor(), BorderLayout.CENTER);
                contentPane.repaint();
                contentPane.revalidate();
                break;
            case QUIZ_CREATION_ACKNOWLEDGEMENT:
                contentPane.removeAll();
                contentPane.add(new ProfessorAcknowledgement(), BorderLayout.CENTER);
                contentPane.repaint();
                contentPane.revalidate();
                break;
            case CLOSED:
                System.exit(0);
        }
    }
}
