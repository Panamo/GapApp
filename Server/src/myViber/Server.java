package myViber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.xml.ws.spi.http.HttpHandler;

public class Server extends Thread {
	static final int PORT = 1234;
	public static ArrayList<User> users = new ArrayList<>();
	public void run() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();

		}
		
		while (true) {
			try {
				socket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				String line = in.readLine();
				users.add(new User(line,socket));
				users.get(users.size() - 1).setRecieve(new RecieveThread(users.get(users.size() - 1))); // new RecieveThread for a client
				System.out.println(line + " connected!!");
				
//				for(int i = 0; i<users.size(); i++){
//					users.get(i).writeToUser("onlines:");
//					users.get(i).writeToUser(Integer.toString(users.size()));
//					for(int j = 0; j<users.size(); j++){
//						if (! users.get(i).equals(users.get(i)))
//							users.get(i).writeToUser(users.get(j).getID());
//					}
//				}
				
			} catch (IOException e) {
				System.out.println("I/O error: " + e);
			}
		}
	}

}