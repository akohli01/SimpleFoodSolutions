package userAccounts.ejb;

import javax.ejb.Local;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Local
public interface ProfilePictureService
{
    void persistProfilePicture(int userID, ByteArrayOutputStream outputStream) throws IOException;

    byte[] retrieveProfilePicture(int userID);

}
