package client;

import java.io.IOException;

public class LeJIn extends Command {

	private User user;
	private Chat chat;
	
	public LeJIn(User user, Chat chat, Client sender) throws IOException {
		
		setSender(sender);
		this.user = user;
		this.chat = chat;

		if (sender.getID().equals(user.getID())) {
			
			if (chat.isMember(user))
				setVerb("leave");
			else
				setVerb("join");
			
			sender.sendToServer(this);
		} else {
			if (!chat.isMember(user)) {
				setVerb("add");
				sender.sendToServer(this);
			}
		}
	}

	protected User getUser() {
		return user;
	}

	protected void setUser(User user) {
		this.user = user;
	}

	protected Chat getChat() {
		return chat;
	}

	protected void setChat(Chat chat) {
		this.chat = chat;
	}
}
