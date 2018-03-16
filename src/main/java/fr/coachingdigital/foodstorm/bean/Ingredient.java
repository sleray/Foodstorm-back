package fr.coachingdigital.foodstorm.bean;
/**
 * 
 */

/**
 * @author sleray
 *
 */
public class Ingredient {

		private Integer id;
	private String name;
	private TypeIngredient type;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public Ingredient(Integer id, String name, TypeIngredient type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
