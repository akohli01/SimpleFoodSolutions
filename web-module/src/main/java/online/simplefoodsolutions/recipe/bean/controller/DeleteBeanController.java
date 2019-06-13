package online.simplefoodsolutions.recipe.bean.controller;

import userAccounts.ejb.AccountDeletionService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class DeleteBeanController
{
    @EJB
    AccountDeletionService accountDeletionService;

    public void confirmDelete(int userID) throws IOException, InterruptedException
    {
        accountDeletionService.deleteUserAccount(userID);
        addMessage("Your account has been deleted.", "Redirecting to home page");

        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().invalidateSession();

        context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/pages/index.xhtml");
    }

    private void addMessage(String summary, String detail)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

