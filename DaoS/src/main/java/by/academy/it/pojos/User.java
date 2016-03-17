package by.academy.it.pojos;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = ("user"))
public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role_id=" + role_id + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
	private int id;
	@Column(name="username")
	@Size(min = 2, max = 20, 
	message="E-mail must be between 2 and 20 characters long.")
	private String username;
	@Column(name="password")
	@Size(min = 2, max = 20, 
	message="Password must be between 2 and 20 characters long.")
	private String password;
	@Column(name="role_id")
	private String role_id;

	public User() {
	}

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

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
}
