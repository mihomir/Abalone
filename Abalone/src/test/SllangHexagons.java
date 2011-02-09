package test;
import java.awt.*;
import  javax.swing.*;

public class SllangHexagons
  extends JFrame{  
  public static void main(String [] args) {
    SllangHexagons frame = new SllangHexagons();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setVisible(true);
  }    
  public SllangHexagons() {    
    // add panel to frame
    PolygonPanel panel = new PolygonPanel();
    Container contentPane = getContentPane();
    contentPane.add(panel);
  }
}

/**
 A panel that shows  hexagons
 */
class PolygonPanel
  extends JPanel {
 
  public void paint(Graphics g) {    
    // a hexagon
    int HexaPts = 7;
    int HexaPtsX[] = new int[HexaPts];
   
    // since it is a circular motion here calling an extra to close up the figure
    int HexaPtsY[] = new int[HexaPts];
    g.setColor(Color.blue);
    int rad = 50; // an enlargement factor
    int x1, y1, x2, y2;
    for (int i = 0; i < HexaPts; i++) {      
      x1 = (int) (rad * Math.sin((2 * Math.PI / 6)*i));
      y1 = (int) (rad * Math.cos((2 * Math.PI / 6) *i));
      HexaPtsX[i]=x1;
      HexaPtsY[i]=y1;
    }
    for (int ic = 0; ic < HexaPts - 1; ic++) {
      if (ic == 0) {
        g.setColor(Color.red);
      }
      if (ic == 1) {
        g.setColor(Color.blue);
      }
      if (ic == 2) {
        g.setColor(Color.green);
      }
      if (ic == 3) {
        g.setColor(Color.orange);
      }
      if (ic == 4) {
        g.setColor(Color.magenta);
      }
      if (ic == 5) {
        g.setColor(Color.yellow);
      }
     
      g.drawLine(100 + HexaPtsX[ic], 150 + HexaPtsY[ic],
                 100 + HexaPtsX[ic + 1], 150 + HexaPtsY[ic + 1]);      
      g.drawLine(187 + HexaPtsX[ic], 150 + HexaPtsY[ic],
                 187 + HexaPtsX[ic + 1], 150 + HexaPtsY[ic + 1]);
      g.drawLine(143 + HexaPtsX[ic], 75 + HexaPtsY[ic],
                 143 + HexaPtsX[ic + 1], 75 + HexaPtsY[ic + 1]);
      g.drawLine(143 + HexaPtsX[ic], 225 + HexaPtsY[ic],
                 143 + HexaPtsX[ic + 1], 225 + HexaPtsY[ic + 1]);    
      g.drawLine(230 + HexaPtsX[ic], 225 + HexaPtsY[ic],
                 230 + HexaPtsX[ic + 1],225 + HexaPtsY[ic + 1]);    
    }
  }
}

