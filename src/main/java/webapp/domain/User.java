package webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	private int id;
	private String username;
	private String password;

	public User() {
	}
	
	public User(String username, String password) {
		this(0, username, password);
	}
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return String.format("[%d, %s, %s]", id, username, password);
	}
}
