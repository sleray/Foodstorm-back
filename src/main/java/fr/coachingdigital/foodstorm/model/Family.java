package fr.coachingdigital.foodstorm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAMILY")
public class Family {

	private static final long serialVersionUID = 2492923586519001757L;
	@Id
	@Column(name = "FAMILY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "FAMILY_NAME")
	private String name;
	
	/**
	 * default
	 */
	public Family() {
		
	}
	
	/**
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Family [id=" + id + ", name=" + name + "]";
	}
	
}
