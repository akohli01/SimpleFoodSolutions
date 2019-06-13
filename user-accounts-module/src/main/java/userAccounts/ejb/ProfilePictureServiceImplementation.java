package userAccounts.ejb;

import userAccounts.dao.ProfilePictureDAOService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Stateless
public class ProfilePictureServiceImplementation implements ProfilePictureService
{
    @Inject
    private ProfilePictureDAOService profilePictureDAOService;

    @Override
    public void persistProfilePicture(int userID, ByteArrayOutputStream byteArrayOutputStream) throws IOException
    {
        profilePictureDAOService.persistProfilePicture(userID, byteArrayOutputStream);
    }

    @Override
    public byte[] retrieveProfilePicture(int userID)
    {
        return profilePictureDAOService.retrieveProfilePicture(userID);
    }
}
