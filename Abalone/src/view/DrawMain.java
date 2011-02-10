package view;

import controller.*;

import javax.swing.*;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.util.*;
public class DrawMain extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5849682772446543981L;
	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
//	public class ActionGameStarter implements ActionListener{
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
////		popup.show(e.getComponent(),
////                e.getX(), e.getY());
////		JMenuItem jmenu = (JMenuItem) e.getSource();
//		
////		Component root = SwingUtilities.getRootPane(jmenu);
////		System.out.println(root);
////	      JFrame frame = (JFrame)root;
////	      System.out.println(frame);
//	      getContentPane().setBackground(Color.BLUE);
////		Util.getFrameAncestor((Component) jmenu);
////		jmenu.getComponent().getComponent();
////		System.out.println(jmenu.getComponent());
////		System.exit(0);
//	}
//	}
	

	
	
	public DrawMain(){
		super();
		build();//On initialise notre fenêtre
	}
	
	private void build(){
	  setTitle("Ma première fenêtre"); //On donne un titre à l'application
	  setSize(620,640); //On donne une taille à notre fenêtre
	  setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
	  setResizable(true); //On interdit la redimensionnement de la fenêtre
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	  JPanel content = new JPanel();
//	  content.setBackground(Color.RED);
//	  setContentPane(content);
//	  content.add(new JButton("golyam"));
//	  content.add(new JPanel().add(new JTextArea("nov panel v golemia")));
//	  add(new JPanel().add(new JButton("malak")));
//	  //Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
		setJMenuBar(menuBar);
		//a group of JMenuItems
		menuItem = new JMenuItem("New Game",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionGameStart("New Game", this));
//		menuItem.g
//		bQuitter . addActionListener(new ActionQuitter());
		
		

	}

}
