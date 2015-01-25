package client;

public class Command {

	User sender;
	String verb;
	
	private User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	private String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
}
