package server;

import java.io.*;

import javax.swing.JTextArea;

import view.DrawMain;

public class ClientChat implements Runnable{

	BufferedReader in;
	JTextArea out;
//	PrintStream stdout;
	
	ClientChat(BufferedReader i, JTextArea o){
		in=i;
		out=o;
//		stdout= std;
	}
	
	@Override
	public void run() {
		try{
			while(true){
			System.out.println("CLIENT: Listening");
			String mes = in.readLine();
			System.out.println("CLIENT: " + mes.length());
			System.out.println("CLIENT: " + mes);
			if (mes.matches("!@#CHAT.*")){
				String[] splitString = (mes.split("!@#CHAT"));
				System.out.println(splitString.length);// Should be 14
				out.append("Server: " + splitString[1]+"\n");
			}
		}
		// TODO Auto-generated method stub
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
