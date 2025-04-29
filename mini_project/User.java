package Model;

public class User {
	private String username;
	private String role;
	public User(String username, String role) {
		this.username = username;
		this.role = role;
	}
	public String Username() {
		return username;
	}
	public String Role() {
		return role;
	}
}
