/**
 * 
 */
package fr.coachingdigital.foodstorm.bean;

/**
 * @author sleray
 *
 */
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
  
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ingredients")
public class Ingredients {
  
    @XmlElement(name="ingredient")
    private ArrayList<Ingredient> ingredients;
  
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
  
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
