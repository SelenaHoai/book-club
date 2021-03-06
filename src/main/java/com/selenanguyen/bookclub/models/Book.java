package com.selenanguyen.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="books")
public class Book {
	
	// ========= Primary Key ==========
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // ========= Member Variables ==========
    @Size(min=2, message="Title must not be blank.")
    private String title;
    
    @Size(min=2, message="Author must not be blank.")
    private String author;
    
    @Size(min=2, message="Thoughts must not be blank.")
    private String myThoughts;
    
    // ========= Data Creation Trackers ==========
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // ========= Relationships ==========
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
   
    // ========= Data Creation Event ==========
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
    
    // ========= Constructors ==========
    public Book() {}
    
    // ========= Getters and Setters ==========
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getMyThoughts() {
		return myThoughts;
	}
	
	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}  

}
