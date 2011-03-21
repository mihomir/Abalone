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
			while(true){
				System.out.println("Listening");
				String mes = in.readLine();
				System.out.println(mes.length());
				System.out.println("1".equals(mes));
				System.out.println(mes=="1\n");
				if ("!@#start".equals(mes)){
					System.out.println("try to start");
					ActionGameStart start = new ActionGameStart("test123", dm, new JDialog(), "Human-Human", true);
					start.actionPerformed(new ActionEvent(this, 123, "Hello World"));
				}
			}
		}
		catch (IOException i){
			System.out.println("SERVERSOCKET: IOEXCEPTION " + i.getMessage());
		}
	}
	
	
	
}
