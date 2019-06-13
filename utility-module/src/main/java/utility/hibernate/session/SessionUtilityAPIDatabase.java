package utility.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtilityAPIDatabase
{
    private static SessionUtilityAPIDatabase instance = new SessionUtilityAPIDatabase();
    private SessionFactory sessionFactory;

    private SessionUtilityAPIDatabase()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-api.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    private static SessionUtilityAPIDatabase getInstance()
    {
        return instance;
    }

    public static Session getSession()
    {
        return getInstance().sessionFactory.openSession();
    }
}
