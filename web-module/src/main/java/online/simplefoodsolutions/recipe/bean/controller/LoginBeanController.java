package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.LoginBean;
import userAccounts.ejb.LoginService;
import utility.hibernate.entity.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBeanController
{
    @Inject
    private LoginBean loginBean;

    @EJB
    private LoginService loginService;

    public void login() throws InterruptedException
    {
        FacesContext context = FacesContext.getCurrentInstance();

        User user = loginService.findUser(loginBean.getUsername(), loginBean.getPassword());

        if (user != null)
        {
            try
            {
                context.getExternalContext().getSessionMap().put("user", user);
                context.getExternalContext().redirect("user-specific/user-profile.xhtml");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } else
        {
            FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect username and/or password." + " Please try again.", null));

            //For future developments add "or click "Forgot Username?" or "Forgot Password?" for more options" to message
        }
    }

    public void logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try
        {
            context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/pages/login.xhtml");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
