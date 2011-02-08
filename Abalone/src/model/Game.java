package model;
import java.util.*;
public class Game {
	private Board board;
	private Ring<Player> players;
	private List<Move> moves;
	private TreeSet<Position> selected_positions;
	int selected_direction;

	public Game(Ring<Player> l){
		players=l;
		board = new Board(l);
		moves = new ArrayList<Move>();
		selected_positions = new TreeSet<Position>();
	}
	
	public void change_player(){
		players.get_next();
	}
	
	public Ring<Player> get_players(){
		return players;
	}
	
	public boolean check_move(Player p, Move m){
		Map<Position, Position> ownpos= m.get_own_positions();

		for (Position pos : ownpos.keySet()){
			Field f = board.get_fields().get(pos);
			if (f.is_empty() || f.get_piece().owner!=p){ return false;}
		}
		return true;
		
	}
	
	//check position - if there's a piece in the field, and it is our own (return true), we can select it. If it's not, we maybe can do a move, but not always. have to check that too.
	
	public boolean check_position(Position pos){
            
                Field f = board.get_fields().get(pos);
                if (selected_positions.isEmpty()){
                    
                }

		if (f.is_empty() || f.get_piece().owner!=players.get_current()){ return false;}
		return true;
	}

        public boolean check_neighbour_position(Position pos){
            if (selected_positions.isEmpty()){return false;}
            Set<Position> s = new TreeSet<Position>();
            for (Position p : selected_positions){
                s.addAll(p.get_neighbours());
            }
            s.removeAll(selected_positions);
            if (!s.contains(pos)){ return false;}
            return true;
        }

        public Move gen_move(Position pos){
//            if (check_postition() || !check_neighbour_position())
                int d =0;
                for (Position p : selected_positions){
//                    System.out.println(p);
                    d = p.get_direction(pos);
//                    System.out.println(d);
                    if (d>0) { break;}
                }
//                System.out.println(d);
                Move m = new Move(selected_positions,d);
                System.out.println(selected_positions.first());
//                selected_positions.
                System.out.println(selected_positions.ceiling(selected_positions.first()));
                int dir = selected_positions.first().get_direction(selected_positions.higher(selected_positions.first()));
//                System.out.println(dir + "  " + d);
                if (dir!=m.get_direction() && dir+3!=m.get_direction()) { m.set_parallel(true);}
                return m;
            
        }

	public boolean add_position(Position p){
		
		//to be removed, because check positions will be called before adding a position.
		
		if (!this.check_position(p)) {return false;}
		
		if (selected_positions.size()==1) {
				for (int i=1; i<7; i++){
					if (p.equals(selected_positions.first().get_neighbour(i))) {
						selected_positions.add(p);
                                                selected_direction=i;
						return true;
					}
				}
		}	
			
		if (selected_positions.size()==2) {
				Position p1 = selected_positions.first();
				Position p2 = selected_positions.last();
//				System.out.println(p1);
//				System.out.println(p2);
				int i=0;
				boolean flag=false;
				while ((!flag) && (i<6)){
					i++;
//					System.out.println("Neighbour: " + p1.get_neighbour(i));
//					System.out.println(p2);
					if (p2.equals(p1.get_neighbour(i))) {flag=true;}
				}
				if ((p.equals(p2.get_neighbour(i))) || p.equals(p1.get_neighbour(i+3))){
					selected_positions.add(p);
					return true;
				}
		}
		selected_positions.clear();
		selected_positions.add(p);
		return true;
	}

