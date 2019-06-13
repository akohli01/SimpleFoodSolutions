package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.ProfilePictureBean;
import online.simplefoodsolutions.recipe.utility.ImageResizer;
import org.primefaces.model.DefaultStreamedContent;
import userAccounts.ejb.ProfilePictureService;
import utility.hibernate.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Named
@RequestScoped
public class ProfilePictureBeanController
{
    @Inject
    ProfilePictureBean profilePictureBean;

    @EJB
    ProfilePictureService profilePictureService;

    @PostConstruct
    public void init()
    {
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        retrieveProfilePicture(user.getUserID());
    }

    public void saveProfilePicture(int userID) throws IOException
    {
        if (profilePictureBean.getProfilePicture().getInputstream() == null)
        {

        }

        BufferedImage originalImage = ImageIO.read(profilePictureBean.getProfilePicture().getInputstream());
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedBufferedImage = ImageResizer.resizeImage(originalImage, 200, 200, type);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(resizedBufferedImage, "jpg", byteArrayOutputStream);
        profilePictureService.persistProfilePicture(userID, byteArrayOutputStream);
    }

    public void retrieveProfilePicture(int userID)
    {
        profilePictureBean.setImageFromDatabase(new DefaultStreamedContent(new ByteArrayInputStream(profilePictureService.retrieveProfilePicture(userID)), "image/jpg"));
    }

    public ProfilePictureBean getProfilePictureBean()
    {
        return profilePictureBean;
    }

    public void setProfilePictureBean(ProfilePictureBean profilePictureBean)
    {
        this.profilePictureBean = profilePictureBean;
    }
}
