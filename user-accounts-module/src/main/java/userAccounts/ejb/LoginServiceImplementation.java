package userAccounts.ejb;

import userAccounts.dao.UserDAOService;
import utility.hibernate.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LoginServiceImplementation implements LoginService
{
    @Inject
    private UserDAOService userDAOService;

    @Override
    public User findUser(String username, String password)
    {
        return userDAOService.getUser(username, password);
    }
}
