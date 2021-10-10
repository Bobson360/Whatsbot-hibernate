package br.com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(nullable = false)
	@Type(type="text")
	String text;
	
	@ManyToOne
    @JoinColumn(name = "user_from_id", referencedColumnName = "id")
	User from;
	
	@ManyToOne
	@JoinColumn(name = "user_to_id", referencedColumnName = "id")
	User to;
	
	@Temporal(TemporalType.DATE)
	Date createdAt;

	public Message(String text, User from, User to) {
		super();
		this.text = text;
		this.from = from;
		this.to = to;
		this.createdAt = new Date(System.currentTimeMillis());
	}
	
	public Message() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", from=" + from + ", to=" + to + ", createdAt=" + createdAt
				+ "]";
	}
	

}