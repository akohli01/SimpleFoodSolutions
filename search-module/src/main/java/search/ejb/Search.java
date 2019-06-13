package search.ejb;

import search.pojo.Recipe;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface Search
{
    List<Recipe> searchRecipesByTitle(String recipe) throws IOException;

    Recipe searchRecipeByID(int id) throws IOException;
}

