package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import view.*;
import model.*;
import javax.swing.*;
import java.util.*;
public class PopupController extends AbstractAction{
	DrawMain dm ;
	public PopupController(String name, DrawMain d){		
		super();
		dm=d;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//                Object check = e.getSource();
//                System.out.println((check isinstanceof JButton));

                if ((e.getSource() instanceof JButton)){
                 JButton check = (JButton)e.getSource();
                 System.out.println(check.getParent());
                 System.out.println(check.getParent().getParent());
                 System.out.println(check.getParent().getParent().getParent());
                 System.out.println(check.getParent().getParent().getParent().getParent());
//                 System.out.println(check.getParent().getParent().getParent().getParent().getParent());
                 check.getParent().getParent().getParent().getParent().setVisible(false);
                }
		RadioButtonStartGame radio = new RadioButtonStartGame();
		radio.createAndShowGUI(dm);
//		Game g = new Game(lp);
		
//		DrawBoardAbsolute db = new DrawBoardAbsolute(g.get_board());
//		dm.getContentPane().add(db);
//		dm.setVisible(true);
		
	}
}
