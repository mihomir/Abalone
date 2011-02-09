package test;
import java.awt.event.*;
import javax.swing.*;


public class ActionButtonPaint implements ActionListener{
	int test1=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		test1++;
		System.out.println(b.getParent());
		System.out.println(b.getParent().getParent());
		System.out.println(b.getParent().getParent().getParent());
		System.out.println(b.getParent().getParent().getParent().getParent());
		JFrame jf = (JFrame) b.getParent().getParent().getParent().getParent().getParent();
		
//		JFrame jf = (JFrame) b.getParent().getParent().getParent().getParent().getParent().getParent();
//		System.out.println(b.getParent().getParent().getParent().getParent().getParent().getParent().getParent());
//		JFrame jf = (JFrame) b.getParent().getParent(); 
		jf.getContentPane().repaint();
//		b.getCom
		System.out.println();
		
	}

}
