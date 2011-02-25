package test;
import view.*;
import javax.swing.*;
import model.*;
public class StartNewGame {
	
		  public static void main(String[] args){
		    SwingUtilities.invokeLater(new Runnable(){
		     public void run(){
		       DrawMain main = new DrawMain();
		       main.setVisible(true);
		     }
		    });
		  }
}
