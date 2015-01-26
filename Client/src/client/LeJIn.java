package client;

public class LeJIn extends Command {

	User user;
	Chat chat;
	
	public LeJIn(User user, Chat chat) {
		
		this.user = user;
		this.chat = chat;

		if (sender.getID().equals(user.getID())) {
			
			if (chat.isMember(user))
				verb = "leave";
			else
				verb = "join";
			
			Client.sendToServer(this);
		} else {
			if (!chat.isMember(user)) {
				verb = "add";
				Client.sendToServer(this);
			}
		}
	}
}
