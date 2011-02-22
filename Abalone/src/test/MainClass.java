package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel {

  Color color;

  public MainClass(Color color) {
    this.color = color;
  }

  public void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    g.setColor(color);
    g.drawOval(0, 0, width, height);
  }

//  public void repaint(){
//	  System.out.println("repaint");
//	  super.repaint();
////	  super();
//  }
  
  public static void main(String args[]) {
    JFrame frame = new JFrame("Oval Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(new GridLayout(2, 2));

    Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };
    for (int i = 0; i < 4; i++) {
      MainClass panel = new MainClass(colors[i]);
      frame.add(panel);
    }

    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}
