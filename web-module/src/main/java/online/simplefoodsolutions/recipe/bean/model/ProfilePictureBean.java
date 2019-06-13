package online.simplefoodsolutions.recipe.bean.model;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProfilePictureBean
{
    private UploadedFile profilePicture;

    private StreamedContent imageFromDatabase;

    public UploadedFile getProfilePicture()
    {
        return profilePicture;
    }

    public void setProfilePicture(UploadedFile profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    public StreamedContent getImageFromDatabase()
    {
        return imageFromDatabase;
    }

    public void setImageFromDatabase(StreamedContent imageFromDatabase)
    {
        this.imageFromDatabase = imageFromDatabase;
    }
}
