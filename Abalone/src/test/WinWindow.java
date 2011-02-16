package test;
import controller.*;
import java.awt.Dialog;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class WinWindow {
	GameController gc;
	public WinWindow(GameController gc){
	
		this.gc=gc;
	}
	
	public void build(){
	System.out.println("TRY TO WIN");
	if (gc.get_game().win_game()){
		System.out.println("Try to show JD");
//		JPanel jp = new JPanel();
//		jp.add(new JLabel("asd"));
//		jp.setVisible(true);
		JDialog jd = new JDialog();
		jd.getContentPane().setLayout(new BoxLayout(jd.getContentPane(), BoxLayout.Y_AXIS));
		JLabel jl= new JLabel("WIN THE GAME!");
		JButton statistics = new JButton("Statistiques");
		jd.getContentPane().add(jl);
		jd.getContentPane().add(statistics);
		jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL );
		jd.setBounds(550,400,200,200);
//		jd.pack();
		jd.setVisible(true);
		
//		jd.getContentPane().add(new JLabel("WIN!"));
		
//		mainframe.add(jp);
	}
	
	
}
	
}
