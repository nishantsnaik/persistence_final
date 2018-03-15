package io.nishant.persistence.single;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import io.nishant.persistence.entity.Employee;

/**
 * Hello world!
 *
 */
public class Tester 
{
    public static void main( String[] args )
    {
    	//created only once
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        
        //to talk to JPA, and tell them to save, get, delete
        //can be created as many as you wamt
        EntityManager em = emf.createEntityManager();
        
        //POST
        /*
        Employee empl= new Employee();
        empl.setFirstname("Nishant");
        empl.setLastname("Naik");
        empl.setEmail("nishantsnaik@gmail.com");
        empl.setCity("Grand Rapids");
        */
        /*
         * Transactions and commit
         */
        /*
        em.getTransaction().begin();
        em.persist(empl);
        em.getTransaction().commit();
        */
        //GET
        /*
        Employee emp = em.find(Employee.class, "5562e301-51da-4ee4-ac66-9acc1208f5dc");
        System.out.println(emp);
*/
        //UPDATE
        /*
        Employee empl = em.find(Employee.class, "5562e301-51da-4ee4-ac66-9acc1208f5dc");
        empl.setEmail("rohit1333@gmail.com");
        em.getTransaction().begin();
        em.merge(empl);
        em.getTransaction().commit();
        */
        
        //DELETE
        /*
         * delete needs an entire object as per JPA specifications
        Employee empl = em.find(Employee.class, "323e4315-918d-4d4c-8463-829754723dec");
        
        em.getTransaction().begin();
        em.remove(empl);
        em.getTransaction().commit();
        */
        
        //JPQL
        /*TypedQuery<Employee> query =  em.createQuery("select emp from Employee emp", Employee.class);
        List<Employee> employees = query.getResultList();
        System.out.println(employees);*/
        
        /*TypedQuery<Employee> query =  em.createQuery("select emp from Employee emp where emp.email=:pEmail", Employee.class);
        query.setParameter("pEmail", "nishantsnaik@gmail.com");
        List<Employee> employees = query.getResultList();
        System.out.println(employees);*/
        
        /*
         * using createnamedQuery, queries n corresponding object
         */
        TypedQuery<Employee> query =  em.createNamedQuery("Employee.findByEmail", Employee.class);
        query.setParameter("pEmail", "nishantsnaik@gmail.com");
        List<Employee> employees = query.getResultList();
        System.out.println(employees);
        
        
        
        
        em.clear();
        
        emf.close();
    }
}
