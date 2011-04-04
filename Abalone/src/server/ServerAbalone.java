package server;
import controller.*;
import view.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

import model.Field;
import model.Position;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class ServerAbalone implements Runnable{
	
	DrawMain dm;
	
	ServerSocket server; 
	Socket sock;
	int serv_port;
	GameController gc;
	static final int PORT=1500;
	
	BufferedReader in;
	PrintWriter out;
	
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
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(sock.getOutputStream())),true);
			
//			System.setOut(new PrintStream(sock.getOutputStream()));
			
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
				if (mes.matches("!@#CHAT.*")){
					
					String[] splitString = (mes.split("!@#CHAT"));
					System.out.println(splitString.length);// Should be 14
//					for (String string : splitString) {
//						System.out.println(string);
//						gc.get_board().getArea().append(string + "\n");
//					}
//					String chatm= mes.split("!@#CHAT").toString();
//					System.out.println("chatmessage: "+chatm);
					gc.get_board().getArea().append("Client: " + splitString[1]+"\n");
				}
				
				if ("!@#MOVE".equals(mes)){
					MouseClicker mouse = new MouseClicker(gc, gc.get_board(), true);
//					mouse.mouseClicked(new MouseEvent());
					Field finalfield;
					for (Field f: gc.get_board().get_drawfields().keySet())
						{
							if (f.get_position()== new Position(1,2)){
								finalfield=f;
							}
						}
					System.out.println(mes.matches("!@#MOVE(\\w\\d,){1,3}\\w\\d"));
					String[] splitString = (mes.split("!@#MOVE"));
					System.out.println(splitString.length);// Should be 14
					for (String string : splitString) {
						System.out.println(string);
					}
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
