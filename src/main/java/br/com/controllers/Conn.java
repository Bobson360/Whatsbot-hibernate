package br.com.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Conn {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
	static EntityManager em = emf.createEntityManager();
}
