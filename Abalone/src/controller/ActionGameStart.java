package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import view.*;
import model.*;
import javax.swing.*;
import java.util.*;
public class ActionGameStart extends AbstractAction{
	DrawMain dm;
	JDialog jd;
	String buttonchosen;
	public ActionGameStart(String name, DrawMain drawm, JDialog dialog, String s){		
		super();
		dm=drawm;
		jd= dialog;
		buttonchosen=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String choice = bg.getSelection().getActionCommand();
		JButton button = (JButton)e.getSource();
		RadioButtonStartGame rbsg = (RadioButtonStartGame)button.getParent();
		
		System.out.println(rbsg.group.getSelection().getActionCommand() +"in action game");
		jd.setVisible(false);
		Player p1 = new Player(1,"test1");
		Player p2 = new Player(1,"test2");
		Ring<Player> lp = new Ring<Player>();
		lp.add(p1);
		lp.add(p2);
		GameController gc = new GameController(lp, dm);
		}
//		Game g = new Game(lp);
		
//		DrawBoardAbsolute db = new DrawBoardAbsolute(g.get_board());
//		dm.getContentPane().add(db);
//		dm.setVisible(true);
		
	}
