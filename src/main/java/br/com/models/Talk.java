package br.com.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Talk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "context_id", referencedColumnName = "id")
	Context ctx;
	
	@ManyToOne
	@JoinColumn(name = "attendant_id", referencedColumnName = "id")
	Attendant attendant;
	
	boolean active;
	
	@Temporal(TemporalType.DATE)
	Date createdAt;
	
	public Talk(Long id, Context ctx, Attendant attendant, boolean active, Date createdAt) {
		super();
		this.id = id;
		this.ctx = ctx;
		this.attendant = attendant;
		this.active = active;
		this.createdAt = createdAt;
	}

	public Talk(Long id, Context ctx, boolean active, Date createdAt) {
		super();
		this.id = id;
		this.ctx = ctx;
		this.active = active;
		this.createdAt = createdAt;
	}
	
	public Talk(Long id, Context ctx, Date createdAt) {
		super();
		this.id = id;
		this.ctx = ctx;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	public Attendant getAttendant() {
		return attendant;
	}

	public void setAttendant(Attendant attendant) {
		this.attendant = attendant;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Talk [id=" + id + ", ctx=" + ctx + ", attendant=" + attendant + ", active=" + active + ", createdAt="
				+ createdAt + "]";
	}

}
