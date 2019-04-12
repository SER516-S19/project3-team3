package view.student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.SwingUtilities;
import javax.swing.*;
import javax.swing.filechooser.*;
/**
 *  To display the list of available quizzes
 * @author Vijaya Gadde
 *
 */

public class Student extends JFrame implements ActionListener {
   JPanel panel = new JPanel();
   JButton button = new JButton("Take Quiz");
   JLabel pageName = new JLabel("Student Dashboard");
   JLabel selectQuizName = new JLabel("Select Quiz");
   JFileChooser fc = new JFileChooser();


   public Student() {
      panel.setLayout(new GridLayout(4,1,2,30));
      panel.add(pageName);
      panel.add(selectQuizName);
      panel.add(button);
      this.add(panel);
      this.pack();
      this.setSize(500,500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);

   }

   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == button) {
         int returnVal = fc.showOpenDialog(this);

         if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println(file);
         }
         else {
            System.out.println("Cancelled");
         }
      }
   }
   public static void main(String[] args) {
		JFrame student = new Student();
		student.setVisible(true);
	}
}

