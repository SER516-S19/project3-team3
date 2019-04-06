package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.JSONController;

public class ReadView extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	JSONController controller;

	public static void main(String[] args) {
		ReadView frame = new ReadView();
		frame.setVisible(true);
	}

	public ReadView() {
		controller = new JSONController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		label = new JLabel();
		contentPane.add(label);

		JButton buttonSubmit = new JButton("Read");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label.setText(controller.getTitle());
			}
		});
		buttonSubmit.setBounds(46, 115, 89, 23);
		contentPane.add(buttonSubmit);
	}
}
