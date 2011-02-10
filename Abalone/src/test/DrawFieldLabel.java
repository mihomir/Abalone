package test;
import javax.swing.*;

import view.DrawField;

import java.awt.*;
import java.awt.event.*;
import model.*;
import controller.*;

public class DrawFieldLabel extends JLabel{
	Field field;
	DrawFieldLabel(Field f){
		super();
		field=f;
		this.setIcon(new ImageIcon("circle.gif"));
	}
	
	 public static void main(String[] args){
         JFrame frame = new JFrame("FieldDemo");
          
         
         JPanel content = (JPanel) frame.getContentPane();
         frame.setLayout(null);
         DrawFieldLabel f = new DrawFieldLabel(new Field(new Position(1,1)));
         content.add(f);
//         Insets insets = content.getInsets();
//	        	Dimension size = f.getPreferredSize();
	        	f.setBounds(0, 0, 21, 21);
//	        	DrawField f2 = new DrawField(new Field(new Position(3,3)));
//	        	content.add(f2);
//	        	f2.setBounds(20, 20, 40, 40);
//         content.add(f, 10, 10);
         
         frame.setSize(520,540); 
         frame.setLocationRelativeTo(null); 
         frame.setResizable(true); 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
 }
	
}
