package test;
import controller.*;
import java.awt.Dialog;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import model.Player;

public class WinWindow extends JDialog{
	GameController gc;
	public WinWindow(GameController gc){
	
		this.gc=gc;
	}
		public void display(String s){
		System.out.println("Function Display");
		JLabel player = new JLabel(s);
		this.add(player);
		player.setVisible(true);
			
		}
	class WindowListener extends AbstractAction {
		/**
		 * 
		 */

		public WindowListener(){
			super();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Player x : gc.get_game().get_players()){
			System.out.println(x);
			display(x.toString());
//			JLabel player = new JLabel(x.toString());
//			add(player);
//			player.setVisible(true);
			// moves for the game
			//pieces pushed for each player
			}
			System.out.println("Action event in nested class");
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	
	
	public void build(){
	System.out.println("TRY TO WIN");
	if (gc.get_game().win_game()){
		System.out.println("Try to show JD");
//		JPanel jp = new JPanel();
//		jp.add(new JLabel("asd"));
//		jp.setVisible(true);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JLabel jl= new JLabel("WIN THE GAME!");
		JButton statistics = new JButton("Statistiques");
		statistics.addActionListener(new WindowListener());
		this.getContentPane().add(jl);
		this.getContentPane().add(statistics);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL );
		this.setBounds(550,400,200,200);
//		jd.pack();
		this.setVisible(true);
		
//		jd.getContentPane().add(new JLabel("WIN!"));
		
//		mainframe.add(jp);
	}
	

	
	
	
}
	
}
