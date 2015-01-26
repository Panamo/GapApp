package client;

import java.io.IOException;

public class Message extends Command {

	private User receiver;
	private String data;
	
	public Message(Client sender, User receiver, String data) throws IOException {
		
		this.sender = sender;
		this.receiver = receiver;
		this.data = data;
		verb = "send";
		sender.sendToServer(this);
	}

	User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
