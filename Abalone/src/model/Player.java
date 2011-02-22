package model;

import java.awt.Color;



public class Player {
//    int colour;
    int type;
    private String name;
//    private static Ring<Color> color_picker = new Ring<Color>().addAll(c);
    private Color color;
    public Player(int t, String n){
        type=t;
        name = n;
        color= new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
//        color=Color.WHITE;
    }
    public String toString(){
    	return name;
    }
    
    public Color get_color(){
//    	Color.
    	return color;
    }
    
    public int get_type(){
    	return type;
    }

    public static void main(String[] args){
    	Player p = new Player(1, "test1");
    	Color c = p.get_color();
    	System.out.println("Player: color stuff:");
    	System.out.println(c.getAlpha());
    	System.out.println(c.getBlue());
    	System.out.println(c.getGreen());
    	System.out.println(c.getRed());
    	System.out.println(c.getTransparency());
    	System.out.println(c.brighter());
    	System.out.println(c.getAlpha());
    	System.out.println(c.getBlue());
    	System.out.println(c.getGreen());
    	System.out.println(c.getRed());
    	System.out.println(c.getTransparency());
//    	System.out.println(c.RGBtoHSB(arg0, arg1, arg2, arg3));
    	
    }
    
}
