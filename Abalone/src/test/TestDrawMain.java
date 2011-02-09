package test;
import view.*;
import javax.swing.*;
import view.*;
public class TestDrawMain {
	
		  public static void main(String[] args){
		    SwingUtilities.invokeLater(new Runnable(){
		     public void run(){
		       //On crée une nouvelle instance de notre JDialog
		       DrawMain main = new DrawMain();
		       main.setVisible(true);//On la rend visible
		     }
		    });
		  }
		

}
