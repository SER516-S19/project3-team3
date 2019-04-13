package view.student;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.parser.ParseException;
import controller.Controller;

/**
 * To display the list of available quizzes
 * 
 * @author Vijaya Gadde
 */
public class Student extends JPanel implements ActionListener {
	JPanel panelMain = new JPanel();
	JButton buttonTakeQuiz = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Student Dashboard");
	JLabel selectQuizName = new JLabel("Select Quiz");
	JFileChooser fileChooser = new JFileChooser();
	Controller controller;

	public Student() {
		panelMain.setLayout(new GridLayout(4, 1, 2, 30));
		panelMain.add(pageName);
		panelMain.add(selectQuizName);
		panelMain.add(buttonTakeQuiz);
		buttonTakeQuiz.addActionListener(this);
		this.add(panelMain);
		this.setSize(500, 500);
		this.setVisible(true);
		fileChooser.setCurrentDirectory(new File("").getAbsoluteFile());
		FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("json files (*.json)", "json");
		fileChooser.addChoosableFileFilter(jsonFilter);
		fileChooser.setFileFilter(jsonFilter);
		controller = Controller.getInstance();
	}

	public void actionPerformed(ActionEvent e) {
		if (fileChooser.showOpenDialog(Student.this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				controller.readQuiz(file);
				StudentApp.updatePage(StudentViews.TAKE_QUIZ_VIEW);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Error Loading File", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
