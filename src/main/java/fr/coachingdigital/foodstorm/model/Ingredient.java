package fr.coachingdigital.foodstorm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * 
 */

/**
 * @author sleray
 *
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable{


	private static final long serialVersionUID = 2492923586519001757L;
	@Id
	@Column(name = "INGR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "INGR_NAME")
	private String name;
	@ManyToOne
	@JoinColumn(name="INGR_TYP_ID", nullable = false)
	private TypeIngredient type;
	@ManyToMany(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinTable(name = "INGREDIENT_GROUP_INGREDIENT")
	private Set<GroupIngredient> groups;	
	@Column(name = "INGR_IMAGE_URL")
	private String imageUrl;
	

	/**
	 * default
	 */
	public Ingredient() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param imageUrl
	 */
	public Ingredient(long id, String name, TypeIngredient type, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageUrl = imageUrl;
	}
	/**
	 * @param name
	 * @param type
	 */
	public Ingredient(String name, TypeIngredient type, String imageUrl) {
		super();

		this.name = name;
		this.type = type;
		this.imageUrl = imageUrl;
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
	 * 
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 
	 * @param imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * tostring
	 */
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	/**
	 * @return the groups
	 */
	public Set<GroupIngredient> getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Set<GroupIngredient> groups) {
		this.groups = groups;
	}
	
	
	
}
