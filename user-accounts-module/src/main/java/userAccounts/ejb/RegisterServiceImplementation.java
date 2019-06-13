package userAccounts.ejb;

import userAccounts.dao.UserDAOService;
import utility.hibernate.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RegisterServiceImplementation implements RegisterService
{
    @EJB
    RegistrationConfirmationService registrationConfirmationService;

    @Inject
    private UserDAOService userDAOService;

    @Override
    public boolean isUsernameUnique(String username)
    {
        return userDAOService.isUsernameUnique(username);
    }

    @Override
    public boolean isEmailUnique(String email)
    {
        return userDAOService.isEmailUnique(email);
    }

    @Override
    public int createNewUser(User user)
    {
        int userID = userDAOService.createNewUser(user);
        registrationConfirmationService.sendRegistrationConfirmationEmail(user.getEmail());

        return userID;
    }
}
