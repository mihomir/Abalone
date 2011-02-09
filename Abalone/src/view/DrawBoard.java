package view;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import model.*;


public class DrawBoard extends JPanel{
	Board b;
	public DrawBoard(Board bb){
		super();
		b=bb;
	}
	public void paint(Graphics g){
		System.out.println("paint");
	      int height = 20;
	      int width = 20;
	      int space = 20;
	      Map<Position, Field> fields= b.get_fields();
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
	      for (int i=0; i<6; i++){
	    	  g.drawOval(30+(i*space),20, height, width);
	    	  if (fields.get(new Position(8,i+4)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(30+(i*space),20, height, width);
	      }
	      for (int i=0; i<7; i++){
	    	  g.drawOval(20+(i*space),40, height, width);
	    	  if (fields.get(new Position(7,i+3)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(20+(i*space),40, height, width);
	      }
	      for (int i=0; i<8; i++){
	    	  g.drawOval(10+(i*space),60, height, width);
	    	  if (fields.get(new Position(6,i+2)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(10+(i*space),60, height, width);
	      }
        for (int i=0; i<9; i++){
	    	  g.drawOval(0+(i*space),80, height, width);
	    	  if (fields.get(new Position(5,i+1)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(0+(i*space),80, height, width);
	      }
        for (int i=0; i<8; i++){
	    	  g.drawOval(10+(i*space),100, height, width);
	    	  if (fields.get(new Position(4,i+1)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(10+(i*space),100, height, width);
	      }
        for (int i=0; i<7; i++){
	    	  g.drawOval(20+(i*space),120, height, width);
	    	  if (fields.get(new Position(3,i+1)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(20+(i*space),120, height, width);
	      }
        for (int i=0; i<6; i++){
	    	  g.drawOval(30+(i*space),140, height, width);
	    	  if (fields.get(new Position(2,i+1)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(30+(i*space),140, height, width);
	      }
        for (int i=0; i<5; i++){
	    	  g.drawOval(40+(i*space),160, height, width);
	    	  if (fields.get(new Position(1,i+1)).is_empty()){g.setColor(Color.gray);}
		      else {g.setColor(Color.white);}
		      g.fillOval(40+(i*space),160, height, width);
	      }
	}
  	  public void repaint(){
		  System.out.println("repaint");
		  super.repaint();
	  }
        
}
