package online.simplefoodsolutions.recipe.validator;

import userAccounts.ejb.RegisterService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@RequestScoped
public class UsernameValidator implements Validator
{
    @EJB
    RegisterService registerService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        String username = o.toString();

        if (!registerService.isUsernameUnique(username))
        {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username is already in use. Please use another username", null));
        }
    }
}
