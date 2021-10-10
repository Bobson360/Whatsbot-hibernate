package br.com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
//@Table(uniqueConstraints = { @UniqueConstraint( columnNames = { "celNumber"}) })
public class User implements Models{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String name;
	
	@Column(nullable = false)
	String celNumber;
	
//	@Temporal(TemporalType.DATE)
	Date createdAt;
	
	
	public User(String name, String celNumber) {
		super();
		this.name = name;
		this.celNumber = celNumber;
		this.createdAt = new Date(System.currentTimeMillis());
	}
	
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCelNumber() {
		return celNumber;
	}

	public void setCelNumber(String celNumber) {
		this.celNumber = celNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", celNumber=" + celNumber + ", createdAt="
				+ createdAt + "]";
	}

}
