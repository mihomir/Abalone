package model;


public class Field {
	private Position position;
	private boolean empty;
	private Piece piece;

	public Field(){
		empty=true;
		piece=null;
	}
	
	public Field(Position p){
		position=p;
		empty=true;
                piece=null;
	}

	public boolean is_empty(){
		return empty;
	}

	public Position get_position(){
		return position;
	}

        public void add_piece(Piece p){
            piece=p;
            empty=false;
        }

        public void remove_piece(){
            piece=null;
            empty=true;
        }

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

        public static void main(String[] args){
            Field f1 = new Field(new Position(1,1));
            Field f2 = new Field(new Position(1,1));
            Field f3 = new Field(new Position(1,2));
            Field f4 = new Field(new Position(1,2));
            System.out.println(f1.equals(f1));
            System.out.println(f1.equals(f2));
            System.out.println(f1.equals(f3));
            System.out.println(f1.equals(new Field(new Position(1,1))));



        }


}
