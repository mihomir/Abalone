package model;
import java.util.*;

public class AI {
	Game game;
	Player player;
	AI(Game g, Player p){
		game=g;
		player=p;
	}
	
	public Game get_game(){
		return game;
	}
	
	public void set_game(Game g){
		game=g;
	}
	
	public double evaluate_move(Move m){
		return 1;
	}
	
	public List<Move> generate_moves(){
		List<Move> moves = new ArrayList<Move>();
		Map<Position, Field> positions_with_fields = game.get_board().get_fields();
		Set<Position> positions = new HashSet<Position>(); 
		for (Position pos : positions_with_fields.keySet()){
			Field f = positions_with_fields.get(pos);
			if (!f.is_empty() && f.get_piece().get_owner()==player){
				positions.add(pos);
			}
		}
		for (Position pos : positions){
			for (int i=1; i<7; i++){
				Position other_pos = pos.get_neighbour(i);
				if (other_pos!=null){
					if (!game.check_position(other_pos)){
						game.add_position(pos);
						Move m = game.gen_move(other_pos);
						System.out.println(m.get_own_positions());
						if (game.check_position_for_move(other_pos, m)){
							moves.add(m);
						}
						game.add_position(pos);
					}
				}
				
			}
		}
		System.out.println(moves.size());
		
		return moves;
	}
	
	public Move get_best_move(List<Move> moves){
		return moves.get(moves.size()-1);
	}
	
	public static void main(String[] args){
		Ring<Player> r = new Ring<Player>();
        r.add(new Player(1, "test1"));
        r.add(new Player(1, "test2"));
        Game g = new Game(r);
        AI ai = new AI(g, r.get_current());
        ai.generate_moves();
	}
	
	
}
