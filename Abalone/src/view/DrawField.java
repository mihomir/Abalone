
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;

public class DrawField extends Component{
       private Field field;
       private boolean selected;
   		public static final int MyWIDTH=50;
   		public static final int MyHEIGTH=50;
       private Player whiteplayer;
       
       public DrawField(Field f){//, boolean sel){
               super();
               field=f;
               selected=false;
       }
       
       public void paint(Graphics g){
//             System.out.print(this);
//    	   	 System.out.println("paint");
             
//             int height = 20;
//             int width = 20;
//              int space = 20;
    	   	 g.setColor(Color.BLACK);
             g.drawOval(0,0, MyHEIGTH-1, MyWIDTH-1);
//             g.drawOval(1,1, MyHEIGTH-1, MyWIDTH-1);
//             g.drawOval(2,2, MyHEIGTH-2, MyWIDTH-2);
//             g.drawOval(3,3, MyHEIGTH-3, MyWIDTH-3);
                 if (field.is_empty()){g.setColor(Color.gray);}
                 else {
                 System.out.println("Owner of field on the drawing board " + field.get_piece().get_owner());
                	 if (!selected) {
                		 

                		 g.setColor(field.get_piece().get_owner().get_color());
                	 } 
                	 else {
                		 g.setColor(Color.CYAN);
                	 }
                }
                 g.fillOval(0,0, MyHEIGTH-1, MyWIDTH-1);
       }
       
       public void select(){
    	   selected=true;
       }
       public void deselect(){
    	   selected=false;
       }
       
       public Field get_field(){
    	   return field;
       }
         
       public void repaint(){
//                 System.out.println("repaint");
                 super.repaint();
         }
           
           public static void main(String[] args){
                   JFrame frame = new JFrame("FieldDemo");
                    
                   frame.setContentPane(new JPanel());
                   JPanel content = (JPanel) frame.getContentPane();
                   frame.setLayout(null);
                   DrawField f = new DrawField(new Field(new Position(1,1)));
                   content.add(f);
                   Insets insets = content.getInsets();
       	        	Dimension size = f.getPreferredSize();
       	        	f.setBounds(0, 0,
       	                     151, 151);
//       	        	DrawField f2 = new DrawField(new Field(new Position(3,3)));
//       	        	content.add(f2);
//       	        	f2.setBounds(20, 20,
//      	                     21, 21);
//       	        	DrawField f3 = new DrawField(new Field(new Position(3,3)));
//       	        	content.add(f3);
//       	        	f3.setBounds(0, 20,
//      	                     41, 41);
//       	        	DrawField f4 = new DrawField(new Field(new Position(3,3)));
//       	        	content.add(f4);
//       	        	f4.setBounds(0, 35,
//      	                     41, 41);
//       	        	
//                   content.add(f, 10, 10);
                   
                   frame.setSize(520,540); 
                   frame.setLocationRelativeTo(null); 
                   frame.setResizable(true); 
                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   frame.setVisible(true);
           }

}
