package utility.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtilityMainDB
{
    private static SessionUtilityMainDB instance = new SessionUtilityMainDB();
    private SessionFactory sessionFactory;

    private SessionUtilityMainDB()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-main.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    private static SessionUtilityMainDB getInstance()
    {
        return instance;
    }

    public static Session getSession()
    {
        return getInstance().sessionFactory.openSession();
    }
}
