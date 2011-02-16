package view;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import model.*;
import controller.*;



public class DrawBoardAbsolute extends JPanel{
	private Board b;
	public static final int MyWIDTH=50;
	public static final int MyHEIGHT=50;
	public static final int SPACE=10;
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
//			System.out.println("balblas");
			DrawField df = new DrawField(f);
			df.addMouseListener(new MouseClicker(gc));
			drawfields.put(f,df);
			this.add(df);
			df.setBounds(
					5*((MyWIDTH+SPACE)/2)+
					(MyWIDTH+SPACE)*(pos.get_diagonal()-1)-
					(pos.get_row()*(MyWIDTH+SPACE)/2)
//					(pos.get_diagonal()-1)*MyWIDTH
					, (9-pos.get_row())*MyHEIGHT, MyHEIGHT, MyWIDTH); //HEIGHT+1, MyWIDTH+1);
		}
		JButton jb = new JButton("Undo");
		jb.setVisible(true);
		jb.setBounds(130,500,90,40);
		jb.addActionListener(new UndoListener(gamec));
		this.add(jb);
//		this.add(jb_coup);
//		this.setVisible(true);
		JButton computer = new JButton("Computer moves");
		computer.setVisible(true);
		computer.setBounds(330,500,90,40);
		computer.addActionListener(new ComputerListener(gamec));
		this.add(computer);
//		this.add(jb_coup);
		this.setVisible(true);
	
   }
	
	public void update_fields(Set<DrawField> fields){
		for (DrawField f : fields){
//			System.out.println("Abstract repaint" + f);
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
	
	public HashSet<DrawField> get_drawfields(HashSet<Field> hf){
		HashSet<DrawField> hset = new HashSet<DrawField>();
		
		for (Field f : hf){
//			for (DrawField df : drawfields.keySet()){
				hset.add(drawfields.get(f));	
//			}
		}
		return hset;
	}
	
	public Map<Field, DrawField> get_drawfields(){
		return drawfields;
	}
	

}