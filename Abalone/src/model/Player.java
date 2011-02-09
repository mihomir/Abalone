package model;

import java.awt.Color;

public class Player {
//    int colour;
    int type;
    String name;
    Color color;
    public Player(int t, String n){
        type=t;
        name = n;
        color=Color.WHITE;
    }
    public String toString(){
    	return name;
    }
}
