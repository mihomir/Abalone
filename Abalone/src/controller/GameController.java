package controller;

import javax.swing.SwingUtilities;

import view.*;
import model.*;
import controller.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameController {

//	private view.DrawMain mainwindow;
	private Game game;
//	private Map<Field, DrawField> drawfields;
	private JFrame mainframe;
	private DrawBoardAbsolute board;
	private	Ring<Player> rp;
//	//--
//	public enum Colour {
//		 gray, white, blue };
		 
		 Color[] colours= { Color.black, Color.blue};
	
	public GameController(Ring<Player> lp, JFrame frame){
//		super();
//		mainwindow = new DrawMain();
//		mainwindow.setVisible(true);
		game = new Game(lp);
		//--
		rp=lp;
		mainframe = frame;
		board = new DrawBoardAbsolute(game.get_board(), this);
		mainframe.getContentPane().add(board);
		mainframe.setVisible(true);
		Map<Field, DrawField> drawfields = board.get_drawfields();
		Iterator<Field> iter = drawfields.keySet().iterator();
		Set<DrawField> dfset = new HashSet<DrawField>();
//		while (iter.hasNext()){
////		for (int i=0; i<10; i++){
//			Field f = iter.next();
//			if (f.is_empty()){
//				f.add_piece(new Piece(lp.get_current()));
//			}
//			else { f.remove_piece(); }
////			System.out.println(drawfields.);
//			dfset.add(drawfields.get(f));
//		}
//		board.update_fields(dfset);
		//--
		Map<Player, Color> mpc = new HashMap<Player, Color>();
		
		mpc.put(rp.get_next(), colours[0]);
		mpc.put(rp.get_next(), colours[1]);
	}

	public Game get_game(){
		return this.game;
	}
	
	public DrawBoardAbsolute get_board(){
		return this.board;
	}
	
	public void show_win_game(){
		System.out.println("TRY TO WIN");
		if (game.win_game()){
			System.out.println("Try to show JD");
//			JPanel jp = new JPanel();
//			jp.add(new JLabel("asd"));
//			jp.setVisible(true);
			JDialog jd = new JDialog();
			jd.getContentPane().add(new JLabel("WIN!"));
			jd.pack();
			jd.setVisible(true);
//			jd.getContentPane().add(new JLabel("WIN!"));
			
//			mainframe.add(jp);
			
		}
	}
	
	public void run(){
	}
	
	
//	 public static void main(String[] args){
//		    SwingUtilities.invokeLater(new Runnable(){
//		     public void run(){
//		       //On crée une nouvelle instance de notre JDialog
//		       DrawMain main = new DrawMain();
//		       main.setVisible(true);//On la rend visible
//		     }
//		    });
//		  }
	
	
}
