package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class User {
	private MainFrame frame = null;
	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	String ID = null;
	Socket serverSocket = null;
	RecieveThread recieve = null;
	public void setRecieve(RecieveThread recieve) {
		this.recieve = recieve;
		recieve.start();
	}

	public User(String ID,Socket serverSocket){
		this.serverSocket = serverSocket;
		this.ID = ID;
	}
	
	public void sendToServer(String text) throws IOException{
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
		out.println(text);
		out.flush();
	}
}