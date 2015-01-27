package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	Client me;
	User user;

	public static void main(String[] args) throws UnknownHostException, IOException {

		String msg = "";
		Socket serverSocket = new Socket("192.168.169.128", 1373);
		PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
		
		msg = "send" + " " + "hello!" + " "
				+ "hi!!!!" + " "
				+ "salam".getBytes().length + "\n"
				+ "salam";
		
		out.println(msg);
		out.flush();
	}

}
