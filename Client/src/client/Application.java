package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		//These should be set later:
		final String dbServer = null; 
		final int dbPort = 0;
		final String mainServer = null; 
		final int mainPort = 0;

		//1. Connect to DB server
		Socket dbSocket = new Socket(dbServer,dbPort);
		
		//2. Authentication and getting UUIDs
		
		//3. Connect to main server
		
		User user1 = new User(new Socket(mainServer, mainPort)); // I'll change constructor to set UUIDs and dbPort here
		FrontFrame frame = new FrontFrame(user1);
		frame.setTitle("GapApp");
		frame.setVisible(true);
		user1.setFrame(frame);
		user1.setRecieve(new RecieveThread(user1));	
	}
<<<<<<< HEAD
	
	

}
=======
}
>>>>>>> da6058e423023250c4405b7628900516bb3aad51
