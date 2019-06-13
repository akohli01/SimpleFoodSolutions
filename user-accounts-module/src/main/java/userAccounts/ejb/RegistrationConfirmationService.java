package userAccounts.ejb;

import javax.ejb.Local;

@Local
public interface RegistrationConfirmationService
{
    void sendRegistrationConfirmationEmail(String userEmail);
}
