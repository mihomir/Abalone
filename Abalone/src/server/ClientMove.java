package server;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import model.Field;
import model.Move;
import model.Position;
import view.DrawField;

import controller.GameController;
import controller.MouseClicker;

public class ClientMove implements Runnable{
	
	GameController gc;
	
	static final Map<String,Integer> m_reversed = new HashMap<String, Integer>() {
		{
			put("A",1);
			put("B",2);
			put("C",3);
			put("D",4);
			put("E",5);
			put("F",6);
			put("G",7);
			put("H",8);
			put("I",9);
		}
	};
	
	public ClientMove(GameController gamec){
		gc=gamec;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
//			System.out.println("CLIENT: Listening on: " + gc.in);
			System.out.println("CLIENT: Listening");
//			System.out.println("CLIENT: Thread1: " + Thread.currentThread());
			String mes = gc.in.readLine();
//			System.out.println("CLIENT: Thread2: " + Thread.currentThread());
//			System.out.println("CLIENT: Threadformove" + mes.length());
//			System.out.println("CLIENT: Threadformove" + mes);
//			System.out.println("CLIENT: Thread3: " + Thread.currentThread());
//			System.out.println("CLIENT TEST MATCH: " + "!@#MOVEF7,E7".matches("!@#MOVE(\\w\\d,){1,3}\\w\\d"));
//			System.out.println("CLIENT: Thread4: " + Thread.currentThread());
			System.out.println("CLIENT: Poluchihme message: " + mes);
			if (mes.matches("!@#CHAT.*")){
				String[] splitString = (mes.split("!@#CHAT"));
				System.out.println(splitString.length);// Should be 14
				gc.get_board().getArea().append("Server: " + splitString[1]+"\n");
			}
			
			if (mes.matches(".*!@#AIMOVE.*")){
				try{
					System.out.println("CLIENT: Matchnahme move-a na kompota");
					ObjectInputStream Oin = new ObjectInputStream(gc.get_dm().getClientA().get_sock().getInputStream());
					try {
						Move m = (Move) Oin.readObject();
						System.out.println("Client has received: " + m);
						
						MouseClicker mouse = new MouseClicker(gc);
						mouse.computer_move(gc.get_board(), m);
						
						
					}
					catch (ClassNotFoundException e){
						e.printStackTrace();
					}
					
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			
			
			if (mes.matches("!@#MOVE(\\w\\d,){1,3}\\w\\d")){
				System.out.println("CLIENT: Thread5: " + Thread.currentThread());
				System.out.println(mes.matches("!@#MOVE(\\w\\d,){1,3}\\w\\d"));
				String[] splitString = (mes.split("!@#MOVE"));
				splitString = (splitString[1].split(","));
				
				System.out.println(mes + splitString.length);// Should be 14
//				for (String string : splitString) {
//					System.out.println(string);
//				}
				// getting the positions from the message
				Position pos;
				for (int i=0;i<=splitString.length-2; i++){				
					int row = m_reversed.get(new String("") + (splitString[i].charAt(0))).intValue();
					int  diagonal = Integer.parseInt(new String("") + splitString[i].charAt(1));
					pos = new Position (row,diagonal);
					System.out.println("Selected pos: " + pos);
					this.gc.get_game().add_position(pos);
					
				}
				// row and diagonal  of the last position 
				for (String s : splitString){
					System.out.println("SPLIT: " + s);
				}
				System.out.println("CLIENT: Split len: " + splitString.length);
				System.out.println("CLIENT: SPLIT last: " + splitString[splitString.length-1].charAt(0));
				System.out.println("cLIENT: SPLIT lastrev: " + m_reversed.get(new String("") + splitString[splitString.length-1].charAt(0)));
				System.out.println("CLIENT: Split lastlast: " + splitString[splitString.length-1].charAt(1));
				System.out.println("CLIENT: Split lastint: " + Integer.parseInt(new String("") + splitString[splitString.length-1].charAt(1)));
				
//				System.out.println(splitString[splitString.length-1]);
				int last_row =  m_reversed.get(new String("") + (splitString[splitString.length-1].charAt(0))).intValue();
				int last_diagonal = Integer.parseInt(new String("") + splitString[splitString.length-1].charAt(1));
				Position last_pos = new Position(last_row, last_diagonal);
//				mouse.mouseClicked(new MouseEvent());
				Field finalfield = new Field(last_pos);
				System.out.println("CLIENT: Field: " + finalfield);
				DrawField df;
				for (Field f: gc.get_board().get_drawfields().keySet())
					{
						if (f.get_position().equals(last_pos)){
							finalfield=f;
						}
					}
				System.out.println("CLIENT: POS: " + last_pos);
				
				df=gc.get_board().get_drawfields().get(finalfield);
				System.out.println("CLIENT: FieldFin: " + finalfield);
				System.out.println("CLIENT: DField: " + df);
				MouseClicker mouse = new MouseClicker(gc, true, finalfield, df, last_pos);
//				mouse.mouseClicked(new MouseEvent(null, null, null, null, null, null, null, null));
				mouse.mouseClicked(new MouseEvent(new JButton(), 1432, 1, 1, 1, 1, 1, false));

			}
		}
		// TODO Auto-generated method stub
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
