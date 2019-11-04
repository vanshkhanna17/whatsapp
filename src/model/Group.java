package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Group {
	@Id
	@GeneratedValue(generator="id_gen")
	@GenericGenerator(name="id_gen", strategy="uuid2")
	private String id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> ul;
	
	@OneToMany
	private List<Message> ml;
	private String name;
	private String createdBy;
	public Group() {
		
	}
	public Group(String gname, String createdBy,List<User> ul, List<Message> ml) {
		super();
		this.name = gname;
		this.ul = ul;
		this.ml = ml;
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String gname) {
		this.name = gname;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<User> getUl() {
		return ul;
	}

	public void setUl(List<User> ul) {
		this.ul = ul;
	}

	public List<Message> getMl() {
		return ml;
	}

	public void setMl(List<Message> ml) {
		this.ml = ml;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
