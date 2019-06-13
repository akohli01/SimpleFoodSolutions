package userAccounts.ejb;

import javax.ejb.Local;

@Local
public interface RoleService
{
    void addDefaultRole(int userID);
}
