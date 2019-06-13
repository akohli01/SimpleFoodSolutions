package search.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import search.pojo.Recipe;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class RESTFulWebClient
{
    private static final String REST_URI_BY_TITLE = "http://localhost:8081/recipesearchapi/api/search/recipe/title/?sorted";
    private static final String REST_URI_BY_ID = "http://localhost:8081/recipesearchapi/api/search/recipe/id/";
    private Client client = ClientBuilder.newClient();
    private List<Recipe> recipes;
    private Recipe recipe;
    private String recipesAsString;

    public List<Recipe> getRecipes(String title) throws IOException
    {
        retrieveWebServiceDataByTitle(title);
        unMarshallJSONDataAsList();
        return recipes;
    }

    public Recipe getRecipeByID(int id) throws IOException
    {
        retrieveWebServiceDataByID(id);
        unMarshallJSONDataAsRecipe();
        return recipe;
    }

    private void retrieveWebServiceDataByTitle(String title) throws IOException
    {
        recipesAsString = client.target(REST_URI_BY_TITLE).path(title).request(MediaType.APPLICATION_JSON).header("Authorization", "hN7rPppylF.>aArv*r&]&H3$Nc2]DcY_S_~+.{^nQR@\\4U").get(String.class);
    }

    private void retrieveWebServiceDataByID(int id) throws IOException
    {
        recipesAsString = client.target(REST_URI_BY_ID).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).header("Authorization", "hN7rPppylF.>aArv*r&]&H3$Nc2]DcY_S_~+.{^nQR@\\4U").get(String.class);
    }

    private void unMarshallJSONDataAsList() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        recipes = mapper.readValue(recipesAsString, new TypeReference<List<Recipe>>()
        {
        });
    }

    private void unMarshallJSONDataAsRecipe() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        recipe = mapper.readValue(recipesAsString, new TypeReference<Recipe>()
        {
        });
    }


}
