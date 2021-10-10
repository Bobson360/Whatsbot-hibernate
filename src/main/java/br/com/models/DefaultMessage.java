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
public class DefaultMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "context_id", referencedColumnName = "id")
	Context context;

	@Column(nullable = false)
	@Type(type="text")
	String message;
	
	@Temporal(TemporalType.DATE)
	Date createdAt;
	
	
}
