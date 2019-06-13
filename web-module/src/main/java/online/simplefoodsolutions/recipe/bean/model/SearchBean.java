package online.simplefoodsolutions.recipe.bean.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SearchBean
{
    private String recipeSearchValue;

    public String getRecipeSearchValue()
    {
        return recipeSearchValue;
    }

    public void setRecipeSearchValue(String recipeSearchValue)
    {
        this.recipeSearchValue = recipeSearchValue;
    }
}
