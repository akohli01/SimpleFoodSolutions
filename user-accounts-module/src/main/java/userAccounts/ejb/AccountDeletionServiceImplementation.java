package userAccounts.ejb;

import userAccounts.dao.AccountDeletionDAOService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AccountDeletionServiceImplementation implements AccountDeletionService
{
    @Inject
    private AccountDeletionDAOService accountDeletionDAOService;

    @Override
    public void deleteUserAccount(int userID)
    {
        accountDeletionDAOService.deleteUserAccount(userID);
    }
}
