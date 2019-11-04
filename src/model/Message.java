package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Message {
	@Id
	@GeneratedValue(generator="id_gen")
	@GenericGenerator(name="id_gen", strategy="uuid2")
	private String id;
	
	private String msg;
	private Date postedDate;
	@OneToOne
	@JoinColumn(name="user")
	private User u;
	
	
	public Message() {
	}


	public Message(String id, String msg, Date postedDate, User u) {
		super();
		this.id = id;
		this.msg = msg;
		this.postedDate = postedDate;
		this.u = u;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Date getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


	public User getU() {
		return u;
	}


	public void setU(User u) {
		this.u = u;
	}
	
	
}
