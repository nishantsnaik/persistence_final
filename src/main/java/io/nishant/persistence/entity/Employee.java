package io.nishant.persistence.entity;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*
 * @Entity
 * we tell hibernate to keep a copy of this object in local memory cache and create table, and sync
 */
@Entity

/*
 * @@NamedQueries
 * this will define the query and compile it once, and can be called multiple times, without neeeding to compile each time
  */

/*
Created by Nishant Naik
 */
@NamedQueries({
	@NamedQuery(name="Employee.findAll", query = "select emp from Employee emp order by emp.firstname"),
	@NamedQuery(name="Employee.findByEmail", query = "select emp from Employee emp where emp.email=:pEmail")
})
public class Employee {
	
	@Id
	private String id;
	private String firstname;
	private String lastname;
	@Column(columnDefinition="VARCHAR(100)", unique = true)
	private String email;
	private String city;
	
	public Employee(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", city=" + city + "]";
	}
	
	
	
	

}
