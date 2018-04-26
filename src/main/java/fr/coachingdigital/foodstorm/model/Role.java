package fr.coachingdigital.foodstorm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToMany(mappedBy="roles",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
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
	public Role(final long id, final String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 *
	 * @param name
	 */
	public Role(final String name) {
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
	 * @return the member list
	 */
	/*public Set<Member> getMembers() {
		return members;
	}*/
	/**
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 *
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}
	/**
	 *
	 * @param members the member list to set
	 */
	public void setMembers(final Set<Member> members) {
		this.members = members;
	}

	/**
	 *
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
