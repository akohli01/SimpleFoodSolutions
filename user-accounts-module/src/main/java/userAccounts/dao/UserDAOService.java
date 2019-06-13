package userAccounts.dao;

import utility.hibernate.entity.User;

public interface UserDAOService
{
    boolean isUsernameUnique(String username);

    boolean isEmailUnique(String email);

    int createNewUser(User user);

    User getUser(String username, String password);
}
