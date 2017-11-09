package controller;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
	
	public static void main(String args[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		
		// Socket für eingehende Anfragen anlegen (Port 6789)
		ServerSocket serverSocket = new ServerSocket(6789);
		
		while(true) {
			// An diesem Socket auf Anfragen von Clients warten
			Socket socket = serverSocket.accept();
			
			// Eingabestrom anlegen, mit Socket verbinden
			Scanner inFromClient = new Scanner(socket.getInputStream());
			
			// Ausgabestrom anlegen, mit Socket verbinden
			PrintStream outToClient = new PrintStream(socket.getOutputStream());
			
			// Zeile vom Socket lesen
			clientSentence = inFromClient.nextLine();
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			
			// Zeile an Client schicken
			outToClient.println(capitalizedSentence);
			
			// Ausgabe des Textes vom Client
			System.out.println(clientSentence); 
			
			socket.close();
			
		}
	}

}
