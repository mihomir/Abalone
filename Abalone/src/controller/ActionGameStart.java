package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import view.*;
import model.*;
import javax.swing.*;
import java.util.*;
public class ActionGameStart extends AbstractAction{
	DrawMain dm;
	JDialog jd;
	String buttonchosen;
	public ActionGameStart(String name, DrawMain drawm, JDialog dialog, String s){		
		super();
		dm=drawm;
		jd= dialog;
		buttonchosen=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

                
                JButton button = (JButton)e.getSource();
		RadioButtonStartGame rbsg = (RadioButtonStartGame)button.getParent();
                buttonchosen=rbsg.group.getSelection().getActionCommand();

		System.out.println(rbsg.group.getSelection().getActionCommand() +"in action game");
                System.out.println("Equals for the chosen button"+"Human-Human".equals(buttonchosen));
                String inputValue = "";
                while ("".equals(inputValue)){
                 inputValue = JOptionPane.showInputDialog("Entrer le nom du joueur 1");
//                 System.out.println(inputValue + " " + inputValue==""); 
                }
//                System.out.println(inputValue);
                String inputValue2="computer";
                int isComputer= 1;
//                System.out.println("Equals for the chosen button"+buttonchosen.equals("Human-Human"));
                
                if(buttonchosen.equals("Human-Human")){
                	while("computer".equals(inputValue2) || "".equals(inputValue2)){
		                inputValue2 = JOptionPane.showInputDialog("Entrer le nom du joueur 2");
		                isComputer=0;
                	}
                }

		jd.setVisible(false);
		Player p1 = new Player(0,inputValue);
		Player p2 = new Player(isComputer,inputValue2);

		Ring<Player> lp = new Ring<Player>();
		lp.add(p1);
		lp.add(p2);
		GameController gc = new GameController(lp, dm);
                System.out.println("Players in actiongamestart"+lp);
        }
                
//		Game g = new Game(lp);
		
//		DrawBoardAbsolute db = new DrawBoardAbsolute(g.get_board());
//		dm.getContentPane().add(db);
//		dm.setVisible(true);
		
	}
