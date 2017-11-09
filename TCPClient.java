package controller;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
	
	public static void main(String args[]) throws Exception {
		String hostname = "localhost";
		String sentence;
		String modifiedSentence;
		
		// Eingabestrom anlegen, Satz vom Nutzer holen
		Scanner inFromUser = new Scanner(System.in);
		sentence = inFromUser.nextLine();
		
		// Client-Socket anlegen, mit dem Server verbinden
		Socket socket = new Socket(hostname, 6789);
		
		// Ausgabestrom anlegen, mit Socket verbinden
		PrintStream outToServer = new PrintStream(socket.getOutputStream());
		
		// Eingabestrom anlegen, mit Socket verbinden
		Scanner inFromServer = new Scanner(socket.getInputStream());
		
		// Zeile an Server schicken
		outToServer.println(sentence + '\n');
		
		// Zeile von Server lesen
		modifiedSentence = inFromServer.nextLine();
		
		System.out.printf("FROM SERVER: %s", modifiedSentence);
		
		socket.close();
	}

}
