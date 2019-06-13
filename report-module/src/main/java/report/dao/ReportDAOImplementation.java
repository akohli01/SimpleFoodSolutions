package report.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import utility.hibernate.entity.User;
import utility.hibernate.session.SessionUtilityAPIDatabase;
import utility.hibernate.session.SessionUtilityMainDB;

import java.math.BigInteger;
import java.util.List;

public class ReportDAOImplementation implements ReportDAO
{
    private Session session;
    private Session session2;

    public ReportDAOImplementation()
    {
        session2 = SessionUtilityAPIDatabase.getSession();
        session = SessionUtilityMainDB.getSession();
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> users = session.createQuery("select a from User a", User.class).getResultList();

        for (User user : users)
        {
            session.detach(user);
            user.setPassword(null);
        }

        return users;
    }

    @Override
    public int getNumberOfRecipesCurrentlyInDatabase()
    {
        Query query = session2.createSQLQuery("select count(*) from recipe");

        return ((BigInteger) query.uniqueResult()).intValue();
    }
}
