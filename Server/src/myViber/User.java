package myViber;

import java.io.PrintWriter;
import java.net.Socket;

public class User {
	private String ID = null;
	RecieveThread recieve;
	private Socket clientSocket;


	public Socket getClientSocket() {
		return clientSocket;
	}


	public User(String ID, Socket socket) {
		this.ID = ID;
		clientSocket = socket;
	}

	public void setRecieve(RecieveThread recieve) {
		this.recieve = recieve;
		recieve.start();
	}

	public String getID() {
		return ID;
	}
	
	public String toString() {
		return "User [ID=" + ID + ", clientSocket=" + clientSocket + "]";
	}

	public void writeToUser(String text) {
		PrintWriter out;
		try {
			out = new PrintWriter(clientSocket.getOutputStream());
			out.println(text);
			out.flush();
			System.out.println("Sending " + text + " to " + ID);
		} catch (Exception e) {
			System.out.println("Error in sending message to " + toString());
			System.out.println(e.toString());
		}
	}

}
