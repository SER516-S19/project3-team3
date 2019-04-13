package view.student;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 * @author: Trevor Forrey
 * @author: Joshua Drumm
 * @Description: Professor Application Main Frame
 * @version: 1.1
 */
public final class StudentApp extends JFrame {

	private static Container contentPane;

	public StudentApp() {
		super("Student Application");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new Student(), BorderLayout.CENTER);
		contentPane.repaint();
		contentPane.revalidate();
		this.setVisible(true);
	}

	public static void updatePage(StudentViews viewToChange) {
		switch (viewToChange) {
		case TAKE_QUIZ_VIEW:
			contentPane.removeAll();
			contentPane.add(new QuizDisplay(), BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate();
			break;
		case WELCOME_VIEW:
			contentPane.removeAll();
			contentPane.add(new Student(), BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate();
			break;
		case QUIZ_COMPLETION_ACKNOWLEDGEMENT:
			contentPane.removeAll();
			contentPane.add(new StudentAcknowledgement(), BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate();
			break;
		case CLOSED:
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentApp();
	}
}
