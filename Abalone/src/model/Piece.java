package model;
public class Piece {
    private Player owner;

    public Piece(Player p){
        owner=p;
    }
    
    public Player get_owner(){
    	return owner;
    }

}
