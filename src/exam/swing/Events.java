package exam.swing;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;


public abstract class Events implements ActionListener,MouseListener, MouseWheelListener, MouseMotionListener {

	Test test;
	ExamGUI gui;
	
	
	public static void main(String[] args) {

	}
		public void mouseClicked(MouseEvent a) {
		char[] temppass = gui.passwordField.getPassword();
		String tempuse=gui.textField.getText();
		String password = null;
		password = String.copyValueOf(temppass);
		System.out.println("Username,Password:" + tempuse + "," + password);
		
		if (test.checkLogin(tempuse, password)) {
			
		}
		else {
			
		}
		}
	
}


	