package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Aplication {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Client me = new Client("navid", "msk", new Socket("192.168.169.199", 1371));
		me.signIn("pass");
		User user = new User("mrma95", "chapal");
		Chat chat = new Chat(user.getID(), user.getName());
		me.addToChat(chat);
		chat.addToMembers(user);
		chat.addToMembers(me);
		me.openFront();
	}
}