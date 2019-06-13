package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.RecipeMapBean;
import online.simplefoodsolutions.recipe.utility.ConvertListToMap;
import online.simplefoodsolutions.recipe.utility.DataConverter;
import search.ejb.Search;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class RecipeMapBeanController
{
    @Inject
    private RecipeMapBean recipeMapBean;
    @EJB
    private Search search;

    public void populateRecipeMap(String recipeTitle)
    {
        if (!recipeTitle.isEmpty())
        {
            try
            {
                recipeMapBean.setRecipes(ConvertListToMap.convertRecipeListToMap(DataConverter.convertRecipeListToRecipeBean(search.searchRecipesByTitle(recipeTitle))));
            } catch (IOException e)
            {
                System.out.println("Error populating recipes map. Either ejb or jsf named bean error");
                e.printStackTrace();
            }
        }
    }
}
