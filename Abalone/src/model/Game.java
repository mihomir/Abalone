import java.util.*;
public class Game {
	private Board board;
	private Ring<Player> players;
	private List<Move> moves;
	private TreeSet<Position> selected_positions;
	
	
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
		if (f.is_empty() || f.get_piece().owner!=players.get_current()){ return false;}
		return true;
	}
	
	public boolean add_position(Position p){
		
		//to be removed, because check positions will be called before adding a position.
		
		if (!this.check_position(p)) {return false;}
		
		if (selected_positions.size()==1) {
				for (int i=1; i<7; i++){
					if (p.equals(selected_positions.first().get_neighbour(i))) {
						selected_positions.add(p);
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
	
	public boolean move(Player p, int direction){
		Move m = new Move(selected_positions, direction);
		moves.add(m);
		return true;
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
		System.out.println(g.add_position(new Position(2,5)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,1)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,2)));
		System.out.println(g.selected_positions);
		System.out.println(g.add_position(new Position(1,3)));
		System.out.println(g.selected_positions);
//		m.add_position(new Position(5,5));
//		System.out.println(g.get_players().get_current());
//		System.out.println(g.check_move(g.get_players().get_current(), m));
//		System.out.println(g.add_position(new Position(3,3)));
//		System.out.println(g.add_position(new Position(3,5)));
	}
	
	
}
