package br.com.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import br.com.models.User;

public class UserController implements Crud<User>{

	static SessionFactory factory;
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	static EntityManager em;

	public void  savedd(User user) throws SQLIntegrityConstraintViolationException {
		em = emf.createEntityManager();
		List<User> u = em.createQuery("from User where celNumber = '" + user.getCelNumber() + "'", User.class)
				.getResultList();

		if (u.size() == 0) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			System.out.println(user + ": Save with success");
		} else {
			throw new SQLIntegrityConstraintViolationException("Duplicate entry '"+user.getCelNumber()+ ". Try using the Update or Delete methods ");
		}
	}

	public User save(User user) throws SQLIntegrityConstraintViolationException {
		em = emf.createEntityManager();
		List<User> u = em.createQuery("from User where celNumber = '" + user.getCelNumber() + "'", User.class)
				.getResultList();

		if (u.size() == 0) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			System.out.println(user + ": Save with success");
			return user;
		} else {
			throw new SQLIntegrityConstraintViolationException("Duplicate entry '"+user.getCelNumber()+ ". Try using the Update or Delete methods ");
		}
	}
	
	public User find(int id) {
		em = emf.createEntityManager();
		User user = em.createQuery("from User where id = '" + id + "'", User.class)
				.getSingleResult();
		return user;
	}


	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public User update(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void destroy(int id) {
		// TODO Auto-generated method stub
		
	}




	
}
