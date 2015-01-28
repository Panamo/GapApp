package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.UUID;

public class Application {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO First opening of Application:
		/* 
		 * 
		 */
		
		// TODO A structural opening for Application(My idea):
		/* 1. open the serialized client  
		 * 2. sign-in (join) to the server
		 * 3. start texting
		 */
		User user = new User();
		user.setID("kapak");
		user.setName("navid");
		Chat chat = new Chat("group","group");
		chat.addToMembers(user);
		Client c = new Client(new Socket("localhost",1373));
		c.name = "mrma95";
		c.setID ("chapal");
		//String ID = UUID.randomUUID().toString();
		//System.out.println(ID + " generated!!");
		//c.setID(ID);
		c.addToChat(chat);
		chat.addToMembers(c);
		c.openFront();
	}

}
