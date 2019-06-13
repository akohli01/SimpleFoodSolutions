package userAccounts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.hibernate.entity.User;
import utility.hibernate.session.SessionUtilityMainDB;

public class UserDAOServiceImplementation implements UserDAOService
{
    private Session session;
    private Query query;

    public UserDAOServiceImplementation()
    {
        session = SessionUtilityMainDB.getSession();
    }

    @Override
    public boolean isUsernameUnique(String username)
    {
        query = session.createQuery("select count(*) from User where username = ?1");
        query.setParameter(1, username);

        Long numberOfUsersWithSameUsername = (Long) query.uniqueResult();

        return numberOfUsersWithSameUsername == 0;
    }

    @Override
    public boolean isEmailUnique(String email)
    {
        query = session.createQuery("select count(*) from User where email = ?1");
        query.setParameter(1, email);

        Long numberOfUsersWithSameEmail = (Long) query.uniqueResult();

        return numberOfUsersWithSameEmail == 0;
    }

    @Override
    public int createNewUser(User user)
    {
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        session.flush();
        transaction.commit();

        return user.getUserID();
    }

    private boolean areCredentialsCorrect(String username, String password)
    {
        query = session.createQuery("select count(*) from User where username = ?1 and password = ?2");
        query.setParameter(1, username);
        query.setParameter(2, password);

        Long numberOfUsersWithTheInputtedCredentials = (Long) query.uniqueResult();

        return numberOfUsersWithTheInputtedCredentials == 1;
    }

    private int getUserID(String username)
    {
        Session session = SessionUtilityMainDB.getSession();

        Query query = session.createQuery("select userID from User where username = ?1 ");
        query.setParameter(1, username);

        return (Integer) query.uniqueResult();
    }

    @Override
    public User getUser(String username, String password)
    {
        Session session = SessionUtilityMainDB.getSession();

        if (areCredentialsCorrect(username, password))
        {
            User user = session.find(User.class, getUserID(username));
            session.detach(user);
            user.setPassword(null);
            return user;
        }
        return null;
    }
}
