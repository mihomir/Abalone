package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		Field f = df.get_field();
		Position pos = f.get_position();
		if (g.check_position(pos)) {
			g.add_position(pos);
		}
		df.select();
		gamec.get_board().update_fields(df);

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