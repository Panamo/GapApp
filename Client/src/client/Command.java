package client;

public class Command {

	private Client sender;
	private String verb;
	
	Client getSender() {
		return sender;
	}
	public void setSender(Client sender) {
		this.sender = sender;
	}
	String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
}
