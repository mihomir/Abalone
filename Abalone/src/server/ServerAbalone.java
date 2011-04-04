package server;
import controller.*;
import view.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;


public class ServerAbalone implements Runnable{
	
	DrawMain dm;
	
	ServerSocket server; 
	Socket sock;
	int serv_port;
	GameController gc;
	static final int PORT=1500;
	public ServerAbalone(DrawMain d, int port){
		dm=d;
		serv_port=port;
		try{
			server = new ServerSocket(serv_port);
			
			
			
//			BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
//			String str = inBuff.readLine();
//			int i = Integer.valueOf(str).intValue();
//			
//			server=new ServerSocket(i);
//			sock=server.accept();
//			
//			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(sock.getOutputStream())),true);
		}
		catch (IOException i){
			System.out.println("SERVERSOCKET: IOEXCEPTION" + i.getMessage());
		}
		
	}
	public void run(){
		try{
			sock = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(sock.getOutputStream())),true);
			
			System.setOut(new PrintStream(sock.getOutputStream()));
			
			while(true){
				System.out.println("SERVER: Listening");
				String mes = in.readLine();
				System.out.println("SERVER: " + mes.length());
				System.out.println("SERVER: " + mes);
//				System.out.println("1".equals(mes));
//				System.out.println(mes=="1\n");
				if ("!@#START1".equals(mes)){
					System.out.println("SERVER: try to start");
					ActionGameStart start = new ActionGameStart("test123", dm, new JDialog(), "Human-Human", true);
					start.actionPerformed(new ActionEvent(this, 123, "Hello World"));

				}
				if ("!@#START2".equals(mes)){
					System.out.println("SERVER: try to start");
					ActionGameStart start = new ActionGameStart("test123", dm, new JDialog(), "Human-Ordinateur", true);
					start.actionPerformed(new ActionEvent(this, 123, "Hello World"));
				}
				if ("!@#NOM".equals(mes)){
					gc.get_game().get_players().get(0).set_name(mes);
				}
				if ("!@#CHAT".equals(mes)){
					gc.get_board().getArea().append(mes + "\n");
				}
			}
		}
		catch (IOException i){
			System.out.println("SERVERSOCKET: IOEXCEPTION " + i.getMessage());
		}
	}
	
	public void setGC(GameController g){
		gc=g;
	}
	
	
}
