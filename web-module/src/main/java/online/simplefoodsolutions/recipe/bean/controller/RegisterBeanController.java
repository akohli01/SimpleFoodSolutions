package online.simplefoodsolutions.recipe.bean.controller;

import online.simplefoodsolutions.recipe.bean.model.RegisterBean;
import userAccounts.ejb.ProfilePictureService;
import userAccounts.ejb.RegisterService;
import userAccounts.ejb.RoleService;
import utility.hibernate.entity.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

@Named
@RequestScoped
public class RegisterBeanController
{
    @Inject
    private RegisterBean registerBean;

    @EJB
    private RegisterService registerService;

    @EJB
    private ProfilePictureService profilePictureService;

    @EJB
    private RoleService roleService;

    public void registerUser() throws IOException
    {
        User user = new User(registerBean.getFirstName(), registerBean.getLastName(), registerBean.getEmail(), registerBean.getUsername(), registerBean.getPassword(), new Timestamp(System.currentTimeMillis()));

        int userID = registerService.createNewUser(user);
        if (userID != 0)
        {
            insertDefaultUserProfilePicture(userID);
            roleService.addDefaultRole(userID);
            FacesContext.getCurrentInstance().addMessage("registerForm", new FacesMessage("Account created! You may now login"));
        }
    }

    private void insertDefaultUserProfilePicture(int userID) throws IOException
    {
        BufferedImage originalImage = ImageIO.read(FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("resources/images/default-profile-picture.jpg"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", byteArrayOutputStream);

        profilePictureService.persistProfilePicture(userID, byteArrayOutputStream);
    }

}
