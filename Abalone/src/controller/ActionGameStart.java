package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import view.*;
import model.*;
import javax.swing.*;
import java.util.*;
public class ActionGameStart extends AbstractAction{
	DrawMain dm;
	public ActionGameStart(String name, DrawMain drawm){		
		super();
		dm=drawm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player p1 = new Player(1,"test1");
		Player p2 = new Player(1,"test2");
		Ring<Player> lp = new Ring<Player>();
		lp.add(p1);
		lp.add(p2);
		Game g = new Game(lp);
		
		DrawBoard db = new DrawBoard(g.get_board());
		dm.getContentPane().add(db);
		
	}
}
