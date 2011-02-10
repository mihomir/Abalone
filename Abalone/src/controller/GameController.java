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
	
	public GameController(Ring<Player> lp, JFrame frame){
//		super();
//		mainwindow = new DrawMain();
//		mainwindow.setVisible(true);
		game = new Game(lp);
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
	}

	public Game get_game(){
		return this.game;
	}
	
	public DrawBoardAbsolute get_board(){
		return this.board;
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
