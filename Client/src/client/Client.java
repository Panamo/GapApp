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

	private String privateUUID;
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

		if (cmd.verb.equals("send")) {
			msg = cmd.verb + " " + ((Message) cmd).getReceiver().getID() + " "
					+ privateUUID + " "
					+ ((Message) cmd).getData().getBytes().length + "\n"
					+ ((Message) cmd).getData();
		} else {
			msg = cmd.verb + " " + ((LeJIn) cmd).getChat().getID() + " " + privateUUID + " 0";
		}

		 PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
		 out.println(msg);
		 out.flush();
	}

}
