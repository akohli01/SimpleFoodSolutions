package userAccounts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.hibernate.entity.ProfilePicture;
import utility.hibernate.session.SessionUtilityMainDB;

public class AccountDeletionDAOServiceImplementation implements AccountDeletionDAOService
{
    private Session session;

    public AccountDeletionDAOServiceImplementation()
    {
        session = SessionUtilityMainDB.getSession();
    }

    @Override
    public void deleteUserAccount(int userID)
    {
        Transaction transaction = session.beginTransaction();

        ProfilePicture profilePicture = session.find(ProfilePicture.class, userID);

        session.delete(profilePicture.getUser());
        session.flush();
        transaction.commit();
    }
}
