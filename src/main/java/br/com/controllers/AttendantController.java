package br.com.controllers;

import br.com.models.Attendant;
import br.com.models.User;

public class AttendantController extends Conn implements Crud{

	int user; 
	Attendant att;
	
	public AttendantController(int user_id) {
		this.user = user;
	}
	
	public AttendantController() {
		
	}
	
	public void create() {
		
		att = new Attendant(false, user);
		em.getTransaction().begin();
		em.persist(att);
		em.getTransaction().commit();
	}

	public void read(int id) {
		
		
	}

	public void readAll() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void updateStateAvailable() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void read() {
		// TODO Auto-generated method stub
		
	}

}
