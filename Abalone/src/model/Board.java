package model;

import java.util.*;

/**
 *
 * @author veronika
 */
public class Board {
//    private List<Field> fields;
    private List<Piece> pieces;
    private Map<Position, Field> fields;
    public static final int MAX_ROW=9;
    public static final int MAX_DIAGONAL=9;
    Board(Ring<Player> listp){
    	fields = new HashMap<Position, Field>();
    	pieces = new ArrayList<Piece>();
//        fields = new ArrayList<Field>();
//        Position p = new Position(1,1);
//        while (p.get_neighbour(1)!=null){
//            fields.add(new Field(p));
//        }
//    	fields.put(new Position(i,1), new Field());
        for (int i=1; i<6; i++){
//            fields.add(new Field(new Position(i, 1)));
        	fields.put(new Position(i,1), new Field(new Position(i,1)));
        }
        for (int i=1; i<7; i++){
//            fields.add(new Field(new Position(i, 2)));
        	fields.put(new Position(i,2), new Field(new Position(i,2)));
        }
        for (int i=1; i<8; i++){
//            fields.add(new Field(new Position(i, 3)));
        	fields.put(new Position(i,3), new Field(new Position(i,3)));
        }
        for (int i=1; i<9; i++){
//            fields.add(new Field(new Position(i, 4)));
        	fields.put(new Position(i,4), new Field(new Position(i,4)));
        }
        for (int i=1; i<10; i++){
//            fields.add(new Field(new Position(i, 5)));
        	fields.put(new Position(i,5), new Field(new Position(i,5)));
        }
        for (int i=2; i<10; i++){
//            fields.add(new Field(new Position(i, 6)));
        	fields.put(new Position(i,6), new Field(new Position(i,6)));
        }
        for (int i=3; i<10; i++){
//            fields.add(new Field(new Position(i, 7)));
        	fields.put(new Position(i,7), new Field(new Position(i,7)));
        }
        for (int i=4; i<10; i++){
//            fields.add(new Field(new Position(i, 8)));
        	fields.put(new Position(i,8), new Field(new Position(i,8)));
        }
        for (int i=5; i<10; i++){
//            fields.add(new Field(new Position(i, 9)));
        	fields.put(new Position(i,9), new Field(new Position(i,9)));
        }

//        System.out.println(listp.get_current());
        
        for (int i=1; i<6; i++){
        	Piece p = new Piece(listp.get_current());
//        	System.out.println(p);
//        	System.out.println(pieces);
        	pieces.add(p);
            fields.get(new Position(1,i)).add_piece(p);

        }
        for (int i=1; i<7; i++){
        	Piece p = new Piece(listp.get_current());
        	pieces.add(p);
            fields.get(new Position(2,i)).add_piece(p);
        }

        for (int i=3; i<6; i++){
        	Piece p = new Piece(listp.get_current());
        	pieces.add(p);
            fields.get(new Position(3,i)).add_piece(p);
        }
        
        listp.get_next();
        
        for (int i=5; i<10; i++){
        	Piece p = new Piece(listp.get_current());
        	pieces.add(p);
            fields.get(new Position(9,i)).add_piece(p);

        }
        for (int i=4; i<10; i++){
        	Piece p = new Piece(listp.get_current());
        	pieces.add(p);
            fields.get(new Position(8,i)).add_piece(p);
        }

        for (int i=5; i<8; i++){
        	Piece p = new Piece(listp.get_current());
        	pieces.add(p);
            fields.get(new Position(7,i)).add_piece(p);
        }
        
        listp.get_next();
    }
    
    public void remove_piece(Piece p){
    	pieces.remove(p);
    }
    
    public Map<Position, Field> get_fields(){
    	return fields;
    }
    
    
    public static void main(String[] args){
        Ring<Player> lp = new Ring<Player>();
        Player p1 = new Player(1, "Amine");
        Player p2 = new Player(1, "Veronika");
        lp.add(p1);
        lp.add(p2);
    	Board b = new Board(lp);
        
        for (Position p: b.fields.keySet()){
//            System.out.print(p);
            if (!b.fields.get(p).is_empty()) {System.out.println(p.toString() + b.fields.get(p).get_piece().get_owner().toString());};
        }


    }

}
