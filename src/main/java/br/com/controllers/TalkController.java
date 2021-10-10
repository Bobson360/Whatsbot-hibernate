package br.com.controllers;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.models.Attendant;
import br.com.models.User;

public class TalkController {
	
    static EntityManagerFactory emf;
    static EntityManager em;
	
	public TalkController(User from, User to, String text) {
		
	}
	
	public TalkController() {
		
	}
	
	public static void main(String[] args) { 		
		
//		emf = Persistence.createEntityManagerFactory("exemplo-jpa");
//		em = emf.createEntityManager();
//	Attendant attendant = em.createQuery("SELECT FROM Attendants WHERE id = 1", Attendant.class).getSingleResult();
//		TalkController tk = new TalkController();
		
		User cliente = new User("Robson", "11933417690");
		User cliente2 = new User("Robson", "11933417690");
		
		UserController u1 = new UserController();
		
		try {
			u1.create(cliente);
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		try {
			u1.create(cliente2);
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
//		User att = new User("Cris", "11987158777");
//		User ROBOT = new User("ROBOT", "DEFALT");
//		em.getTransaction().begin();
		
		
//		Attendant at = new Attendant(true, ROBOT);
//		em.persist(ROBOT);
//		em.persist(cliente);
//		em.persist(cliente2);
//		em.persist(att);
//		em.persist(at);
//		
//		em.getTransaction().commit();
		
		
	}

}
