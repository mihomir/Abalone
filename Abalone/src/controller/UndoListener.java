package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;

import model.Game;
import model.Player;
import model.Ring;
import view.DrawMain;
import view.RadioButtonStartGame;

public class UndoListener extends AbstractAction{
//	DrawMain dm;
//	JDialog jd;
//	String buttonchosen;
	Game game;
	public UndoListener(Game g){		
		super();
//		dm=drawm;
//		jd= dialog;
//		buttonchosen=s;
		game=g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		    game.undo_move();
	}
//		String choice = bg.getSelection().getActionCommand();
//		JButton button = (JButton)e.getSource();
//		RadioButtonStartGame rbsg = (RadioButtonStartGame)button.getParent();
//		
//		System.out.println(rbsg.group.getSelection().getActionCommand() +"in action game");
//		jd.setVisible(false);
//		Player p1 = new Player(1,"test1");
//		Player p2 = new Player(1,"test2");
//		Ring<Player> lp = new Ring<Player>();
//		lp.add(p1);
//		lp.add(p2);
//		GameController gc = new GameController(lp, dm);
//		}
//		Game g = new Game(lp);
		
//		DrawBoardAbsolute db = new DrawBoardAbsolute(g.get_board());
//		dm.getContentPane().add(db);
//		dm.setVisible(true);
		
}
