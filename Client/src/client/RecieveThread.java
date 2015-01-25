package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecieveThread extends Thread {

	private Client client;

	public RecieveThread(Client user) {
		this.client = user;
	}

	public void run() {
		BufferedReader in;
		
		try {
			in = new BufferedReader(new InputStreamReader(
					client.serverSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String text;
		while (true) {
			// get the received stream
			// who is sender?
			// if sender's frame is open -> show in frame
			// else save in a txt file for later use

		}

	}

}
