package client;

import java.util.ArrayList;

public class Chat { 
	
	private String ID;
	private String name;
	private boolean isGroup;
	private ArrayList<User> members;

	private ChatFrame frame;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void openFrame(){
		frame = new ChatFrame(this);
		frame.setVisible(true);
	}
	
	void addToMembers(User user) {
		
		members.add(user);
	}
	
	void removeFromMembers(User user) {
		
		members.remove(user);
	}
	
	void setIsGroup() {
		
		if (members.size() > 2) {
			isGroup = true;
		} else {
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
}
