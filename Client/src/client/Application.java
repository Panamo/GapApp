package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Application {

	public static void main(String[] args) throws UnknownHostException, IOException {
		User user = new User();
		user.setID("kapak");
		user.setName("navid");
		Chat chat = new Chat("group","group");
		chat.addToMembers(user);
		Client c = new Client(new Socket("localhost",1373));
		c.addToChat(chat);
		c.name = "mrma95";
		c.setID ("chapal");
		chat.addToMembers(c);
		c.openFront();
		
	}

}
