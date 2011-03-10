package server;

import java.io.*;
import java.net.*;
public class ServerTest {
	public static void main(String [] args) {
		ServerSocket server;
		Socket comsock;
		try {
			System.out.println("Veuillez entrer le numero de port sur lequel ecouter : ");
			
			BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
			String str = inBuff.readLine();
			System.out.println("port: " + Integer.valueOf(str).intValue());
			int i = Integer.valueOf(str).intValue();
			
			//creation de la socket serveur
			server=new ServerSocket(i);
			System.out.println("created socket");
			//acceptation de la connection
			comsock=server.accept();
			System.out.println("accepted connection");
			System.out.println("connexion etablie");
			
			//creation des streams
			BufferedReader in = new BufferedReader(new InputStreamReader(comsock.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(comsock.getOutputStream())),true);
			
			System.out.println("creation des IOStream...");
			while(true){
				String mes = in.readLine();
				System.out.println("Message:" + mes);
			}
		}
		//les streams sont definies et pretes a etre utilisees
		catch(Exception e){System.out.println("message 2:"+e.getMessage());}
	}
}



