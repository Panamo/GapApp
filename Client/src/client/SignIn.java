package client;

public class SignIn extends Command {

	String pass;
	
	SignIn(String pass, Client client) {
		setVerb("signin");	
		setSender(client);
		this.pass = pass;
	}
	
	String getPass() {
		return pass;
	}
}
