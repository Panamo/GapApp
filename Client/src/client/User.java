package client;

public class User {

	String name;
	String ID;
	String publicUUID;
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getID() {
		return ID;
	}
	void setID(String iD) {
		ID = iD;
	}
	String getPublicUUID() {
		return publicUUID;
	}
	void setPublicUUID(String publicUUID) {
		this.publicUUID = publicUUID;
	}
}