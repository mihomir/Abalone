package test;


	import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class DrawingColor{
		JFrame frame;
		static int test1=0;
	
	  public static void main(String[] args) {
	    DrawingColor d = new DrawingColor();
	  }

	  public DrawingColor(){
	    frame = new JFrame("Drawing with Alpha");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MyComponent myc = new MyComponent();
	    JButton but = new JButton("test1");
	    but.addActionListener(new ActionButtonPaint());
	    myc.add(but);
	    frame.getContentPane().add(myc);
	    
	    frame.setSize(400,400);
	    frame.setVisible(true); 
	     
	  }
	  
	  public class ActionButtonPaint implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				frame.getContentPane().repa
				test1++;
				frame.getContentPane().repaint();
//				frame.getContentPane().paint
//				JButton b = (JButton) e.getSource();
//				b.getCom
//				System.out.println(b.getComponents());
				
			}
	  }

	  public class MyComponent extends JPanel{
	    
		  public void paint(Graphics g){
	      int height = 20;
	      int width = 20;
	      int space = 20;
	      if (test1==0){

//	      g.setColor(Color.red);
//	      g.drawRect(10,10,height,width);
//	      g.setColor(Color.gray);
//	      g.fillRect(11,11,height,width); 
//	      g.setColor(Color.red);
	      for (int i=0; i<5; i++){
	    	  g.drawOval(40+(i*space),0, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(40+(i*space),0, height, width);
	      }
	      for (int i=0; i<6; i++){
	    	  g.drawOval(30+(i*space),20, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(30+(i*space),20, height, width);
	      }
	      for (int i=0; i<7; i++){
	    	  g.drawOval(20+(i*space),40, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(20+(i*space),40, height, width);
	      }
	      for (int i=0; i<8; i++){
	    	  g.drawOval(10+(i*space),60, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(10+(i*space),60, height, width);
	      }
          for (int i=0; i<9; i++){
	    	  g.drawOval(0+(i*space),80, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(0+(i*space),80, height, width);
	      }
          for (int i=0; i<8; i++){
	    	  g.drawOval(10+(i*space),100, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(10+(i*space),100, height, width);
	      }
          for (int i=0; i<7; i++){
	    	  g.drawOval(20+(i*space),120, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(20+(i*space),120, height, width);
	      }
          for (int i=0; i<6; i++){
	    	  g.drawOval(30+(i*space),140, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(30+(i*space),140, height, width);
	      }
          for (int i=0; i<5; i++){
	    	  g.drawOval(40+(i*space),160, height, width);
		      g.setColor(Color.gray);
		      g.fillOval(40+(i*space),160, height, width);
	      }
	      }
	      else {
		      

		  g.drawOval(test1*20,80, height, width);
	      g.setColor(Color.CYAN);
	      g.fillOval(test1*20,80, height, width);
	      }
	    }
	      
	  }
//	  public void repaint(int x, int y, int height, int width){
//		  Graphics g = new Graphics();
//		  this.g.drawOval(x,y, height, width);
//	      g.setColor(Color.purple);
//	      g.fillOval(x,y, height, width);
//	  }
	}
