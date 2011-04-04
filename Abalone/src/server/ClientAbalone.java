package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import controller.GameController;

import view.DrawMain;

public class ClientAbalone implements Runnable{
	
	DrawMain dm;
 
	Socket sock;
	int serv_port;
	String serv_name;
	static final int PORT=1500;
	GameController gc;
	BufferedReader in;
	PrintWriter out;
	public ClientAbalone(DrawMain d, String name, int port){
		dm=d;
		serv_name=name;
		serv_port=port;
		try{
			sock = new Socket(serv_name, serv_port);
			in = new BufferedReader( new InputStreamReader (sock.getInputStream()));
			out = new PrintWriter(new BufferedWriter( new OutputStreamWriter (sock.getOutputStream())),true);
		}
		catch(Exception e){
			System.out.println("CLIENT ABALONE: creation of socket" + e.getMessage());
		}
	}
	public void run(){
		try{
//			DrawMain main = new DrawMain();
//		       main.setVisible(true);
//			BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader( new InputStreamReader (sock.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter (sock.getOutputStream())),true);
			
//			System.out.println(System.out.toString());
//			PrintStream stdout = new PrintStream(System.out);
//			stdout.println("test stdout1");
//			System.console().writer().println("CONSOLE!!!");

//			new PrintStream(stdout).println("123etsatgsdfgdfgd");
//			System.setOut(new PrintStream(sock.getOutputStream()));
//			System.setOut()
//			stdout.println("test stdout2");
			System.out.println(Thread.currentThread().toString());
			
			System.out.println(Thread.currentThread().toString());
//			new Thread.start();
//			stdout.println("test stdout3");
//			DrawMain main = new DrawMain();
//		       main.setVisible(true);
//			System.console().writer().println("CONSOLE!!!");
			while (true) {
//				System.out.println("test stdout");
//				stdout.println("test stdout");
//				System.out.println("CLIENT: Listening");
//				String mes = in.readLine();
//				
////				stdout.println("CLIENT RECEIVES:" + mes);
////				stdout.println(mes);
////				stdout.println("TEST123");
//				System.out.println("CLIENT: " + mes.length());
//				System.out.println("CLIENT: " + mes);
//				if (mes.matches("!@#CHAT.*")){
//					
//					String[] splitString = (mes.split("!@#CHAT"));
//					System.out.println(splitString.length);// Should be 14
//					out.append(splitString[1]+"\n");
//				}
				
				
//				String mess = in.readLine();
				
//				System.out.println("CLIENT: Enter a message:");
//				String mess = inBuff.readLine();
//				out.println(mess);
//				System.setOut(new PrintStream(stdout));
//				System.out.println("CLIENT: Listening");
//				String mes = in.readLine();
//				System.out.println("CLIENT: " + mes.length());
//				System.out.println("CLIENT: " + mes);
//				if ("!@#CHAT".equals(mes)){
//					gc.get_board().getArea().append(mes + "\n");
//					gc.get_board().getArea()
//				}
//				System.setOut(new PrintStream(sock.getOutputStream()));
				
			}
		}
		catch(Exception e){
			System.out.println("CLIENT ABALONE: usage of socket" + e.getMessage());
		}
		
	};
	public void setGC(GameController g){
		gc=g;
		Thread th_chat = new Thread(new ClientChat(in, gc.get_board().getArea()),"CLIENTCHAT");
		th_chat.start();
		
	}
	public BufferedReader get_in(){
		return in;
	}
	public PrintWriter get_out(){
		return out;
	}
	
	public Socket get_sock(){
		return sock;
	}
	
}
