package server;
import java.io.*;
import java.net.*;

public class ServerAbalone{
	
	ServerSocket server; 
	Socket sock;
	static final int PORT=1500;
	ServerAbalone(){
		
	
		try{
			server = new ServerSocket(PORT);
//			sock = server.accept();
			
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
			System.out.println("SERVERSOCKET: IOEXCEPTION");
		}
	}
	
	
	
}
