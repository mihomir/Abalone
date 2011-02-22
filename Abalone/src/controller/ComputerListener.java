package controller;
import java.awt.event.ActionEvent;
import java.util.HashSet;

import model.*;
import view.*;

import javax.swing.*;
public class ComputerListener extends AbstractAction{
	Game game;
	GameController gc;
	AI ai;
	public ComputerListener(GameController gamec){
		gc=gamec;
		game=gc.get_game();
		game.change_player();
		ai = new AI(game, game.get_current_player());
		game.change_player();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(game.get_moves());
//	    if (!game.get_moves().isEmpty()){
//		Move m = game.undo_move();
		System.out.println("COMPLIST: AI is player: " + ai.get_player());
		System.out.println("COMPLIST: Current player before AI searches for move: " + game.get_current_player());
		Move m = ai.get_best_move(ai.generate_moves());
		System.out.println("COMPLIST: Current player after AI searches for move: " + game.get_current_player());
		game.move(m);
		System.out.println("COMPLIST: Current player after AI makes a move: " + game.get_current_player());
		JButton df = (JButton) e.getSource();
		DrawBoardAbsolute dba = (DrawBoardAbsolute) df.getParent();
//		Field f = df.get_field();
		HashSet<Position> posset = new HashSet<Position>(); 
		HashSet<Field> fieldset = new HashSet<Field>();
		HashSet<DrawField> drawset = new HashSet<DrawField>();
		
	    posset.addAll(m.get_own_positions().keySet());
		for (Position position : posset){
			fieldset.add(game.get_board().get_fields().get(position));
		}
		drawset.addAll(dba.get_drawfields(fieldset));
		for (DrawField dff : drawset){
			dff.deselect();
		}
		posset.addAll(m.get_affected_positions());
		for (Position position : posset){
			fieldset.add(game.get_board().get_fields().get(position));
		}
		drawset.addAll(dba.get_drawfields(fieldset));
		gc.get_board().update_fields(drawset);
		gc.show_win_game();
		game.change_player();
		System.out.println("COMPLIST: Current player after AI makes and draws a move: " + game.get_current_player());

	}
}
