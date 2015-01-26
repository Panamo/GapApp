package client;

public class LeJIn extends Command{ //TODO check chats and decide the verb

	User user;
	Chat chat;
	
	public LeJIn(User user, Chat chat) {
		
		this.user = user;
		this.chat = chat;

		if (sender.getID().equals(user.getID())) {
			
			
		} else {
			
			
		}
	}
}
