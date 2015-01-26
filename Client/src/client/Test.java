package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	Client me;
	User user;
	
	Test() throws UnknownHostException, IOException {
		
		me = new Client(new Socket("192.168.169.160", 1373));
		
		
	}
	
	public static void main(String[] args) {

	}

}
