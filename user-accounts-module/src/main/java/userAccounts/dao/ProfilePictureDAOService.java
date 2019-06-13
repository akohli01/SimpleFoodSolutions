package userAccounts.dao;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface ProfilePictureDAOService
{
    void persistProfilePicture(int userID, ByteArrayOutputStream imageInputStream) throws IOException;

    byte[] retrieveProfilePicture(int userID);
}
