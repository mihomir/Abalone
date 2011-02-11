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
	public ActionGameStart(String name, DrawMain drawm, JDialog dialog){		
		super();
		dm=drawm;
		jd= dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		jd.setVisible(false);
		Player p1 = new Player(1,"test1");
		Player p2 = new Player(1,"test2");
		Ring<Player> lp = new Ring<Player>();
		lp.add(p1);
		lp.add(p2);
		GameController gc = new GameController(lp, dm);
//		Game g = new Game(lp);
		
//		DrawBoardAbsolute db = new DrawBoardAbsolute(g.get_board());
//		dm.getContentPane().add(db);
//		dm.setVisible(true);
		
	}
}
