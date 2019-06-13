package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.RecipeBean;
import online.simplefoodsolutions.recipe.utility.DataConverter;
import search.ejb.Search;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class RecipeBeanController
{
    @EJB
    Search search;

    @Inject
    private RecipeBean recipeBean;

    public void initializeRecipeBeanByID(int id) throws IOException
    {
        recipeBean = DataConverter.convertRecipeToRecipeBean(search.searchRecipeByID(id));
    }

    public RecipeBean getRecipeBean()
    {
        return recipeBean;
    }

    public void setRecipeBean(RecipeBean recipeBean)
    {
        this.recipeBean = recipeBean;
    }

}
