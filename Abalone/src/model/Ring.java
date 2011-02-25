package model;
import java.util.*;
/**
 * Un extension de la classe ArrayList qui a un index de l'element courant et qui a des methods pour acceder l'elemnt precedant et suivant
 * @author E10A896G
 *
 * @param <Type> Le type des elements dans le list
 */
public class Ring<Type> extends ArrayList<Type>{
	private int current;
	/**
	 * Creer un anneau vide
	 */
	public Ring(){
		super();
		current=0;
	}
	/**
	 * Recuperer l'element courant est faire l'element suivant l'element courant
	 * @return l'element courant 
	 */
	public Type get_next(){
		System.out.println("RING: Going forth one player");
		Type x = this.get(current);
		current++;
		if (current > this.size()-1){current=0;}
		return x;
	}
	/**
	 * Recuperer l'element courant est faire l'element precedent l'element courant
	 * @return l'element courant 
	 */
	public Type get_previous(){
		System.out.println("RING: Going back one player");
		Type x = this.get(current);
		current--;
		if (current < 0){current = this.size()-1;}
		return x;
	}
	/**
	 * Recuperer l'element courant
	 * @return l'element courant
	 */
	public Type get_current(){
		return this.get(current);
	}
	
	
//	public static void main(String[] args){
//		Ring<Player> r = new Ring<Player>();
//		r.add(new Player(1, "test1"));
//		r.add(new Player(1, "test2"));
//		System.out.println(r.get_next());
//		System.out.println("33"+r.get(0));
//		System.out.println(r.get_next());
//		System.out.println("33"+r.get(0));
//		System.out.println(r.get_next());
//		System.out.println("33"+r.get(0));
//	}
	
}
