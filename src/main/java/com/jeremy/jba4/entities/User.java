package com.jeremy.jba4.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.jeremy.jba4.annotations.UniqueUsername;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, message="Name must be at least 3 characters!")
	@Column(unique=true)
	@UniqueUsername(message = "Such username already exists!")
	private String name;
	@Size(min=1, message="Invalid email address")
	@Email(message="Invalid email address")
	private String email;
	@Size(min=5, message="Password must be at least 5 characters!")
	private String password;
	
	private boolean enabled;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	
	
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Blog> blogs;

	
	





	




	public byte[] getPhoto() {
		return photo;
	}





	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}





	public String getNomPhoto() {
		return nomPhoto;
	}





	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}





	public List<Role> getRoles() {
		return roles;
	}

	
	
	
	
	public boolean isEnabled() {
		return enabled;
	}





	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	public List<Blog> getBlogs() {
		return blogs;
	}





	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}





	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
