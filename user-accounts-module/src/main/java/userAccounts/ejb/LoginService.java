package userAccounts.ejb;

import utility.hibernate.entity.User;

import javax.ejb.Local;

@Local
public interface LoginService
{
    User findUser(String username, String password);
}
