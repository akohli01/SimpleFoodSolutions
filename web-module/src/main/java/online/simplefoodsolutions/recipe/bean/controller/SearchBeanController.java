package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.SearchBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class SearchBeanController
{
    @Inject
    private SearchBean searchBean;

    public void navigateToSearchPage(String recipeName) throws IOException
    {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/pages/search.xhtml?searchValue=" + recipeName);
    }
}
