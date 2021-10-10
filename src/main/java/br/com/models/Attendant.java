package br.com.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	boolean available;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	User user;
	
	@Temporal(TemporalType.DATE)
	Date lastUpdate;
	
	public Attendant(boolean available, User user) {
		super();
		this.user = user;
		this.available = available;
		this.lastUpdate = new Date(System.currentTimeMillis());
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Attendant [id=" + id + ", available=" + available + ", user=" + user + ", lastUpdate=" + lastUpdate
				+ "]";
	}
}
