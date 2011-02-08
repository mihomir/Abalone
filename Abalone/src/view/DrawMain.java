package view;

import controller.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
//import java.util.*;
public class DrawMain extends JFrame{
	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	

	
	
	public DrawMain(){
		super();
		build();//On initialise notre fenêtre
	}
	
	private void build(){
	  setTitle("Ma première fenêtre"); //On donne un titre à l'application
	  setSize(320,240); //On donne une taille à notre fenêtre
	  setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
	  setResizable(false); //On interdit la redimensionnement de la fenêtre
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
	  JPanel content = new JPanel();
	  content.setBackground(Color.RED);
	  setContentPane(content);
	  content.add(new JButton("golyam"));
	  content.add(new JPanel().add(new JTextArea("nov panel v golemia")));
	  add(new JPanel().add(new JButton("malak")));
	  //Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
		setJMenuBar(menuBar);
		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionGameStarter());
//		menuItem.g
//		bQuitter . addActionListener(new ActionQuitter());
		
		

	}

}
