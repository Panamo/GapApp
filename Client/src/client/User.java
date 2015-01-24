package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class User {
	static int count = 0;
	private FrontFrame frame = null;
	public FrontFrame getFrame() {
		return frame;
	}
	
	private ArrayList<Chat> chats = new ArrayList<Chat>();
	
	public void setFrame(FrontFrame frame) {
		this.frame = frame;
	}

	String ID = null;
	private String publicUUID;
	private String privateUUID;
	Socket serverSocket = null;
	RecieveThread recieve = null;
	public void setRecieve(RecieveThread recieve) {
		this.recieve = recieve;
		this.recieve.start();
	}

	public User(Socket serverSocket){
		if (count == 0){
			this.serverSocket = serverSocket;
			//this.ID = ID;
			count++;
		}
	}
	
	public void sendToServer(String verb,String msg, String destID) throws IOException{
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
		int size = msg.getBytes().length;
		out.println(verb + " " + destID + " " + size + "\n" + msg);
		out.flush();
	}
}
