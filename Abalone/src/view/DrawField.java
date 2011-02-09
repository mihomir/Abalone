package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
//	      int space = 20;
	      g.drawOval(20,120, height, width);
		  if (field.is_empty()){g.setColor(Color.gray);}
		  else {g.setColor(Color.white);}
		  g.fillOval(20,120, height, width);
	}
  	  public void repaint(){
		  System.out.println("repaint");
		  super.repaint();
	  }
  	  
  	  public static void main(String[] args){
  		  JFrame frame = new JFrame("FieldDemo");
  		  frame.setSize(520,540); //On donne une taille à notre fenêtre
  		  frame.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
  		  frame.setResizable(true); //On interdit la redimensionnement de la fenêtre
  		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la c
  		  frame.setVisible(true);
  		  JPanel content = new JPanel();
  		  content.add(new JButton("golyam"));
  	      DrawField f= new DrawField(new Field(new Position(1,1)));
  	      content.add(f);
//	       f.repaint();
  	  }

}
