package online.simplefoodsolutions.recipe.utility;

import utility.hibernate.entity.Role;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Set;

@Named
@RequestScoped
public class RoleSetHandler
{
    public static String convertRoleSetToString(Set<Role> roles)
    {
        StringBuilder rolesToString = new StringBuilder();

        for (Role role : roles)
        {
            rolesToString.append(role + ", ");
        }
        return rolesToString.toString();
    }
}
