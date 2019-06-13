package utility.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "profile_picture")
public class ProfilePicture
{
    @Id
    @Column(name = "user_id")
    private Integer userID;

    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private byte[] photo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    public ProfilePicture(int userID, byte[] photo)
    {
        this.userID = userID;
        this.photo = photo;
    }

    public ProfilePicture()
    {
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public byte[] getPhoto()
    {
        return photo;
    }

    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
