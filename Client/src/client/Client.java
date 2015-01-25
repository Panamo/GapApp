package client;

import java.net.Socket;
import java.util.ArrayList;

public class Client extends User {
	static int count = 0;
	private FrontFrame frame;
	private ArrayList<Chat> chats = new ArrayList<Chat>();

	public FrontFrame getFrame() {
		return frame;
	}

	public void setFrame(FrontFrame frame) {
		this.frame = frame;
	}

	private String privateUUID;
	Socket serverSocket;
	RecieveThread rt;

	public Client(Socket serverSocket) {
		if (count == 0) {
			this.serverSocket = serverSocket;
			rt = new RecieveThread(this);
			rt.start();
			// this.ID = ID;
			count++;
		}
	}

	// public void sendToServer(Message msg, String ver) throws IOException{
	// PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
	// int size = msg.getBytes().length;
	// out.println(verb + " " + destID + " " + size + "\n" + msg);
	// out.flush();
	// }

}
