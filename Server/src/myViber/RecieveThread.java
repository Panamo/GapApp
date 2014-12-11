package myViber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecieveThread extends Thread {
	
	private User user;

	public RecieveThread(User user) {
		this.user = user;
	}

	public void run() {
		BufferedReader in = null;

		try {
			in = new BufferedReader(new InputStreamReader(user
					.getClientSocket().getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String text;
		while (true) {
			try {
				text = in.readLine();
				//System.out.println("recieved: " + "'" + text + "'");
				//String destID = in.readLine();
				for (User user : Server.users) {
					if (!user.equals(this.user))
						user.writeToUser(text);
				}
				//System.out.println(user.getID() + " sent: " + text + " to " + destID);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
