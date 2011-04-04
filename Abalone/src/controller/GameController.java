package controller;
//import teWinWindow;
import view.*;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import view.*;
import model.*;
import controller.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class GameController {

	private Game game;
	private DrawMain mainframe;
	private DrawBoardAbsolute board;
	private	Ring<Player> rp;
		 
	public GameController(Ring<Player> lp, JFrame frame){
		

//		super();
//		mainwindow = new DrawMain();
		
		System.out.println("!@#start");
		System.out.println("Players in gamecontroller " + lp);
		game = new Game(lp);
		//--
		rp=lp;
		mainframe = (DrawMain) frame;
                mainframe.getContentPane().removeAll();
		board = new DrawBoardAbsolute(game.get_board(), this);
//		mainframe.getContentPane().setLayout(new FlowLayout());
		mainframe.getContentPane().add(board);
//		mainframe.setVisible(true);
		board.setVisible(true);
		mainframe.setVisible(true);
		
		
//		Map<Field, DrawField> drawfields = board.get_drawfields();
//		Iterator<Field> iter = drawfields.keySet().iterator();
//		Set<DrawField> dfset = new HashSet<DrawField>();
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

		
		// panel for buttons
		
		
//		JPanel buttons_panel = new JPanel();
//		mainframe.getContentPane().add(buttons_panel);
//		JButton jb_coup = new JButton("Indiquer");
//		jb_coup.setBounds(220,500,90,40);
//		buttons_panel.add(jb_coup);
				
//		buttons_panel.setVisible(true);
//		jb_coup.setVisible(true);
//		mainframe.setVisible(true);
		
		if (mainframe.getServerA()!=null){
			mainframe.getServerA().setGC(this);
		}
		
		if (mainframe.getClientA()!=null){
			mainframe.getClientA().setGC(this);
		}

		
	}

	public Game get_game(){
		return this.game;
	}
	
	public DrawBoardAbsolute get_board(){
		return this.board;
	}
	
	public void show_win_game(){
		WinWindow window = new WinWindow(this);
		window.build();

	}
	
	public void run(){


	}
	
	public DrawMain get_dm(){
		return mainframe;
	}
	
	
//	 public static void main(String[] args){
//		    SwingUtilities.invokeLater(new Runnable(){
//		     public void run(){
//		       //On cr�e une nouvelle instance de notre JDialog
//		       DrawMain main = new DrawMain();
//		       main.setVisible(true);//On la rend visible
//		     }
//		    });
//		  }
	
	
}
