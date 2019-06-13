package online.simplefoodsolutions.recipe.validator;

import userAccounts.ejb.RegisterService;

import javax.ejb.EJB;
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
public class EmailValidator implements Validator
{
    @EJB
    RegisterService registerService;

    private String EMAIL_MATCH_MESSAGE = "Email and Confirm Email fields must match";
    private String EMAIL_NOT_VALID = "Email is not a valid email.";
    private String EMAIL_NOT_UNIQUE = "Email is already in use. Please use another email";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        String email = o.toString();

        UIInput uiInput = (UIInput) uiComponent.getAttributes().get("confirmEmail");

        String confirmEmail = uiInput.getSubmittedValue().toString();

        org.apache.commons.validator.routines.EmailValidator emailValidator = org.apache.commons.validator.routines.EmailValidator.getInstance();

        if (!email.equals(confirmEmail))
        {
            generateMessage(uiInput, EMAIL_MATCH_MESSAGE);
        } else if (!emailValidator.isValid(email))
        {
            generateMessage(uiInput, EMAIL_NOT_VALID);
        } else if (!registerService.isEmailUnique(email))
        {
            generateMessage(uiInput, EMAIL_NOT_UNIQUE);
        }
    }

    private void generateMessage(UIInput uiInput, String email_not_valid)
    {
        uiInput.setValid(false);
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, email_not_valid, null));
    }

}
