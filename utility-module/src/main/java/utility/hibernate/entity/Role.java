package utility.hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role
{
    @Id
    @Column(name = "role_id")
    private int roleID;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @Column(name = "name", unique = true)
    private String roleName;

    public Role(int roleID, String name)
    {
        this.roleID = roleID;
        this.roleName = name;
    }

    public Role()
    {
    }

    public int getRoleID()
    {
        return roleID;
    }

    public void setRoleID(int roleID)
    {
        this.roleID = roleID;
    }

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String role)
    {
        this.roleName = role;
    }

    @Override
    public String toString()
    {
        return roleName;
    }
}
