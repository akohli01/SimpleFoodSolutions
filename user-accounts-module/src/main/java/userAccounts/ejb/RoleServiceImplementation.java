package userAccounts.ejb;

import userAccounts.dao.RoleDAOService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RoleServiceImplementation implements RoleService
{
    @Inject
    RoleDAOService roleDAOService;

    @Override
    public void addDefaultRole(int userID)
    {
        roleDAOService.addDefaultRole(userID);
    }
}
