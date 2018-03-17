package fr.coachingdigital.foodstorm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 * 
 */

/**
 * @author sleray
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable{


	private static final long serialVersionUID = 2492923586519001757L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "typeid")
	private TypeIngredient type;

	/**
	 * default
	 */
	protected Ingredient() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public Ingredient(long id, String name, TypeIngredient type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	/**
	 * @param name
	 * @param type
	 */
	public Ingredient(String name, TypeIngredient type) {
		super();

		this.name = name;
		this.type = type;
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
	 * @return the type
	 */
	public TypeIngredient getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TypeIngredient type) {
		this.type = type;
	}
	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
}
