package userAccounts.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.hibernate.entity.ProfilePicture;
import utility.hibernate.entity.User;
import utility.hibernate.session.SessionUtilityMainDB;

import java.io.ByteArrayOutputStream;

public class ProfilePictureDAOServiceImplementation implements ProfilePictureDAOService
{
    private Session session;

    public ProfilePictureDAOServiceImplementation()
    {
        session = SessionUtilityMainDB.getSession();
    }

    @Override
    public void persistProfilePicture(int userID, ByteArrayOutputStream byteArrayOutputStream)
    {
        Transaction transaction = session.beginTransaction();

        User user = session.find(User.class, userID);

        ProfilePicture profilePicture = new ProfilePicture(userID, byteArrayOutputStream.toByteArray());

        profilePicture.setUser(user);

        user.setProfilePicture(profilePicture);

        session.merge(profilePicture);

        session.flush();

        transaction.commit();
    }

    @Override
    public byte[] retrieveProfilePicture(int userID)
    {
        Session session = SessionUtilityMainDB.getSession();

        Transaction transaction = session.beginTransaction();

        ProfilePicture profilePicture = session.find(ProfilePicture.class, userID);

        session.flush();

        transaction.commit();

        return profilePicture.getPhoto();
    }
}
