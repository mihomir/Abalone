package model;

/**
 * La classe pour represente un case
 * @author E10A896G
 *
 */
public class Field {
	private Position position;
	private boolean empty;
	private Piece piece;

	/**
	 * creer un case vide
	 */
	public Field(){
		empty=true;
		piece=null;
	}
	/**
	 * creer un case pour une position
	 * @param p Le position pour le case
	 */
	public Field(Position p){
		position=p;
		empty=true;
		piece=null;
	}

	/**
	 * verifier si un case est vide
	 * @return vrai si le case est vide et faux sinon
	 */
	public boolean is_empty(){
		return empty;
	}

	public Position get_position(){
		return position;
	}
	/**
	 * ajouter un bille dans un case
	 * @param p un bille
	 */
        public void add_piece(Piece p){
            piece=p;
            empty=false;
        }

        /**
         * supprimer un bille d'un case
         */
        public void remove_piece(){
            piece=null;
            empty=true;
        }
        /**
         * recuperer le bille dans le case 
         * @return le bille dans le case
         */
        public Piece get_piece(){
        	return piece;
        }
        
        public boolean equals(Object o){
                        if (this.getClass().isInstance(o)){

                        Field f = (Field) o;
                  return this.get_position().equals(f.get_position());
//                return (p.get_diagonal()==this.get_diagonal()) && (p.get_row()==this.get_row());
            }

            else return super.equals(o);
            
        }
//
//        public static void main(String[] args){
//            Field f1 = new Field(new Position(1,1));
//            Field f2 = new Field(new Position(1,1));
//            Field f3 = new Field(new Position(1,2));
//            Field f4 = new Field(new Position(1,2));
//            System.out.println(f1.equals(f1));
//            System.out.println(f1.equals(f2));
//            System.out.println(f1.equals(f3));
//            System.out.println(f1.equals(new Field(new Position(1,1))));
//
//
//
//        }


}
