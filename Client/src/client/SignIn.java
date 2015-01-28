package client;

import java.io.IOException;

public class SignIn extends Command {
	
	String pass;
	
	SignIn(String pass, Client client) throws IOException {
		if (client.getSihnIn()) {
			setVerb("signin");
			client.SignIn(pass);
		} else {
			setVerb("signout");
			client.SignOut();
		}
		this.pass = pass;
		setSender(client);
	}
	
	String getPass() {
		return pass;
	}
}
