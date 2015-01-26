package client;

import java.io.IOException;
import java.io.PrintWriter;
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

	private String ID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	Socket serverSocket;
	RecieveThread rt;

	public Client(Socket serverSocket) {
		if (count == 0) {
			this.serverSocket = serverSocket;
			rt = new RecieveThread(this);
			rt.start();
			count++;
		}
	}

	public void sendToServer(Command cmd) throws IOException {

		String msg = "";

		if (cmd.getVerb().equals("send")) {
			msg = cmd.getVerb() + " " + cmd.getReceiver().getID()
					+ " " + ID + " "
					+ ((Message) cmd).getData().getBytes().length + "\n"
					+ ((Message) cmd).getData();
		} else {
			msg = cmd.getVerb() + " " + cmd.getReceiver().getID() + " "
					+ ((LeJIn) cmd).getUser().getID() + " 0";
		}

		PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
		out.println(msg);
		out.flush();
	}

	void addToChat(Chat chat) {
		chats.add(chat);
	}
	
	ArrayList<Chat> getChats() {
		return chats;
	}
	
	public void openFrame(Chat chat){
		new ChatFrame(this,chat).setVisible(true);
	}
	public void openFront(){
		frame=new FrontFrame(this);
		frame.setVisible(true);
	}
}
