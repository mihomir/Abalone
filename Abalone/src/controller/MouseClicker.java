package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.TreeSet;

import model.*;
import view.*;


public class MouseClicker implements MouseListener {

	private GameController gamec;
	private Game g;
	
	public MouseClicker(GameController gc){
		gamec=gc;
		g = gc.get_game();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DrawField df = (DrawField) e.getSource();
		DrawBoardAbsolute dba = (DrawBoardAbsolute) df.getParent();
		Field f = df.get_field();
		Position pos = f.get_position();
		
		TreeSet<Position> posset = new TreeSet<Position>(); 
		
		HashSet<Field> fieldset = new HashSet<Field>();
		
		HashSet<DrawField> drawset = new HashSet<DrawField>();
		// this part concerns selecting positions
		if (g.check_position(pos)) {
			System.out.println("Az sym!");
			
			posset.addAll(g.add_position(pos));
			
			for (Position position : posset){
				fieldset.add(g.get_board().get_fields().get(position));

			}
			df.select();
			drawset.addAll(dba.get_drawfields(fieldset));
			for (DrawField dff : drawset){
				dff.deselect();
			}
			drawset.add(df);
		}
		// this part concerns moves
//		if (g.check_neighbour_position(pos)){
//			Move move = g.gen_move(pos)
//		}
		
		//update of the fields that need to be redrawn
		System.out.println(drawset);
		gamec.get_board().update_fields(drawset);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}