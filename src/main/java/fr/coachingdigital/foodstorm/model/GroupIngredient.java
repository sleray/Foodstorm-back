package fr.coachingdigital.foodstorm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 * 
 */

/**
 * A group ingredient helps to define a Menu. some ingredient can be cooked as main or at dessert.
 * @author sleray
 *
 */
@Entity
@Table(name = "GROUP_INGREDIENT")
public class GroupIngredient implements Serializable{


	private static final long serialVersionUID = 2492923586519001757L;
	@Id
	@Column(name = "INGR_GROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "INGR_GROUP_NAME")
	private String name;
	@ManyToMany(mappedBy="groups")    
	private Set<Ingredient> ingredients;


	/**
	 * default
	 */
	public GroupIngredient() {
		
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
	
	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
