/**
 * 
 */
package fr.coachingdigital.foodstorm.resources;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.coachingdigital.foodstorm.bean.Ingredient;
import fr.coachingdigital.foodstorm.bean.Ingredients;
import fr.coachingdigital.foodstorm.bean.TypeIngredient;
 
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ingredients")
@Path("/ingredients")
public class IngredientResource
{
    private static Map<Integer, Ingredient> DB = new HashMap<>();
     
    @GET
    @Produces("application/json")
    public Ingredients getAllIngredients() {
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredients(new ArrayList<>(DB.values()));
        return ingredients;
    }
     
    @POST
    @Consumes("application/json")
    public Response createIngredient(Ingredient ingredient) throws URISyntaxException
    {
        if(ingredient.getName() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        ingredient.setId(DB.values().size()+1);
        
        DB.put(ingredient.getId(), ingredient);
        return Response.status(201).build();
    }
 
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getIngredientById(@PathParam("id") int id) throws URISyntaxException
    {
        Ingredient ingredient = DB.get(id);
        if(ingredient == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(ingredient).build();
    }
 
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateIngredient(@PathParam("id") int id, Ingredient ingredient) throws URISyntaxException
    {
        Ingredient temp = DB.get(id);
        if(ingredient == null) {
            return Response.status(404).build();
        }
        temp.setName(ingredient.getName());

        DB.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }
 
    @DELETE
    @Path("/{id}")
    public Response deleteIngredient(@PathParam("id") int id) throws URISyntaxException {
        Ingredient ingredient = DB.get(id);
        if(ingredient != null) {
            DB.remove(ingredient.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }
     
    static
    {
    	TypeIngredient viande = new TypeIngredient(1, "Viande");
        Ingredient ingredient1 = new Ingredient(1,"Poulet",viande);
        
        TypeIngredient legumes = new TypeIngredient(2, "Légumes");
        Ingredient ingredient2 = new Ingredient(2,"Brocolis",legumes);
        
      
         
        DB.put(ingredient1.getId(), ingredient1);
        DB.put(ingredient2.getId(), ingredient2);
    }
}