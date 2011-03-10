package server;

import java.io.*;
import java.net.*;
import java.io.*;
public class ClientTest{
	public static void main(String [] args) {
		Socket comsock;
		try {
			
			BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Veuillez entrer le numero de port sur lequel on ecoute : ");
			String str = inBuff.readLine();
			int i = Integer.valueOf(str).intValue();
			
			System.out.println("Veuillez entrer le nom de la machine a laquelle se connecter : ");
			str = new String(inBuff.readLine());
			
			// le port sur lequel on ecoute et le nom
			// de la machine distante sont en parametre du constructeur
			comsock=new Socket(str,i);
			System.out.println("connexion etablie");
			// on cree les streams
			
			BufferedReader in = new BufferedReader( new InputStreamReader (comsock.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter (comsock.getOutputStream())),true);
		
			System.out.println("creation des IOStream...");
			while (true) {
				System.out.println("Enter a message:");
				String mess = inBuff.readLine();
				out.println(mess);
			}
//			out.println("hello............."); 
		}
		catch(UnknownHostException e1){
			System.out.println(e1.getMessage());
		}
		catch (IOException E2){
			System.out.println("connexion ratee... redemarrez le serveur!"); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			} 
	}
}