        public boolean check_position_for_move(Position p, Move m){
//            System.out.println(board.get_fields().get(p).is_empty());
//            System.out.println(m.is_parallel());
            if (m.is_parallel()) {
                for (Position pos : m.get_own_positions().values()){
                    if (!board.get_fields().get(pos).is_empty()) {return false;}
                }
                return true;
            }
            if (board.get_fields().get(p).is_empty()){ return true;}
//            else if (m.is_parallel()) {return false;}
            else
                try{
//                    System.out.println("!!");
                if (board.get_fields().get(p.get_neighbour(m.get_direction())).is_empty() && m.get_own_positions().size()>1){
                    m.add_other_position(p);
                    return true;
                }
                else try {
                    if (board.get_fields().get(p.get_neighbour(m.get_direction()).get_neighbour(m.get_direction())).is_empty() && m.get_own_positions().size()>2 && board.get_fields().get(p.get_neighbour(m.get_direction()).get_neighbour(m.get_direction())).get_piece().owner!=this.players.get_current())
                    {
                        m.add_other_position(p);
                        m.add_other_position(p.get_neighbour(m.get_direction()));
                        return true;
                    }
                    else {return false;}

                }
                catch (NullPointerException npe){
                    m.set_removed(true);
                    m.add_other_position(p.get_neighbour(m.get_direction()));
                    return true;
                }
            }
            catch (NullPointerException npe){
                m.set_removed(true);
                m.add_other_position(p);
                return true;
            }
//            return true;
        }

//	public boolean move(Player p, int direction){
//		Move m = new Move(selected_positions, direction);
//		moves.add(m);
//		return true;
//	}

        public void move(Move m){
            for (Position pos : m.get_own_positions().keySet()){
                board.get_fields().get(pos).remove_piece();
            }
            for (Position pos : m.get_other_positions().keySet()){
                board.get_fields().get(pos).remove_piece();
            }
            for (Position pos : m.get_own_positions().values()){
                board.get_fields().get(pos).add_piece(new Piece(players.get_current()));
            }
            for (Position pos : m.get_other_positions().values()){
                try {
                    board.get_fields().get(pos).add_piece(new Piece(players.get_current()));
                }
                catch (NullPointerException npe){}
            }
        }
	
	public static void main(String[] args){
		Ring<Player> r = new Ring<Player>();
//		System.out.println(r.get_current());
		r.add(new Player(1, "test1"));
//		System.out.println("111"+r.get_current());
		r.add(new Player(1, "test2"));
//		System.out.println("222"+r.get_current());
		Game g = new Game(r);
//		Move m = new Move(1);
		
		System.out.println(g.add_position(new Position(4,2)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(5,3)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(6,4)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(3,2)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(3,3)));
		System.out.println(g.selected_positions);
                System.out.println(g.add_position(new Position(4,2)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(3,4)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(9,8)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(8,8)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(7,8)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,3)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,5)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,4)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(2,1)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(2,2)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(2,4)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(3,5)));
		System.out.println(g.selected_positions);
//		System.out.println(g.add_position(new Position(2,5)));
//		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,4)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,3)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,2)));
		System.out.println(g.selected_positions);
//                System.out.println(g.add_position(new Position(3,3)));
//		System.out.println(g.selected_positions);
//		System.out.println(g.add_position(new Position(2,3)));
//		System.out.println(g.selected_positions);
//		System.out.println(g.add_position(new Position(1,3)));
//                System.out.println(g.selected_positions);
                Position p11 = new Position(1,1);
                Move m = g.gen_move(p11);
                System.out.println(m.get_own_positions());
                System.out.println(m.get_other_positions());
                System.out.println(m.get_direction());
                System.out.println(m.is_parallel());
//                System.out.println(g.check_neighbour_position(new Position(1,2)));
//                System.out.println(g.gen_move(new Position(4,4)).get_own_positions());
                System.out.println(g.check_position_for_move(p11, m));
                g.move(m);
                System.out.println(g.board.get_fields().get(new Position(1,4)).is_empty());
//                System.out.println(new Move(g.selected_positions,1).get_own_positions());
//		m.add_position(new Position(5,5));
//		System.out.println(g.get_players().get_current());
//		System.out.println(g.check_move(g.get_players().get_current(), m));
//		System.out.println(g.add_position(new Position(3,3)));
//		System.out.println(g.add_position(new Position(3,5)));
	}
	
	
}
