package io.nishant.persistence.relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

		EntityManager em = emf.createEntityManager();
/*
		User user = new User();
		user.setFirstname("Nishant");
		user.setLastname("Naik");

		Address address = new Address();
		address.setCity("Herndon");
		address.setState("VA");
		address.setStreet("2101 Maryland Circle");
		address.setZip("49512");

		

		em.getTransaction().begin();
		em.persist(address);
		user.setAddress(address);
		em.persist(user);
		em.getTransaction().commit();
*/
		User user = em.find(User.class, "ab4f69f8-b661-4d3b-a9a7-d7d90452e570");
		System.out.println(user);
		em.close();
		
		//emf.close();
	}

}
