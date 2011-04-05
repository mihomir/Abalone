package model;
import java.util.*;
/**
 * La classe pour gerer des positions
 * @author E10A896G
 *
 */
public class Position implements Comparable<Position>{

	int row;
	int diagonal;
	static final Map<Integer, String> m = new HashMap<Integer, String>() {
		{
			put(1, "A");
			put(2, "B");
			put(3, "C");
			put(4, "D");
			put(5, "E");
			put(6, "F");
			put(7, "G");
			put(8, "H");
			put(9, "I");
		}
	};
	
	/**
	 * Creer une position a partir des nombre pour le ligne et colonne 
	 * @param r le numero de ligne
	 * @param d le numero de colonne
	 */
	public Position(int r, int d) {
		row = r;
		diagonal = d;
	}

	public int get_row() {
		return row;
	}

	public int get_diagonal() {
		return diagonal;
	}

	public void set_row(int r) {
		row = r;
	}

	public void set_diagonal(int d) {
		diagonal = d;
	}

	public String toString() {
		return m.get(row) + new Integer(diagonal).toString();
	}
/**
 * Recuperer le direction d'une autre position 
 * @param pos L'autre position
 * @return Le numero de direction si l'autre position est a cote de la position, 0 sinon
 */
        public int get_direction(Position pos){
            int i=1;
            while (i<7){
                if (pos.equals(this.get_neighbour(i))) {return i;}
                i++;
            }
            return 0;
        }
/**
 * Recuperer toutes positions a cote de la position 
 * @return Un ensemble des positions
 */
        public Set<Position> get_neighbours(){
            Set<Position> n = new TreeSet<Position>();
            for (int i=1; i<7; i++){
//            	System.out.println("Checking for neighbour of "+ this + " in direction " + i);
//                try{
                    if (this.get_neighbour(i)!=null) n.add(this.get_neighbour(i));
//                    System.out.println("I've added the neighbour " + this.get_neighbour(i) + ". The set is now: "+ n);
//                }
//                catch (NullPointerException npe){;}
            }
//            System.out.println("Neighbours of "+ this + " : " + n);
            return n;
        }
 /**
  * Recuperer le voisin de la position dans une direction donnee
  * @param direction Un nombre entier qui represent la direction.
  * @return La position dans cette direction. S'il n y a pas une position (le bord du plateau) la valeur retourner est NULL
  */
	public Position get_neighbour(int direction) {
//		System.out.println(this + " " + direction);
		Position p=null;
//		System.out.println("Direction"+direction);
		if (direction==1) p = new Position(get_row()+1, get_diagonal());
		else if (direction==2) p = new Position(get_row()+1, get_diagonal()+1);
		else if (direction==3) p = new Position(get_row(), get_diagonal()+1);
		else if (direction==4) p = new Position(get_row()-1, get_diagonal());
		else if (direction==5) p = new Position(get_row()-1, get_diagonal()-1);
		else if (direction==6) p = new Position(get_row(), get_diagonal()-1);
//                System.out.println(direction);
//		System.out.println("Current neighbour " + p);
		if (p.row==0 || p.diagonal==0){ p=null;}
		else if (p.row==10 || p.diagonal==10) p=null;

		else if ((p.row==1) && p.diagonal>5) p=null;
		else if ((p.row==9) && p.diagonal<5) p=null;
		else if ((p.diagonal==1) && p.row>5) p=null;
		else if ((p.diagonal==9) && p.row<5) p=null;

		else if ((p.row==2) && p.diagonal>6) p=null;
		else if ((p.row==8) && p.diagonal<4) p=null;
		else if ((p.diagonal==2) && p.row>6) p=null;
		else if ((p.diagonal==8) && p.row<4) p=null;

		else if ((p.row==3) && p.diagonal>7) p=null;
		else if ((p.row==7) && p.diagonal<3) p=null;
		else if ((p.diagonal==3) && p.row>7) p=null;
		else if ((p.diagonal==7) && p.row<3) p=null;

		else if ((p.row==4) && p.diagonal>8) p=null;
		else if ((p.row==6) && p.diagonal<2) p=null;
		else if ((p.diagonal==4) && p.row>8) p=null;
		else if ((p.diagonal==6) && p.row<2) p=null;

		else if (p.row==5 && p.diagonal>9) p=null;
		else if (p.diagonal==5 && p.row>9) p=null;
		
//		System.out.println("Current neighbour to return" + p);
		
		return p;
	}

        public boolean equals(Object o){
            if (this.getClass().isInstance(o)){
                Position p = (Position) o;
                return (p.get_diagonal()==this.get_diagonal()) && (p.get_row()==this.get_row());
            }
            
            else return super.equals(o);
        }
        
        public int hashCode(){
        	return 31*row+diagonal;
        }

        public int compareTo(Position pos){
        	if (this.get_row()==pos.get_row()){ return new Integer(this.get_diagonal()).compareTo(new Integer(pos.get_diagonal())); }
        	else return new Integer(this.get_row()).compareTo(new Integer(pos.get_row()));
        }
        

//	public static void main(String[] Args) {
//                
//
//
//		Position p = new Position(1, 2);
//                System.out.println(p.get_neighbours());
//		System.out.println(p);
//		try {
//			System.out.println(p.get_neighbour(1));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//		try {
//			System.out.println(p.get_neighbour(2));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//		try {
//			System.out.println(p.get_neighbour(3));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//		try {
//		System.out.println(p.get_neighbour(4));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//		try {
//			System.out.println(p.get_neighbour(5));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//		try {
//			System.out.println(p.get_neighbour(6));
//		}
//		catch (NullPointerException e){
//			System.out.println("Out of board");
//		}
//
//	}
}
