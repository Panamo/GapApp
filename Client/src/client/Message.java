package client;

public class Message extends Command {

	private User receiver;
	private String data;
	
	public Message(User sender, User receiver, String data) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.data = data;
		verb = "send";
		Client.sendToServer(this);
	}

	private User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	private String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
