package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Client me = new Client(new Socket("192.168.169.128", 1373));
		me.setName("navid");
		me.setID("kapak");
		User user = new User();
		user.setID("chapal");
		user.setName("mrma95");
		Chat chat = new Chat("group", "group");
		chat.addToMembers(user);
		chat.addToMembers(me);
		me.openFront();
	}
}