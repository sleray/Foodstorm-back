/**
 * 
 */
package fr.coaching.foodstorm.bean;

import java.io.Serializable;

/**
 * @author sleray
 *
 */
public class TypeIngredient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6988508328892137646L;
	private Long id;
	private String name;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 * @param name
	 */
	public TypeIngredient(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
