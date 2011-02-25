package model;

import java.awt.Color;

/**
 * La classe utilise pour les joueurs
 * @author E10A896G
 * 
 *
 */

public class Player {
//    int colour;
    int type;
    private String name;
//    private static Ring<Color> color_picker = new Ring<Color>().addAll(c);
    private Color color;
    /**
     * Creer le nouveaux joueur
     * 
     * @param t Type du joueur. 0 pour l'human et 1 pour l'ordinateur. 
     * @param n Nom du joueur
     * 
     */
    public Player(int t, String n){
        type=t;
        name = n;
        color= new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
//        color=Color.WHITE;
    }
    /**
     * @return Le nom du joueur
     */
    public String toString(){
    	return name;
    }
    
    /**
     * 
     * @return Le Coleur du joueur
     */
    
    public Color get_color(){
//    	Color.
    	return color;
    }
    /**
     * Le type du joueur
     * @return un nomber entier qui. 0 pour humain, 1 pour ordinateur 
     */
    public int get_type(){
    	return type;
    }

//    public static void main(String[] args){
//    	Player p = new Player(1, "test1");
//    	Color c = p.get_color();
//    	System.out.println("Player: color stuff:");
//    	System.out.println(c.getAlpha());
//    	System.out.println(c.getBlue());
//    	System.out.println(c.getGreen());
//    	System.out.println(c.getRed());
//    	System.out.println(c.getTransparency());
//    	System.out.println(c.brighter());
//    	System.out.println(c.getAlpha());
//    	System.out.println(c.getBlue());
//    	System.out.println(c.getGreen());
//    	System.out.println(c.getRed());
//    	System.out.println(c.getTransparency());
////    	System.out.println(c.RGBtoHSB(arg0, arg1, arg2, arg3));
//    	
//    }
    
}
