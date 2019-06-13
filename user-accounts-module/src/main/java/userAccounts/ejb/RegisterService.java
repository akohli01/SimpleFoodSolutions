package userAccounts.ejb;

import utility.hibernate.entity.User;

import javax.ejb.Local;

@Local
public interface RegisterService
{
    boolean isUsernameUnique(String userName);

    boolean isEmailUnique(String email);

    int createNewUser(User user);
}
