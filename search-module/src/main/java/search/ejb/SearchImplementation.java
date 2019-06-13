package search.ejb;

import search.client.RESTFulWebClient;
import search.pojo.Recipe;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class SearchImplementation implements Search
{
    public List<Recipe> searchRecipesByTitle(String recipe) throws IOException
    {
        return new RESTFulWebClient().getRecipes(recipe);
    }

    @Override
    public Recipe searchRecipeByID(int id) throws IOException
    {
        return new RESTFulWebClient().getRecipeByID(id);
    }
}
