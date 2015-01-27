package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Chat {

	private String iD;
	private String name;
	private boolean isGroup;
	private ArrayList<User> members;
	private ArrayList<Message> messages;

	public Chat(String ID, String name) {
		this.name = name;
		this.iD = ID;
		members = new ArrayList<User>();
	}

	public ArrayList<User> getMembers() {
		return members;
	}

	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void addToMembers(User user) {

		members.add(user);
	}

	void removeFromMembers(User user) {

		members.remove(user);
	}

	boolean isMember(User user) {

		if (members.contains(user))
			return true;
		return false;
	}

	void setIsGroup() {

		if (members.size() > 2)
			isGroup = true;
		else {
			if (members.size() == 2)
				isGroup = false;
			else {
				// TODO remove chat from asghar
			}
		}
	}

	boolean getIsGroup() {
		return isGroup;
	}

	void writeMessageInFile(String senderID, String msg) throws IOException {

		File file = new File(iD);

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				file, true)));

		String s = "{\n" + senderID + "\n" + msg + "\n}";

		pw.println(s);
		pw.flush();
		
		messages.add(new Message(senderID, msg));
		
		//TODO view new message in frame (Chapal work)
	}

	void readFile() throws FileNotFoundException {
		
		File file = new File(iD);
		
		Scanner sc = new Scanner(file);
		messages = new ArrayList<Message>();
		
		while (sc.hasNext()) {
			
			if (sc.nextLine().equals("{")) {
				String senderID = sc.nextLine();
				String msg = "";
				String s = sc.nextLine();
				while (!s.equals("}")) {
					msg += s + "\n";
					s = sc.nextLine();
				}
				messages.add(new Message(senderID, msg));
			}
		}
	}
}