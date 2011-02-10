package view;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import model.*;
import controller.*;



public class DrawBoardAbsolute extends JPanel{
	private Board b;
	public static final int WIDTH=20;
	public static final int HEIGTH=20;
	private Map<Field, DrawField> drawfields;
	private GameController gamec;
	
	public DrawBoardAbsolute(Board bb, GameController gc){
		super();
		b=bb;
		this.setLayout(null);
		gamec = gc;

//		Map<Position, Field> fields= b.get_fields();
		Collection<Field> setfields = b.get_fields().values();
		drawfields = new HashMap<Field, DrawField>();
		for (Field f : setfields){
			Position pos = f.get_position();
			System.out.println("balblas");
			DrawField df = new DrawField(f);
			df.addMouseListener(new MouseClicker(gc));
			drawfields.put(f,df);
			this.add(df);
			df.setBounds((5*(WIDTH/2))-(pos.get_row()*WIDTH/2)+(pos.get_diagonal()-1)*WIDTH, (9-pos.get_row())*HEIGTH, 21, 21);
		}
		this.setVisible(true);
   }
	
	public void update_fields(Set<DrawField> fields){
		for (DrawField f : fields){
			f.repaint();
		}
		this.setVisible(true);
	}
	
	public void update_fields(DrawField f){
//		for (DrawField f : fields){
			f.repaint();
//		}
		this.setVisible(true);
	}
	
	public Map<Field, DrawField> get_drawfields(){
		return drawfields;
	}
	

}