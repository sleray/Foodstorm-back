package fr.coachingdigital.foodstorm.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="family", fetch = FetchType.LAZY)
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
	public Family(final long id, final String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 *
	 * @param name
	 */
	public Family(final String name) {
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
	 * @return the list of member in the family
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
	 * @param members set the list of member of the family
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
		return "Family [id=" + id + ", name=" + name + "]";
	}


}
