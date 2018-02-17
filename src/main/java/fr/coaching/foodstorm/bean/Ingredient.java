/**
 * 
 */
package fr.coaching.foodstorm.bean;

import java.io.Serializable;

/**
 * @author sleray
 *
 */
public class Ingredient {

		private Long id;
	private String name;
	private TypeIngredient type;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
}
