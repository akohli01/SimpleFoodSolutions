package online.simplefoodsolutions.recipe.utility;

import online.simplefoodsolutions.recipe.bean.model.RecipeBean;
import search.pojo.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class DataConverter
{
    public static List<RecipeBean> convertRecipeListToRecipeBean(List<Recipe> recipes)
    {
        return recipes.stream().map(recipe -> new RecipeBean(recipe.getId(), recipe.getTitle(), recipe.getDescription())).collect(Collectors.toList());
    }

    public static RecipeBean convertRecipeToRecipeBean(Recipe recipe)
    {
        return new RecipeBean(recipe.getId(), recipe.getTitle(), recipe.getDescription());
    }
}
