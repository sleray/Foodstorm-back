package fr.coachingdigital.foodstorm.model;
/**
 * 
 */


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sleray
 *
 */
@Entity
@Table(name = "TYPE_INGREDIENT")
public class TypeIngredient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6988508328892137646L;
	@Id
	@Column(name = "INGR_TYP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "INGR_TYP_NAME")
	private String name;
	@OneToMany(mappedBy = "type", cascade = CascadeType.MERGE)
	private Set<Ingredient> ingredients;

	public TypeIngredient() {
		
	}
	/**
	 * @param id
	 * @param name
	 */
	public TypeIngredient(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeIngredient [id=" + id + ", name=" + name + "]";
	}

}
