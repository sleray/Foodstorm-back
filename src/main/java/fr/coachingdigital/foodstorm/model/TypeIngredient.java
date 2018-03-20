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
@Table(name = "typeingredient")
public class TypeIngredient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6988508328892137646L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
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

}
