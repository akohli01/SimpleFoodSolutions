package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.RecipeReportBean;
import online.simplefoodsolutions.recipe.bean.model.UserReportBean;
import report.ejb.ReportService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class ReportBeanController
{
    @Inject
    private UserReportBean userReportBean;

    @Inject
    private RecipeReportBean recipeReportBean;

    @EJB
    private ReportService reportService;

    private String reportChoice;

    public void whichReportToGenerate()
    {
        if (reportChoice.equals("registeredUsersReport")) retrieveUsersForReport();
        else if (reportChoice.equals("numberOfRecipesReport")) retrieveRecipesReport();
    }

    private void retrieveUsersForReport()
    {
        userReportBean.setUsers(reportService.getAllUsers());
        userReportBean.setColumns();
    }

    private void retrieveRecipesReport()
    {
        recipeReportBean.setNumberOfRecipes(reportService.getNumberOfRecipesCurrentlyInDatabase());
        recipeReportBean.setColumns();
    }

    public UserReportBean getUserReportBean()
    {
        return userReportBean;
    }

    public void setUserReportBean(UserReportBean userReportBean)
    {
        this.userReportBean = userReportBean;
    }

    public RecipeReportBean getRecipeReportBean()
    {
        return recipeReportBean;
    }

    public void setRecipeReportBean(RecipeReportBean recipeReportBean)
    {
        this.recipeReportBean = recipeReportBean;
    }

    public String getReportChoice()
    {
        return reportChoice;
    }

    public void setReportChoice(String reportChoice)
    {
        this.reportChoice = reportChoice;
    }
}
