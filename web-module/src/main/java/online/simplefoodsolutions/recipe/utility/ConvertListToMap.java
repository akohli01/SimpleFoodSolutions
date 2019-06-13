package online.simplefoodsolutions.recipe.utility;

import online.simplefoodsolutions.recipe.bean.model.RecipeBean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap
{
    public static Map<Integer, RecipeBean> convertRecipeListToMap(List<RecipeBean> recipes)
    {

        return recipes.stream().collect(Collectors.toMap(RecipeBean::getId, recipe -> recipe, (u, v) ->
        {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        }, LinkedHashMap::new));
    }
}
