package userAccounts.ejb;

import javax.ejb.Local;

@Local
public interface AccountDeletionService
{
    void deleteUserAccount(int userID);
}
