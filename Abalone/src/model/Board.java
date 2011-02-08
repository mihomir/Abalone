/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abalone;
import java.util.*;

/**
 *
 * @author veronika
 */
public class Board {
    private List<Field> fields;
    private List<Piece> pieces;
    public static final int MAX_ROW=9;
    public static final int MAX_DIAGONAL=9;
    Board(List<Player> listp){
        fields = new ArrayList<Field>();
//        Position p = new Position(1,1);
//        while (p.get_neighbour(1)!=null){
//            fields.add(new Field(p));
//        }
        for (int i=1; i<6; i++){
            fields.add(new Field(new Position(i, 1)));
        }
        for (int i=1; i<7; i++){
            fields.add(new Field(new Position(i, 2)));
        }
        for (int i=1; i<8; i++){
            fields.add(new Field(new Position(i, 3)));
        }
        for (int i=1; i<9; i++){
            fields.add(new Field(new Position(i, 4)));
        }
        for (int i=1; i<10; i++){
            fields.add(new Field(new Position(i, 5)));
        }
        for (int i=2; i<10; i++){
            fields.add(new Field(new Position(i, 6)));
        }
        for (int i=3; i<10; i++){
            fields.add(new Field(new Position(i, 7)));
        }
        for (int i=4; i<10; i++){
            fields.add(new Field(new Position(i, 8)));
        }
        for (int i=5; i<10; i++){
            fields.add(new Field(new Position(i, 9)));
        }

        for (int i=1; i<6; i++){
            Field f = new Field(new Position(1,i));
            System.out.println(f.get_position());
//            System.out.println(fields.get(fields.));
            if (fields.contains(f)) {
                System.out.println("ASADSADSADSA");
                for (Field ff : fields){
                    System.out.println("!!!");
                    if (ff.equals(f)){
                        System.out.println("!!!!!");
                     ff.add_piece(new Piece(listp.get(1)));
                    }
                }
                
            }
        }
        for (int i=1; i<7; i++){
            Field f = new Field(new Position(2,i));
            if (fields.contains(f)) {
                fields.get(fields.indexOf(f)).add_piece(new Piece(listp.get(1)));
            }
        }

        for (int i=3; i<6; i++){
            Field f = new Field(new Position(3,i));
            if (fields.contains(f)) {
                fields.get(fields.indexOf(f)).add_piece(new Piece(listp.get(1)));
            }
        }


//        for (int i=0; i<MAX_FIELDS; i++){
//            fields.add(new Field());
//        }
    }

    public static void main(String[] args){
        Board b = new Board(new ArrayList<Player>());
        for (Field f: b.fields){
            System.out.print(f.get_position());
            System.out.println(f.is_empty());
        }


    }

}
