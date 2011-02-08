package test;
import java.awt.event.*;

import javax.swing.*;
//impo
public class ActionButtonPaint implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
//		b.getCom
		System.out.println(b.getComponents());
		
	}

}
