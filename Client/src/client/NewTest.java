package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Client me = new Client(new Socket("192.168.169.199", 1373));
		me.setName("navid");
		me.setID("kapak");
		SignIn si = new SignIn("chapal", me);
		me.sendToServer(si);
		User user = new User();
		user.setID("chapal");
		user.setName("mrma95");
		Chat chat = new Chat(user.getID(), user.getName());
//		Chat chat = new Chat("group", "group");
		me.addToChat(chat);
		chat.addToMembers(user);
		chat.addToMembers(me);
		me.openFront();
	}
}