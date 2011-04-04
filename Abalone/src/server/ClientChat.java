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
			DrawMain main = new DrawMain();
		       main.setVisible(true);
			while(true){
				 try{
					    FileWriter fstream = new FileWriter("/tmp/out2.txt");
					        BufferedWriter outfile = new BufferedWriter(fstream);
					    outfile.write("Hello Java");
					    outfile.write("MESSAGEAVANT: ");
					    outfile.close();
					    }
				 catch (Exception e){//Catch exception if any
					      System.err.println("Error: " + e.getMessage());
					    }
//			System.console().writer().println("CONSOLEINCHAT!!!");
//			stdout.println("CLIENT RECEIVES111:");
			System.out.println("CLIENT: Listening");
			String mes = in.readLine();
			 try{
				    FileWriter fstream = new FileWriter("/tmp/out.txt");
				        BufferedWriter outfile = new BufferedWriter(fstream);
				    outfile.write("Hello Java");
				    outfile.write("MESSAGE: " +mes);
				    outfile.close();
				    }
			 catch (Exception e){//Catch exception if any
				      System.err.println("Error: " + e.getMessage());
				    }
//			stdout.println("CLIENT RECEIVES:" + mes);
			System.out.println("CLIENT: " + mes.length());
			System.out.println("CLIENT: " + mes);
			if (mes.matches("!@#CHAT.*")){
				String[] splitString = (mes.split("!@#CHAT"));
				System.out.println(splitString.length);// Should be 14
				out.append(splitString[1]+"\n");
			}
		}
		// TODO Auto-generated method stub
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
