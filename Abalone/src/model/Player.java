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
    
}
