package controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionGameStarter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		popup.show(e.getComponent(),
//                e.getX(), e.getY());
		JMenuItem jmenu = (JMenuItem) e.getSource();
		Component root = SwingUtilities.getRoot(jmenu);
		System.out.println(root);
	      JFrame frame = (JFrame)root;
	      System.out.println(frame);
	      frame.getContentPane().setBackground(Color.BLUE);
//		Util.getFrameAncestor((Component) jmenu);
//		jmenu.getComponent().getComponent();
		System.out.println(jmenu.getComponent());
//		System.exit(0);
	}
	
}
