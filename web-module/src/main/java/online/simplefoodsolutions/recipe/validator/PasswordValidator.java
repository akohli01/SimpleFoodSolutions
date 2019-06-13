package online.simplefoodsolutions.recipe.validator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@RequestScoped
public class PasswordValidator implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        String password = o.toString();

        UIInput uiInput = (UIInput) uiComponent.getAttributes().get("confirmPassword");

        String confirmPassword = uiInput.getSubmittedValue().toString();

        if (!password.equals(confirmPassword))
        {
            uiInput.setValid(false);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password must match confirm password", null));
        }
    }
}
