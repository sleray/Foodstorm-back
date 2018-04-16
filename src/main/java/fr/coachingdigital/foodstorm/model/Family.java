package fr.coachingdigital.foodstorm.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@ManyToMany(mappedBy="family")    
	private Set<Member> members;
	
	/**
	 * default
	 */
	public Family() {
		super();
	}
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Family(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 * @param name
	 */
	public Family(String name) {
		super();
		this.name = name;
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

	/**
	 * 
	 * @return the list of member in the family
	 */
	public Set<Member> getMembers() {
		return members;
	}

	/**
	 * 
	 * @param members set the list of member of the family
	 */
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
	
}
