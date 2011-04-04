package view;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.*;

import model.*;
import controller.*;
public class DrawBoardAbsolute extends JPanel{
	private Board b;
	public static final int MyWIDTH=50;
	public static final int MyHEIGHT=50;
	public static final int SPACE=10;
	private Map<Field, DrawField> drawfields;
	private GameController gamec;
	private JLabel player_one, player_two;
	int pieces_p1, pieces_p2;
	
//	public AbalchatServer
	
	  public static JTextArea chatText = null;
	  public static JTextField chatLine = null;
	  

	   
	  

	
	public DrawBoardAbsolute(Board bb, GameController gc){
		super();
		b=bb;
		this.setLayout(null);
		gamec = gc;

//		Map<Position, Field> fields= b.get_fields();
		Collection<Field> setfields = b.get_fields().values();
		drawfields = new HashMap<Field, DrawField>();
		for (Field f : setfields){
			Position pos = f.get_position();
//			System.out.println("balblas");
			DrawField df = new DrawField(f);
			df.addMouseListener(new MouseClicker(gc));
			drawfields.put(f,df);
			this.add(df);
			df.setBounds(
					5*((MyWIDTH+SPACE)/2)+
					(MyWIDTH+SPACE)*(pos.get_diagonal()-1)-
					(pos.get_row()*(MyWIDTH+SPACE)/2)
//					(pos.get_diagonal()-1)*MyWIDTH
					, (9-pos.get_row())*MyHEIGHT, MyHEIGHT, MyWIDTH); //HEIGHT+1, MyWIDTH+1);
		}
		JButton jb = new JButton("Undo");
		jb.setVisible(true);
		jb.setBounds(130,500,90,40);
		jb.addActionListener(new UndoListener(gamec));
		this.add(jb);
		String player1 = gamec.get_game().get_current_player().toString();
		pieces_p1=6;
		pieces_p2=6;
		player_one = new JLabel("<html>Joueur 1 :"+player1+"<br> billes a gagner: "+pieces_p1+"</html>");
		this.add(player_one);
		player_one.setVisible(true);
		player_one.setBounds(480,400,190,40);
		gamec.get_game().get_players().get_next();
		String player2 = gamec.get_game().get_current_player().toString();
		player_two = new JLabel("<html>Joueur 2: "+player2+"<br> billes a gagner: "+pieces_p2+"</html>");
		this.add(player_two);
		player_two.setVisible(true);
		player_two.setBounds(480,10,190,40);
		gamec.get_game().get_players().get_previous();
//		JLabel current_player = new JLabel("Now it is player :");
//		this.add(current_player);
//		current_player.setVisible(true);
//		current_player.setBounds(500,200,90,40);
//		this.add(jb_coup);
//		this.setVisible(true);
		JButton computer = new JButton("Indiquer le meilleur coup");
		computer.setVisible(true);
		computer.setBounds(330,500,190,40);
		computer.addActionListener(new BestMoveListener(gamec));
		this.add(computer);
//		this.add(jb_coup);
		
		//draw chat box

		  JPanel chatPane = new JPanel(new BorderLayout());
		  this.add(chatPane);
		  chatPane.setVisible(true);
	      chatText = new JTextArea(20, 20);
//	      chatText.setTabSize(60);
	      chatText.setLineWrap(true);
	      chatText.setEditable(false);
	      chatText.setForeground(Color.blue);
	      JScrollPane chatTextPane = new JScrollPane(chatText,
	         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	      chatLine = new JTextField();
	      chatLine.setEnabled(true);
	      chatLine.addActionListener(new ChatListener(this)); //
	      chatPane.add(chatLine, BorderLayout.SOUTH);
	      chatPane.add(chatTextPane, BorderLayout.CENTER);
//	      JButton chatb = new JButton();
	      chatPane.setBounds(610,400,200,150);
	      
//	      chatPane.add(chatb);
//	      chatText.setBounds(410,500,190,70);
//	      chatText.setVisible(true);
//	      this.add(chatText);
//	      this.add(chatLine);
		 
	      
		this.setVisible(true);
		
		

	
   }
	
	public JTextField getField(){
		return chatLine;		
	}
	
	public JTextArea getArea(){
		return chatText;		
	}
	
	public JLabel get_label_one(){
		return player_one;
	}
	
	public JLabel get_label_two(){
		return player_two;
	}
	
	public void update_fields(Set<DrawField> fields){
		 pieces_p1 = gamec.get_game().get_pieces_to_win(gamec.get_game().get_players().get(0));
		 String player1 = gamec.get_game().get_players().get(0).toString();
		 pieces_p2 = gamec.get_game().get_pieces_to_win(gamec.get_game().get_players().get(1));
		 player_one.setText("<html>Joueur 1 :"+player1+"<br> billes a gagner: "+pieces_p1+"</html>");
		 String player2 = gamec.get_game().get_players().get(1).toString();
		 player_two.setText("<html>Joueur 2: "+player2+"<br> billes a gagner: "+pieces_p2+"</html>");
		
		 
		 
		 
		
		
		for (DrawField f : fields){
//			System.out.println("Abstract repaint" + f);
			f.repaint();
		}
		this.setVisible(true);
	}
	
	public void update_fields(DrawField f){
//		for (DrawField f : fields){
			f.repaint();
//		}
		this.setVisible(true);
	}
	
	public HashSet<DrawField> get_drawfields(HashSet<Field> hf){
		HashSet<DrawField> hset = new HashSet<DrawField>();
		
		for (Field f : hf){
//			for (DrawField df : drawfields.keySet()){
				hset.add(drawfields.get(f));	
//			}
		}
		return hset;
	}
	
	public Map<Field, DrawField> get_drawfields(){
		return drawfields;
	}
	
	public GameController get_gc(){
		return gamec;
	}
	
	
	

}