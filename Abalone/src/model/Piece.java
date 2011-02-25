package model;
/**
 * La classe gerer des billes
 * @author E10A896G
 *
 */
public class Piece {
    private Player owner;
/**
 * creer un nouveu bille pour un joueur
 * @param p Une jour pour qui le bille est cree
 */
    public Piece(Player p){
        owner=p;
    }
    
    public Player get_owner(){
    	return owner;
    }

}
