package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import view.DrawMain;

public class ClientAbalone implements Runnable{
	
	DrawMain dm;
 
	Socket sock;
	int serv_port;
	String serv_name;
	static final int PORT=1500;
	public ClientAbalone(DrawMain d, String name, int port){
		dm=d;
		serv_name=name;
		serv_port=port;
		try{
			sock = new Socket(serv_name, serv_port);
		}
		catch(Exception e){
			System.out.println("CLIENT ABALONE: creation of socket" + e.getMessage());
		}
	}
	public void run(){
		try{
			BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader( new InputStreamReader (sock.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter (sock.getOutputStream())),true);
			System.setOut(new PrintStream(sock.getOutputStream()));

			while (true) {
//				String mess = in.readLine();
				
				System.out.println("CLIENT: Enter a message:");
				String mess = inBuff.readLine();
				out.println(mess);
			}
		}
		catch(Exception e){
			System.out.println("CLIENT ABALONE: usage of socket" + e.getMessage());
		}
		
	};
	
}
