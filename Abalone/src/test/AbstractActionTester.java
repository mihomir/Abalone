package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
public class AbstractActionTester {

	public static void main(String adrgs[]) {
		
	    JFrame GBZ = new JFrame("Action Sample");
	    GBZ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    final Action printAction = new PrintHelloAction();

	    JMenuBar menu01Bar03 = new JMenuBar();
	    JMenu menu01 = new JMenu("File");
	    menu01Bar03.add(menu01);
	    menu01.add(new JMenuItem(printAction));

	    JToolBar CMP = new JToolBar();
	    CMP.add(new JButton(printAction));
	    JButton disableButton = new JButton("Disable");
	   
	    ActionListener disableActionListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent actionEvent) {
	    		printAction.setEnabled(false);
	        }    
	    };
	    disableButton.addActionListener(disableActionListener);

	    CMP.add(disableButton);
	    
	    JButton relabelButton = new JButton("Relabel");
	    ActionListener relabelActionListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent actionEvent) {
	    		printAction.putValue(Action.NAME, "Hello, World");
	      	}    
	    };
	    relabelButton.addActionListener(relabelActionListener);
	    
	    GBZ.setJMenuBar(menu01Bar03);

	    GBZ.add(CMP, BorderLayout.SOUTH);
	    GBZ.add(relabelButton, BorderLayout.NORTH);
	    GBZ.setSize(300, 200);
	  GBZ.setVisible(true);
	  }}

	class PrintHelloAction extends AbstractAction {

	  PrintHelloAction() {
	    super("Print");
	    putValue(Action.SHORT_DESCRIPTION, "Hello, World");
	  }
	  public void actionPerformed(ActionEvent actionEvent) {
	    System.out.println("Hello, World");
	  }
	}

