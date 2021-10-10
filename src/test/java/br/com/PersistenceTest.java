package br.com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.models.Attendant;
import br.com.models.Message;
import br.com.models.User;




public class PersistenceTest {

    static EntityManagerFactory emf;
    static EntityManager em;
    
    @BeforeAll
    public static void before() {

    	emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    	em = emf.createEntityManager();
	}

    @Test
    public void saveMessage() {
    	
		em.getTransaction().begin();
		User from = new User("Robson Rodrigues", "11933417690");
		User to = new User("Cris", "11987158777");
		
		Attendant at = new Attendant(true, from);
		
        Message message = new Message("Hello, universe", from, to);
        em.persist(from);
        em.persist(to);
        em.persist(message);
        em.persist(at);
        em.getTransaction().commit();
    }

    @Test
    public void readMessage() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
        List<Message> list = em.createQuery("from Message", Message.class).getResultList();
        System.out.println(list.size());
        Assertions.assertTrue( list.size() == 1, "Message configuration in error; table should contain only one. Set ddl to create-drop.");
    }
    
    @AfterAll
    public static void after() {
    	em.close();
    	emf.close();

	}
    
}
