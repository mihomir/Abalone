package test;
import java.util.Set;

import model.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class TestGame extends TestCase{

	Ring<Player> r;
	Game g;
	
	
	protected void setUp() throws Exception {
        super.setUp();
        r = new Ring<Player>();
        r.add(new Player(1, "test1"));
        r.add(new Player(1, "test2"));
        g = new Game(r);
	}
	
	public void testSelection(){
		System.out.println(g.add_position(new Position(4,2)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(5,3)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(6,4)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(3,2)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(3,3)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(4,2)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(3,4)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(9,8)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(8,8)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(7,8)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,3)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,5)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,4)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(2,1)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(2,2)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(2,4)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(3,5)));
		System.out.println(g.get_selected_positions());
//		System.out.println(g.add_position(new Position(2,5)));
//		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,4)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,3)));
		System.out.println(g.get_selected_positions());
		System.out.println(g.add_position(new Position(1,2)));
		System.out.println(g.get_selected_positions());
//	            System.out.println(g.add_position(new Position(3,3)));
//		System.out.println(g.get_selected_positions());
//		System.out.println(g.add_position(new Position(2,3)));
//		System.out.println(g.get_selected_positions());
//		System.out.println(g.add_position(new Position(1,3)));
//	            System.out.println(g.get_selected_positions());
	            Position p11 = new Position(1,1);
	            Move m = g.gen_move(p11);
	            System.out.println(m.get_own_positions());
	            System.out.println(m.get_other_positions());
	            System.out.println(m.get_direction());
	            System.out.println(m.is_parallel());
//	            System.out.println(g.check_neighbour_position(new Position(1,2)));
//	            System.out.println(g.gen_move(new Position(4,4)).get_own_positions());
	            System.out.println(g.check_position_for_move(p11, m));
	            g.move(m);
	            System.out.println(g.get_board().get_fields().get(new Position(1,4)).is_empty());
	            System.out.println(g.get_pieces_to_win(g.get_current_player()));
//	            System.out.println(new Move(g.get_selected_positions(),1).get_own_positions());
//		m.add_position(new Position(5,5));
//		System.out.println(g.get_players().get_current());
//		System.out.println(g.check_move(g.get_players().get_current(), m));
//		System.out.println(g.add_position(new Position(3,3)));
//		System.out.println(g.add_position(new Position(3,5)));
	}

	
	
	
	public static Test suite(){
	    TestSuite suite = new TestSuite();
	    return suite;
	}
	
}
