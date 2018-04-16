package fr.coachingdigital.foodstorm.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Entity
@Table(name="ROLE")
public class Role {
	private static final long serialVersionUID = 2492923586519001757L;
	
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "ROLE_NAME")
	private String name;
	@ManyToMany(mappedBy="roles")    
	private Set<Member> members;
	
	
	/**
	 * default
	 */
	public Role() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public Role(String name) {
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
		return "Role [id=" + id + ", name=" + name + ", members=" + members + "]";
	}

	/**
	 * 
	 * @return the member list
	 */
	public Set<Member> getMembers() {
		return members;
	}

	/**
	 * 
	 * @param members the member list to set
	 */
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
}
