package userAccounts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.hibernate.entity.Role;
import utility.hibernate.entity.User;
import utility.hibernate.session.SessionUtilityMainDB;

public class RoleDAOServiceImplementation implements RoleDAOService
{
    private Session session;

    public RoleDAOServiceImplementation()
    {
        session = SessionUtilityMainDB.getSession();
    }

    @Override
    public void addDefaultRole(int userID)
    {
        Transaction transaction = session.beginTransaction();

        User user = session.find(User.class, userID);

        Role defaultRole = session.find(Role.class, 2);

        user.addRole(defaultRole);

        session.persist(user);

        session.flush();
        transaction.commit();
    }
}
