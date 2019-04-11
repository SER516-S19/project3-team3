package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.Controller;

public class WriteView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Controller controller;

	public static void main(String[] args) {
		WriteView frame = new WriteView();
		frame.setVisible(true);
	}

	public WriteView() {
		controller = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(21, 28, 125, 52);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton buttonSubmit = new JButton("Save");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.updateTitle(textField.getText());
//				controller.writeData();
			}
		});
		buttonSubmit.setBounds(46, 115, 89, 23);
		contentPane.add(buttonSubmit);
	}
}
