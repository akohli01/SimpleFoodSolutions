package online.simplefoodsolutions.recipe.bean.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class RecipeMapBean
{
    private Map<Integer, RecipeBean> recipes;

    public Map<Integer, RecipeBean> getRecipes()
    {
        return recipes;
    }

    public void setRecipes(Map<Integer, RecipeBean> recipes)
    {
        this.recipes = recipes;
    }
}

