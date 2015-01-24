package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Scanner input = new Scanner(System.in);
		String id = input.nextLine();
		input.close();
		User user1 = new User(id, new Socket("localhost", 1234));
		user1.sendToServer(user1.ID);
		MainFrame frame = new MainFrame(user1);
		frame.setTitle(id);
		frame.setVisible(true);
		user1.setFrame(frame);
		user1.setRecieve(new RecieveThread(user1));	
	}
}