package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator="id_gen")
	@GenericGenerator(name="id_gen", strategy="uuid2")
	String id;

	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Message> ml;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="group")
	private List<Group> gl;
	

	public User() {
		}
	public User(String name, String email, String password, List<Message> ml) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.ml = ml;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Group> getGl() {
		return gl;
	}
	public void setGl(List<Group> gl) {
		this.gl = gl;
	}
	public List<Message> getMl() {
		return ml;
	}
	public void setMl(List<Message> ml) {
		this.ml = ml;
	}
	
}
