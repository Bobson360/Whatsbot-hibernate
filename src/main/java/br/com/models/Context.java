package br.com.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Context {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String context;

	@Temporal(TemporalType.DATE)
	Date createdAt;

	public Context(Long id, String context, Date createdAt) {
		super();
		this.id = id;
		this.context = context;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Context [id=" + id + ", context=" + context + ", createdAt=" + createdAt + "]";
	}
}
