package model;
import java.util.*;
public class Ring<Type> extends ArrayList<Type>{
	private int current;
	public Ring(){
		super();
		current=0;
	}
		
	public Type get_next(){
		System.out.println("RING: Going forth one player");
		Type x = this.get(current);
		current++;
		if (current > this.size()-1){current=0;}
		return x;
	}
	
	public Type get_previous(){
		System.out.println("RING: Going back one player");
		Type x = this.get(current);
		current--;
		if (current < 0){current = this.size()-1;}
		return x;
	}
	
	public Type get_current(){
		return this.get(current);
	}
	
	
	public static void main(String[] args){
		Ring<Player> r = new Ring<Player>();
		r.add(new Player(1, "test1"));
		r.add(new Player(1, "test2"));
		System.out.println(r.get_next());

		System.out.println(r.get_next());

		System.out.println(r.get_next());

	}
	
}
