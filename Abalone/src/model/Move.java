/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package abalone;

/**
 *
 * @author veronika
 */
import java.util.*;
public class Move {
	private Map<Position, Position> own_positions;
	private Map<Position, Position> other_positions;
	private int direction;
	private boolean removed;
	private boolean linear;

	public Move(){
		own_positions= new HashMap<Position, Position>();
		other_positions= new HashMap<Position, Position>();
		removed=false;
		linear=false;
	}
	public Move(int d){
		direction = d;
		own_positions= new HashMap<Position, Position>();
		other_positions= new HashMap<Position, Position>();
		removed=false;
		linear=false;
	}

	public Move(List<Position> l, int d){
		direction=d;
		own_positions= new HashMap<Position, Position>();
		other_positions= new HashMap<Position, Position>();
		for (Position p:  l){
			own_positions.put(p, p.get_neighbour(d));
		}
		linear=false;
		removed=false;
	}

	public void add_position(Position p){
		own_positions.put(p, p.get_neighbour(direction));
	}

	public void remove_position(Position p){
		if (own_positions.containsKey(p)) { own_positions.remove(p);};
	}

	public void add_other_position(Position p){
//		other_positions.put(p, null);
//		System.out.println(p);
//		System.out.println(p.get_neighbour(direction));
		other_positions.put(p, p.get_neighbour(direction));
	}

	public void remove_other_position(Position p){
		if (other_positions.containsKey(p)) { other_positions.remove(p);};
	}

	public void set_direction(int d){
		direction=d;
	}


	public boolean is_pushed(){
		return other_positions.isEmpty();
	}

	public void set_removed(boolean r){
		removed=r;
	}

	public boolean is_removed(){
		return removed;
	}

	public void set_linear(boolean l){
		linear=l;
	}

	public boolean is_linear(){
		return linear;
	}

	public static void main(String[] args){

		Position p = new Position(3,2);
//		System.out.println(p.get_neighbour(4).get_neighbour(4));
		List<Position> l = new ArrayList<Position>();
		l.add(p);
		l.add(p.get_neighbour(3));
		l.add(p.get_neighbour(3).get_neighbour(3));
		Move m = new Move(l,6);
//		m.own_positions.put(new Position(1,2), null);
//		m.add_other_position(p.get_neighbour(6));
//		System.out.println(p.get_neighbour(6));
//		m.add_position(p);
//		m.add_position(p.get_neighbour(3));
//		m.add_position(p.get_neighbour(3).get_neighbour(3));
		System.out.println(m.own_positions);
		System.out.println(m.other_positions);
	}


}
