package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Map;

import model.*;

public class DrawField  extends Component{
	private Field field;
	
	public DrawField(Field f){
		super();
		field=f;
	}
	
	public void paint(Graphics g){
		System.out.println("paint");
	      int height = 20;
	      int width = 20;
	      int space = 20;

//	      if (test1==0){

//	      g.setColor(Color.red);
//	      g.drawRect(10,10,height,width);
//	      g.setColor(Color.gray);
//	      g.fillRect(11,11,height,width); 
//	      g.setColor(Color.red);
	      for (int i=0; i<5; i++){
	    	  g.drawOval(40+(i*space),0, height, width);
		      if (fields.get(new Position(9,i+5)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(40+(i*space),0, height, width);
	      }
	}
  	
	public void repaint(){
		  System.out.println("repaint");
		  super.repaint();
	  }

}
