package online.simplefoodsolutions.recipe.bean.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class RecipeReportBean extends AbstractReport
{
    private int numberOfRecipes;

    public void setColumns()
    {
        columns = new ArrayList<>();
        columns.add("Total Recipes");
    }

    public List<String> getColumns()
    {
        return columns;
    }

    public int getNumberOfRecipes()
    {
        return numberOfRecipes;
    }

    public void setNumberOfRecipes(int numberOfRecipes)
    {
        this.numberOfRecipes = numberOfRecipes;
    }
}
